import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame2 {
    public static void main(String[] args) {
        X x=new X();

    }
}
class X extends JFrame implements ActionListener{
    int i=0;
    JProgressBar p;
    public X(){

         p = new JProgressBar(0,20);


        Timer t = new Timer(250,this);
        JButton b = new JButton("Calculator");
        add(b);
        add(p);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.start();
            }
        });
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(i==20){
            new Addition();
            dispose();
        }
        i++;
        p.setValue(i);
    }
}

