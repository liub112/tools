package com.lfxfs.tools.pattern.adapter;

import org.junit.Test;

public class AudioPlayTest {

    @Test
    public void testMedisPlay(){
        IMediaPlay mediaPlay = new AudioPlay();
        mediaPlay.play("mp4","青青子衿");
    }
}
