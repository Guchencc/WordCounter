package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Counter {
    private String filename=null; //当前进行计数处理的文件名
    private int charCount=0; //字符计数器
    private int wordCount=0; //单词计数器
    private int lineCount=0; //行计数器
    private int codeLinecount=0; //代码行计数器
    private int blankLinecount=0; //空行计数器
    private int commentLinecount=0; //注释行计数器
    private ArrayList<String> optlist=new ArrayList<>(); //输入的命令
    private ArrayList<String> stoplist=new ArrayList<>(); //读取的停用词
    private ArrayList<String> filelist=new ArrayList<>(); //输入的计数文件
    private String suffix=null; //通配符后缀
    private String outFileName=null; //输出文件名
    private String stopFileName=null; //停用词文件名

    /**
     * 选择计数
     * @author
     */
    public void Count() {

    }

    /**
     * 根据oplist动态数组中的命令选择数据进行文本输出
     * @author
     */
    public void outprint() {
        File file=null;
        String str="";
        if (!optlist.contains("-c")&&!optlist.contains("-w")&&!optlist.contains("-l")&&!optlist.contains("-a")){
            System.out.println("无统计操作，无输出项！");
            return;
        }
        if(optlist.contains("-o") && outFileName!=null)
            file = new File(outFileName);       //如果指定输出文件路径，则在相应路径输出统计结果
        else
            file = new File("result.txt");      //否则在当前路径下的result.txt文件中输出。
        try{
            FileWriter fw=new FileWriter(file,true);
            PrintWriter pw=new PrintWriter(fw);
            if(!file.exists()){
                file.createNewFile();
            }
            if (optlist.contains("-c"))         //根据oplist中的命令选择记录统计结果
                str+=filename+","+"字符数:"+charCount+"\r\n";
            if (optlist.contains("-w"))
                str+=filename+","+"单词数:"+wordCount+"\r\n";
            if (optlist.contains("-l"))
                str+=filename+","+"行数:"+lineCount+"\r\n";
            if (optlist.contains("-a"))
                str+=filename+","+"代码行/空行/注释行:"+codeLinecount+"/"+blankLinecount+"/"+commentLinecount+"\r\n";
            pw.write(str);
            pw.close();
            fw.close();
        }catch (Exception e){
            System.out.println("输出文件失败！");
        }
    }

    /**
     * 重置计数器
     */
    public void resetCounter() {
        filename=null;
        charCount=0;
        wordCount=0;
        lineCount=0;
        codeLinecount=0;
        blankLinecount=0;
        commentLinecount=0;
    }

    /**
     * 读取输入的停用词文件中的停用词并添加进stoplist动态数组
     * @author Guchencc
     */
    public void readStopFile() {
        String str="";
        String[] stopwords;
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(stopFileName)));
            while ((str = bf.readLine()) != null) {     //遍历输入的停用词文件并登记停用词
                stopwords = str.trim().split("\\s");
                Collections.addAll(stoplist, stopwords);
            }
        }catch (Exception e){
            System.out.println("读取停用词表错误！");
        }
    }

    /**
     * 递归处理输入的文件路径（包含*.XXX）获取所有以XXX为文件格式的文件路径，并添加进filelist动态数组
     * @author Guchencc
     * @param path
     */
    public void findAllFiles(String path) {
        File file=new File(path);
        if (!file.isDirectory()) {
            String filename=file.getName();
            if (filename.substring(filename.lastIndexOf('.')+1,filename.length()).equals(suffix))
                filelist.add(file.getAbsolutePath());
        }else if (file.isDirectory()) {
            if (file.listFiles()==null) //如果是空文件夹就返回
                return;
            for (File f : file.listFiles())
                findAllFiles(f.getAbsolutePath());
        }
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getCharCount() {
        return charCount;
    }

    public void setCharCount(int charCount) {
        this.charCount = charCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getLineCount() {
        return lineCount;
    }

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }

    public int getCodeLinecount() {
        return codeLinecount;
    }

    public void setCodeLinecount(int codeLinecount) {
        this.codeLinecount = codeLinecount;
    }

    public int getBlankLinecount() {
        return blankLinecount;
    }

    public void setBlankLinecount(int blankLinecount) {
        this.blankLinecount = blankLinecount;
    }

    public int getCommentLinecount() {
        return commentLinecount;
    }

    public void setCommentLinecount(int commentLinecount) {
        this.commentLinecount = commentLinecount;
    }

    public ArrayList<String> getOptlist() {
        return optlist;
    }

    public void setOptlist(ArrayList<String> oplist) {
        this.optlist = oplist;
    }

    public ArrayList<String> getStoplist() {
        return stoplist;
    }

    public void setStoplist(ArrayList<String> stoplist) {
        this.stoplist = stoplist;
    }

    public ArrayList<String> getFilelist() {
        return filelist;
    }

    public void setFilelist(ArrayList<String> filelist) {
        this.filelist = filelist;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getOutFileName() {
        return outFileName;
    }

    public void setOutFileName(String outFileName) {
        this.outFileName = outFileName;
    }

    public String getStopFileName() {
        return stopFileName;
    }

    public void setStopFileName(String stopFileName) {
        this.stopFileName = stopFileName;
    }
}
