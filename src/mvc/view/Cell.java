/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mvc.model.CellModel;

/**
 *
 * @author alexisrabilloud
 */
public class Cell extends JPanel implements Observer{
    
    public final Grid grid;
    public JLabel label;
    
    public Cell(Grid g, Dimension d) {
        super();
        this.grid = g;
        this.label = new JLabel();
        this.add(this.label);
        
        this.setPreferredSize(d);
        
        //System.out.println(r);
        setBackground(Color.GRAY);
        
    }
    

    @Override
    public void update(Observable o, Object arg) {
        CellModel m = (CellModel) o;
        if(m.getFlagged() && !m.getDiscovered()){
            this.setBackground(Color.white);
            this.label.setIcon(new ImageIcon(this.getClass().getResource("/mvc/resources/flag.png")));
        }
        
        else if (m.getDiscovered() && !m.getTrapped()){
            if(m.getNbNeighMines() != 0){
                String s = Integer.toString(m.getNbNeighMines());
                this.label.setText(s);
                this.label.setVisible(true);
            }
            setBackground(Color.LIGHT_GRAY);
            this.label.setIcon(new ImageIcon());
        }
        else if (m.getDiscovered() && m.getTrapped()){
            this.setBackground(Color.red);
            this.label.setIcon(new ImageIcon(this.getClass().getResource("/mvc/resources/bomb.png")));
        }
        else {
            setBackground(Color.GRAY);
            this.label.setIcon(new ImageIcon());
        }
    }
}
