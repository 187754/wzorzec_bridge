package parsers;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import reports.ReportData;

/**
 * Created by Prusak on 2017-04-05.
 */
public class CsvParser implements ParserInterface {

	public void parseToFile(ArrayList<ReportData> data, String path) throws FileNotFoundException {

	}

	public ArrayList<ReportData> parseFileToReportData(String path) {
		return new ArrayList<ReportData>();
	}
}
