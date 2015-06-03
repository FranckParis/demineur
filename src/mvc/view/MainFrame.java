/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author alexisrabilloud
 */
public class MainFrame extends JFrame {
    
    public Grid grid;
    
    public MainFrame()
    {
        super();
        
        build();
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                super.windowClosing(arg0);
                System.exit(0);
            }
        });
                

    }
    
    public void build()
    {
        setTitle("Démineur");
        
        this.setLayout(new BorderLayout());
        
        this.grid = new Grid(10,10,10);
  
        this.setPreferredSize(new Dimension(550,700));       
        this.add(this.grid,BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
        
    }
    
}
