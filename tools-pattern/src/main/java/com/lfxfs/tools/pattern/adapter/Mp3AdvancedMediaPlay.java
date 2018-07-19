package com.lfxfs.tools.pattern.adapter;

public class Mp3AdvancedMediaPlay implements IAdvancedMediaPlayer{
    @Override
    public void playVc(String fileName) {

    }

    @Override
    public void playMp3(String fileName) {
        System.out.println("play:mp3"+fileName);
    }
}
