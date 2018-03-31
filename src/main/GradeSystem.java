package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import main.Grade;

public class GradeSystem {
	private ArrayList<Grade> students;
	private static final double[] INITIAL_WEIGHTS = new double[] {0.1, 0.1, 0.1, 0.3, 0.4};
	private double[] weights = new double[5];

	public GradeSystem() throws IOException  {
		students = new ArrayList<Grade>();
		
		try (FileInputStream in = new FileInputStream("src/gradeinput.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
				) {
			String line;

			while ((line = br.readLine()) != null) {
				students.add(new Grade(line));
			}
			
			updateWeights(INITIAL_WEIGHTS);
			
//			for (Grade student : students) {
//				student.print();
//				showGrade(student);
//				break;
//			}
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
		System.out.println("lab1:\t" + student.getGrade(0));
		System.out.println("lab2:\t" + student.getGrade(1));
		System.out.println("lab3:\t" + student.getGrade(2));
		System.out.println("mid-term:\t" + student.getGrade(3));
		System.out.println("final exam:\t" + student.getGrade(4));
		System.out.println("total grade:\t" + student.totalGrade);
	}
	
	public void showAverage(Grade student) {
		System.out.println(student.name + "'s total grade:" + student.totalGrade);
	}
	
	public void showRank(Grade student) {
		System.out.println(student.name + "'s rank: " + student.rank);
	}
	
	public void updateWeights(double[] newWeights) {
		for (int i=0; i<5; i++) {
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
		System.out.println("lab1:\t" + weights[0] * 100 + "%");
		System.out.println("lab2:\t" + weights[1] * 100 + "%");
		System.out.println("lab3:\t" + weights[2] * 100 + "%");
		System.out.println("mid-term:\t" + weights[3] * 100 + "%");
		System.out.println("final exam:\t" + weights[4] * 100 + "%");
		

		System.out.println("New Weights:");
		System.out.print("lab1:\t");
		int lab1 =  Input.getScanner().nextInt();
		System.out.print("lab2:\t");
		int lab2 =  Input.getScanner().nextInt();
		System.out.print("lab3:\t");
		int lab3 =  Input.getScanner().nextInt();
		System.out.print("mid-term:\t");
		int midterm =  Input.getScanner().nextInt();
		System.out.print("final exam:\t");
		int finalexam =  Input.getScanner().nextInt();
		
		System.out.println("Check new Weights:");
		System.out.println("lab1:\t" + lab1 + "%");
		System.out.println("lab2:\t" + lab2 + "%");
		System.out.println("lab3:\t" + lab3 + "%");
		System.out.println("mid-term:\t" + midterm + "%");
		System.out.println("final exam:\t" + finalexam + "%");
		
		System.out.println("Is it correct?(y/n)");
		String answer = Input.getScanner().next();
		
		if (answer.equalsIgnoreCase("Y")) {
			double[] newWeights = new double[] {
					((double) lab1) / 100,
					((double) lab2) / 100,
					((double) lab3) / 100,
					((double) midterm) / 100,
					((double) finalexam) / 100,
			};
			
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
