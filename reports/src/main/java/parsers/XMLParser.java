package parsers;

import reports.ReportData;

import java.util.ArrayList;

public class XMLParser implements ParserInterface {



    @Override
    public void parseToFile(ArrayList<ReportData> data, String path) {


    }

    @Override
    public ArrayList<ReportData> parseFileToReportData(String path) {
        return new ArrayList<ReportData>();
    }

}
