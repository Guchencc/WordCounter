package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws Exception {
        String filename=Main.inputValidate(args);
        try {
            ArrayList<WordInfo> wordInfos = Main.countFrequency(filename);
            wordInfos=Main.sort(wordInfos);
            for (WordInfo wordInfo:wordInfos)
                System.out.println(wordInfo.getWord()+" "+wordInfo.getFrequency());
            Main.output(wordInfos);
        }catch (Exception e){
            System.out.println("");
        }
    }

    /**
     * 输入验证
     * @author
     * @param args
     */
    public static String inputValidate(String[] args)
    {
        String param =null;
        if(args.length == 1)
        {
            if(args[0].length()>4 && args[0].indexOf(".txt")!=-1)
            {
                param = args[0];
                File file = new File(param);
                if(!file.exists())
                {
                    System.out.println("输入文件不存在，请检查并确认");
                    param = null;
                }
            }
            else
            {
                System.out.println("请检查输入文件是否为*.txt格式");
            }
        }
        else
        {
            System.out.println("输入文件不为1，请检查并重新输入");
        }

        return param;
    }


    /**
     * 词频统计
     * @author
     * @param filename
     * @return ArrayList<WordInfo>
     */
    public static ArrayList<WordInfo> countFrequency(String filename) {
        ArrayList<WordInfo> wordInfos=new ArrayList<>();
        Pattern pattern=Pattern.compile("[a-zA-Z]+-?[a-zA-Z]*");    //定义单词的正则表达式
        String text=Main.readFile(filename);    //调用readFile（）读取文本内容赋值给text
        if (text==null){
            return null;
        }
        Matcher matcher=pattern.matcher(text);  //利用之前定义的单词正则表达式匹配text中的单词
        String word;
        int index;
        WordInfo wordInfo;
        while(matcher.find()) {     //如果匹配到单词则进入循环处理
            word=matcher.group().toLowerCase();     //将匹配到的单词赋值给word
            if (word.endsWith("-"))     //如果匹配到“单词-”情况，则去除符号“-”
                word=word.substring(0,word.length()-1);
            if ((index=Main.hasWord(wordInfos,word))!=-1) {     //如果动态数组wordInfos中已经有该单词，则将频数加一
                wordInfos.get(index).setFrequency(wordInfos.get(index).getFrequency()+1);
            }else{      //如果动态数组wordInfos中无该单词，则将该单词加入动态数组
                wordInfo=new WordInfo(word, 1);
                wordInfos.add(wordInfo);
            }
        }
        return wordInfos;
    }

    public static int hasWord(ArrayList<WordInfo> wordInfos, String word) {     //判断word是否存在于动态数组wordInfos中，若存在则返回位置，负责返回-1
        for (WordInfo wordInfo:wordInfos){
            if (wordInfo.getWord().equals(word.trim().toLowerCase()))
                return wordInfos.indexOf(wordInfo);
        }
        return -1;
    }

    public static String readFile(String filename) {    //读取filename文本文件
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
            return sb.toString();
        }catch (IOException e){
            System.out.println("读取文件失败！");
        }
        return null;
    }

    /**
     * 排序
     * @param wordInfos
     * @return
     */

    public static int findMax (ArrayList<WordInfo> wordInfos)
    {
        int max=wordInfos.get(0).getFrequency();
        for(int i=1; i<wordInfos.size();i++)
        {
            if( wordInfos.get(i).getFrequency() > max )
            {
                max = wordInfos.get(i).getFrequency();
            }
        }
        return max;
    }

    public static ArrayList<WordInfo> sort( ArrayList<WordInfo> wordInfos )
    {
        int k = findMax(wordInfos);//temp数组zeroToMax的最大下标
        int n = wordInfos.size()-1; //wordInfos最大下标

        int[] temp = new int [k+1]; //temp数组zeroToMax
        ArrayList<WordInfo> outputWords = new ArrayList<WordInfo> (); //输出，排序完毕的ArrayList
        //outputWords初始化
        for(int i=0; i<= n ;i++)
        {
            WordInfo aWord = new WordInfo("");
            outputWords.add(aWord);
        }
        //temp数组初始化
        for (int i=0; i<= k; i++)
        {
            temp[i] = 0;
        }
        //遍历wordInfos，将temp中存入当前下标表示的数的个数
        for (int i=0; i<=n ; i++)
        {
            temp[wordInfos.get(i).getFrequency()] += 1;
        }
        //遍历temp，temp中的元素表示为，小于等于下标元素的个数
        for (int i=1; i<= k ; i++)
        {
            temp[i] += temp[i-1];
        }
        //存入outputWords
        for (int j=n; j>=0 ; j--)
        {
            int fre = wordInfos.get(j).getFrequency();
            String word = wordInfos.get(j).getWord();
            WordInfo WI = new WordInfo(word,fre);

            int index = temp[fre] -1;
            outputWords.set(index,WI);
            temp[fre] = temp[fre] -1 ;
        }

        Collections.reverse(outputWords);
        for (int i=0;i<outputWords.size()-1;i++)
        {
            for(int j=i; j<outputWords.size()-1;j++)
            {
                if (outputWords.get(j).getFrequency() ==outputWords.get(j+1).getFrequency())
                {
                    if (outputWords.get(j).getWord().compareTo(outputWords.get(j+1).getWord()) > 0)
                    {
                        swap(outputWords,j,j+1);
                    }
                }
            }
        }

        return outputWords;
    }

    public static void swap( ArrayList<WordInfo> wordInfos, int i, int j )
    {
        if ( i<0 || j<0 || i>=wordInfos.size() || j>= wordInfos.size() )
        {
            System.out.println("边界出错，请注意交换位置的边界");
            return;
        }
        int fre = wordInfos.get(i).getFrequency();
        String word = wordInfos.get(i).getWord();
        WordInfo tempWI =new WordInfo (word,fre);

        wordInfos.set(i,wordInfos.get(j));
        wordInfos.set(j,tempWI);
    }


    /**
     *输出结果
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
