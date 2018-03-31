package org.csse2018;

import java.util.LinkedList;

public class GradeSystem {
	private float weights;
	private LinkedList grades;

	public GradeSystem() {
		fr = new FileReader("grades.txt")
	}
	public boolean containsID(int ID) {
		return true;
	}
	public void showGrade(int ID) {}
	public void showRank(int ID) {}
	public void updateWeights() {}
	public Grades find(int ID) {
		return new Grades();
	}
}
