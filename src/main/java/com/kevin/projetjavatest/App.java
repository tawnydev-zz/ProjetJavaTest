package com.kevin.projetjavatest;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String args[]) {
		App tester = new App();

		// with type declaration
		MathOperation addition = (int a, int b) -> a + b;

		// with out type declaration
		MathOperation subtraction = (a, b) -> a - b;

		// with return statement along with curly braces
		MathOperation multiplication = (int a, int b) -> {
			return a * b;
		};

		// without return statement and without curly braces
		MathOperation division = (int a, int b) -> a / b;

		System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
		System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
		System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + tester.operate(10, 5, division));

		// without parenthesis
		GreetingService greetService1 = (message, nom) -> System.out.println("Hello "+ nom+ " I have to tell you this : " + message);

		// with parenthesis
		GreetingService repondeur = (message, nom) -> System.out.println("Hello " + nom + " your message is "+ message);

		GreetingService crier = (action, nom) -> System.out.println("ARE YOU INSANE FOR "+ action +" stupid dumb "+ nom);
		
		greetService1.sayMessage("Mahesh", "the salary has just arrived");
		repondeur.sayMessage("Suresh", "Hello Suresh it's Thom. We need to do a meeting tomorrow morning at 10, see you at office!");
		crier.sayMessage("Throw your mobile so hard against the floor", "fool");
	}

	interface MathOperation {
		int operation(int a, int b);
	}

	interface GreetingService {
		void sayMessage(String message, String nom);
	}

	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}
}
