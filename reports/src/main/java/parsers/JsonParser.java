package parsers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import reports.ReportData;

public class JsonParser implements ParserInterface {

	PrintWriter writer;
	final String FILE_SUFFIX = ".json";

	public void parseToFile(ArrayList<ReportData> data, String path) throws FileNotFoundException {

		JSONObject obj = new JSONObject();
		JSONArray list = new JSONArray();

		for (int i = 0; i < data.get(0).getValue().size(); i++) {
			obj = new JSONObject();
			for (ReportData singleData : data) {
				String s = singleData.getValue().get(i);
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

		JSONParser parser = new JSONParser();
		ArrayList<ReportData> data = new ArrayList<ReportData>();
		path += FILE_SUFFIX;

		try {
			Object obj = parser.parse(new FileReader(path));
			JSONArray ja = (JSONArray) obj;
			// System.out.println(ja);
			JSONObject jo;
			jo = (JSONObject) ja.get(0);
			Object[] parameterNames;
			parameterNames = jo.keySet().toArray();
			int j = 0;
			for (Object parameterName : parameterNames) {
				data.add(new ReportData());
				data.get(j).setParameterName((String) parameterName);
				j++;
			}
			j = 0;

			for (Object parameterName : parameterNames) {
				ArrayList<String> list = new ArrayList<String>();
				for (int i = 0; i < ja.size(); i++) {
					jo = (JSONObject) ja.get(i);
					list.add((String) jo.get((String) parameterName));
				}

				System.out.println((String) parameterName);
				System.out.println(list);
				data.get(j).setValue(list);
				j++;
			}

			System.out.println(data);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return data;
	}
}
