package com.example.task02;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import java.util.LinkedList;
import java.nio.file.*;

public class Task02Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println(listFiles(Paths.get("task02/src/main/resources/")));

    }

    public static List<Path> listFiles(Path rootDir) throws IOException, InterruptedException {
        List<Path> paths = new LinkedList<>();
        Files.walk(rootDir).filter(Files::isRegularFile).forEach(paths::add);
        return paths;
    }
}
