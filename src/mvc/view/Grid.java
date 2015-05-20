/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import mvc.model.CellModel;

/**
 *
 * @author alexisrabilloud
 */
public class Grid extends JFrame {

    public JTextField jt;
    public int row;
    public int col;
    
    public Grid(int r, int c) {
        super();
        
        build(r, c);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                super.windowClosing(arg0);
                System.exit(0);
            }
        });
    }
    
    public void build(int r, int c)
    {
        setTitle("Démineur");
        setSize(500, 500);
        JComponent pan = new JPanel (new GridLayout(r,c));
        Border blackline = BorderFactory.createLineBorder(Color.black,1);

        for(int i = 0; i<r;i++){
            for(int j = 0; j<c; j++){
                Cell cell = new Cell(i,j, this);
                CellModel m = new CellModel(i, j);
                
                cell.setBorder(blackline);
                pan.add(cell);
                m.addObserver(cell);
                
                cell.addMouseListener(new MouseAdapter() {
        
                    @Override
                    public void mouseClicked(MouseEvent arg0) {
                        super.mouseClicked(arg0);
                        //cell.setBackground(Color.BLACK);
                        m.toggleFlag();
                    }
            
                });
            }
            
        }
        pan.setBorder(blackline);
        add(pan);
    }
    
}
