/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fgh
 */
public class FileDeleteAction implements Action{
    
    private Path from;

    public FileDeleteAction(Path from) {
        this.from = from;
    }

    @Override
    public void run() {
        try {
            Files.delete(from);
        } catch (IOException ex) {
            System.err.println("Can't remove! " + ex.getMessage());
            
        }
    }

    @Override
    public void close() throws Exception {
        from = null;
    }
    
}
