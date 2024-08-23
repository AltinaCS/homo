import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Homomaze extends JFrame implements startgame{
    ImageIcon icon = new ImageIcon("C:\\Users\\catis\\OneDrive\\桌面\\HomoMaze\\HomoMaze\\Lava.png");
    Border border=BorderFactory.createLineBorder(new Color(0xE145E4));
    JLabel title;
    JLabel start;
    JLabel HowToPlay;
    int level=1;
    JPanel[] path =new JPanel[49];
    Homomaze(){
        this.setIconImage(icon.getImage());
        this.setTitle("HomoMaze");
        this.setResizable(false);
        this.setSize(700,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.BLACK);
        MenuScreen();
        this.setVisible(true);
    }
    public void startmap(){
        MusicExecutor.open_Music();
            this.getContentPane().removeAll();
            new Buildamap(this,path,level);
            this.revalidate();
            this.repaint();
    }
    public void MenuScreen(){
        this.getContentPane().removeAll();
        title=new JLabel("HomoMaze");
        title.setFont(new Font("Arial",Font.PLAIN,100));
        title.setForeground(new Color(0xE145E4));
        title.setBounds(80,100,900,100);
        start=new JLabel("Start");
        start.setFont(new Font("Arial",Font.PLAIN,50));
        start.setForeground(new Color(0xE145E4));
        start.setBounds(100,500,200,100);
        start.setHorizontalAlignment(SwingConstants.CENTER);
        start.setBorder(border);
        start.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                startmap();
            }
        });
        HowToPlay=new JLabel("Help");
        HowToPlay.setFont(new Font("Arial",Font.PLAIN,50));
        HowToPlay.setForeground(new Color(0xE145E4));
        HowToPlay.setBounds(400,500,200,100);
        HowToPlay.setHorizontalAlignment(SwingConstants.CENTER);
        HowToPlay.setBorder(border);
        HowToPlay.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                HelpScreen();
            }
        });
        this.add(title);
        this.add(start);
        this.add(HowToPlay);
        this.revalidate();
        this.repaint();
    }
    public void HelpScreen(){
        this.getContentPane().removeAll();
        JLabel help = new JLabel("<html>●Use your mouse to control<br><br>●Don't touch the red blocks<br><br>●Press the #1f1e33 button to next stage<br><br>●Use headphone for best experience</html>");
        JLabel back=new JLabel("Back");
        help.setFont(new Font("Arial",Font.PLAIN,30));
        help.setForeground(new Color(0xE145E4));
        help.setBounds(40,50,900,900);
        help.setHorizontalAlignment(SwingConstants.LEFT);
        help.setVerticalAlignment(SwingConstants.TOP);
        back.setFont(new Font("Arial",Font.PLAIN,50));
        back.setForeground(new Color(0xE145E4));
        back.setBounds(400,500,200,100);
        back.setHorizontalAlignment(SwingConstants.CENTER);
        back.setBorder(border);
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                MenuScreen();
            }
        });
        this.add(help);
        this.add(back);
        this.revalidate();
        this.repaint();
    }
    public static void main(String[] args){
        new Homomaze();
    }
}