package ru.avalon.java;

import java.io.BufferedReader;
import ru.avalon.java.console.ConsoleUI;

import java.io.*;
import java.nio.file.*;
import ru.avalon.java.actions.*;

/**
 * Лабораторная работа №3
 * <p>
 * Курс: "Программирование на платформе Java. Разработка
 * многоуровневых приложений"
 * <p>
 * Тема: "Потоки исполнения (Threads) и многозадачность" 
 *
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 */
public class Lab3 extends ConsoleUI<Commands> {
    /**
     * Точка входа в приложение.
     * 
     * @param args 
     */
    
    Path from;
    Path to;

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) {
        new Lab3().run();
    }
    /**
     * Конструктор класса.
     * <p>
     * Инициализирует экземпляр базового типа с использоавнием
     * перечисления {@link Commands}.
     */
    Lab3() {
        super(Commands.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCommand(Commands command) throws IOException {
        switch (command) {
            case copy:
                System.out.println("Enter path of origin: ");
                from = Paths.get(in.readLine());
                System.out.println("Enter  path of copy: ");
                to = Paths.get(in.readLine());
                new FileCopyAction(from, to).start();
                break;
            case move:
                System.out.println("Enter path from: ");
                from = Paths.get(in.readLine());
                System.out.println("Enter path to: ");
                to = Paths.get(in.readLine());
                new FileMoveAction(from, to).start();
                break;
            case delete:
                System.out.println("Enter path: ");
                from = Paths.get(in.readLine());
                new FileDeleteAction(from).start();
                break;
            case rename:
                System.out.println("Enter path from: ");
                from = Paths.get(in.readLine());
                System.out.println("Enter new name: ");
                new FileRenameAction (from, Paths.get(in.readLine()));
                break;                
            case exit:
                close();
                break;
        }
    }
    
}


