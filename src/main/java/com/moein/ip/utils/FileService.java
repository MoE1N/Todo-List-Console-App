package com.moein.ip.utils;

import java.io.File;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class FileService {
    private Path FILE_PATH = FileSystems.getDefault().getPath("todo.json");

    public boolean isFileExisted(){
        return false;
    }

    public String readDataFile(){
        return "";
    }

    public boolean saveToDataFile(CharSequence stringData){
        return false;
    }


}
