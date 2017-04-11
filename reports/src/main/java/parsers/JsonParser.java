package parsers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import reports.ReportData;

public class JsonParser implements ParserInterface {

	PrintWriter writer;
	final String FILE_SUFFIX = ".json";

	public void parseToFile(ArrayList<ReportData> data, String path) throws FileNotFoundException {

		JSONObject obj = new JSONObject();
		JSONArray list = new JSONArray();

		for (int i = 0; i < data.get(0).getValue().size(); i++) {
			for (ReportData singleData : data) {
				obj.put(singleData.getParameterName(), singleData.getValue().get(i));
			}

			list.add(obj);
		}

		path += FILE_SUFFIX;
		File f = new File(path);
		f.getParentFile().mkdirs();
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			writer = new PrintWriter(f);
			writer.print(list);
		} finally {
			writer.close();
		}

	}

	public ArrayList<ReportData> parseFileToReportData(String path) {
		return new ArrayList<ReportData>();
	}
}
