package org.example.repositories;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class repor {
    public String history;
    public String res;
    public File file;
    public String ans;
    public repor(String history, String res){
        System.out.print("Введіть назву файлу\n");
        Scanner in = new Scanner(System.in);
        this.ans=in.nextLine();
        this.file = new File(this.ans+".txt");
        this.history=history;
        this.res=res;
        this.savafile(this.file);
    }
    public void savafile(File file)  {
        try (FileWriter writer = new FileWriter(file)){
            writer.write(this.history);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
