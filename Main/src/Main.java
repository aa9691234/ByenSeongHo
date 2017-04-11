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

	private static void delete() {
		// TODO Auto-generated method stub
		int num;
		System.out.println("����� �� ����� (����) ��� �Դϱ�? [������ 1�� Ʋ���� 2��]");
		num = sc.nextInt();
		if(num==1){
			
		}else{
			System.out.println("�ٸ� ����� �������ּ���.");
		}
	}

	private static void Ser() {
		// TODO Auto-generated method stub
		int num;
		System.out.println("����� �� ����� (�˻�) ��� �Դϱ�? [������ 1�� Ʋ���� 2��]");
		num = sc.nextInt();
		if(num==1){
			int Num_s = -1;
			while(Num_s != 0){
			System.out.println("[���� ����]");
			System.out.println("1. å �̸�  \t 2. ����  \t 3. ���� ");
			System.out.println("���� ���?");
			int ser = sc.nextInt();
			switch(ser){
			case 1:
				Num_s = 0;
				break;
			case 2:
				Num_s = 0;
				break;
			case 3:
				Num_s = 0;
				break;
			default:
				Num_s = 1;
				System.out.println("����ε� �Է°��� �Է����ּ���");
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
		System.out.println("����� �� ����� (��� ���) ��� �Դϱ�? [������ 1�� Ʋ���� 2��]");
		num = sc.nextInt();
		if(num==1){
			try {
				BufferedReader r = new BufferedReader(new FileReader(WPath));
				int Count = 0;
				String Reading = "";
				while((Reading = r.readLine()) !=null){
					Count++;
					System.out.println(Count + ". " +Reading);
				}
				System.out.println("�հ� : "  + Count + "\n");
				
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
		System.out.println("����� �� ����� (�߰�) ��� �Դϱ�? [������ 1�� Ʋ���� 2��]");
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
				if(set != 2){
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
