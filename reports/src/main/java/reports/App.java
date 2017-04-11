package reports;

import java.util.ArrayList;

import factories.ReportFactoryInterface;
import factories.TechnicalUniversityReportFactory;

/**
 * Hello world!
 *
 */

public class App {
	public static void main(String[] args) {
		// test csvParser
		ReportFactoryInterface factory = new TechnicalUniversityReportFactory();
		testApp(factory);
	}

	static void testApp(ReportFactoryInterface factory) {
		Report report = factory.getStudentReport("C:\\reports\\");

		ArrayList<ReportData> data = new ArrayList<ReportData>();

		ReportData singleData = new ReportData();
		ReportData singleData1 = new ReportData();
		ReportData singleData2 = new ReportData();
		ReportData singleData3 = new ReportData();
		ReportData singleData4 = new ReportData();

		ArrayList<String> nameValues = new ArrayList<String>();
		nameValues.add("Krzysztof");
		nameValues.add("Krystian");
		singleData.setValue(nameValues);
		data.add(singleData);

		ArrayList<String> surnameValues = new ArrayList<String>();
		surnameValues.add("Pruski");
		surnameValues.add("Leszczyński");
		singleData1.setValue(surnameValues);
		data.add(singleData1);

		ArrayList<String> indexValues = new ArrayList<String>();
		indexValues.add("187790");
		indexValues.add("187754");
		singleData2.setValue(indexValues);
		data.add(singleData2);

		ArrayList<String> subjectValues = new ArrayList<String>();
		subjectValues.add("Powp");
		subjectValues.add("Projektowanie obiektowe - wzorce projektowe");
		singleData3.setValue(subjectValues);
		data.add(singleData3);

		ArrayList<String> marksValues = new ArrayList<String>();
		marksValues.add("2 3 2 2 2 2 3");
		marksValues.add("4 4 4 5 4 5");
		singleData4.setValue(marksValues);
		data.add(singleData4);

		report.setData(data);
		report.parseToFile();
		report.parseFileToReportData();
		report.parseFileToReportData();

	}
}
