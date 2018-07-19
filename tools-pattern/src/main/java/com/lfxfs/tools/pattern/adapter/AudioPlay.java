package com.lfxfs.tools.pattern.adapter;


import com.lfxfs.tools.pattern.exception.NotSupportException;

public class AudioPlay implements IMediaPlay{
    private IMediaPlay mediaPlayAdapter;
    @Override
    public void play(String audioType, String fileName) {
        this.mediaPlayAdapter = new MediaPlayAdapter(audioType);
        if(audioType.equalsIgnoreCase("mp3")||
                audioType.equalsIgnoreCase("vc")){
            mediaPlayAdapter.play(audioType,fileName);
        }else if(audioType.equalsIgnoreCase("mp4")){
            System.out.println("play mp4:"+fileName);
        }else{
            throw new NotSupportException("audioType:"+audioType+" not support");
        }
    }
}
