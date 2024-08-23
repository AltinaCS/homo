import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MouseExecutor implements MouseListener,startgame {

    JPanel[] path =new JPanel[49];
    public final JFrame frame;
    JLabel label;
    JLabel tryagain;
    Border border = BorderFactory.createLineBorder(Color.green);
    MouseExecutor(JFrame frame){
        this.frame=frame;
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        MusicExecutor.close_music();
        this.frame.getContentPane().removeAll();
        ImageIcon icon = new ImageIcon("C:\\Users\\catis\\OneDrive\\桌面\\HomoMaze\\HomoMaze\\oneoneone.jpg");
        label = new JLabel("GameOver!:(");
        tryagain= new JLabel("Restart");
        label.setBounds(100,100,600,600);
        tryagain.setBounds(170,600,200,50);
        label.setIcon(icon);
        label.setFont(new Font("Arial",Font.BOLD,50));
        tryagain.setFont(new Font("Arial",Font.BOLD,50));
        label.setForeground(Color.green);
        tryagain.setForeground(Color.green);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        tryagain.setBorder(border);
        tryagain.setHorizontalAlignment(SwingConstants.CENTER);
        tryagain.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                startmap();
            }
        });
        this.frame.add(label);
        this.frame.add(tryagain);
        this.frame.revalidate();
        this.frame.repaint();
     }
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void startmap(){
        MusicExecutor.open_Music();
        this.frame.getContentPane().removeAll();
        new Buildamap(frame,path,1);
        this.frame.revalidate();
        this.frame.repaint();
    }
}