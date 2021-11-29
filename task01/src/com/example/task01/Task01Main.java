package com.example.task01;

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Task01Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        
    }

    public static String extractSoundName(File file) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("ffprobe", "-v", "error", "-of", "flat", "-show_format", file.getAbsolutePath());
        Process process = processBuilder.start();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String[] input = reader.lines().toArray(String[]::new);
            for (String str : input)
                if (str.contains("format.tags.title"))
                    return str.substring(str.lastIndexOf('=') + 2, str.length() - 1);
        }

        throw new RuntimeException();
    }
}
