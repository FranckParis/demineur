/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
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
    
    public Cell(Grid g) {
        super();
        this.grid = g;
        this.label = new JLabel();
        this.add(this.label);
        
        //System.out.println(r);
        setBackground(Color.white);
        
    }
    

    @Override
    public void update(Observable o, Object arg) {
        CellModel m = (CellModel) o;
        if(m.getFlagged()){
            setBackground(Color.red);
        }
        
        else if (m.getDiscovered() && !m.getTrapped()){
            if(m.getNbNeighMines() != 0){
                String s = Integer.toString(m.getNbNeighMines());
                this.label.setText(s);
                this.label.setVisible(true);
            }
            setBackground(Color.GRAY);
        }
        else if (m.getDiscovered() && m.getTrapped()){
            setBackground(Color.ORANGE);
        }
        else {
            setBackground(Color.white);
        }
    }
}
