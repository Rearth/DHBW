package de.dhbw.java.exercise.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class TextFile {

    //for testing purposes
    public static void main(String[] args) {

        System.out.println("Creating object");

        TextFile textFile = new TextFile("io/test");
        System.out.println("Reading file: " + textFile.read());
        System.out.println("Line 3: " + textFile.getLine(3));
        System.out.println("Number of Lines: " + textFile.availLines());
        try {
            textFile.setLine(4, "Replaced");
            textFile.setLine(100, "Replaced");
        } catch (LineNumberOutOfBoundsException e) {
            e.printStackTrace();
        }

        System.out.println("going communism: " + textFile.replaceAll("meine", "unsere"));
        textFile.close();
        System.out.println("Done");

    }

    private File file;
    List<String> content = new ArrayList<>();

    public TextFile(File file) {
        this.file = file;
    }


    public TextFile(String file) {
        this.file = new File(file);
    }

    public String read() {
        try {
            content = IO_01.readfileList(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("Unable to read file, stopping");
            System.exit(0);
        }

        return content.toString();
    }

    public void write() {

        StringBuilder toWrite = new StringBuilder("");
        for (String line : content) {
            if (line == content.get(content.size() - 1)) {
                toWrite.append(line);
                continue;
            }
            toWrite.append(line + System.lineSeparator());
        }

        IO_01.writeToFile(file, toWrite.toString(), false);
    }

    public int availLines() {
        return content.size();
    }

    public String[] getLines() {
        return (String[]) content.toArray();
    }

    public String getLine(int line) {
        return content.get(line - 1);
    }

    public void setLine(int line, String text) throws LineNumberOutOfBoundsException {
        if (line < 1 || line > content.size()) {
            //throw exception
            throw new LineNumberOutOfBoundsException();
        }

        content.set(line - 1, text);
        //write();
    }

    public TextFile replaceAll(String regEx, String replace) {
        for (int i = 0; i < content.size(); i++) {
            content.set(i, content.get(i).replaceAll(regEx, replace));
        }

        return this;
    }

    public void close() {
        System.out.println("Closing");
        write();
        content.clear();
    }


    public class LineNumberOutOfBoundsException extends Exception {

        public LineNumberOutOfBoundsException() {
        }

        public LineNumberOutOfBoundsException(String message) {
            super(message);
        }
    }

    @Override
    public String toString() {
        String toReturn = file.getAbsolutePath() + System.lineSeparator();

        for (String line : content) {
            toReturn += line + System.lineSeparator();
        }

        return toReturn;
    }
}
