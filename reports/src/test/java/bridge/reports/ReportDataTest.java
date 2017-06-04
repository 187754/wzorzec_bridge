package bridge.reports;

import java.util.ArrayList;

import junit.framework.Assert;
import junit.framework.TestCase;
import reports.ReportData;

public class ReportDataTest extends TestCase {

	public void testGetParameterName() {
		ReportData temp = new ReportData();
		temp.setParameterName("test");
		Assert.assertEquals("test", temp.getParameterName());
	}

	public void testSetParameterName() {
		ReportData temp = new ReportData();
		temp.setParameterName("test2");
		Assert.assertEquals("test2", temp.getParameterName());
	}

	public void testGetValue() {
		ReportData temp = new ReportData();
		temp.setParameterName("test2");
		ArrayList<String> value = new ArrayList<String>();
		value.add("test");
		temp.setValue(value);
		ArrayList<String> test = temp.getValue();
		Assert.assertEquals(value, test);
	}

	public void testToString() {
		ReportData temp = new ReportData();
		temp.setParameterName("test2");
		ArrayList<String> value = new ArrayList<String>();
		value.add("test");
		temp.setValue(value);
		String testString = temp.getParameterName() + temp.getValue();
		String a = "test2[test]";
		Assert.assertEquals(a, testString);
	}

	public void testSetValue() {
		ReportData temp = new ReportData();
		temp.setParameterName("test2");
		ArrayList<String> value = new ArrayList<String>();
		value.add("test");
		temp.setValue(value);
		ArrayList<String> test = temp.getValue();
		Assert.assertEquals(value, test);
	}

}
