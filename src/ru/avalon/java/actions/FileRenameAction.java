/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.actions;

import java.io.File;
import java.nio.file.Path;

/**
 *
 * @author fgh
 */
public class FileRenameAction implements Action{
    
    private Path path;
    private Path name;

    public FileRenameAction(Path file, Path name) {
        this.path = file;
        this.name = name;
    }

    @Override
    public void run() {
            File file = new File(path.toString());
            if(file.exists()){ // если файл существует, то переименовываем его
                file.renameTo(new File(name.toString()));
        }
        else{
            System.out.println("File not found!");
        }
    }

    @Override
    public void close() throws Exception {
        path = null;
        name = null;
    }
    
}
