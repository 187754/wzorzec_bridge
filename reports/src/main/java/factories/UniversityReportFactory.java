package factories;

import parsers.XMLParser;
import reports.StudentsReport;
import reports.SubjectsReport;

public class UniversityReportFactory implements ReportFactoryInterface {

	public StudentsReport getStudentReport(String path) {
		return new StudentsReport(new XMLParser(), path);
	}

	public SubjectsReport getSubjectsReport(String path) {
		return new SubjectsReport(new XMLParser(), path);
	}
}
