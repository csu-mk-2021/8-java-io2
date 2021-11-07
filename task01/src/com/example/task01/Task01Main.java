package com.example.task01;

import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Task01Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //здесь вы можете вручную протестировать ваше решение, вызывая реализуемый метод и смотря результат
        // например вот так:

        /*
        System.out.println(extractSoundName(new File("task01/src/main/resources/3727.mp3")));
        */
    }

    public static String extractSoundName(File file) throws IOException, InterruptedException {
        // your implementation here
        ProcessBuilder process = new ProcessBuilder("cmd.exe", "/c", "ffprobe -v error -of flat -show_format " + file.getAbsolutePath());
        process.directory(new File("D:\\ffmpeg-2021-11-03-git-08a501946f-essentials_build\\bin"));
        try(BufferedReader buffer = new BufferedReader(new InputStreamReader(process.start().getInputStream()))) {
            String txt = buffer.readLine();
            while (txt != null){
                if (txt.contains("format.tags.title"))
                    return txt.split("\"")[1];
                txt = buffer.readLine();
            }
        }
        return null;
    }
}
