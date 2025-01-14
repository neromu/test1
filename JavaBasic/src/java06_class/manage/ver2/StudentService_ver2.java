package java06_class.manage.ver2;

import java.util.Scanner;


public class StudentService_ver2 {

   private Scanner sc = new Scanner(System.in);

   private Student[] stuArr = new Student[3];
   
   // ver1 코드 삭제
   //private Student stu = new Student();
   
   
   
   // ---------- 생성자 ----------
   // 디폴트 생성자
   public StudentService_ver2()
   {
      for(int i=0; i<stuArr.length; i++)
         stuArr[i] = new Student();
   }
      
   
   /* ver1 코드 삭제
   // 매개변수가 있는 생성자
   public StudentService2(String name, int age) {
      stu.setName(name);
      stu.setAge(age);
   }
   */
   // -------------------------
   
   
   
   // ---------- 공통 메소드 ----------
   // 몇번째 학생인지 선택하는 기능
   private int getIdx() {
      int idx;
      do {
         System.out.print("몇번째학생? ");
         idx = sc.nextInt();
         if(idx<1 || idx>3)
            System.out.println(" >> Error : 3명만 존재합니다");
      } while(idx<1 || idx>3);
      
      return idx;
   }
   // -------------------------
   
   
   
   // ---------- 정보 입력기능 ----------
   /* ver1 코드 삭제
   // 인적정보 입력 기능 - insertInfo
   public void insertInfo() {
      System.out.println(" ++ 기본 정보 입력 ++");
      System.out.print("이름을 입력하세요 : ");
      String name = sc.next();
      stu.setName(name);
      
      System.out.print("나이를 입력하세요 : ");
      int age = sc.nextInt();
      stu.setAge(age);
   }
   */
   private void insertInfo(Student s, int i) {
      System.out.println(" ++ " + i + "번째 학생 기본 정보 입력 ++");
      System.out.print("이름을 입력하세요 : ");
      String name = sc.next();
      s.setName(name);
      
      System.out.print("나이를 입력하세요 : ");
      int age = sc.nextInt();
      s.setAge(age);
   }
      
   // 3인 인적정보 입력 기능 - insertInfoAll
   public void insertInfoAll() {
      for(int i=0; i<stuArr.length; i++)
         insertInfo(stuArr[i], i+1);
   }
   
   // 인적 정보 1명 입력(선택)
   public void insertInfoIdx() {
      int idx = getIdx();
      insertInfo(stuArr[idx-1], idx);
   }
   
   
   /* ver1 코드 삭제
   // 인적정보 입력 기능 - insertInfo(String, int)
   public void insertInfo(String name, int age) {
      System.out.println(" ++ 기본 정보 입력 ++");
      System.out.println("입력된 이름 : " + name);
      System.out.println("입력된 나이 : " + age);
      stu.setName(name);
      stu.setAge(age);
   }
   */
   
   private void insertStu(int idx) {
      insertInfo(stuArr[idx-1], idx);
      insertScore(stuArr[idx-1], idx);
   }
   
   public void insertStuAll() {
      for(int i=1; i<=3; i++)
         insertStu(i);
   }
   // -------------------------

   
   
   // ---------- 성적 입력 기능 ----------
   /* ver1 코드 삭제
   // 3과목 성적 입력 기능 - insertScore
   public void insertScore() {
      System.out.println(" ++ 3과목 점수 입력 ++");
      System.out.print("국어 점수 입력 : ");
      stu.setKor(sc.nextInt());
      System.out.print("영어 점수 입력 : ");
      stu.setEng(sc.nextInt());
      System.out.print("수학 점수 입력 : ");
      stu.setMath(sc.nextInt());
      
      // 총점, 평균 계산
      calcSum(stu);
      calcAvg(stu);
   }
   */
   
   private void insertScore(Student s, int i) {
      System.out.println(" ++ " + i + "번째 학생 3과목 점수 입력 ++");
      System.out.print("국어 점수 입력 : ");
      s.setKor(sc.nextInt());
      System.out.print("영어 점수 입력 : ");
      s.setEng(sc.nextInt());
      System.out.print("수학 점수 입력 : ");
      s.setMath(sc.nextInt());
      
      // 총점, 평균 계산
      calcSum(s);
      calcAvg(s);
   }
   
   // 3인 점수 입력 - insertScoreAll
   public void insertScoreAll() {
      for(int i=0; i<stuArr.length; i++)
         insertScore(stuArr[i], i+1);
   }
   
   // 점수 정보 1명 입력(선택)
   public void insertScoreIdx() {
      int idx = getIdx();
      insertScore(stuArr[idx-1], idx);
   }
   
   // 총점 계산 기능 - calcSum
   private void calcSum(Student stu) {
      stu.setSum( stu.getKor()
            + stu.getEng()
            + stu.getMath() );
   }
   
   // 평균 계산 기능 - calcAvg
   private void calcAvg(Student stu) {
      stu.setAvg( stu.getSum()/(double)3 );
   }
   // -------------------------
   
   
   
   // ---------- 출력 기능 ----------
   /* ver1 코드 삭제
   public void printStu() {
      System.out.println(" ++ 출력 ++");
      System.out.println("이름 : " + stu.getName());
      System.out.println("나이 : " + stu.getAge());
      
      System.out.println("Kor : " + stu.getKor());
      System.out.println("Eng : " + stu.getEng());
      System.out.println("Math : " + stu.getMath());

      System.out.println("총점 : " + stu.getSum());
      System.out.println("평균 : " + stu.getAvg());
   }
   */
   
   private void printStu(Student s, int i) {
      System.out.println(" ++ " + i + "번째 학생 출력 ++");
      System.out.println("이름\t나이\t국어\t영어\t수학\t총점\t평균");
      System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\t%.2f\n",
            s.getName(),s.getAge(),
            s.getKor(),s.getEng(),s.getMath(),
            s.getSum(),s.getAvg());
   }
   
   // 3인 출력 기능 - printStuAll
   public void printStuAll() {
      
//      int i=1;
//      for( Student s : stuArr )
//         printStu(s, i++);
      
      for(int i=0; i<stuArr.length; i++)
         printStu(stuArr[i], i+1);
   }
   
   // 학생 1명 선택해서 출력 기능
   public void printStuIdx() {
      int idx = getIdx();
      printStu(stuArr[idx-1], idx);
   }
   // -------------------------
}