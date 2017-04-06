package reports;

import java.util.ArrayList;

import parsers.ParserInterface;

/**
 * Created by Prusak on 2017-04-05.
 */
public class SubjectsReport extends Report {

	private ArrayList<ReportData> data;

	public enum SubjectParameterNames {
		Przedmiot, Kierunek, Rok, Grupa, Studenci;
	}

	public SubjectsReport(ParserInterface parser, String path) {
		super(parser, path);

		// przypisujemy nazwy parametrów dla tego typu raportów
		data = super.getData();
		for (int i = 0; i < data.size(); i++) {
			data.get(i).setParameterName(SubjectParameterNames.values()[i].toString());
		}
	}

}
