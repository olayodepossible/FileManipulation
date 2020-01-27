package com.possible.task2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {

	public static void main(String[] args)throws Exception {
		Map<String, String> list1 = new HashMap<>();
		List<String[]> fileList;

		if(args.length < 1){
			fileList = configFile("src/config.txt");
			for(int i = 0; i < fileList.size(); i++){
				String[] s1 =fileList.get(i);
				if(list1.containsKey(s1[0])) continue;
				for(int j = 0; j < s1.length -1; j++){
					list1.put(s1[0], s1[1]);
				}
			}
		}
		else {
			fileList = configFile(args[0]);
			for(int i = 0; i < fileList.size(); i++){
				String[] s1 =fileList.get(i);
				if(list1.containsKey(s1[0])) continue;
				for(int j = 0; j < s1.length -1; j++){
					list1.put(s1[0], s1[1]);
				}
			}
		}

		System.out.println(list1);
	}

	public static List<String[]> configFile(String file) throws Exception{
		ArrayList<String[]> listOfData = new ArrayList<>();
		final String APPLICATION = "application.";
		try(BufferedReader input = new BufferedReader(new FileReader("src/config.txt"));){
			String eachLine;
			boolean flag = false;
			while((eachLine = input.readLine()) != null){
				if(eachLine.equals("[application]")){
					flag = true;
					continue;
				}
				if(eachLine.equals("")){
					flag = false;
					continue;
				}
				String[] split = eachLine.split("=");
				if(flag){
					split[0] = APPLICATION + split[0];
				}
				listOfData.add(split);
			}
		}
		catch (FileNotFoundException e){
			System.out.println(e.getMessage());
		}

		return listOfData;
	}

}
