package com.possible.task2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {
	private static ConfigFile configParser;
	public static void main(String[] args) throws Exception {
		String fileName = null;

		if(args.length < 1){
			configParser = new ConfigFile(fileName);
		}
		else {
			fileName = args[0];
			configParser = new ConfigFile(fileName);
		}

		System.out.println(configParser.get("application.name"));
		configParser.printData();
	}


}
