package com.company;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<WordInfo> wordInfos=null;
        wordInfos=Main.countFrequency("test.txt");
        Main.output(wordInfos);
    }

    /**
     * 输入验证
     * @author
     * @param args
     */
    public static String InputValidate(String[] args)
    {
        String param ="";
        int fileNum=0;
        for (int i=0; i<args.length; i++)
        {
            if ( args[i].matches("\\*[.](txt)$") )
            {
                param = args[i];
                fileNum++;
            }
            else
            {
                System.out.println("请按照要求输入参数，*.txt !");
                return "";
            }
//            if( fileNum == 1)
//            {
//                return param;
//            }
//            else
//            {
//                System.out.println("输入文件数量不为一，请重新输入！");
//                return "";
//            }

        }
        if( fileNum == 1)
        {
            return param;
        }
        else
        {
            System.out.println("输入文件数量不为一，请检查并重新输入！");
            return "";
        }

    }

    /**
     * 词频统计
     * @author
     * @param filename
     * @return ArrayList<WordInfo>
     */
    public static ArrayList<WordInfo> countFrequency(String filename) {
        ArrayList<WordInfo> wordInfos = new ArrayList<>();
        Pattern pattern = Pattern.compile("[a-zA-Z]+-?[a-zA-Z]*");
        String text = Main.readFile(filename);
        Matcher matcher = pattern.matcher(text);
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
            String str = "";
            while ((str = br.readLine()) != null) { //逐行读取文件内容，不读取换行符和末尾的空格
                sb.append(str + "\n");
            }
            br.close();
        }catch (IOException e){
            System.out.println("读取文件失败！");
        }
        return sb.toString();
    }
    /**
     *输出结果
     * @author
     * @param wordInfos
     */
    public static void output(ArrayList<WordInfo> wordInfos){
        for (WordInfo e:wordInfos) {
            System.out.println(e.getWord()+" : "+e.getFrequency());
        }
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

    public static ArrayList<WordInfo> sort( ArrayList<WordInfo>wordInfos )
    {
        int k = findMax(wordInfos);//temp数组zeroToMax的最大下标
        int n = wordInfos.size()-1; //wordInfos最大下标

        int[] zeroToMax = new int [k+1]; //temp数组zeroToMax
        ArrayList<WordInfo> outputWords = new ArrayList<WordInfo> (); //输出，排序完毕的ArrayList
        //outputWords初始化
        for(int i=0; i<= n ;i++)
        {
            WordInfo aWord = new WordInfo("");
            outputWords.add(aWord);
        }
        //temp数组zeroToMax初始化
        for (int i=0; i<= k; i++)
        {
            zeroToMax[i] = 0;
        }
        //遍历wordInfos，将zeroToMax中存入当前下标表示的数的个数
        for (int i=0; i<=n ; i++)
        {
            zeroToMax[wordInfos.get(i).getFrequency()] += 1;
        }
        //遍历zeroToMax，zeroToMax中的元素表示为，小于等于下标元素的个数
        for (int i=1; i<= k ; i++)
        {
            zeroToMax[i] += zeroToMax[i-1];
        }
        //存入outputWords
        for (int j=n; j>=0 ; j--)
        {
            int fre = wordInfos.get(j).getFrequency();
            int index = zeroToMax[fre] -1;
            String word = wordInfos.get(j).getWord();
            WordInfo WI = new WordInfo(word,fre);
            outputWords.set(index,WI);
        }

        return outputWords;
    }


}
