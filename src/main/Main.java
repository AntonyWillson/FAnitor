package main;

import java.util.ArrayList;
import java.util.Scanner;

import model.Designer;
import model.Gaming;
import model.Monitor;

public class Main {
	Scanner s = new Scanner(System.in);
	ArrayList<Monitor> monitorList = new ArrayList<>();
	
	public Main() {
		while (true) {
			System.out.println("FAnitor");
			System.out.println("1. Insert Monitor");
			System.out.println("2. View Monitor");
			System.out.println("3. Delete Monitor");
			System.out.println("4. Exit");
			
			int choose;
			do {
				try {
					System.out.print(">> ");
					choose = s.nextInt();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					choose = 0;
				}
			} while (choose < 1 || choose > 4);
			
			switch (choose) {
			case 1:
				menu1();
				break;
			case 2:
				menu2();
				break;
			case 3:
				menu3();
				break;
			case 4:
				System.exit(0);
				break;

			}
		}

	}
	
	void menu1() {
		String brand;
		do {
			System.out.print("Insert monitor brand [AOC | LG | ASUS] : ");
			brand = s.nextLine();
		} while (!brand.equals("AOC") && !brand.equals("LG") && !brand.equals("ASUS"));
		
		String name;
		do {
			System.out.print("Insert monitor name [minimum 5 character]: ");
			name = s.nextLine();
		} while (name.length() < 5);
		
		int size;
		do {
			System.out.print("Input Monitor Size [20 - 30 inch] : ");
			size = s.nextInt();s.nextLine();
		} while (size < 20 || size > 30);
		
		double weight;
		do {
			try {
				System.out.print("Input Monitor Weight [1.5 - 3.0 kg] : ");
				weight = s.nextDouble();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				weight = 0;
			}s.nextLine();
		} while (weight < 1.5 || weight > 3.0);
		
		String type;
		do {
			System.out.print("Input monitor type [Designer | Gaming] : ");
			type = s.nextLine();
		} while (!type.equals("Designer") && !type.equals("Gaming"));
		
		if (type.equals("Designer")) {
			double color;
			do {
				try {
					System.out.print("Input color accuracy [0,0 - 2.0] : ");
					color = s.nextDouble();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					color = -1;
				}
			} while (color < 0 || color > 2);
			
			Monitor d = new Designer(brand, name, size, weight, type, color);
			monitorList.add(d);
			
			System.out.println(" ");
			System.out.println("New Designer monitor has been added!");
			System.out.println("Press enter to contiunue");s.nextLine();
		}else if (type.equals("Gaming")) {
			int rate;
			do {
				try {
					System.out.print("Input refresh rate [120 | 144 | 240] : ");
					rate = s.nextInt();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					rate = -1;
				}
			} while (rate != 120 && rate != 144 && rate != 240);
			Monitor g = new Gaming(brand, name, size, weight, type, rate);
			monitorList.add(g);
			System.out.println(" ");
			System.out.println("New Gaming monitor has been added!");
			System.out.println("Press enter to contiunue");s.nextLine();
		}
		
		
	}
	
	void menu2() {
		if (monitorList.isEmpty()) {
			System.out.println("Kosong");
			System.out.println("Press enter to continue");s.nextLine();
		}else {
			System.out.println("FAnitor CAtalouge");
			System.out.println("=========================================================================================================");
			System.out.printf("|%-5s|%-10s|%-10s|%-20s|%-5s|%-5s|%-10s|%-10s|%-20s|\n","No.","Type","Brand","Name","Size","Weight","Color Accuracy","Refresh Rate","Price");
			System.out.println("=========================================================================================================");
			for (int i = 0; i < monitorList.size(); i++) {
				Monitor m = monitorList.get(i);
				if (m instanceof Gaming) {
					System.out.printf("|%-5s|%-10s|%-10s|%-20s|%-5s|%-5s|%-10s|%-10s|%-20s|\n",(i+1),m.getType(),m.getBrand(),m.getName(),m.getSize(),m.getWeight()," - ",((Gaming)m).rate,m.Hitung());
				}else if (m instanceof Designer) {
					System.out.printf("|%-5s|%-10s|%-10s|%-20s|%-5s|%-5s|%-10s|%-10s|%-20s|\n",(i+1),m.getType(),m.getBrand(),m.getName(),m.getSize(),m.getWeight(),((Designer)m).color," - ",m.Hitung());
				}
			}
			System.out.println("=========================================================================================================");
			System.out.println("Press Enter to Continue...");s.nextLine();
		}
	}
	
	void menu3() {
		if (monitorList.isEmpty()) {
			System.out.println("Kosong");
			System.out.println("Press enter to continue");s.nextLine();
		}else {
			int choose;
			do {
				try {
					System.out.println("Chooe monitor to delete [1.."+monitorList.size()+"] : ");
					choose = s.nextInt();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					choose = -1;
				}s.nextLine();
			} while (choose <= 0 || choose > monitorList.size());
			
			monitorList.remove(choose -1);
			System.out.println("Monitor deleted!");
			System.out.println(" ");
			System.out.println("Press enter to continue");s.nextLine();
		}
	}

	public static void main(String[] args) {
		new Main();

	}

}
