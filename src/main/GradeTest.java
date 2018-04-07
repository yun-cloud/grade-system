package main;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runners.JUnit4;

public class GradeTest {

	/**-------------------------------------------------------
	 *Test Grade Object including its methods and variables
	 *
	 *variables:
	 *	(o) -> String ID
	 *	(o) -> String name
	 *	(o) -> int[] grades
	 *	(o) -> int totalGrade
	 *	(x) -> int rank (* Since no methods in Grade change rank, we don't test rank var here. )
	 *
	 *methods:
	 *	(x) -> void print() (* Is not main method, so no testing. )
	 *	(o) -> String getGrade(int )
	 *	(o) -> void updateTotalGrade(double[] )
	 *
	 *cases:
	 *	case1:
	 *		Parsing String:"1234 黃睿緯 100 100 99 90 99"
	 *		weights = {0.1, 0.1, 0.2, 0.3, 0.3}
	 *	case2:
	 *		Parsing String:"2468 呵呵 0 10 20 30 40"
	 *		weights = {0.15, 0.15, 0.2, 0.25, 0.25};
	 ---------------------------------------------------------*/
	@Test
	public void Gradetest1() {
		String s1 = "1234 黃睿緯 100 100 99 90 99";
		double[] weights = {0.1, 0.1, 0.2, 0.3, 0.3};

		String ID = "1234", name = "黃睿緯";
		int[] grades = {100, 100, 99, 90, 99};
		String[] grades_str = {"100", "100", "99", "90", "99"};
		int totalGrade = 97; //96.5

		Grade g1 = new Grade(s1);

		// test Grade constructor
		assertEquals(ID, g1.ID);
		assertEquals(name, g1.name);
		assertEquals(grades.length, g1.grades.length);
		for(int i=0; i<grades.length; i++) {
			assertEquals(grades[i], g1.grades[i]);
		}

		// test getGrade method
		for(int i=0; i<grades_str.length; i++) {
			assertEquals(grades_str[i], g1.getGrade(i));
		}

		// test updateTotalGrade method
		g1.updateTotalGrade(weights);
		assertEquals(totalGrade, g1.totalGrade);
	}

	@Test
	public void Gradetest2() {
		String s2 = "2468 呵呵 0 10 20 30 40";
		double[] weights = {0.15, 0.15, 0.2, 0.25, 0.25};

		String ID = "2468", name = "呵呵";
		int[] grades = {0, 10, 20, 30, 40};
		String[] grades_str = {"0*", "10*", "20*", "30*", "40*"};
		int totalGrade = 23; // 23

		Grade g2 = new Grade(s2);

		// test Grade constructor
		assertEquals(ID, g2.ID);
		assertEquals(name, g2.name);
		assertEquals(grades.length, g2.grades.length);
		for(int i=0; i<grades.length; i++) {
			assertEquals(grades[i], g2.grades[i]);
		}

		// test getGrade method
		for(int i=0; i<grades_str.length; i++) {
			assertEquals(grades_str[i], g2.getGrade(i));
		}

		// test updateTotalGrade method
		g2.updateTotalGrade(weights);
		assertEquals(totalGrade, g2.totalGrade);
	}

}
