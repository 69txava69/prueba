package tunombre;

import java.util.Scanner;

public class Dinombre {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
System.out.println("Dime tu nombre");
Scanner teclado = new Scanner(System.in);
String nom= teclado.next();
System.out.println("Hola "+ nom +", perteneces a la generación del futuro");
	}

}
