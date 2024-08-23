
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicExecutor {
    private static final String BGM="C:\\Users\\catis\\OneDrive\\桌面\\HomoMaze\\HomoMaze\\onlymp3.app - Bach s Air on G String perfect version-U7RYSQvrUrc-192k-1711894355 (mp3cut.net).wav";
    private static final String SOUNDEFFECT="C:\\Users\\catis\\OneDrive\\桌面\\HomoMaze\\HomoMaze\\114514.wav";
    private static final String FINALMUSIC="C:\\Users\\catis\\OneDrive\\桌面\\HomoMaze\\HomoMaze\\野獸先輩 音量MAX (online-audio-converter (mp3cut.net).wav";
    private static File fileclip;
    private static AudioInputStream music;
    private static Clip Bgm;

    public static void open_Music(){
        fileclip=new File(BGM);
        try{
            music = AudioSystem.getAudioInputStream(fileclip);
            Bgm= AudioSystem.getClip();
            Bgm.open(music);
            Bgm.start();
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            throw new RuntimeException(ex);
        }

    }
    public static void close_music(){
        Bgm.close();
    }
    public static void open_soundeffect(){
        fileclip=new File(SOUNDEFFECT);
        try{
            music = AudioSystem.getAudioInputStream(fileclip);
            Clip sound = AudioSystem.getClip();
            sound.open(music);
            sound.start();
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            throw new RuntimeException(ex);
        }

    }
    public static void open_finalmusic(){
        fileclip=new File(FINALMUSIC);
        try{
            music = AudioSystem.getAudioInputStream(fileclip);
            Clip finalmusic = AudioSystem.getClip();
            finalmusic.open(music);
            finalmusic.start();
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            throw new RuntimeException(ex);
        }


    }
}
