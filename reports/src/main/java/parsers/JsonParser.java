package parsers;

import reports.ReportData;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class JsonParser implements ParserInterface {


    @Override
    public void parseToFile(ArrayList<ReportData> data, String path) throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter(path);

    }

    @Override
    public ArrayList<ReportData> parseFileToReportData(String path) {
        return new ArrayList<ReportData>();
    }
}
