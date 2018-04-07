package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import main.Grade;

/*
 * class GradeSystem
 *
 * GradeSystem()
 * find(ID)
 * showGrade(Grade)
 * showAverage(Grade)
 * showRank(Grade)
 * updateWeights(newWeights)
 * promptUpdateWeights()
 * updateRank()
 */
public class GradeSystem {
	private ArrayList<Grade> students;
	private static final double[] INITIAL_WEIGHTS = new double[] { 0.1, 0.1, 0.1, 0.3, 0.4 };
	private double[] weights = new double[5];

	/* GradeSystem constructor  ----------------------------------------------------------------------------------
	* 從 src/gradeinput.txt 讀取學生之成績資料
	*
	* @throws IOException –
	* 	src/gradeinput.txt 檔案不存在或毀損
	* Pseudo code:
	* 1. 開啟檔案，每一行創建一個 Grade object 存入 students 列表中
	* 2. 以 updateWeights() method 設定 INITIAL_WEIGHTS，會順便設定 total grade 及 排名
	*
	* Time estimate : O (n × log(n))
	* Example: new GradeSystem() ;
	----------------------------------------------------------------------------------------------------------*/
	public GradeSystem() throws IOException {
		students = new ArrayList<Grade>();
		try (FileInputStream in = new FileInputStream("src/gradeinput.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));) {
			br.read(); // fixed a weird bug
			String line;
			while ((line = br.readLine()) != null) {
				students.add(new Grade(line.trim()));
			}
			updateWeights(INITIAL_WEIGHTS);
		}
	}

	/* method  find  ----------------------------------------------------------------------------------
	* 利用 ID 找到對應的 Grade object
	*
	* @param ID 尋找的ID
	* @return 對應的 Grade object
	*
	* Pseudo code:
	* 1. Iterate 內部 students，若 ID 相同則回傳 。
	* 2. 若迴圈結束，還未回傳，代表找不到該 ID 對應的 student，回傳 null。
	*
	* Time estimate : O(n)
	* Example: GradeSystem物件.find("962001044") ; 傳回結果為 null
	----------------------------------------------------------------------------------------------------------*/
	public Grade find(String ID) {
		for (Grade student : students) {
			if (student.ID.equals(ID)) {
				return student;
			}
		}
		return null;
	}

	/* method  showGrade  ----------------------------------------------------------------------------------
	* 印出該 student 的成績資料
	*
	* @param student 要印出成績之學生 Grade object
	* @return void （印出其成績資料）
	*
	* Pseudo code:
	* 1. 印出 student 的名字
	* 2. 及5個成績
	* 3. 最後是加權後總成績
	*
	* Time estimate : O (1)
	* Example: GradeSystem物件.showGrade(some_student) ; 印出該學生之成績
	----------------------------------------------------------------------------------------------------------*/
	public void showGrade(Grade student) {
		System.out.println(student.name + "'s grade:");
		for (int i = 0; i < Grade.NUM_GRADE; i++) {
			System.out.println(String.format("%s:\t%s", Grade.grade_names[i], student.getGrade(i)));
		}
		System.out.println("total grade:\t" + student.totalGrade);
	}

	/* method  showAverage  ----------------------------------------------------------------------------------
	* 顯示該學生之平均分數
	*
	* @param student 目標學生
	* @return void (印出平均成績）
	*
	* Pseudo code:
	* 1. 計算平均成績，然後印出
	*
	* Time estimate : O (n)
	* Example: GradeSystem物件.showAverage(some_student) ;
	----------------------------------------------------------------------------------------------------------*/
	public void showAverage(Grade student) {
		System.out.println(student.name + "'s total grade:" + student.totalGrade);
	}

	/* method  showRank  ----------------------------------------------------------------------------------
	* 顯示該學生之排名
	*
	* @param student 目標學生
	* @return void (印出其排名）
	*
	* Pseudo code:
	* 1. 印出已計算好之排名
	*
	* Time estimate : O (1)
	* Example: GradeSystem物件.showRank(some_student) ;
	----------------------------------------------------------------------------------------------------------*/
	public void showRank(Grade student) {
		System.out.println(student.name + "'s rank: " + student.rank);
	}

	/* method  updateWeights  ----------------------------------------------------------------------------------
	* 更新加權比重，並一併更新 total grade 及排名
	*
	* @param newWeights 欲更新之新加權比重
	* @return void (更新內部資料）
	*
	* Pseudo code:
	* 1. 更新內部 weights
	* 2. 呼叫 updateTotalGrade，更新所有學生之 total grade
	* 3. 以新的 total grade 排序所有學生（由大到小）
	* 4. 更新所有學生之排名
	*
	* Time estimate : O (n × log(n))
	* Example: GradeSystem物件.updateWeights([0.2, 0.2, 0.2, 0.2, 0.2]) ;
	----------------------------------------------------------------------------------------------------------*/
	public void updateWeights(double[] newWeights) {
		for (int i = 0; i < 5; i++) {
			weights[i] = newWeights[i];
		}

		for (Grade student : students) {
			student.updateTotalGrade(weights);
		}

		Collections.sort(students, new Comparator<Grade>() {
			@Override
			public int compare(Grade s1, Grade s2) {
				// reverse order
				return Integer.compare(s2.totalGrade, s1.totalGrade);
			}
		});

		updateRank();
	}

	/* method  promptUpdateWeights  ----------------------------------------------------------------------------------
	* 顯示原加權比重，並接收使用者新的加權比重輸入，確認後呼叫 updateWeights
	*
	* @param void
	* @return void
	*
	* Pseudo code:
	* 1. 印出原加權比重
	* 2. 使用者輸入新加權比重
	* 3. 印出接收之新加權比重，使用者確認後，執行 updateWeights
	*
	* Time estimate : O (n × log(n))  （同 updateWeights)
	* Example: GradeSystem物件.updateWeights() ;
	----------------------------------------------------------------------------------------------------------*/
	public void promptUpdateWeights() {
		System.out.println("Old Weights:");
		for (int i = 0; i < Grade.NUM_GRADE; i++) {
			System.out.println(String.format("\t%s:\t%s%%", Grade.grade_names[i], weights[i] * 100));
		}

		double[] newWeights = new double[5];
		System.out.println("New Weights:");
		for (int i = 0; i < Grade.NUM_GRADE; i++) {
			System.out.print(String.format("\t%s:\t", Grade.grade_names[i]));
			newWeights[i] = Input.getScanner().nextDouble();
		}

		System.out.println("Check new Weights:");
		for (int i = 0; i < Grade.NUM_GRADE; i++) {
			System.out.println(String.format("\t%s:\t%s%%", Grade.grade_names[i], newWeights[i]));
		}

		System.out.println("Is it correct?(y/n)");
		String answer = Input.getScanner().next();

		if (answer.equalsIgnoreCase("Y")) {
			for (int i = 0; i < Grade.NUM_GRADE; i++) {
				newWeights[i] = newWeights[i] / 100;
			}

			updateWeights(newWeights);
		}
	}

	/* method  updateRank  ----------------------------------------------------------------------------------
	* 預設 students 已依 total grade 由大至小之順序排列好。
	* 從排名1開始，遞增地分配排名，若與前一學生相同分數，則相同排名。
	*
	* @param void
	* @return void (更新內部資料）
	*
	* Pseudo code:
	* 1. 依序賦序學生排名值（index + 1)
	* 2. 若該學生分數與 previousTotalGrade 一樣，則排名亦為 previousRank
	*
	* Time estimate : O (n)
	* Example: GradeSystem物件.updateRank() ;
	----------------------------------------------------------------------------------------------------------*/
	public void updateRank() {
		// must after update weights
		int index = 0;
		int previousTotalGrade = -1;
		int previousRank = -1;

		for (Grade student : students) {
			if (previousRank == -1) {
				student.rank = index + 1;
			} else {
				if (student.totalGrade == previousTotalGrade) {
					student.rank = previousRank;
				} else {
					student.rank = index + 1;
				}
			}

			index++;
			previousTotalGrade = student.totalGrade;
			previousRank = student.rank;
		}
	}
}
