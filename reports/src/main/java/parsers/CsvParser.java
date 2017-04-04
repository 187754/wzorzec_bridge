package parsers;

import reports.ReportData;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by Prusak on 2017-04-05.
 */
public class CsvParser implements ParserInterface {


    @Override
    public void parseToFile(ArrayList<ReportData> data, String path) throws FileNotFoundException {

    }

    @Override
    public ArrayList<ReportData> parseFileToReportData(String path) {
        return new ArrayList<ReportData>();
    }
}
