package org.csse2018;

import java.util.Scanner;
import org.csse2018.Main.NoSuchCommandExceptions;
import org.csse2018.Main.NoSuchIDExceptions;

public class UI {
	private GradeSystem gs;

	private enum Cmd { G, R, A, W, E }

	public UI() throws NoSuchIDExceptions, NoSuchCommandExceptions {
		this.gs = new GradeSystem();
		while (true) {
			int id = this.promptID();
			if (id == -1) {
				break;
			}
			this.checkID(id);
			this.showWelcomeMsg(id);
			while (true) {
				Cmd cmd = this.promptCommand();
				if (cmd == Cmd.G) {
					this.gs.showGrade(id);
				} else if (cmd == Cmd.R) {
					this.gs.showRank(id);
				} else if (cmd == Cmd.A) {
					// ???
				} else if (cmd == Cmd.W) {
					this.gs.updateWeights();
				} else if (cmd == Cmd.E) {
					System.out.println("Exit");
					break;
				}
			}
		}
		this.showFinishMsg();
	}

	public boolean checkID(int ID) throws NoSuchIDExceptions {
		if (!this.gs.containsID(ID)) {
			throw new NoSuchIDExceptions();
		}
		return true;
	}

	public Cmd promptCommand() throws NoSuchCommandExceptions {
		System.out.println("Insert command:");
		System.out.println("\nG) Show Grade");
		System.out.println("\nR) Show Rank");
		System.out.println("\nA) Show Average");
		System.out.println("\nW) Update Weight");
		System.out.println("\nE) Exit");
		System.out.println("> ");
		try (Scanner scanner = new Scanner(System.in)) {
			String input = scanner.next();
			Cmd cmd;
			try {
				cmd = Cmd.valueOf(input);
			} catch (Exception e) {
				throw new NoSuchCommandExceptions();
			}
			return cmd;
		}
	}

	public int promptID() {
		System.out.println("Enter ID or insert 'Q' to exit: ");
		try (Scanner scanner = new Scanner(System.in)) {
			String input = scanner.next();
			int id;
			try {
				id = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				return -1;
			}

			return id;
		}
	}

	public void showFinishMsg() {
		System.out.println("Done.");
	}

	public void showWelcomeMsg(int ID) {
		String name = gs.find(ID).getName();
		System.out.println("Welcome " + name);
	}
}
