/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;

import java.awt.BorderLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author alexisrabilloud
 */
public class MainFrame extends JFrame {
    
    public Grid grid;
    public JMenuBar menubar;
    
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
        
        
        this.menubar = new JMenuBar();
        JMenu menu = new JMenu("Nouvelle partie");
        menubar.add(menu);
        
        JMenuItem menuItem1 = new JMenuItem("Niveau Facile",MouseEvent.BUTTON1);
        menuItem1.addActionListener((ActionEvent e) -> {
            grid = new Grid(10, 10, 10);
            add(grid,BorderLayout.CENTER);
            System.out.println("Patate");
        });
        menu.add(menuItem1);
        
        
        JMenuItem menuItem2 = new JMenuItem("Niveau Moyen",MouseEvent.BUTTON1);
        menu.add(menuItem2);
        
        JMenuItem menuItem3 = new JMenuItem("Niveau Difficile",MouseEvent.BUTTON1);
        menu.add(menuItem3);
             
        this.add(menubar,BorderLayout.NORTH);
        
        this.add(this.grid,BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
        
    }

   
}
