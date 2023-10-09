package com.omrbranch.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {
public static void generateJvmReport(String jsonFile) {
		
		//1. mention the path jvm report where to store
		
		File file=new File("C:\\Users\\Hp\\eclipse-workspace\\Cucumber\\target");
		//2. create the object for Configuration  class
		
		Configuration configuration=new Configuration(file, "OMR Branch Automation");
		//3. Browser,Author,Version details
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("version", "123");
		configuration.addClassifications("OS", "Windows 10");
		
		//4. Generate the Object For ReportBuilder Class to accessing Json file
		List<String> jsonFiles=new ArrayList<String>();
		jsonFiles.add(jsonFile);
		
		ReportBuilder builder=new ReportBuilder(jsonFiles, configuration);
				
		//5. Generate Report
		builder.generateReports();

	}

}
