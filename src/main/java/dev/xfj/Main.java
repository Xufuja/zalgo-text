package dev.xfj;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static dev.xfj.Zalgo.goZalgo;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        final String zalgoTxt = goZalgo(input, true, false, true, true, true);

        try {
            final File fileDir = new File("zalgo.txt");
            final Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileDir), StandardCharsets.UTF_8));

            final String[] lines = zalgoTxt.split("\n");

            for (String line : lines) {
                out.append(line).append("\r\n");
            }

            out.flush();
            out.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
