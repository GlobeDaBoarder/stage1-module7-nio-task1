package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class FileReader {

    public Profile getDataFromFile(File file) {
        try(BufferedReader bf = new BufferedReader(new java.io.FileReader(file))){
            List<String>  lines = bf.lines().collect(Collectors.toList());
            Map<String, String> map = lines.stream()
                .map(s -> s.split(":"))
                .collect(Collectors.toMap(s -> s[0].trim(), s -> s[1].trim()));
            return  new Profile(
                map.get("Name"),
                Integer.parseInt(map.get("Age")),
                map.get("Email"),
                Long.parseLong(map.get("Phone"))
            );
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

