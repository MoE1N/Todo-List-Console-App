package com.moein.ip.utils;

import com.moein.ip.todo.Config;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class FileService {

    public boolean isFileExisted(String stringPath){

        return Files.exists( stringToPath( stringPath ) );

    }

    public String readDataFile(String stringPath){
        String content = "";

        try
        {
            content = new String ( Files.readAllBytes( stringToPath( stringPath ) ) );
        }
        catch (IOException e)
        {
            System.out.println(ConsoleControl.RED + e.getMessage() + ConsoleControl.RESET);
        }

        return content;
    }

    public boolean saveToDataFile(String stringData, String stringPath) throws IOException{

        Path resultPath = Files.write(stringToPath( stringPath ), stringData.getBytes());
        if (resultPath instanceof Path){
            return true;
        }
        return false;
    }

    public Path stringToPath(String stringPath){
        Path filePath = null;
        try {
            filePath = FileSystems.getDefault().getPath(stringPath);
        } catch (IllegalArgumentException error){
            System.out.println(error.getMessage());
        }
        return filePath;
    }


}
