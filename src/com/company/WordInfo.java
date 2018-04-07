package com.company;

public class WordInfo {

    private String word; //单词
    private int frequency; //词频

    public WordInfo(String word){
        this.word = word;
        this.frequency = 0;
    }

    public WordInfo(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

}
