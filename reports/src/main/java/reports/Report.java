package reports;

import java.util.ArrayList;

import parsers.ParserInterface;

public class Report {
	private ParserInterface parser;
	private String path;

	private ArrayList<ReportData> data;

	public Report(ParserInterface parser, String path) {
		this.parser = parser;
		this.path = path;
	}

	public ArrayList<ReportData> getData() {
		return data;
	}

	public void setData(ArrayList<ReportData> data) {
		this.data = data;
	}

	public void parseToFile() {
		parser.parseFileToReportData(path);
	}

	public ArrayList<ReportData> parseFileToReportData() {
		return parser.parseFileToReportData(path);
	}

}
