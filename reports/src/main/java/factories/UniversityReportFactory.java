package factories;

import parsers.CsvParser;
import reports.Report;
import reports.StudentsReport;
import reports.SubjectsReport;

public class UniversityReportFactory implements ReportFactoryInterface {

	public Report getReport(String path) {
		return new Report(new CsvParser(), path);
	}

	public StudentsReport getStudentReport(String path) {
		return new StudentsReport(new CsvParser(), path);
	}

	public SubjectsReport getSubjectsReport(String path) {
		return new SubjectsReport(new CsvParser(), path);
	}
}
