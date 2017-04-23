package factories;

import parsers.JsonParser;
import reports.StudentsReport;
import reports.SubjectsReport;

public class TechnicalUniversityReportFactory implements ReportFactoryInterface {

	public StudentsReport getStudentReport(String path) {
		return new StudentsReport(new JsonParser(), path);
	}

	public SubjectsReport getSubjectsReport(String path) {
		return new SubjectsReport(new JsonParser(), path);
	}

}
