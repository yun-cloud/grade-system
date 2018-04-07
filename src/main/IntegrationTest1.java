package main;

import static org.junit.Assert.*;

import java.io.*;

import org.junit.Test;

public class IntegrationTest1 {

	/**-------------------------------------------------------
	 *Test whole grade system
	 *
	 *cases:
	 *	case1:
	 *		Parsing String:"1234\nK\nX\n955002056\nG\nH\nR\nA\nW\n20\n20\n20\n20\n20\ny\nG\nW\n0\n0\n0\n0\n0\nn\nG\nE\nQ\n"
	 *		testing whether whole system run as expected
	 ---------------------------------------------------------*/
	@Test
	public void maintest() throws IOException {
		String input = "1234\nK\nX\n955002056\nG\nH\nR\nA\nW\n20\n20\n20\n20\n20\ny\nG\nW\n0\n0\n0\n0\n0\nn\nG\nE\nQ\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);

		Main.main(null);

		assertEquals("Enter ID or insert 'Q' to exit: \r\n" +
				"Invalid ID\r\n" +
				"Enter ID or insert 'Q' to exit: \r\n" +
				"Invalid ID\r\n" +
				"Enter ID or insert 'Q' to exit: \r\n" +
				"Invalid ID\r\n" +
				"Enter ID or insert 'Q' to exit: \r\n" +
				"Welcome 許文馨\r\n" +
				"Insert command:\r\n" +
				"	G) Show Grade\r\n" +
				"	R) Show Rank\r\n" +
				"	A) Show Average\r\n" +
				"	W) Update Weight\r\n" +
				"	E) Exit\r\n" +
				"> \r\n" +
				"許文馨's grade:\r\n" +
				"lab1:	88\r\n" +
				"lab2:	92\r\n" +
				"lab3:	88\r\n" +
				"mid-term:	98\r\n" +
				"final exam:	91\r\n" +
				"total grade:	93\r\n" +
				"Insert command:\r\n" +
				"	G) Show Grade\r\n" +
				"	R) Show Rank\r\n" +
				"	A) Show Average\r\n" +
				"	W) Update Weight\r\n" +
				"	E) Exit\r\n" +
				"> \r\n" +
				"Invalid Command\r\n" +
				"Insert command:\r\n" +
				"	G) Show Grade\r\n" +
				"	R) Show Rank\r\n" +
				"	A) Show Average\r\n" +
				"	W) Update Weight\r\n" +
				"	E) Exit\r\n" +
				"> \r\n" +
				"許文馨's rank: 9\r\n" +
				"Insert command:\r\n" +
				"	G) Show Grade\r\n" +
				"	R) Show Rank\r\n" +
				"	A) Show Average\r\n" +
				"	W) Update Weight\r\n" +
				"	E) Exit\r\n" +
				"> \r\n" +
				"Average grade:90\r\n" +
				"Insert command:\r\n" +
				"	G) Show Grade\r\n" +
				"	R) Show Rank\r\n" +
				"	A) Show Average\r\n" +
				"	W) Update Weight\r\n" +
				"	E) Exit\r\n" +
				"> \r\n" +
				"Old Weights:\r\n" +
				"lab1:	10.0%\r\n" +
				"lab2:	10.0%\r\n" +
				"lab3:	10.0%\r\n" +
				"mid-term:	30.0%\r\n" +
				"final exam:	40.0%\r\n" +
				"New Weights:\r\n" +
				"lab1:	lab2:	lab3:	mid-term:	final exam:	Check new Weights:\r\n" +
				"lab1:	20%\r\n" +
				"lab2:	20%\r\n" +
				"lab3:	20%\r\n" +
				"mid-term:	20%\r\n" +
				"final exam:	20%\r\n" +
				"Is it correct?(y/n)\r\n" +
				"Insert command:\r\n" +
				"	G) Show Grade\r\n" +
				"	R) Show Rank\r\n" +
				"	A) Show Average\r\n" +
				"	W) Update Weight\r\n" +
				"	E) Exit\r\n" +
				"> \r\n" +
				"許文馨's grade:\r\n" +
				"lab1:	88\r\n" +
				"lab2:	92\r\n" +
				"lab3:	88\r\n" +
				"mid-term:	98\r\n" +
				"final exam:	91\r\n" +
				"total grade:	91\r\n" +
				"Insert command:\r\n" +
				"	G) Show Grade\r\n" +
				"	R) Show Rank\r\n" +
				"	A) Show Average\r\n" +
				"	W) Update Weight\r\n" +
				"	E) Exit\r\n" +
				"> \r\n" +
				"Old Weights:\r\n" +
				"lab1:	20.0%\r\n" +
				"lab2:	20.0%\r\n" +
				"lab3:	20.0%\r\n" +
				"mid-term:	20.0%\r\n" +
				"final exam:	20.0%\r\n" +
				"New Weights:\r\n" +
				"lab1:	lab2:	lab3:	mid-term:	final exam:	Check new Weights:\r\n" +
				"lab1:	0%\r\n" +
				"lab2:	0%\r\n" +
				"lab3:	0%\r\n" +
				"mid-term:	0%\r\n" +
				"final exam:	0%\r\n" +
				"Is it correct?(y/n)\r\n" +
				"Insert command:\r\n" +
				"	G) Show Grade\r\n" +
				"	R) Show Rank\r\n" +
				"	A) Show Average\r\n" +
				"	W) Update Weight\r\n" +
				"	E) Exit\r\n" +
				"> \r\n" +
				"許文馨's grade:\r\n" +
				"lab1:	88\r\n" +
				"lab2:	92\r\n" +
				"lab3:	88\r\n" +
				"mid-term:	98\r\n" +
				"final exam:	91\r\n" +
				"total grade:	91\r\n" +
				"Insert command:\r\n" +
				"	G) Show Grade\r\n" +
				"	R) Show Rank\r\n" +
				"	A) Show Average\r\n" +
				"	W) Update Weight\r\n" +
				"	E) Exit\r\n" +
				"> \r\n" +
				"Exit\r\n" +
				"Enter ID or insert 'Q' to exit: \r\n" +
				"Quit\r\n", baos.toString());
	}
}
