import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swingdemo {
    public static void main(String[] args) {
        System.out.println("Hello");
        Addition obj = new Addition();


    }
}

class Addition extends JFrame implements ActionListener{

    JTextField t1,t2;
    JButton b1,b2,b3,b4;
    JLabel l;
    public Addition(){

         t1= new JTextField(20);
         t2= new JTextField(20);
         b1 = new JButton("+");
         b2 = new JButton("-");
        b3 = new JButton("*");
        b4 = new JButton("/");
        add(t1);
        add(t2);
        add(b1);
        add(b2);
        add(b3);
        add(b4);



         l=new JLabel("Result");

        add(l);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        setLayout(new FlowLayout());
        setVisible(true);
        setSize(250,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
                int num1=Integer.parseInt(t1.getText());
                int num2=Integer.parseInt(t2.getText());
                int val = 0;
                if(e.getSource()==b1){
                    val=num1+num2;
                    System.out.println(val);
                }
                else if(e.getSource()==b2){
                    val=num1-num2;
                    System.out.println(val);
                }
                else if(e.getSource()==b3){
                    val=num1*num2;
                    System.out.println(val);
                }
                else if(e.getSource()==b4){
                    val=num1/num2;
                    System.out.println(val);
                }

                l.setText(val+"");
    }
}
