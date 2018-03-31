package org.csse2018;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new UI();
		} catch (NoSuchIDExceptions e1) {
			System.out.println("Invalid ID!");
		} catch (NoSuchCommandExceptions e2) {
			System.out.println("Invalid Command!");
		}

	}

	public static class NoSuchIDExceptions extends Exception {}
	public static class NoSuchCommandExceptions extends Exception {}

}
