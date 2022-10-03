package firstJavaProject;
import java.util.Scanner;

public class Account extends FileWork{
	

	double balance;

	String name;
	
	String dir;
	
	Scanner scan = new Scanner(System.in);
	
	String filename = "firstJavaProject\\history.csv";
	
	
	Account(String name, double initBalance){
		this.name = name;
		this.balance  = initBalance;
	}


	void showMenu(){
		this.readFile(filename);
		System.out.println("Vítejte " + this.name + "!");
		System.out.println("Vyberte si z nabídky možností: ");
		System.out.println("A-> Zobrazit zústatek na účtu\n"
				+ "B-> Vložit peníze\n"
				+ "C-> Vybrat peníze\n"
				+ "D-> Zobrazit historii transakcí\n"
				+ "E-> Spočítat úročení\n"
				+ "F-> Převodník měn\n");
		System.out.println("\n\tCo si přejete udělat? ->");
		
		//Vychytat exception pro spatný vstup
		String choice = scan.next();
		System.out.println("Vybrali jste " + choice);
		
		switch (choice) {
		case "A":
			checkBalance();
			break;
		case "B":
			deposit();
			break;
		case "C":
			withdraw();
			break;
		case "D":
			transHistory();
			break;
		case "E":
			interest();
			break;
		case "F":
			currConverter();
			break;
		default:
			System.out.println("Neplatná volba!");
			break;
		}
	
	}

	void checkBalance(){
		System.out.println("Váš zůstatek je " + balance + "Kč");
		backToMenu();
		}

	void deposit(){
		System.out.println("Kolik peněz chcete vložit? ");
		double amount = scan.nextDouble();
		this.balance += amount;
		System.out.println("Vloženo " + amount + "Kč");
		this.writeHistory(filename, "Vklad", amount);
		backToMenu();
	}

	void withdraw(){
		System.out.println("Kolik peněz chcete vybrat? ");
		double amount = scan.nextDouble();
		this.balance -= amount;
		System.out.println("Vybráno " + amount + "Kč");
		this.writeHistory(filename, "Vyber", amount);
		backToMenu();
	}

	void transHistory() {
		this.printHistory(filename);
		backToMenu();
	}

	void interest () {
		System.out.println("Zvolte úrokovou sazbu (%): ");
		double interest = scan.nextDouble();
		System.out.println("Zvolte počet let: ");
		int years = scan.nextInt();
		
		double val=this.balance;
		
		for (int i = 0; i < years;i++) {
			val+= val*(interest/100);
		}
		
		System.out.println("Zůstatek na Vašem účtu za " + years + " let bude " + val + " Kč");
		backToMenu();
	}

	void currConverter () {
	
	}
	
	void backToMenu (){
		System.out.println("Prejete si pokracovat ? A/N ");
		String choice = scan.next();
		
		if(choice.equals("A")) {
			showMenu();
		} else {
			System.out.println("Nashledanou");
			System.exit(0);
		}
	}
	
	
	
}