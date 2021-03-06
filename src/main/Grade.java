package main;

/*
 * Grade(line)
 * getGrade(index)
 * updateTotalGrade(weights)
 */
public class Grade {
	public String name;
	public String ID;
	public static final int NUM_GRADE = 5;
	public static final String[] grade_names = new String[] { "lab1", "lab2", "lab3", "mid-term", "final exam" };
	public int[] grades = new int[NUM_GRADE];
	public int totalGrade;
	public int rank;

	/* Grade constructor  ----------------------------------------------------
	* parse gradeLine 參數，設定為內部欄位
	*
	* @param gradeLine 格式為"ID name lab1 lab2 lab3 mid-term finalExam"之字串
	*
	* Pseudo code:
	* 1. 以空格區分出不同資料
	* 2. 依序設定到內部欄位
	*
	* Time estimate : O (1)
	* Example: new GradeSystem() ;
	-------------------------------------------------------------------------*/
	public Grade(String gradeLine) {
		String[] parts = gradeLine.split(" ");
		int k = 0;
		for (String part : parts) {
			if (ID == null) {
				ID = part;
			} else if (name == null) {
				name = part;
			} else {
				grades[k] = Integer.parseInt(part);
				k++;
			}
		}
	}

	/* method  getGrade  ----------------------------------------------------------------------------------
	* 回傳 index 對應成績之字串形式。
	* 若低於60分，後面加註一個 *
	*
	* @param index 指定是哪個成績
	* @return 其字串形式
	*
	* Pseudo code:
	* 1. 檢查是否低於60分
	* 2. 是，則加註 *；反之，則轉為 String 後直接回傳。
	*
	* Time estimate : O (1)
	* Example: Grade物件.getGrade(4) ; 回傳收成績之字串形式
	----------------------------------------------------------------------------------------------------------*/
	public String getGrade(int index) {
		int grade = grades[index];
		if (grade < 60) {
			return grade + "*";
		} else {
			return String.valueOf(grade);
		}
	}

	/* method  updateTotalGrade  ----------------------------------------------------------------------------------
	* 以加權權重 weights，更新 totalGrade
	*
	* @param weights 加權權重
	* @return void
	*
	* Pseudo code:
	* 1. 算出該加權權重下之 total grade
	* 2. 小數點後，四捨五入。
	*
	* Time estimate : O (1)
	* Example: Grade物件.updateTotalGrade([0.1, 0.1, 0.1, 0.3, 0.4]) ;
	----------------------------------------------------------------------------------------------------------*/
	public void updateTotalGrade(double[] weights) {
		double result = 0;
		for (int i = 0; i < 5; i++) {
			result += weights[i] * grades[i];
		}
		totalGrade = (int) Math.round(result);
	}
}
