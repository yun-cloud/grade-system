package main;

import java.util.Scanner;

public class Input {
	private static Scanner sc = new Scanner(System.in);

	/* Input constructor  -------------------------
	* 以空的函式主體覆蓋預設行為，避免創建多餘物件。
	---------------------------------------------*/
	private Input() {}

	/* method  getScanner  ----------------------------------------------------
	* 直接回傳 scanner
	*
	* @param void
	* @return singleton scanner
	*
	* Pseudo code:
	* 1. 直接回傳 scanner
	*
	* Time estimate : O (1)
	* Example: Input類別.getScanner() ; 回傳 singleton scanner
	--------------------------------------------------------------------------*/
	public static Scanner getScanner() {
		return sc;
	}
}
