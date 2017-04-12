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
			System.out.println("1. �߰� ");
			System.out.println("2. ��ü ��� ");
			System.out.println("3. �˻� ");
			System.out.println("4. ���� ");
			System.out.println("5. ���� ");
			System.out.println("��� ���� ? [�⺻ ���̽� ������ �߰� �κ��� ������ �˴ϴ�.]");
			
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
				System.out.println("���� �Ǿ����ϴ�.");
				Num = 0;
				break;
			default:
				System.out.println("����ε� �Է°��� �Է����ּ���");
			}
		}
		
	}

	private static void delete() throws IOException {
		// TODO Auto-generated method stub
		int num;
		System.out.println("����� �� ����� (����) ��� �Դϱ�? [������ 1�� Ʋ���� �ƹ�����]");
		num = sc.nextInt();
		if(num==1){
			try {
				sc.nextLine();
				System.out.println("���� �� å�� �̸��� �����ּ���.");
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
					System.out.println("�����ϴ� Ű����� ���� ���� �ʽ��ϴ�.");
				}
				
				rr.close();
				CPath.delete();
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else{
			System.out.println("�ٸ� ����� �������ּ���.");
		}
	}

	private static void Ser() throws IOException {
		// TODO Auto-generated method stub
		int num;
		System.out.println("����� �� ����� (�˻�) ��� �Դϱ�? [������ 1�� Ʋ���� �ƹ�����]");
		num = sc.nextInt();
		if(num==1){
			BufferedReader r = new BufferedReader(new FileReader(WPath));
			int Num_s = -1;
			while(Num_s != 0){
			System.out.println("[���� ����]");
			System.out.println("1. å �̸�  \t 2. å ����  \t 3. ���� [������ �ܾ� ���־ ��µ˴ϴ�.]");
			System.out.println("���� ���?");
			int ser = sc.nextInt();
			switch(ser){
			case 1:
				
				sc.nextLine();
				System.out.println("å �̸� ��[��] �����ּ���.");
				String BoName= sc.nextLine();
				System.out.println("å �̸��� " + "[" + BoName + "]" + "�� �½��ϱ�? [������ 1�� Ʋ���� �ƹ�����]");
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
					System.out.println("�հ� : " + Count + "\n");
				}
				r.close();
				Num_s = 0;
				break;
			case 2:
				sc.nextLine();
				System.out.println("å ���� ��[��] �����ּ���.");
				String BooName= sc.nextLine();
				System.out.println("å �������̸��� " + "[" + BooName + "]" + "�� �½��ϱ�? [������ 1�� Ʋ���� �ƹ�����]");
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
				System.out.println("�հ� : " + Count + "\n");
				}
				Num_s = 0;
				r.close();
				break;
			case 3:
				sc.nextLine();
				System.out.println("���� �ܾ� �� �����ּ���.");
				String BookName= sc.nextLine();
				System.out.println("���� �ܾ " + "[" + BookName + "]" + "�� �½��ϱ�? [������ 1�� Ʋ���� �ƹ�����]");
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
				System.out.println("�հ� : " + Count + "\n");
				}
				Num_s = 0;
				break;
			default:
				Num_s = 1;
				System.out.println("����ε� �Է°��� �Է����ּ���");
				r.close();
				break;
			}
		 }
		}else{
			System.out.println("�ٸ� ����� �������ּ���.");
		}
	}

	private static void print() throws IOException {
		// TODO Auto-generated method stub
		int num;
		System.out.println("����� �� ����� (��� ���) ��� �Դϱ�? [������ 1�� Ʋ���� �ƹ�����]");
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
				System.out.println("�հ� : "  + Count + "\n");
				r.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("���� �� ������ �ֽ��ϴ�.");
				System.out.println("1. �߰� ����� ���� ���ּ���.");
			}
		}else{
			System.out.println("�ٸ� ����� �������ּ���.");
		}
	}

	private static void Plus() throws IOException {
		// TODO Auto-generated method stub
		int num;
		System.out.println("����� �� ����� (�߰�) ��� �Դϱ�? [������ 1�� Ʋ���� �ƹ�����]");
		num = sc.nextInt();
		if(num==1){
			File file = new File(FPath);
			if(!file.exists()){
				file.mkdirs();
				System.out.println("��� ���� �Ϸ�!" + "\n");
				
			}else{
				System.out.println("��� Ȯ�� �Ϸ�!" + "\n");
			}
		
			
			try {
				BufferedWriter w = new BufferedWriter(new FileWriter(WPath,true));
				int set = -1;
				while(set != 0){
				sc.nextLine();
				System.out.println("å �̸� ��[��] �����ּ���.");
				String Boname = sc.nextLine();
				System.out.println("å ���� ��[��] �����ּ���.");
				String BoWrit = sc.nextLine();
				System.out.println("���ǻ�  ��[��] �����ּ���.");
				String pu = sc.nextLine();
				System.out.println("���� ��[��] �����ּ���.");
				String pay = sc.nextLine();
				
				System.out.println("[�Է� ����]");
				System.out.println("å �̸� : " + Boname + "\tå ���� : " + BoWrit + "\t���ǻ� : " + pu + "\t���� : " + pay);
				System.out.println("�Էµ� ������ �½��ϱ�? [������ 1�� Ʋ���� 2��]");
				set = sc.nextInt();
				if(set == 1){
					set = 0;
					w.write(Boname + "\t" + BoWrit + "\t" + pu + "\t" + pay);
					w.newLine();
					w.close();
					System.out.println("���������� �ԷµǾ����ϴ�." + "\n");
				}else{
					System.out.println("�ٽ� �Է����ּ���." + "\n");
				}
				
				
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("���� �� ������ �ֽ��ϴ�.");
			}
		}else{
			System.out.println("�ٸ� ����� �������ּ���.");
		}
		
	}
}
