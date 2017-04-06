package parsers;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import reports.ReportData;

public class JsonParser implements ParserInterface {

	public void parseToFile(ArrayList<ReportData> data, String path) throws FileNotFoundException {

		PrintWriter zapis = null;
		try {
			zapis = new PrintWriter(path);
		} finally {
			zapis.close();
		}
	}

	public ArrayList<ReportData> parseFileToReportData(String path) {
		return new ArrayList<ReportData>();
	}
}
