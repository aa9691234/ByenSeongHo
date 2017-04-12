import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static String FPath = "C:\\Book";
	public static String WPath = "C:\\Book\\Book.txt";
	public static void main(String[] args) throws IOException{
		int Num = -1;
		while(Num != 0){
			System.out.println("1. 추가 ");
			System.out.println("2. 전체 출력 ");
			System.out.println("3. 검색 ");
			System.out.println("4. 삭제 ");
			System.out.println("5. 중지 ");
			System.out.println("기능 선택 ? [기본 베이스 파일은 추가 로부터 생성이 됩니다.]");
			
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
				System.out.println("중지 되었습니다.");
				Num = 0;
				break;
			default:
				System.out.println("제대로된 입력값을 입력해주세요");
			}
		}
		
	}

	private static void delete() throws IOException {
		// TODO Auto-generated method stub
		int num;
		System.out.println("당신이 고른 기능은 (삭제) 기능 입니까? [맞으면 1번 틀리면 아무숫자]");
		num = sc.nextInt();
		if(num==1){
			try {
				sc.nextLine();
				System.out.println("삭제 할 책의 이름을 적어주세요.");
				String BoName = sc.nextLine();
				
				
				File CPath = new File("C:\\Book\\BookCopy.txt");
				File WCPath = new File(WPath);

				CPath.createNewFile();
				
				int Num = 0;
				String Ser = "";
				BufferedReader r = new BufferedReader(new FileReader(WPath));
				while((Ser = r.readLine()) != null ){
					String[] split = Ser.split("\t");
					if(!(split[0].equals(BoName))){
						BufferedWriter ww = new BufferedWriter(new FileWriter("C:\\Book\\BookCopy.txt",true));
						ww.write(Ser);
						ww.newLine();
						ww.close();
					}else{
						Num++;
					}
				}
				r.close();				
				WCPath.delete();
				
				Ser = "";
				
				BufferedReader rr = new BufferedReader(new FileReader("C:\\Book\\BookCopy.txt"));
				while((Ser = rr.readLine()) != null ){
					BufferedWriter w = new BufferedWriter(new FileWriter(WPath,true));
						w.write(Ser);
						w.newLine();
						w.close();
				}
				
				
				if(Num == 0){
					System.out.println("삭제하는 키워드는 존재 하지 않습니다.");
				}
				
				rr.close();
				CPath.delete();
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else{
			System.out.println("다른 기능을 선택해주세요.");
		}
	}

	private static void Ser() throws IOException {
		// TODO Auto-generated method stub
		int num;
		System.out.println("당신이 고른 기능은 (검색) 기능 입니까? [맞으면 1번 틀리면 아무숫자]");
		num = sc.nextInt();
		if(num==1){
			BufferedReader r = new BufferedReader(new FileReader(WPath));
			int Num_s = -1;
			while(Num_s != 0){
			System.out.println("[선택 사항]");
			System.out.println("1. 책 이름  \t 2. 책 저자  \t 3. 통합 [유사한 단어 만있어도 출력됩니다.]");
			System.out.println("선택 기능?");
			int ser = sc.nextInt();
			switch(ser){
			case 1:
				
				sc.nextLine();
				System.out.println("책 이름 를[을] 적어주세요.");
				String BoName= sc.nextLine();
				System.out.println("책 이름이 " + "[" + BoName + "]" + "이 맞습니까? [맞으면 1번 틀리면 아무숫자]");
				int Num_n = sc.nextInt();
				if(Num_n == 1){
					
				int Count = 0;
				String Reading = "";
				while((Reading = r.readLine()) != null){
				String[] split = Reading.split("\t");
				if(split[0].equals(BoName)){
					Count++;
					System.out.println(Count + ". " + Reading);
					
				}
				
				}
					System.out.println("합계 : " + Count + "\n");
				}
				r.close();
				Num_s = 0;
				break;
			case 2:
				sc.nextLine();
				System.out.println("책 저자 를[을] 적어주세요.");
				String BooName= sc.nextLine();
				System.out.println("책 저자의이름이 " + "[" + BooName + "]" + "이 맞습니까? [맞으면 1번 틀리면 아무숫자]");
				int Num_a = sc.nextInt();
				if(Num_a == 1){
					
				int Count = 0;
				String Reading = "";
				while((Reading = r.readLine()) != null){
				String[] split = Reading.split("\t");
				if(split[1].equals(BooName)){
					Count++;
					System.out.println(Count + ". " + Reading);
					
				}
				
				}
				System.out.println("합계 : " + Count + "\n");
				}
				Num_s = 0;
				r.close();
				break;
			case 3:
				sc.nextLine();
				System.out.println("통합 단어 를 적어주세요.");
				String BookName= sc.nextLine();
				System.out.println("통합 단어가 " + "[" + BookName + "]" + "이 맞습니까? [맞으면 1번 틀리면 아무숫자]");
				int Num_b = sc.nextInt();
				if(Num_b == 1){
					
				int Count = 0;
				String Reading = "";
				while((Reading = r.readLine()) != null){
				
				if(Reading.contains(BookName)){
					Count++;
					System.out.println(Count + ". " + Reading);
					
				}
				
				}
				System.out.println("합계 : " + Count + "\n");
				}
				Num_s = 0;
				break;
			default:
				Num_s = 1;
				System.out.println("제대로된 입력값을 입력해주세요");
				r.close();
				break;
			}
		 }
		}else{
			System.out.println("다른 기능을 선택해주세요.");
		}
	}

	private static void print() throws IOException {
		// TODO Auto-generated method stub
		int num;
		System.out.println("당신이 고른 기능은 (모두 출력) 기능 입니까? [맞으면 1번 틀리면 아무숫자]");
		num = sc.nextInt();
		if(num==1){
			try {
				BufferedReader r = new BufferedReader(new FileReader(WPath));
				int Count = 0;
				String Reading = "";
				while((Reading = r.readLine()) !=null){
					Count++;
					System.out.println(Count + ".\t" +Reading);
				}
				System.out.println("합계 : "  + Count + "\n");
				r.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("파일 의 문제가 있습니다.");
				System.out.println("1. 추가 기능을 실행 해주세요.");
			}
		}else{
			System.out.println("다른 기능을 선택해주세요.");
		}
	}

	private static void Plus() throws IOException {
		// TODO Auto-generated method stub
		int num;
		System.out.println("당신이 고른 기능은 (추가) 기능 입니까? [맞으면 1번 틀리면 아무숫자]");
		num = sc.nextInt();
		if(num==1){
			File file = new File(FPath);
			if(!file.exists()){
				file.mkdirs();
				System.out.println("경로 설정 완료!" + "\n");
				
			}else{
				System.out.println("경로 확인 완료!" + "\n");
			}
		
			
			try {
				BufferedWriter w = new BufferedWriter(new FileWriter(WPath,true));
				int set = -1;
				while(set != 0){
				sc.nextLine();
				System.out.println("책 이름 를[을] 적어주세요.");
				String Boname = sc.nextLine();
				System.out.println("책 저자 를[을] 적어주세요.");
				String BoWrit = sc.nextLine();
				System.out.println("출판사  를[을] 적어주세요.");
				String pu = sc.nextLine();
				System.out.println("가격 를[을] 적어주세요.");
				String pay = sc.nextLine();
				
				System.out.println("[입력 정보]");
				System.out.println("책 이름 : " + Boname + "\t책 저자 : " + BoWrit + "\t출판사 : " + pu + "\t가격 : " + pay);
				System.out.println("입력된 정보가 맞습니까? [맞으면 1번 틀리면 2번]");
				set = sc.nextInt();
				if(set == 1){
					set = 0;
					w.write(Boname + "\t" + BoWrit + "\t" + pu + "\t" + pay);
					w.newLine();
					w.close();
					System.out.println("성공적으로 입력되었습니다." + "\n");
				}else{
					System.out.println("다시 입력해주세요." + "\n");
				}
				
				
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("파일 의 문제가 있습니다.");
			}
		}else{
			System.out.println("다른 기능을 선택해주세요.");
		}
		
	}
}
