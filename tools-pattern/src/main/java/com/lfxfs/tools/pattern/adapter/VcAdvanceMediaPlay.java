package com.lfxfs.tools.pattern.adapter;

public class VcAdvanceMediaPlay implements IAdvancedMediaPlayer{
    @Override
    public void playVc(String fileName) {
        System.out.println("play vc:"+fileName);
    }

    @Override
    public void playMp3(String fileName) {

    }
}
