package factories;

import reports.Report;
import reports.StudentsReport;
import reports.SubjectsReport;

public interface ReportFactoryInterface {
	public Report getReport(String path);

	public StudentsReport getStudentReport(String path);

	public SubjectsReport getSubjectsReport(String path);

}
