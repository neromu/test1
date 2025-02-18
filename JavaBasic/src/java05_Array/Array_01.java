package java05_Array;

public class Array_01 {

	public static void main(String[] args) {
		
		int num;	//int형 변수 선언
		num =123;	//int값 대입 
//		변수가 많아지면 힘들어짐.
//		----------------------------------------------
//		배열 선언
//		배열자료형 배열명;
		
//		**배열의 자료형 표현
//		자료형[];
		
//		Ex) int[] - int형 배열 
		
//		--------------------------------------------------
//		int형 배열 타입의 변수를 선언한다
		
		int[] arr;
		
		arr = new int[5]; //new int[] <- 변수의 묶음 생성
//		int형 배열 공간 생성
//		int변수 공간 5개를 만들고 연결해놓는다
//		생성된 전체 배열 공간의 첫 주소(참조값)을 반환한다
				
//		반환된 주소(참조값)를 arr 배열변수에 저장한다		
				
		System.out.println("arr 참조값 : "+arr);		
				
//		자바에서는 참조값 사용을 막아놓음		
//		--------------------------------------------------
//		배열을 생성할 때 변수 공간이 묶음으로 한꺼번에 만들어진다
//		->int단위로 구분된 공간 5개를 만들었음		
		
//		->첫 번째 공간부터 0번째(인덱스)로 부른다
		
		arr[0] = 11;
		arr[1] = 22;
		arr[2] = 33;
		arr[3] = 44;
		arr[4] = 55;
		
//		Erorr 대입 공간이 없음
//		ArrayIndexOutOfBoundsException 예외 상황 발생
//		->arr배열의 길이(크기)가 5 이니까 인덱스 범위는 0~4 이다
//		->인덱스를 5로 접근하면 여섯번째 공간을 찾는 것 이다
//		->오류(예외)
//		arr[5] = 66;
//		Exception -> 실행 후 판단되는 오류
		
//		--------------------------------------------------------
		
//		반복문을 이용하여 배열의 모든 값 대입하기
		for( int i=0; i<5; i++) {
			arr[i] = (i+1)*100;
		} //arr[i] => 변수
		
//		배열의 모든 값 출력하기
		for( int i=0; i<5; i++) {
			System.out.println(arr[i]);
		}
	
	}//main

}//class
