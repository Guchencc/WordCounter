package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<WordInfo> wordInfos;
        wordInfos=Main.countFrequency("test.txt");
        Main.output(wordInfos);
    }

    /**
     * 输入验证
     * @author
     * @param args
     */
    public static void InputValidate(String[] args) {

    }

    /**
     * 词频统计
     * @author
     * @param filename
     * @return ArrayList<WordInfo>
     */
    public static ArrayList<WordInfo> countFrequency(String filename) {
        ArrayList<WordInfo> wordInfos=new ArrayList<>();
        Pattern pattern=Pattern.compile("[a-zA-Z]+-?[a-zA-Z]*");
        String text=Main.readFile(filename);
        Matcher matcher=pattern.matcher(text);
        String word;
        int index;
        WordInfo wordInfo;
        while(matcher.find()) {
            word=matcher.group().toLowerCase();
            if (word.endsWith("-"))
                word=word.substring(0,word.length()-1);
            if ((index=Main.hasWord(wordInfos,word))!=-1) {
                wordInfos.get(index).setFrequency(wordInfos.get(index).getFrequency()+1);
            }else{
                wordInfo=new WordInfo(word, 1);
                wordInfos.add(wordInfo);
            }
        }
        return wordInfos;
    }

    public static int hasWord(ArrayList<WordInfo> wordInfos, String word) {
        for (WordInfo wordInfo:wordInfos){
            if (wordInfo.getWord().equals(word.trim().toLowerCase()))
                return wordInfos.indexOf(wordInfo);
        }
        return -1;
    }

    public static String readFile(String filename) {
        File file=new File(filename);
        StringBuilder sb = new StringBuilder();
        try {
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String str;
            while ((str = br.readLine()) != null) { //逐行读取文件内容，不读取换行符和末尾的空格
                sb.append(str + "\n");
            }
            br.close();
        }catch (IOException e){
            System.out.println("读取文件失败！");
        }
        return sb.toString();
    }

    //按词频从高到低排序
    /*public static ArrayList<WordInfo> Sort(ArrayList<WordInfo> wordInfos) {

    }*/


    /**
     *输出结果
     * @author
     * @param wordInfos
     */
    public static void output(ArrayList<WordInfo> wordInfos) {

    }
}
