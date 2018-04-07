package main;

import java.io.IOException;

import main.UI.Cmd;
import main.UI.NoSuchCommandExceptions;

public class Main {

	public static void main(String[] args) {
		UI ui = new UI();
		GradeSystem gs = null;
		try {
			gs = new GradeSystem();
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (true) {
			String id = ui.promptID();
			if (id.equalsIgnoreCase("Q")) {
				System.out.println("Quit");
				break;
			}
			Grade student = gs.find(id);
			if (student == null) {
				System.out.println("Invalid ID");
				continue;
			}
			ui.showWelcomeMsg(student);

			while (true) {
				Cmd cmd = null;
				try {
					cmd = ui.promptCommand();
				} catch (NoSuchCommandExceptions e) {
					System.out.println("Invalid Command");
					continue;
				}

				if (cmd == Cmd.G) {
					gs.showGrade(student);
				} else if (cmd == Cmd.R) {
					gs.showRank(student);
				} else if (cmd == Cmd.A) {
					gs.showAverage();
				} else if (cmd == Cmd.W) {
					gs.promptUpdateWeights();
				} else if (cmd == Cmd.E) {
					System.out.println("Exit");
					break;
				}
			}
		}
	}

}
