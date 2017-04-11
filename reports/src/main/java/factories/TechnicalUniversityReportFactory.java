package factories;

import parsers.JsonParser;
import reports.Report;
import reports.StudentsReport;
import reports.SubjectsReport;

public class TechnicalUniversityReportFactory implements ReportFactoryInterface {

	public Report getReport(String path) {
		return new Report(new JsonParser(), path);
	}

	public StudentsReport getStudentReport(String path) {
		return new StudentsReport(new JsonParser(), path);
	}

	public SubjectsReport getSubjectsReport(String path) {
		return new SubjectsReport(new JsonParser(), path);
	}

}
