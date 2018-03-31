package main;

import java.util.Scanner;

public class UI {
	
	public enum Cmd { G, R, A, W, E }
	
	public static class NoSuchIDExceptions extends Exception {}
	public static class NoSuchCommandExceptions extends Exception {}
	
	public UI() {}

	public Cmd promptCommand() throws NoSuchCommandExceptions {
		System.out.println("Insert command:");
		System.out.println("\tG) Show Grade");
		System.out.println("\tR) Show Rank");
		System.out.println("\tA) Show Average");
		System.out.println("\tW) Update Weight");
		System.out.println("\tE) Exit");
		System.out.println("> ");
		
		String input = Input.getScanner().next();
		Cmd cmd;
		try {
			cmd = Cmd.valueOf(input);
		} catch (Exception e) {
			throw new NoSuchCommandExceptions();
		}
		return cmd;
	}

	public String promptID() {
		System.out.println("Enter ID or insert 'Q' to exit: ");
		return Input.getScanner().next();
	}

	public void showFinishMsg() {
		System.out.println("Done.");
	}

	public void showWelcomeMsg(Grade student) {
		System.out.println("Welcome " + student.name);
	}
	
	
}
