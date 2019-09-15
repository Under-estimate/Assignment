
package com.zjs.assignment;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * @author ZhouJingsen
 */
public class Assignment extends JFrame{
    
    public Base b;
    public Dict d;
    public QRCode q;
    public JPanel func;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Assignment a=new Assignment();
        a.initialize();
        a.setDefaultCloseOperation(EXIT_ON_CLOSE);
        a.setVisible(true);
    }
    
    public final void initialize(){
        setSize(500,300);
        setTitle("Assignment");
        setLayout(new GridBagLayout());
        GridBagConstraints gc=new GridBagConstraints();
        JRadioButton[] jrb=new JRadioButton[3];
        String[] s={"Base64 Encode","Dictionary Reverse","QRCode Generator"};
        ButtonGroup bg=new ButtonGroup();
        func=new JPanel();
        b=new Base();
        d=new Dict();
        q=new QRCode();
        gc.weightx=1/3;
        gc.weighty=0.1;
        gc.gridy=0;
        gc.gridheight=1;
        gc.gridwidth=1;
        for(int i=0;i<jrb.length;i++){
            gc.gridx=i;
            jrb[i]=new JRadioButton(s[i]);
            bg.add(jrb[i]);
            add(jrb[i],gc);
        }
        gc.weightx=1;
        gc.weighty=0.9;
        gc.gridx=0;
        gc.gridy=1;
        gc.gridwidth=3;
        add(func,gc);
        jrb[0].setSelected(true);
        jrb[0].addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                func.removeAll();
                func.add(b);
                revalidate();
            }
        });
        jrb[1].addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                func.removeAll();
                func.add(d);
                revalidate();
            }
        });
        jrb[2].addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                func.removeAll();
                func.add(q);
                revalidate();
            }
        });
        func.add(b);
    }
}
