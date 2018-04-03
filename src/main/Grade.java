package main;

public class Grade {
	public String name;
	public String ID;
	public static final int NUM_GRADE = 5;
	public static final String[] grade_names = new String[] { "lab1", "lab2", "lab3", "mid-term", "final exam" };
	public int[] grades = new int[NUM_GRADE];
	public int totalGrade;
	public int rank;

	public Grade(String gradeLine) {
		String[] parts = gradeLine.split(" ");
		int k = 0;
		for (String part : parts) {
			if (ID == null) {
				ID = part;
			} else if (name == null) {
				name = part;
			} else {
				grades[k] = Integer.parseInt(part);
				k++;
			}
		}
	}

	public void print() {
		System.out.print(ID + " " + name);
		for (int grade : grades) {
			System.out.print(" " + grade);
		}
		System.out.print(" " + totalGrade);
		System.out.print(" " + rank);
		System.out.println("");
	}

	public String getGrade(int index) {
		int grade = grades[index];
		if (grade < 60) {
			return grade + "*";
		} else {
			return String.valueOf(grade);
		}
	}

	public void updateTotalGrade(double[] weights) {
		double result = 0;
		for (int i = 0; i < 5; i++) {
			result += weights[i] * grades[i];
		}
		totalGrade = (int) Math.round(result);
	}
}
