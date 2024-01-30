package com.practice;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class PracticeJSONFile {

	public static void main(String[] args) throws Throwable {
		FileReader filepath = new FileReader(".\\src\\test\\resources\\jsonReader.json");
		// TODO Auto-generated method stub
// JSON Parser is used to read/write data from json formatted file
		
		JSONParser jsonp= new JSONParser();
		
		Object OBJ=jsonp.parse(filepath);
		
		
		// Read data from json file
		
		JSONObject map= (JSONObject)OBJ;
		System.out.println(map.get("browser"));
		System.out.println(map.get("url"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
	}

}
