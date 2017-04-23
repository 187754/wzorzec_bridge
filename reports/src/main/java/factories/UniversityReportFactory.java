package factories;

import parsers.CsvParser;
import reports.StudentsReport;
import reports.SubjectsReport;

public class UniversityReportFactory implements ReportFactoryInterface {

	public StudentsReport getStudentReport(String path) {
		return new StudentsReport(new CsvParser(), path);
	}

	public SubjectsReport getSubjectsReport(String path) {
		return new SubjectsReport(new CsvParser(), path);
	}
}
