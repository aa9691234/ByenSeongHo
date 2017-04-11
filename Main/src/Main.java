import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int Num = -1;
		while(Num != 0){
			System.out.println("1. 추가 ");
			System.out.println("2. 전체 출력 ");
			System.out.println("3. 검색 ");
			System.out.println("4. 삭제 ");
			System.out.println("5. 중지 ");
			System.out.println("기능 선택 ? ");
			
			Num = sc.nextInt();
			switch(Num){
			case 1: 
				Plus();
				break;
			case 2: 
				print();
				break;
			case 3: 
				Ser();
				break;
			case 4: 
				delete();
				break;
			case 5: 
				System.out.println("END");
				Num = 0;
				break;
			
			}
		}
		
	}

	private static void delete() {
		// TODO Auto-generated method stub
		
	}

	private static void Ser() {
		// TODO Auto-generated method stub
		
	}

	private static void print() {
		// TODO Auto-generated method stub
		
	}

	private static void Plus() {
		// TODO Auto-generated method stub
		
		
	}
}
