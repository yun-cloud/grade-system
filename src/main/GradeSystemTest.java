package main;

import static org.junit.Assert.*;

import java.io.*;

import org.junit.Test;

public class GradeSystemTest {

	/**-------------------------------------------------------
	 *Test GradeSystem Object's methods
	 *
	 *variables: (all are private)
	 *	(x) -> ArrayList<Grade> students
	 *	(x) -> double[] weights
	 *
	 *methods:
	 *	(o) -> Grade find(String )
	 *	(o) -> void showGrade(Grade )
	 *	(o) -> void showAverage()
	 *	(o) -> void showRank(Grade )
	 *	(o) -> void updateWeights(double[] )
	 *	(o) -> void promptUpdateWeights()
	 *	(x) -> void updateRank() (private method)
	 *
	 *cases:
	 *	case1:
	 *		Parsing String:"955002056 許文馨 88 92 88 98 91" as a testing Grade.
	 *		testing whether:
	 *			gs.find("955002056") equals to above Grade.
	 *			gs.showGrade(above Grade) equals to above Grade's totalGrade.
	 *			gs.showRank(above Grade) equals to above Grade's rank.
	 *			gs.updateWeights(0.2, 0.2, 0.2, 0.2, 0.2) correctly change above Grade's totalGrade and rank.
	 *
	 *	case2:
	 *		Parsing String:"985002016 王　淳 97 96 89 85 80" as a testing Grade.
	 *		testing whether:
	 *			gs.find("985002016") equals to above Grade.
	 *			gs.showGrade(above Grade) equals to above Grade's totalGrade.
	 *			gs.showRank(above Grade) equals to above Grade's rank.
	 *			gs.updateWeights(0, 0, 0, 0, 0) correctly change above Grade's totalGrade and rank.
	 *
	 *	case3:
	 *		testing whether gs.showAverage() equals to average of all students' totalGrade.
	 *
	 *	case4:
	 *		gs.find("955002056") to find a Grade.
	 *		than testing whether gs.promptUpdateWeights() really change weights and so on above Grade's totalGrade.
	 ---------------------------------------------------------*/
	@Test
	public void GradeSystemtest_student1() throws IOException {
		GradeSystem gs = new GradeSystem();

		String s1 = "955002056 許文馨 88 92 88 98 91";
		String stu1_id = "955002056";
		Grade student1 = new Grade(s1); // Grade has already be tested

		// test Grade find(String )
		assertEquals(student1.ID, gs.find(student1.ID).ID);
		assertEquals(student1.name, gs.find(student1.ID).name);
		assertEquals(student1.grades.length, gs.find(student1.ID).grades.length);
		for(int i=0; i<student1.grades.length; i++) {
			assertEquals(student1.grades[i], gs.find(student1.ID).grades[i]);
		}

		// test void showGrade(Grade )
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);

		gs.showGrade(gs.find(stu1_id));
		assertEquals("許文馨's grade:\r\n"
				+ "lab1:\t88\r\n"
				+ "lab2:\t92\r\n"
				+ "lab3:\t88\r\n"
				+ "mid-term:\t98\r\n"
				+ "final exam:\t91\r\n"
				+ "total grade:\t93\r\n", baos.toString());
		baos.reset();

		//test showRank(Grade )
		gs.showRank(gs.find(stu1_id));
		assertEquals("許文馨's rank: 9\r\n", baos.toString());
		baos.reset();

		//test updateWeight(double[] ) # also test the private method updateRank() too.
		double[] newWeights = {0.2, 0.2, 0.2, 0.2, 0.2};
		gs.updateWeights(newWeights);
		assertEquals(91, gs.find(stu1_id).totalGrade);
		assertEquals(17, gs.find(stu1_id).rank);
	}

	@Test
	public void GradeSystemtest_student2() throws IOException {
		GradeSystem gs = new GradeSystem();

		String s2 = "985002016 王　淳 97 96 89 85 80";
		String stu2_id = "985002016";
		Grade student2 = new Grade(s2);

		// test Grade find(String )
		assertEquals(student2.ID, gs.find(student2.ID).ID);
		assertEquals(student2.name, gs.find(student2.ID).name);
		assertEquals(student2.grades.length, gs.find(student2.ID).grades.length);
		for(int i=0; i<student2.grades.length; i++) {
			assertEquals(student2.grades[i], gs.find(student2.ID).grades[i]);
		}

		// test void showGrade(Grade )
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);

		gs.showGrade(gs.find(stu2_id));
		assertEquals("王　淳's grade:\r\n" +
				"lab1:	97\r\n" +
				"lab2:	96\r\n" +
				"lab3:	89\r\n" +
				"mid-term:	85\r\n" +
				"final exam:	80\r\n" +
				"total grade:	86\r\n", baos.toString());
		baos.reset();

		//test showRank(Grade )
		gs.showRank(gs.find(stu2_id));
		assertEquals("王　淳's rank: 52\r\n", baos.toString());
		baos.reset();

		//test updateWeight(double[] ) # also test the private method updateRank() too.
		double[] newWeights = {0, 0, 0, 0, 0};
		gs.updateWeights(newWeights);
		assertEquals(0, gs.find(stu2_id).totalGrade);
		assertEquals(1, gs.find(stu2_id).rank);
	}

	@Test
	public void showAveragetest() throws IOException {
		GradeSystem gs = new GradeSystem();

		int avg = 90;

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);

		gs.showAverage();
		assertEquals("Average grade:" + Integer.toString(avg) + "\r\n", baos.toString());
	}

	@Test
	public void promptUpdateWeights() throws IOException {
		GradeSystem gs = new GradeSystem();

		double totalgrade = 0.0f;

		// proof that weights don't change
		Grade student = gs.find("955002056");
		totalgrade = 0;

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);

		String input = "0\n0\n0\n0\n0\ny\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		gs.promptUpdateWeights();

		assertEquals("Old Weights:\r\n" +
				"lab1:	10.0%\r\n" +
				"lab2:	10.0%\r\n" +
				"lab3:	10.0%\r\n" +
				"mid-term:	30.0%\r\n" +
				"final exam:	40.0%\r\n" +
				"New Weights:\r\n" +
				"lab1:	lab2:	lab3:	mid-term:	final exam:	Check new Weights:\r\n" +
				"lab1:	0%\r\n" +
				"lab2:	0%\r\n" +
				"lab3:	0%\r\n" +
				"mid-term:	0%\r\n" +
				"final exam:	0%\r\n" +
				"Is it correct?(y/n)\r\n", baos.toString());

		assertEquals(Math.round(totalgrade), gs.find("955002056").totalGrade);
	}
}
