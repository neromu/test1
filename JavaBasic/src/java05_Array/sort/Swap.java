package java05_Array.sort;

public class Swap {

	public static void main(String[] args) {
		
//		스왑, swap
//		교환, 맞바꾸기
//		---------------------------------------------
		
		int num1 =11;
		int num2 =22;
		System.out.println("[스왑 전] "+num1+", "+num2);
		
//		스왑 코드
		int temp=num1;
		num1 = num2;
		num2 = temp;
//		swap logic
//		임시 저장 공간 만들어서 사용
		
		System.out.println("[스왑 후] "+num1+", "+num2);
		
	}//main

}//class
