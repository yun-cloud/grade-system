package main;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

import main.UI.Cmd;
import main.UI.NoSuchCommandExceptions;

public class UI_cmdTest {

	/**-------------------------------------------------------
	 *Test UI Object's methods
	 *
	 *methods:
	 *	(o) -> Cmd promptCommand()
	 *	(x) -> String promptID()
	 *	(x) -> void showFinishMsg()
	 *  (x) -> void showWelcomeMsg(Grade )
	 *
	 *cases:
	 *	case1:
	 *		Parsing String:"G\nR\nA\nW\nE\n"
	 *		testing whether ui.promptCommand() return exactly 'G', 'R', 'A', 'W', 'E', and show insert commend message 5 times.
	 ---------------------------------------------------------*/
	@Test
	public void promptCommandtest() throws NoSuchCommandExceptions {
		UI ui = new UI();
		Cmd cmd = null, inp = null;

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);

		String input = "G\nR\nA\nW\nE\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		cmd = ui.promptCommand();
		assertEquals(inp.G, cmd);
		cmd = ui.promptCommand();
		assertEquals(inp.R, cmd);
		cmd = ui.promptCommand();
		assertEquals(inp.A, cmd);
		cmd = ui.promptCommand();
		assertEquals(inp.W, cmd);
		cmd = ui.promptCommand();
		assertEquals(inp.E, cmd);

		assertEquals("Insert command:\r\n" +
				"	G) Show Grade\r\n" +
				"	R) Show Rank\r\n" +
				"	A) Show Average\r\n" +
				"	W) Update Weight\r\n" +
				"	E) Exit\r\n" +
				"> \r\n" +
				"Insert command:\r\n" +
				"	G) Show Grade\r\n" +
				"	R) Show Rank\r\n" +
				"	A) Show Average\r\n" +
				"	W) Update Weight\r\n" +
				"	E) Exit\r\n" +
				"> \r\n" +
				"Insert command:\r\n" +
				"	G) Show Grade\r\n" +
				"	R) Show Rank\r\n" +
				"	A) Show Average\r\n" +
				"	W) Update Weight\r\n" +
				"	E) Exit\r\n" +
				"> \r\n" +
				"Insert command:\r\n" +
				"	G) Show Grade\r\n" +
				"	R) Show Rank\r\n" +
				"	A) Show Average\r\n" +
				"	W) Update Weight\r\n" +
				"	E) Exit\r\n" +
				"> \r\n" +
				"Insert command:\r\n" +
				"	G) Show Grade\r\n" +
				"	R) Show Rank\r\n" +
				"	A) Show Average\r\n" +
				"	W) Update Weight\r\n" +
				"	E) Exit\r\n" +
				"> \r\n", baos.toString());
	}

}
