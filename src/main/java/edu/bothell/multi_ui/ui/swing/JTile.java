package edu.bothell.multi_ui.ui.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import edu.bothell.multi_ui.core.Control;

public class JTile extends JButton implements ActionListener, Locatable {
    private final JFrame  b;
    private final Control c;
    
    private final int[]   pos;
    private char          it;

    public JTile(Swing b, int[] pos){
        this.b      = b;
        this.c      = b.getControl();
        this.pos    = pos;
        System.out.println("hi");
        init();
    }

    private void init(){
        this.addActionListener(this);
        b.add(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        char bt = c.update( pos,"" );
        if(bt != ' ') super.setText("" + bt);
    }

    @Override
    public int[] getPos() {
        return this.pos;
    }

    @Override
    public char getIt(){
        return this.it;
    }

    @Override
    public void setIt(char x){
        this.it = x;
        super.setText(""+ x);
    }
    
}
