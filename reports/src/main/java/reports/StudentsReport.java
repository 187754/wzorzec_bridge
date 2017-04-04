package reports;

import parsers.ParserInterface;

import java.util.ArrayList;

/**
 * Created by Prusak on 2017-04-05.
 */
public class StudentsReport extends Report {

    private ArrayList<ReportData> data;



    public enum StudentParameterNames {
        Imie, Nazwisko, Indeks, Oceny;
    }

    public StudentsReport(ParserInterface parser, String path) {
        super(parser, path);

        //przypisujemy nazwy parametrów dla tego typu raportów
        data=super.getData();
        for(int i=0;i<data.size();i++){
            data.get(i).setParameterName(StudentParameterNames.values()[i].toString());
        }
    }

}
