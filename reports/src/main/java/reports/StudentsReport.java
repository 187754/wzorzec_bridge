package reports;

import java.util.ArrayList;

import parsers.ParserInterface;

/**
 * Created by Prusak on 2017-04-05.
 */
public class StudentsReport extends Report {

	private ArrayList<ReportData> data;
	static final String FILENAME="StudentReport";

	public enum StudentParameterNames {
		Imie, Nazwisko, Indeks, Przedmiot, Oceny;
	}

	public StudentsReport(ParserInterface parser, String path) {
		super(parser, path+FILENAME);
	}
	public void setData(ArrayList<ReportData> data) {
		this.data = data;
		// przypisujemy nazwy parametrów dla tego typu raportów
		for (int i = 0; i < data.size(); i++) {
			this.data.get(i).setParameterName(StudentParameterNames.values()[i].toString());
			super.setData(data);
		}
	}


}
