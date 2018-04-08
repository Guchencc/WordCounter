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
     * 杈撳叆楠岃瘉
     * @author
     * @param args
     */
    public static void InputValidate(String[] args) {

    }

    /**
     * 璇嶉缁熻
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
            while ((str = br.readLine()) != null) { //閫愯璇诲彇鏂囦欢鍐呭锛屼笉璇诲彇鎹㈣绗﹀拰鏈熬鐨勭┖鏍�
                sb.append(str + "\n");
            }
            br.close();
        }catch (IOException e){
            System.out.println("璇诲彇鏂囦欢澶辫触锛�");
        }
        return sb.toString();
    }

    //鎸夎瘝棰戜粠楂樺埌浣庢帓搴�
    /*public static ArrayList<WordInfo> Sort(ArrayList<WordInfo> wordInfos) {

    }*/


    /**
     *杈撳嚭缁撴灉
     * @author
     * @param wordInfos
     */
    public static void output(ArrayList<WordInfo> wordInfos) {
        File file=new File("result.txt");
        String str="";
        try {
            FileWriter fw = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fw);
            if (!file.exists())
                if (!file.createNewFile())
                    System.out.println("创建统计文件失败!");
            int size=wordInfos.size();
            int n=size>100?100:size;
            for (int i=0;i<n;i++)
                str=str+wordInfos.get(i).getWord()+" "+wordInfos.get(i).getFrequency()+"\r\n";
            pw.write(str);
            pw.close();
            fw.close();
        }catch (IOException e) {
            System.out.println("统计结果写入文件失败！");
        }
    }
}
