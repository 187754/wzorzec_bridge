package reports;

import parsers.CsvParser;
import reports.Report;
import reports.ReportData;
import reports.StudentsReport;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */

public class App {
	public static void main(String[] args) {
		ArrayList<ReportData> data = new ArrayList<>();
		ReportData singleData = new ReportData();
		ReportData singleData1 = new ReportData();
		ReportData singleData2 = new ReportData();
		ReportData singleData3 = new ReportData();
		ReportData singleData4 = new ReportData();
        StudentsReport report = new StudentsReport(new CsvParser(),"C:\\Users\\Prusak\\IdeaProjects\\wzorzec_bridge_projekt\\reports\\src\\main\\java\\reports\\");
		ArrayList<String> nameValues = new ArrayList<>();
		nameValues.add("Krzysztof");
		nameValues.add("Krystian");
		singleData.setValue(nameValues);
		data.add(singleData);

        ArrayList<String> surnameValues = new ArrayList<>();
		surnameValues.add("Pruski");
		surnameValues.add("Leszczyński");
		singleData1.setValue(surnameValues);
		data.add(singleData1);

        ArrayList<String> indexValues = new ArrayList<>();
		indexValues.add("187790");
		indexValues.add("jakiś tam :D");
		singleData2.setValue(indexValues);
		data.add(singleData2);

        ArrayList<String> subjectValues = new ArrayList<>();
		subjectValues.add("Powp");
		subjectValues.add("Projektowanie obiektowe - wzorce projektowe");
		singleData3.setValue(subjectValues);
		data.add(singleData3);

        ArrayList<String> marksValues = new ArrayList<>();
		marksValues.add("2 3 2 2 2 2 3");
		marksValues.add("4 4 4 5 4 5");
		singleData4.setValue(marksValues);
		data.add(singleData4);



		report.setData(data);
		report.parseToFile();
        System.out.println("odczyt");

        report.parseFileToReportData();

		System.out.println("siemeneczko");
	}
}
