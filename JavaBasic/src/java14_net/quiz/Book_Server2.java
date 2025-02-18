package java14_net.quiz;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Book_Server2 {
	public static void main(String[] args) {
		
//		소켓
		ServerSocket servSock = null;
		Socket sock = null;
		
		int port = 10000;
		int num = 0;
		
//		객체를 저장할 ser 파일
		File file = new File("./src/java14_net/quiz/bookDara.ser");
		
//		객체 스트림
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		InputStream inNum = null;
		
		List<Book> book = new ArrayList<>();
		
		try {
			servSock = new ServerSocket(port);
			System.out.println("+ + + 서버 소켓 생성 + + +");
			System.out.println("----- 접속 대기중 -----");
			System.out.println("IP : "+InetAddress.getLocalHost().getHostAddress());
			System.out.println("Linsten Port : " + servSock.getLocalPort() );
			System.out.println("-----------------------");
			
			while( true ) {
				try{
					sock = servSock.accept();
				}catch(IOException e) {
					e.printStackTrace();
				}
				
				inNum = sock.getInputStream();
				num = inNum.read();
				
				switch (num) {
				case 1:
					System.out.println("입력 1 실행");
					ois = new ObjectInputStream( new BufferedInputStream( sock.getInputStream() ) );
					oos = new ObjectOutputStream( new BufferedOutputStream( new FileOutputStream(file) ) );
					
//					ois 객체 in
					Book clientData = (Book)ois.readObject();
					System.out.println(clientData.toString());
					book.add(new Book(clientData.getTitle(),clientData.getAuthor(),clientData.getPrice()) );
					
//					oos 객체 out
					oos.writeObject(book);
					oos.flush();
					break;
					
				case 2:
					System.out.println("입력 2 실행");
					ois = new ObjectInputStream( new BufferedInputStream( new FileInputStream(file) ) );
					oos = new ObjectOutputStream( new BufferedOutputStream( sock.getOutputStream() ) );
					
					Book fileData =(Book)ois.readObject();
					book.add(new Book(fileData.getTitle(),fileData.getAuthor(),fileData.getPrice()) );
					oos.writeObject(fileData);
					oos.flush();
					
					break;
					
				case 3:
					
					break;
				default:
					System.out.println(">>Client 에서 잘못된 값을 전송 : "+num);
					break;
				}
				
				
				
				
			}
//			
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {//소켓 닫기.
			if(sock!=null)	sock.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try { //서버 소켓 닫기
			if(servSock!=null)		servSock.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
	}

}
