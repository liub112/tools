package orm.adapter;

import com.sun.istack.internal.NotNull;
import orm.exception.NotSupportException;

public class MediaPlayAdapter implements IMediaPlay{

    private IAdvancedMediaPlayer advancedMediaPlayer;

    public MediaPlayAdapter(@NotNull String audioType) {
        if(audioType.equalsIgnoreCase("mp3")){
            this.advancedMediaPlayer = new Mp3AdvancedMediaPlay();
        }else if(audioType.equalsIgnoreCase("vc")){
            this.advancedMediaPlayer = new VcAdvanceMediaPlay();
        }
    }


    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("mp3")){
            advancedMediaPlayer.playMp3(fileName);
        }else if(audioType.equalsIgnoreCase("vc")){
            advancedMediaPlayer.playVc(fileName);
        }else{
            throw new NotSupportException("not support");
        }

    }
}
