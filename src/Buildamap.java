import javax.swing.*;
import java.awt.*;

public class Buildamap {
    private final char[] BUILDMAP1 =
            {'X', 'X', 'X', 'X', 'X', 'X', 'X',
                    'X', 'S', 'S', 'S', 'S', 'S', 'B',
                    'X', 'S', 'S', 'S', 'X', 'X', 'X',
                    'X', 'S', 'S', 'S', 'X', 'X', 'X',
                    'X', 'S', 'S', 'S', 'X', 'X', 'X',
                    'X', 'S', 'S', 'S', 'X', 'X', 'X',
                    'X', '@', '@', '@', 'X', 'X', 'X',
            };
    private final char[] BUILDMAP2 =
                   {'X', 'X', 'X', 'X', 'X', 'X', 'X',
                    'X', 'S', 'S', 'S', 'S', 'S', 'S',
                    'X', 'S', 'X', 'X', 'X', 'X', 'X',
                    'X', 'S', 'S', 'S', 'S', 'S', 'X',
                    'X', 'X', 'X', 'X', 'X', 'S', 'X',
                    'X', 'B', 'S', 'S', 'S', 'S', 'X',
                    'X', 'X', 'X', 'X', 'X', 'X', 'X',
            };
    private final char[] BUILDMAP3 =
                   {'X', 'N', 'N', 'B', 'N', 'N', 'X',
                    'X', 'S', 'S', 'n', 'X', 'X', 'X',
                    'X', 'S', 'N', 'N', 'N', 'X', 'X',
                    'X', 'S', 'S', 'S', 'S', 'S', 'X',
                    'X', 'X', 'X', 'X', 'X', 'S', 'X',
                    'X', 'S', 'S', 'S', 'S', 'S', 'X',
                    'X', 'X', 'X', 'X', 'X', 'X', 'X',
            };
    private final char[] BUILDMAP4 =
            {       'X', 'N', 'N', 'S', 'N', 'N', 'X',
                    'X', 'S', 'S', 'n', 'X', 'X', 'X',
                    'X', 'S', 'N', 'N', 'N', 'X', 'X',
                    'X', 'S', 'S', 'S', 'S', 'S', 'X',
                    'N', 'X', 'X', 'X', 'X', 'S', 'X',
                    'b', 'S', 'S', 'S', 'S', 'S', 'X',
                    'X', 'X', 'X', 'X', 'X', 'X', 'X',
            };
    private JButton next_stage;
    private int level;
    private final JPanel[] panel;
    private final JFrame frame;
    private char[] map = {};
    Buildamap(JFrame frame, JPanel[] panel, int level)  {
        this.level = level;
        this.panel = panel;
        this.frame = frame;
        buildmaps();
    }
    public void buildmaps() {

        if (this.level == 1) {
            map = this.BUILDMAP1;
        } else if (this.level == 2) {
            map = this.BUILDMAP2;
        } else if (this.level == 3) {
            map = this.BUILDMAP3;
        }
          else if (this.level==4){
              map=this.BUILDMAP4;
        }
        int index = 0;
        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 7; x++) {
                if (map[index] == 'X') {
                    this.panel[index] = new JPanel();
                    this.panel[index].setBackground(Color.RED);
                    this.panel[index].setBounds(x * 100, y * 100, 100, 100);
                    this.panel[index].addMouseListener(new MouseExecutor(this.frame));
                    this.frame.add(this.panel[index]);
                }
                if (map[index] == 'N') {
                    this.panel[index] = new JPanel();
                    this.panel[index].setBackground(Color.RED);
                    this.panel[index].setBounds(x * 100, y * 100, 100, 170);
                    this.panel[index].addMouseListener(new MouseExecutor(this.frame));
                    this.frame.add(this.panel[index]);
                }
                if (map[index] == '@') {
                    this.panel[index] = new JPanel();
                    this.panel[index].setBackground(Color.RED);
                    this.panel[index].setBounds(x * 100, y * 100+50, 100, 20);

                    this.panel[index].addMouseListener(new MouseExecutor(this.frame));
                    this.frame.add(this.panel[index]);
                }
                if (map[index] == 'n') {
                    this.panel[index] = new JPanel();
                    this.panel[index].setBackground(Color.RED);
                    this.panel[index].setBounds(x * 100, y * 100, 80, 80);

                    this.panel[index].addMouseListener(new MouseExecutor(this.frame));
                    this.frame.add(this.panel[index]);
                }
                if (map[index] == 'T') {
                    this.panel[index] = new JPanel();
                    this.panel[index].setBackground(Color.RED);
                    this.panel[index].setBounds(x * 100, y * 100, 30, 100);
                    this.panel[index].addMouseListener(new MouseExecutor(this.frame));
                    this.frame.add(this.panel[index]);
                }
                if (map[index] == 'B') {
                    next_stage = new JButton();
                    next_stage.setBounds(x * 100, y * 100, 100, 100);
                    next_stage.setBackground(new Color(0x1f1e33));
                    frame.add(next_stage);
                    next_stage.addActionListener(e -> {
                            if (e.getSource() == next_stage) {
                                MusicExecutor.open_soundeffect();
                                this.frame.getContentPane().removeAll();
                                this.frame.revalidate();
                                this.frame.repaint();
                                this.level += 1;
                                buildmaps();
                            }

                    });

                     }
                if (map[index] == 'b') {
                    next_stage = new JButton();
                    next_stage.setBounds(x * 100, y * 100+100, 50, 50);
                    next_stage.setBackground(new Color(0x1f1e33));
                    frame.add(next_stage);
                    next_stage.addActionListener(e -> {
                        if(e.getSource()==next_stage){
                                MusicExecutor.close_music();
                                MusicExecutor.open_finalmusic();
                                this.frame.getContentPane().removeAll();
                                ImageIcon image = new ImageIcon("C:\\Users\\catis\\OneDrive\\桌面\\HomoMaze\\HomoMaze\\stinkypicture.png");
                                JLabel label = new JLabel();
                                label.setIcon(image);
                                label.setBounds(0,0,700,700);
                                this.frame.add(label);
                                this.frame.revalidate();
                                this.frame.repaint();
                        }
                    });
                }
                index++;
            }
        }
    }
}