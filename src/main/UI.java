package main;

/*
 * UI()
 * promptCommand()
 * promptID()
 * showFinishMsg()
 * showWelcomeMsg(Grade)
 */
public class UI {
	
	public enum Cmd { G, R, A, W, E }
	
	public static class NoSuchIDExceptions extends Exception {}
	public static class NoSuchCommandExceptions extends Exception {}
	
	public UI() {}

	/* method promptCommand  ----------------------------------------------------------------------------------
	* 引導使用者輸入欲執行之command。
	*
	* @return 使用者輸入 command
	*
	* @throws NoSuchCommandExceptions –
	* 		使用者輸出無法處理之Command
	* Pseudo code:
	* 1. 印出 RPOMPT_COMMAND_MESSAGE
	* 2. 接收並轉成 Cmd，若發生錯誤則丟出 NoSuchCommandExceptions
	*
	* Time estimate : O (1)
	* Example: UI物件.promptCommand() ; 回傳使用者指定 Cmd 物件
	----------------------------------------------------------------------------------------------------------*/
	public Cmd promptCommand() throws NoSuchCommandExceptions {
		System.out.println("Insert command:");
		System.out.println("\tG) Show Grade");
		System.out.println("\tR) Show Rank");
		System.out.println("\tA) Show Average");
		System.out.println("\tW) Update Weight");
		System.out.println("\tE) Exit");
		System.out.println("> ");
		
		String input = Input.getScanner().next();
		Cmd cmd;
		try {
			cmd = Cmd.valueOf(input);
		} catch (Exception e) {
			throw new NoSuchCommandExceptions();
		}
		return cmd;
	}

	/* method promptID  ----------------------------------------------------------------------------------
	* 引導使用者輸入該學生之 ID
	*
	* @return 使用者輸入之 ID
	*
	* Pseudo code:
	* 1. 印出 PROMPT_ID_MESSAGE
	* 2. 接收使用者輸入
	*
	* Time estimate : O (1)
	* Example: UI物件.promptID() ; 回傳使用者輸入之ID
	----------------------------------------------------------------------------------------------------------*/
	public String promptID() {
		System.out.println("Enter ID or insert 'Q' to exit: ");
		return Input.getScanner().next();
	}

	/* method showFinishMsg  ----------------------------------------------------------------------------------
	* 印出結束訊息
	*
	* Pseudo code:
	* 1. 印出結束訊息
	*
	* Time estimate : O (1)
	* Example: UI物件.showFinishMsg() ;
	----------------------------------------------------------------------------------------------------------*/
	public void showFinishMsg() {
		System.out.println("Done.");
	}

	/* method showWelcomeMsg  ----------------------------------------------------------------------------------
	* 印出歡迎訊息
	*
	* @param student 欲歡迎之學生
	*
	* Pseudo code:
	* 1. 印出歡迎訊息
	*
	* Time estimate : O (1)
	* Example: UI物件.showWelcomeMsg() ;
	----------------------------------------------------------------------------------------------------------*/
	public void showWelcomeMsg(Grade student) {
		System.out.println("Welcome " + student.name);
	}
}
