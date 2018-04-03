package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import main.Grade;

public class GradeSystem {
	private ArrayList<Grade> students;
	private static final double[] INITIAL_WEIGHTS = new double[] { 0.1, 0.1, 0.1, 0.3, 0.4 };
	private double[] weights = new double[5];

	public GradeSystem() throws IOException {
		students = new ArrayList<Grade>();
		try (FileInputStream in = new FileInputStream("src/gradeinput.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));) {
			br.read(); // fixed a weird bug
			String line;
			while ((line = br.readLine()) != null) {
				students.add(new Grade(line.trim()));
			}
			updateWeights(INITIAL_WEIGHTS);
		}
	}

	public Grade find(String ID) {
		for (Grade student : students) {
			if (student.ID.equals(ID)) {
				return student;
			}
		}
		return null;
	}

	public void showGrade(Grade student) {
		System.out.println(student.name + "'s grade:");
		for (int i = 0; i < Grade.NUM_GRADE; i++) {
			System.out.println(String.format("%s:\t%s", Grade.grade_names[i], student.getGrade(i)));
		}
		System.out.println("total grade:\t" + student.totalGrade);
	}

	public void showAverage(Grade student) {
		System.out.println(student.name + "'s total grade:" + student.totalGrade);
	}

	public void showRank(Grade student) {
		System.out.println(student.name + "'s rank: " + student.rank);
	}

	public void updateWeights(double[] newWeights) {
		for (int i = 0; i < 5; i++) {
			weights[i] = newWeights[i];
		}

		for (Grade student : students) {
			student.updateTotalGrade(weights);
		}

		Collections.sort(students, new Comparator<Grade>() {
			@Override
			public int compare(Grade s1, Grade s2) {
				// reverse order
				return Integer.compare(s2.totalGrade, s1.totalGrade);
			}
		});

		updateRank();
	}

	public void promptUpdateWeights() {
		System.out.println("Old Weights:");
		for (int i = 0; i < Grade.NUM_GRADE; i++) {
			System.out.println(String.format("\t%s:\t%s%%", Grade.grade_names[i], weights[i] * 100));
		}

		double[] newWeights = new double[5];
		System.out.println("New Weights:");
		for (int i = 0; i < Grade.NUM_GRADE; i++) {
			System.out.print(String.format("\t%s:\t", Grade.grade_names[i]));
			newWeights[i] = Input.getScanner().nextDouble();
		}

		System.out.println("Check new Weights:");
		for (int i = 0; i < Grade.NUM_GRADE; i++) {
			System.out.println(String.format("\t%s:\t%s%%", Grade.grade_names[i], newWeights[i]));
		}

		System.out.println("Is it correct?(y/n)");
		String answer = Input.getScanner().next();

		if (answer.equalsIgnoreCase("Y")) {
			for (int i = 0; i < Grade.NUM_GRADE; i++) {
				newWeights[i] = newWeights[i] / 100;
			}

			updateWeights(newWeights);
		}
	}

	public void updateRank() {
		// must after update weights
		int index = 0;
		int previousTotalGrade = -1;
		int previousRank = -1;

		for (Grade student : students) {
			if (previousRank == -1) {
				student.rank = index + 1;
			} else {
				if (student.totalGrade == previousTotalGrade) {
					student.rank = previousRank;
				} else {
					student.rank = index + 1;
				}
			}

			index++;
			previousTotalGrade = student.totalGrade;
			previousRank = student.rank;
		}
	}
}
