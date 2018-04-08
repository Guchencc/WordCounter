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
     * 璇嶉缁熻
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

    public static void swap( ArrayList<WordInfo> wordInfos, int i, int j )
    {
        int fre = wordInfos.get(i).getFrequency();
        String word = wordInfos.get(i).getWord();
        WordInfo tempWI =new WordInfo (word,fre);

        wordInfos.set(i,wordInfos.get(j));
        wordInfos.set(j,tempWI);
    }

    public static void linearSort( ArrayList<WordInfo> wordInfos )
    {
        int i=0;
        WordInfo nowWordInfo = wordInfos.get(i);
        for (int j=1; j<wordInfos.size(); j++)
        {
            if (nowWordInfo.getFrequency() == wordInfos.get(j).getFrequency() )
            {
                if(nowWordInfo.getWord().compareTo(wordInfos.get(j).getWord()) > 0 )
                {
                    swap(wordInfos,i,j);
                    i = j;
                    nowWordInfo = wordInfos.get(i);
                }
            }
        }
    }


}
