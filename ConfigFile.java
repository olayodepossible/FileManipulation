package com.possible.task2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ConfigFile {
    private Path p;
    private Map<String, String> config;

    public ConfigFile(String fileName) throws Exception {
        if(fileName == null){
            fileName = "config.txt";
        }
        p = Paths.get(fileName).toAbsolutePath();
        config = new HashMap<>();
        fileDataList();
    }

    /* This add file data to HashMap*/
    private void mapFileData(List dataList){
        for(int i = 0; i < dataList.size(); i++){
            String[] s1 = (String[]) dataList.get(i);
            if(config.containsKey(s1[0])) continue;
            for(int j = 0; j < s1.length -1; j++){
                config.put(s1[0], s1[1]);
            }
        }
    }

    /*This turn file data to List  */
    private void fileDataList() throws Exception{
        ArrayList<String[]> listOfData = new ArrayList<>();
        final String APPLICATION = "application.";
        try(BufferedReader input = new BufferedReader(new FileReader(String.valueOf(p)))){
            String eachLine = "";
            boolean flag = false;
            while((eachLine = input.readLine()) != null){
                if(eachLine.startsWith("[") && eachLine.endsWith("]")){
                    flag = true;
                    continue;
                }
                else if(eachLine.isEmpty()){
                    flag = false;
                    continue;
                }
                else{
                    String[] split = eachLine.split("=");
                    if(flag){
                        split[0] = APPLICATION + split[0];
                    }
                    listOfData.add(split);
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        mapFileData(listOfData);
    }

    public String get(String key){
        return config.get(key);
    }
    public void printData(){
        System.out.println(config);
    }
}
