package com.example.task02;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.nio.file.Files;
import java.util.LinkedList;

public class Task02Main {
    public static void main(String[] args) throws IOException, InterruptedException {
    }

    public static List<Path> listFiles(Path rootDir) throws IOException, InterruptedException {
        List<Path> paths = new LinkedList<>();
        Files.walk(rootDir).filter(Files::isRegularFile).forEach(paths::add);
        return paths;
    }
}
