package factories;

import reports.StudentsReport;
import reports.SubjectsReport;

public interface ReportFactoryInterface {

	public StudentsReport getStudentReport(String path);

	public SubjectsReport getSubjectsReport(String path);

}
