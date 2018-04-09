package com.company;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void main() throws Exception {
    }

    @Test
    public void countFrequency1() throws Exception {
        ArrayList<WordInfo> wordInfos=Main.countFrequency("Test/countFrequency/testcase1.txt");
        assertEquals(0,wordInfos.size());
    }

    @Test
    public void countFrequency2() throws Exception {
        ArrayList<WordInfo> wordInfos=Main.countFrequency("Test/countFrequency/testcase2.txt");
        assertEquals(4,wordInfos.size());
    }

    @Test
    public void countFrequency3() throws Exception {
        ArrayList<WordInfo> wordInfos=Main.countFrequency("Test/countFrequency/testcase3.txt");
        assertEquals(3,wordInfos.size());
    }

    @Test
    public void countFrequency4() throws Exception {
        ArrayList<WordInfo> wordInfos=Main.countFrequency("Test/countFrequency/testcase4.txt");
        assertEquals(3,wordInfos.size());
    }

    @Test
    public void countFrequency5() throws Exception {
        ArrayList<WordInfo> wordInfos=Main.countFrequency("Test/countFrequency/testcase5.txt");
        assertEquals(4,wordInfos.size());
    }

    @Test
    public void countFrequency6() throws Exception {
        ArrayList<WordInfo> wordInfos=Main.countFrequency("Test/countFrequency/testcase6.txt");
        assertEquals(2,wordInfos.size());
    }

    @Test
    public void countFrequency7() throws Exception {
        ArrayList<WordInfo> wordInfos=Main.countFrequency("Test/countFrequency/testcase7.txt");
        assertEquals(3,wordInfos.size());
    }

    @Test
    public void countFrequency8() throws Exception {
        ArrayList<WordInfo> wordInfos=Main.countFrequency("Test/countFrequency/testcase8.txt");
        assertEquals(3,wordInfos.size());
    }

    @Test
    public void countFrequency9() throws Exception {
        ArrayList<WordInfo> wordInfos=Main.countFrequency("Test/countFrequency/testcase9.txt");
        assertEquals(3,wordInfos.size());
    }

    @Test
    public void countFrequency10() throws Exception {
        ArrayList<WordInfo> wordInfos=Main.countFrequency("Test/countFrequency/testcase10.txt");
        assertEquals(3,wordInfos.size());
    }

    @Test
    public void countFrequency11() throws Exception {
        ArrayList<WordInfo> wordInfos=Main.countFrequency("Test/countFrequency/testcase11.txt");
        assertEquals(3,wordInfos.size());
    }

    @Test
    public void countFrequency12() throws Exception {
        ArrayList<WordInfo> wordInfos=Main.countFrequency("Test/countFrequency/testcase12.txt");
        assertEquals(4,wordInfos.size());
    }

    @Test
    public void countFrequency13() throws Exception {
        ArrayList<WordInfo> wordInfos=Main.countFrequency("Test/countFrequency/testcase13.txt");
        assertEquals(0,wordInfos.size());
    }

    @Test
    public void countFrequency14() throws Exception {
        ArrayList<WordInfo> wordInfos=Main.countFrequency("Test/countFrequency/testcase14.txt");
        assertEquals(4,wordInfos.size());
    }


    @Test
    public void hasWord1() throws Exception {
        ArrayList<WordInfo> wordInfos=new ArrayList<>();
        wordInfos.add(new WordInfo("apple",21));
        wordInfos.add(new WordInfo("pig",6));
        wordInfos.add(new WordInfo("ccc",12));
        int index=Main.hasWord(wordInfos,"pig");
        assertEquals(1,index);
    }

    @Test
    public void hasWord2() throws Exception {
        ArrayList<WordInfo> wordInfos=new ArrayList<>();
        wordInfos.add(new WordInfo("ad",3));
        wordInfos.add(new WordInfo("pig",12));
        wordInfos.add(new WordInfo("bird",12));
        int index=Main.hasWord(wordInfos,"dog");
        assertEquals(-1,index);
    }

    @Test
    public void hasWord3() throws Exception {
        ArrayList<WordInfo> wordInfos=new ArrayList<>();
        wordInfos.add(new WordInfo("abc",6));
        wordInfos.add(new WordInfo("hello",12));
        wordInfos.add(new WordInfo("shit",14));
        int index=Main.hasWord(wordInfos,"AbC");
        assertEquals(0,index);
    }

    @Test
    public void hasWord4() throws Exception {
        ArrayList<WordInfo> wordInfos=new ArrayList<>();
        wordInfos.add(new WordInfo("basic",10));
        wordInfos.add(new WordInfo("xxx",30));
        wordInfos.add(new WordInfo("memory",20));
        int index=Main.hasWord(wordInfos,"Girl");
        assertEquals(-1,index);
    }

    @Test
    public void readFile1() throws Exception {
        String str=Main.readFile("abc.txt");
        assertNull(str);
    }

    @Test
    public void readFile2() throws Exception {
        String str=Main.readFile("test.txt");
        assertNotNull(str);
    }

    @Test
    public void output() throws Exception {
    }


    //ryo
    //正常情况
    @Test
    public void findMax1() throws Exception
    {
        ArrayList<WordInfo> wdInfos = new ArrayList<>();
        wdInfos.add(new WordInfo("woaini",99));
        wdInfos.add(new WordInfo("wohenni",100));
        wdInfos.add(new WordInfo("konoyaro",543));
        wdInfos.add(new WordInfo("kadamono",12));
        wdInfos.add(new WordInfo("ryuichi",22));
        int max = Main.findMax(wdInfos);
        assertEquals(543,max);
    }
    //多个相同最大值时的情况
    @Test
    public void findMax2() throws Exception
    {
        ArrayList<WordInfo> wdInfos = new ArrayList<>();
        wdInfos.add(new WordInfo("haha",55));
        wdInfos.add(new WordInfo("konoyaro",55));
        wdInfos.add(new WordInfo("jiraiya",55));
        wdInfos.add(new WordInfo("sasuke",12));
        wdInfos.add(new WordInfo("naruto",22));
        int max = Main.findMax(wdInfos);
        assertEquals(55,max);
    }

    //相邻
    @Test
    public void swap1() throws Exception
    {
        ArrayList<WordInfo> wdInfos = new ArrayList<>();
        wdInfos.add(new WordInfo("ichi",10));
        wdInfos.add(new WordInfo("ni",20));
        wdInfos.add(new WordInfo("san",30));
        wdInfos.add(new WordInfo("shi",40));
        wdInfos.add(new WordInfo("go",50));
        WordInfo aExpect =wdInfos.get(1);
        WordInfo bExpect =wdInfos.get(0);
        Main.swap(wdInfos,0,1);
        WordInfo aAfterSwap =wdInfos.get(0);
        WordInfo bAfterSwap =wdInfos.get(1);
        assertEquals(aExpect.getFrequency(),aAfterSwap.getFrequency());
        assertEquals(aExpect.getWord(),aAfterSwap.getWord());
        assertEquals(bExpect.getFrequency(),bAfterSwap.getFrequency());
        assertEquals(bExpect.getWord(),bAfterSwap.getWord());
    }
    //  相间
    @Test
    public void swap2() throws Exception
    {
        ArrayList<WordInfo> wdInfos = new ArrayList<>();
        wdInfos.add(new WordInfo("ichi",10));
        wdInfos.add(new WordInfo("ni",20));
        wdInfos.add(new WordInfo("san",30));
        wdInfos.add(new WordInfo("shi",40));
        wdInfos.add(new WordInfo("go",50));
        WordInfo aExpect =wdInfos.get(1);
        WordInfo bExpect =wdInfos.get(4);
        Main.swap(wdInfos,1,4);
        WordInfo aAfterSwap =wdInfos.get(4);
        WordInfo bAfterSwap =wdInfos.get(1);
        assertEquals(aExpect.getFrequency(),aAfterSwap.getFrequency());
        assertEquals(aExpect.getWord(),aAfterSwap.getWord());
        assertEquals(bExpect.getFrequency(),bAfterSwap.getFrequency());
        assertEquals(bExpect.getWord(),bAfterSwap.getWord());
    }

    //边界错误1
    @Test
    public void swap3() throws Exception
    {
        ArrayList<WordInfo> wdInfos = new ArrayList<>();
        wdInfos.add(new WordInfo("ichi",10));
        wdInfos.add(new WordInfo("ni",20));
        wdInfos.add(new WordInfo("san",30));
        wdInfos.add(new WordInfo("shi",40));
        wdInfos.add(new WordInfo("go",50));
        WordInfo aExpect =wdInfos.get(1);
        WordInfo bExpect =wdInfos.get(4);
        Main.swap(wdInfos,-1,4);

    }
    //边界错误2
    @Test
    public void swap4() throws Exception
    {
        ArrayList<WordInfo> wdInfos = new ArrayList<>();
        wdInfos.add(new WordInfo("ichi",10));
        wdInfos.add(new WordInfo("ni",20));
        wdInfos.add(new WordInfo("san",30));
        wdInfos.add(new WordInfo("shi",40));
        wdInfos.add(new WordInfo("go",50));
        WordInfo aExpect =wdInfos.get(1);
        WordInfo bExpect =wdInfos.get(4);
        Main.swap(wdInfos,2,6);
    }
    //边界错误3
    @Test
    public void swap5() throws Exception
    {
        ArrayList<WordInfo> wdInfos = new ArrayList<>();
        wdInfos.add(new WordInfo("ichi",10));
        wdInfos.add(new WordInfo("ni",20));
        wdInfos.add(new WordInfo("san",30));
        wdInfos.add(new WordInfo("shi",40));
        wdInfos.add(new WordInfo("go",50));
        WordInfo aExpect =wdInfos.get(1);
        WordInfo bExpect =wdInfos.get(4);
        Main.swap(wdInfos,-1,-5);
    }
    //边界错误4
    @Test
    public void swap6() throws Exception
    {
        ArrayList<WordInfo> wdInfos = new ArrayList<>();
        wdInfos.add(new WordInfo("ichi",10));
        wdInfos.add(new WordInfo("ni",20));
        wdInfos.add(new WordInfo("san",30));
        wdInfos.add(new WordInfo("shi",40));
        wdInfos.add(new WordInfo("go",50));
        WordInfo aExpect =wdInfos.get(1);
        WordInfo bExpect =wdInfos.get(4);
        Main.swap(wdInfos,123123,12312);
    }

    //词频排序,词频确认
    @Test
    public void sort1() throws Exception
    {
        ArrayList<WordInfo> wdInfos = new ArrayList<>();
        wdInfos.add(new WordInfo("ichi",10));
        wdInfos.add(new WordInfo("ni",20));
        wdInfos.add(new WordInfo("san",30));
        wdInfos.add(new WordInfo("shi",40));
        wdInfos.add(new WordInfo("go",50));

        ArrayList<WordInfo>afterSort=Main.sort(wdInfos);
        assertEquals(50,afterSort.get(0).getFrequency());
        assertEquals(40,afterSort.get(1).getFrequency());
    }

    //词频排序，单词确认
    @Test
    public void sort2() throws Exception
    {
        ArrayList<WordInfo> wdInfos = new ArrayList<>();
        wdInfos.add(new WordInfo("ichi",10));
        wdInfos.add(new WordInfo("ni",20));
        wdInfos.add(new WordInfo("san",30));
        wdInfos.add(new WordInfo("shi",40));
        wdInfos.add(new WordInfo("go",50));

        ArrayList<WordInfo>afterSort=Main.sort(wdInfos);
        assertEquals("go",afterSort.get(0).getWord());
        assertEquals("shi",afterSort.get(1).getWord());
    }

    //词频排序，再按字母表排序，词频确认1
    @Test
    public void sort3() throws Exception
    {
        ArrayList<WordInfo> wdInfos = new ArrayList<>();
        wdInfos.add(new WordInfo("sdasd",20));
        wdInfos.add(new WordInfo("haha",20));
        wdInfos.add(new WordInfo("das",20));
        wdInfos.add(new WordInfo("a",20));
        wdInfos.add(new WordInfo("bas",20));
        wdInfos.add(new WordInfo("jiangs",123));

        ArrayList<WordInfo>afterSort=Main.sort(wdInfos);
        assertEquals(123,afterSort.get(0).getFrequency());
    }

    //词频排序，再按字母表排序，词频确认2
    @Test
    public void sort4() throws Exception
    {
        ArrayList<WordInfo> wdInfos = new ArrayList<>();
        wdInfos.add(new WordInfo("sdasd",20));
        wdInfos.add(new WordInfo("haha",20));
        wdInfos.add(new WordInfo("das",20));
        wdInfos.add(new WordInfo("tashikani",3));
        wdInfos.add(new WordInfo("a",20));
        wdInfos.add(new WordInfo("bas",20));
        wdInfos.add(new WordInfo("jiangs",123));

        ArrayList<WordInfo>afterSort=Main.sort(wdInfos);
        assertEquals(20,afterSort.get(2).getFrequency());
    }

    //词频排序，再按字母表排序，词频确认3
    @Test
    public void sort5() throws Exception
    {
        ArrayList<WordInfo> wdInfos = new ArrayList<>();
        wdInfos.add(new WordInfo("sdasd",20));
        wdInfos.add(new WordInfo("haha",20));
        wdInfos.add(new WordInfo("das",20));
        wdInfos.add(new WordInfo("tashikani",3));
        wdInfos.add(new WordInfo("a",20));
        wdInfos.add(new WordInfo("bas",20));
        wdInfos.add(new WordInfo("jiangs",123));

        ArrayList<WordInfo>afterSort=Main.sort(wdInfos);
        assertEquals(3,afterSort.get(6).getFrequency());
    }

    //词频排序，再按字母表排序，单词确认1
    @Test
    public void sort6() throws Exception
    {
        ArrayList<WordInfo> wdInfos = new ArrayList<>();
        wdInfos.add(new WordInfo("sdasd",20));
        wdInfos.add(new WordInfo("haha",20));
        wdInfos.add(new WordInfo("das",20));
        wdInfos.add(new WordInfo("tashikani",3));
        wdInfos.add(new WordInfo("a",20));
        wdInfos.add(new WordInfo("bas",20));
        wdInfos.add(new WordInfo("jiangs",123));

        ArrayList<WordInfo>afterSort=Main.sort(wdInfos);
        assertEquals("jiangs",afterSort.get(0).getWord());
    }

    //词频排序，再按字母表排序，单词确认2
    @Test
    public void sort7() throws Exception
    {
        ArrayList<WordInfo> wdInfos = new ArrayList<>();
        wdInfos.add(new WordInfo("sdasd",20));
        wdInfos.add(new WordInfo("haha",20));
        wdInfos.add(new WordInfo("das",20));
        wdInfos.add(new WordInfo("tashikani",3));
        wdInfos.add(new WordInfo("a",20));
        wdInfos.add(new WordInfo("bas",20));
        wdInfos.add(new WordInfo("jiangs",123));

        ArrayList<WordInfo>afterSort=Main.sort(wdInfos);
        assertEquals("tashikani",afterSort.get(6).getWord());
    }

    //词频排序，再按字母表排序，多个单词，单词确认
    @Test
    public void sort8() throws Exception
    {
        ArrayList<WordInfo> wdInfos = new ArrayList<>();
        wdInfos.add(new WordInfo("nihaode",20));
        wdInfos.add(new WordInfo("haha",11));
        wdInfos.add(new WordInfo("das",20));
        wdInfos.add(new WordInfo("tashikani",20));
        wdInfos.add(new WordInfo("a",12));
        wdInfos.add(new WordInfo("baasdasds",87));
        wdInfos.add(new WordInfo("basdas",80));
        wdInfos.add(new WordInfo("ba",80));

        ArrayList<WordInfo>afterSort=Main.sort(wdInfos);
        assertEquals("baasdasds",afterSort.get(0).getWord());
        assertEquals("ba",afterSort.get(1).getWord());
        assertEquals("basdas",afterSort.get(2).getWord());

    }

    //词频排序，再按字母表排序，多个单词，包含数字的单词，单词确认
    @Test
    public void sort9() throws Exception
    {
        ArrayList<WordInfo> wdInfos = new ArrayList<>();
        wdInfos.add(new WordInfo("nihaode",20));
        wdInfos.add(new WordInfo("haha",11));
        wdInfos.add(new WordInfo("das",20));
        wdInfos.add(new WordInfo("tashikani",20));
        wdInfos.add(new WordInfo("a",12));
        wdInfos.add(new WordInfo("baasdasds",87));
        wdInfos.add(new WordInfo("1basdas",80));
        wdInfos.add(new WordInfo("ba",80));

        ArrayList<WordInfo>afterSort=Main.sort(wdInfos);
        assertEquals("baasdasds",afterSort.get(0).getWord());
        assertEquals("1basdas",afterSort.get(1).getWord());
        assertEquals("ba",afterSort.get(2).getWord());

    }

    //词频排序，再按字母表排序，多个单词，包含特殊字符的单词，单词确认
    @Test
    public void sort10() throws Exception
    {
        ArrayList<WordInfo> wdInfos = new ArrayList<>();
        wdInfos.add(new WordInfo("nihaode",20));
        wdInfos.add(new WordInfo("haha",11));
        wdInfos.add(new WordInfo("das",20));
        wdInfos.add(new WordInfo("tashikani",20));
        wdInfos.add(new WordInfo("a",12));
        wdInfos.add(new WordInfo("baasdasds",87));
        wdInfos.add(new WordInfo("&basdas",80));
        wdInfos.add(new WordInfo("ba",80));

        ArrayList<WordInfo>afterSort=Main.sort(wdInfos);
        assertEquals("baasdasds",afterSort.get(0).getWord());
        assertEquals("&basdas",afterSort.get(1).getWord());
        assertEquals("ba",afterSort.get(2).getWord());

    }

    //词频排序，再按字母表排序，多个单词，包含多个特殊字符的单词，单词确认
    @Test
    public void sort11() throws Exception
    {
        ArrayList<WordInfo> wdInfos = new ArrayList<>();
        wdInfos.add(new WordInfo("nihaode",20));
        wdInfos.add(new WordInfo("haha",11));
        wdInfos.add(new WordInfo("das",20));
        wdInfos.add(new WordInfo("#tashikani",20));
        wdInfos.add(new WordInfo("$a",12));
        wdInfos.add(new WordInfo("^baasdasds",87));
        wdInfos.add(new WordInfo("&basdas",80));
        wdInfos.add(new WordInfo("*ba",80));

        ArrayList<WordInfo>afterSort=Main.sort(wdInfos);
        assertEquals("^baasdasds",afterSort.get(0).getWord());
        assertEquals("&basdas",afterSort.get(1).getWord());
        assertEquals("*ba",afterSort.get(2).getWord());

    }

    //词频排序，再按字母表排序，多个单词，包含多个特殊字符组合的单词，单词确认
    @Test
    public void sort12() throws Exception
    {
        ArrayList<WordInfo> wdInfos = new ArrayList<>();
        wdInfos.add(new WordInfo("nihaode",20));
        wdInfos.add(new WordInfo("haha",11));
        wdInfos.add(new WordInfo("das",20));
        wdInfos.add(new WordInfo("#tashikani",20));
        wdInfos.add(new WordInfo("$a",12));
        wdInfos.add(new WordInfo("&*^baasdasds",87));
        wdInfos.add(new WordInfo("&*&basdas",80));
        wdInfos.add(new WordInfo("*&*ba",80));

        ArrayList<WordInfo>afterSort=Main.sort(wdInfos);
        assertEquals("&*^baasdasds",afterSort.get(0).getWord());
        assertEquals("&*&basdas",afterSort.get(1).getWord());
        assertEquals("*&*ba",afterSort.get(2).getWord());

    }


    //黑盒测试,success
    @Test
    public void inputValidate1() throws Exception
    {
        String[] arg = new String [1];
        arg[0]="test.txt";

        String  aStr=Main.inputValidate(arg);
        assertEquals("test.txt",aStr);

    }
    //白盒路径测试 文件不存在
    @Test
    public void inputValidate2() throws Exception
    {
        String[] arg = new String [1];
        arg[0]="abab.txt";
        String expect = null;
        String  aStr=Main.inputValidate(arg);
        assertEquals(expect,aStr);

    }

    //白盒路径测试 文件不唯一
    @Test
    public void inputValidate3() throws Exception
    {
        String[] arg = new String [2];
        arg[0]="test.txt";
        arg[1]="haha.txt";
        String expect = null;
        String  aStr=Main.inputValidate(arg);
        assertEquals(expect,aStr);

    }

    //白盒路径测试 文件是否为*.txt格式
    @Test
    public void inputValidate4() throws Exception
    {
        String[] arg = new String [1];
        arg[0]="test.java";
        String expect = null;
        String  aStr=Main.inputValidate(arg);
        assertEquals(expect,aStr);

    }

}