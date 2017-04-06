package factories;

import parsers.XMLParser;
import reports.Report;
import reports.StudentsReport;
import reports.SubjectsReport;

public class TechnicalUniversityReportFactory implements ReportFactoryInterface {

	public Report getReport(String path) {
		return new Report(new XMLParser(), path);
	}

	public StudentsReport getStudentReport(String path) {
		return new StudentsReport(new XMLParser(), path);
	}

	public SubjectsReport getSubjectsReport(String path) {
		return new SubjectsReport(new XMLParser(), path);
	}

}
