package main;

import java.util.Scanner;

public class UI {
	private static final String PROMPT_COMMAND_MESSAGE = "Insert command:\n" + "\tG) Show Grade\n" + "\tR) Show Rank\n"
			+ "\tA) Show Average\n" + "\tW) Update Weight\n" + "\tE) Exit\n" + "> ";
	private static final String PROMPT_ID_MESSAGE = "Enter ID or insert 'Q' to exit: ";

	public enum Cmd {
		G, R, A, W, E
	}

	public static class NoSuchIDExceptions extends Exception {
	}

	public static class NoSuchCommandExceptions extends Exception {
	}

	public UI() {
	}

	public Cmd promptCommand() throws NoSuchCommandExceptions {
		System.out.print(PROMPT_COMMAND_MESSAGE);

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
		System.out.print(PROMPT_ID_MESSAGE);
		return Input.getScanner().next();
	}

	public void showFinishMsg() {
		System.out.println("Done.");
	}

	public void showWelcomeMsg(Grade student) {
		System.out.println("Welcome " + student.name);
	}

}
