package com.company;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void main() throws Exception {
    }

    @Test
    public void inputValidate() throws Exception {
    }

    @Test
    public void countFrequency1() throws Exception {
        ArrayList<WordInfo> wordInfos=Main.countFrequency("testcase1.txt");
        assertEquals(0,wordInfos.size());
    }

    @Test
    public void countFrequency2() throws Exception {
        ArrayList<WordInfo> wordInfos=Main.countFrequency("testcase2.txt");
        assertEquals(4,wordInfos.size());
    }

    @Test
    public void countFrequency3() throws Exception {
        ArrayList<WordInfo> wordInfos=Main.countFrequency("testcase3.txt");
        assertEquals(3,wordInfos.size());
    }

    @Test
    public void countFrequency4() throws Exception {
        ArrayList<WordInfo> wordInfos=Main.countFrequency("testcase4.txt");
        assertEquals(3,wordInfos.size());
    }

    @Test
    public void countFrequency5() throws Exception {
        ArrayList<WordInfo> wordInfos=Main.countFrequency("testcase5.txt");
        assertEquals(4,wordInfos.size());
    }

    @Test
    public void countFrequency6() throws Exception {
        ArrayList<WordInfo> wordInfos=Main.countFrequency("testcase6.txt");
        assertEquals(2,wordInfos.size());
    }

    @Test
    public void countFrequency7() throws Exception {
        ArrayList<WordInfo> wordInfos=Main.countFrequency("testcase7.txt");
        assertEquals(3,wordInfos.size());
    }

    @Test
    public void countFrequency8() throws Exception {
        ArrayList<WordInfo> wordInfos=Main.countFrequency("testcase8.txt");
        assertEquals(3,wordInfos.size());
    }

    @Test
    public void countFrequency9() throws Exception {
        ArrayList<WordInfo> wordInfos=Main.countFrequency("testcase9.txt");
        assertEquals(3,wordInfos.size());
    }

    @Test
    public void countFrequency10() throws Exception {
        ArrayList<WordInfo> wordInfos=Main.countFrequency("testcase10.txt");
        assertEquals(3,wordInfos.size());
    }

    @Test
    public void countFrequency11() throws Exception {
        ArrayList<WordInfo> wordInfos=Main.countFrequency("testcase11.txt");
        assertEquals(3,wordInfos.size());
    }

    @Test
    public void countFrequency12() throws Exception {
        ArrayList<WordInfo> wordInfos=Main.countFrequency("testcase12.txt");
        assertEquals(4,wordInfos.size());
    }

    @Test
    public void countFrequency13() throws Exception {
        ArrayList<WordInfo> wordInfos=Main.countFrequency("testcase13.txt");
        assertEquals(0,wordInfos.size());
    }

    @Test
    public void countFrequency14() throws Exception {
        ArrayList<WordInfo> wordInfos=Main.countFrequency("testcase14.txt");
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

}