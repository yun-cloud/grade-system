package main;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

public class UITest {

	/**-------------------------------------------------------
	 *Test UI Object's methods
	 *
	 *methods:
	 *	(x) -> Cmd promptCommand()
	 *	(o) -> String promptID()
	 *	(o) -> void showFinishMsg()
	 *  (o) -> void showWelcomeMsg(Grade )
	 *
	 *cases:
	 *	case1:
	 *		Parsing String:"1234"
	 *		testing whether us.promptID() return the exactly above string and the insert command message as well.
	 *
	 *	case2:
	 *		testing whether ui.showFinishMsg() show exactly the finish message.
	 *
	 *	case3:
	 *		Parsing String:"18961111 哈哈 100 90 80 70 60" as a new Grade.
	 *		testing whether ui.showWelcomeMsg() show exactly the welcome message to 哈哈.
	 *
	 *	case4:
	 *		Parsing String:"11231111 呵呵 100 94 83 71 62" as a new Grade.
	 *		testing whether ui.showWelcomeMsg() show exactly the welcome message to 呵呵.
	 ---------------------------------------------------------*/
	@Test
	public void promptIDtest1() {
		UI ui = new UI();

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);

		String input = "1234";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		assertEquals("1234", ui.promptID());
		assertEquals("Enter ID or insert 'Q' to exit: \r\n", baos.toString());
	}

	@Test
	public void showFinishMsgtest() {
		UI ui = new UI();

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);

		ui.showFinishMsg();

		assertEquals("Done.\r\n", baos.toString());
	}

	@Test
	public void showWelcomeMsgtest1() {
		UI ui = new UI();
		Grade student = new Grade("18961111 哈哈 100 90 80 70 60");

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);

		ui.showWelcomeMsg(student);

		assertEquals("Welcome 哈哈\r\n", baos.toString());
	}

	@Test
	public void showWelcomeMsgtest2() {
		UI ui = new UI();
		Grade student = new Grade("11231111 呵呵 100 94 83 71 62");

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);

		ui.showWelcomeMsg(student);

		assertEquals("Welcome 呵呵\r\n", baos.toString());
	}
}
