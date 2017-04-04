package parsers;

import reports.ReportData;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface ParserInterface {

    public void parseToFile(ArrayList<ReportData> data, String path) throws FileNotFoundException;

    public ArrayList<ReportData> parseFileToReportData(String path );



}
