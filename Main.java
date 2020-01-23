package com.possible.task2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {

	public static void main(String[] args)throws Exception {
		Map<String, String> list1 = new HashMap<>();
		List<String[]> fileList = new ArrayList<>();

		if(args.length < 1){
			fileList = configFile("src/config.txt");
			for(int i = 0; i < fileList.size(); i++){
				String[] s1 =fileList.get(i);
				for(int j = 0; j < s1.length -1; j++){
					list1.put(s1[0], s1[1]);
				}
			}
		}

		fileList = configFile(args[0]);
		for(int i = 0; i < fileList.size(); i++){
			String[] s1 =fileList.get(i);
			for(int j = 0; j < s1.length -1; j++){
				list1.put(s1[0], s1[1]);
			}
		}

		System.out.println(list1);

	}

	public static List<String[]> configFile(String file) throws Exception{
		ArrayList<String[]> s1 = new ArrayList<>();
		try(BufferedReader input = new BufferedReader(new FileReader("src/config.txt"));){
			String eachLine;
			while((eachLine = input.readLine()) != null){
				s1.add(eachLine.split("="));
			}
		}
		catch (FileNotFoundException e){
			System.out.println(e.getMessage());
		}

		return s1;
	}

}
