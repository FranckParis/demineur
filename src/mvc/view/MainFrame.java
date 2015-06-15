/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import mvc.model.GameModel;

/**
 *
 * @author alexisrabilloud
 */
public final class MainFrame extends JFrame implements Observer {
    
    public Grid grid;
    public int timer;
    
    public JMenuBar menubar;
    public JPanel info;
    public JLabel flags;
    public JLabel time;
    
    public JPanel text;
    public JLabel textf;
    public JLabel textt;
    
    public JPanel center;
    
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
        this.timer =0;
        this.setLayout(new BorderLayout());
        GameModel g = new GameModel();
        g.addObserver(this);
        this.grid = new Grid(9,9,10, new Dimension(40,40), g);    
        
        this.info = new JPanel();
        time = new JLabel();
        flags = new JLabel();
        
        this.text = new JPanel();
        textf = new JLabel();
        textt = new JLabel();
        
        this.center = new JPanel();
        
        time.setText("0");
        flags.setText("10");
        
        textf.setText("Flags");
        textt.setText("Timer");
        
        
        info.add(time, FlowLayout.LEFT);
        info.add(flags, FlowLayout.CENTER);
        
        text.add(textt, FlowLayout.LEFT);
        text.add(textf, FlowLayout.CENTER);
        
        this.menubar = new JMenuBar();
        JMenu menu = new JMenu("Nouvelle partie");
        menubar.add(menu);
        
        JMenuItem menuItem1 = new JMenuItem("Niveau Facile",MouseEvent.BUTTON1);
        menuItem1.addActionListener((ActionEvent e) -> {
            this.timer = 0;
            grid.removeAll();
            GameModel gm = new GameModel();
            gm.addObserver(this);
            grid.build(9, 9, 10, new Dimension(40,40), gm);
            flags.setText("10");
            add(grid,BorderLayout.SOUTH);
            this.pack();
            validate();
        });
        menu.add(menuItem1);
        
        
        JMenuItem menuItem2 = new JMenuItem("Niveau Moyen",MouseEvent.BUTTON1);
        menuItem2.addActionListener((ActionEvent e) -> {
            this.timer = 0;
            grid.removeAll();
            GameModel gm = new GameModel();
            gm.addObserver(this);
            grid.build(16, 16, 40, new Dimension(35,35), gm);
            flags.setText("40");
            add(grid,BorderLayout.SOUTH);
            this.pack();
            validate();
        });
        menu.add(menuItem2);
        
        JMenuItem menuItem3 = new JMenuItem("Niveau Difficile",MouseEvent.BUTTON1);
        menuItem3.addActionListener((ActionEvent e) -> {
            this.timer = 0;
            grid.removeAll();
            GameModel gm = new GameModel();
            gm.addObserver(this);
            grid.build(16, 30, 99, new Dimension(30,30), gm);
            flags.setText("99");
            add(grid,BorderLayout.SOUTH);
            this.pack();
            validate();
        });
        menu.add(menuItem3);
        flags.setVisible(true);
        time.setVisible(true);
        textt.setVisible(true);
        textf.setVisible(true);
        
        this.add(menubar,BorderLayout.NORTH);
        
        center.add(text, BorderLayout.NORTH);
        center.add(info, BorderLayout.SOUTH);
        
        this.add(center, BorderLayout.CENTER);
        
        this.add(this.grid,BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
        
    }

    @Override
    public void update(Observable o, Object arg) {
        GameModel gm = (GameModel) o;
        if(gm.getGameStatus() == 1){
            JOptionPane.showMessageDialog(this, "Bien joué ! Rejouez !");
        }
        else if(gm.getGameStatus() == 2){
            JOptionPane.showMessageDialog(this, "Partie perdue, réessayez ! ", "Défaite!", JOptionPane.ERROR_MESSAGE);
        }
        if(gm.getVal()>this.timer+1){
            gm.setRunning(false);
        }
        this.timer = gm.getVal();
        
        flags.setText(Integer.toString(gm.getNbFlagsRemaining()));
        time.setText(Integer.toString(gm.getVal()));
        
    }

   
}
