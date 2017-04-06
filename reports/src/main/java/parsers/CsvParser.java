package parsers;

import java.io.*;
import java.util.ArrayList;

import reports.ReportData;

/**
 * Created by Prusak on 2017-04-05.
 */
public class CsvParser implements ParserInterface {

	PrintWriter writer;
	BufferedReader br = null;
	FileReader fr = null;
	final String SEPARATOR=";";
	final String FILE_SUFFIX=".csv";


	public void parseToFile(ArrayList<ReportData> data, String path) throws FileNotFoundException {

		String line = "";
		path+=FILE_SUFFIX;

		File f = new File(path);

		f.getParentFile().mkdirs();
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			writer = new PrintWriter(f);
			for (ReportData singleData : data) {
				line += singleData.getParameterName();
				line += SEPARATOR;
			}
			writer.println(line);

			line = "";
			for (int i = 0; i < data.get(0).getValue().size(); i++) {
				for (ReportData singleData : data) {
					line += singleData.getValue().get(i);
					line += SEPARATOR;

				}
				System.out.println(line);
				writer.println(line);
				line = "";

			}
		} finally {
			writer.close();
		}


	}

	public ArrayList<ReportData> parseFileToReportData(String path) {
		ArrayList<ReportData> data = new ArrayList<ReportData>();
		path+=FILE_SUFFIX;



		File f = new File(path);

		try {


			String line = "";

			br = new BufferedReader(new FileReader(f));

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

			return data;
		}
	}
}