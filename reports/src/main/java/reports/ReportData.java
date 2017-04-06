package reports;

import java.util.ArrayList;

/**
 * Created by Prusak on 2017-04-04.
 */
public class ReportData {

    private String ParameterName;
    private ArrayList<String> Value;

    public String getParameterName() {
        return ParameterName;
    }

    public void setParameterName(String parameterName) {
        ParameterName = parameterName;
    }

    public ArrayList<String> getValue() {
        return Value;
    }

    public void setValue(ArrayList<String> value) {
        Value = value;
    }



}
