package main;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

public class IntegrationTest2 {
	
	/**-------------------------------------------------------
	 *Test whole grade system
	 *
	 *cases:
	 *	case2:
	 *		Parsing String:"1233214\nK\nX\n955002056\nE\n985002504\nG\nH\nR\nA\nW\n10\n20\n10\n20\n40\ny\nG\nW\n0\n0\n0\n0\n0\ny\nG\nE\n955002056\nG\nE\nQ\n"
	 *		testing whether whole system run as expected
	 ---------------------------------------------------------*/
	@Test
	public void test() {
		String input = "1233214\nK\nX\n955002056\nE\n985002504\nG\nH\nR\nA\nW\n10\n20\n10\n20\n40\ny\nG\nW\n0\n0\n0\n0\n0\ny\nG\nE\n955002056\nG\nE\nQ\n";
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
				"Exit\r\n" + 
				"Enter ID or insert 'Q' to exit: \r\n" + 
				"Welcome 張婉庭\r\n" + 
				"Insert command:\r\n" + 
				"	G) Show Grade\r\n" + 
				"	R) Show Rank\r\n" + 
				"	A) Show Average\r\n" + 
				"	W) Update Weight\r\n" + 
				"	E) Exit\r\n" + 
				"> \r\n" + 
				"張婉庭's grade:\r\n" + 
				"lab1:	97\r\n" + 
				"lab2:	92\r\n" + 
				"lab3:	96\r\n" + 
				"mid-term:	83\r\n" + 
				"final exam:	93\r\n" + 
				"total grade:	91\r\n" + 
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
				"張婉庭's rank: 22\r\n" + 
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
				"lab1:	10%\r\n" + 
				"lab2:	20%\r\n" + 
				"lab3:	10%\r\n" + 
				"mid-term:	20%\r\n" + 
				"final exam:	40%\r\n" + 
				"Is it correct?(y/n)\r\n" + 
				"Insert command:\r\n" + 
				"	G) Show Grade\r\n" + 
				"	R) Show Rank\r\n" + 
				"	A) Show Average\r\n" + 
				"	W) Update Weight\r\n" + 
				"	E) Exit\r\n" + 
				"> \r\n" + 
				"張婉庭's grade:\r\n" + 
				"lab1:	97\r\n" + 
				"lab2:	92\r\n" + 
				"lab3:	96\r\n" + 
				"mid-term:	83\r\n" + 
				"final exam:	93\r\n" + 
				"total grade:	92\r\n" + 
				"Insert command:\r\n" + 
				"	G) Show Grade\r\n" + 
				"	R) Show Rank\r\n" + 
				"	A) Show Average\r\n" + 
				"	W) Update Weight\r\n" + 
				"	E) Exit\r\n" + 
				"> \r\n" + 
				"Old Weights:\r\n" + 
				"lab1:	10.0%\r\n" + 
				"lab2:	20.0%\r\n" + 
				"lab3:	10.0%\r\n" + 
				"mid-term:	20.0%\r\n" + 
				"final exam:	40.0%\r\n" + 
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
				"張婉庭's grade:\r\n" + 
				"lab1:	97\r\n" + 
				"lab2:	92\r\n" + 
				"lab3:	96\r\n" + 
				"mid-term:	83\r\n" + 
				"final exam:	93\r\n" + 
				"total grade:	0\r\n" + 
				"Insert command:\r\n" + 
				"	G) Show Grade\r\n" + 
				"	R) Show Rank\r\n" + 
				"	A) Show Average\r\n" + 
				"	W) Update Weight\r\n" + 
				"	E) Exit\r\n" + 
				"> \r\n" + 
				"Exit\r\n" + 
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
				"total grade:	0\r\n" + 
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
