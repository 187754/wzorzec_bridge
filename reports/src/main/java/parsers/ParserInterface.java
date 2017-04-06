package parsers;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import reports.ReportData;

public interface ParserInterface {

	public void parseToFile(ArrayList<ReportData> data, String path) throws FileNotFoundException;

	public ArrayList<ReportData> parseFileToReportData(String path);

}
