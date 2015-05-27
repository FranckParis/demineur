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
import javax.swing.JPanel;
import mvc.model.CellModel;

/**
 *
 * @author alexisrabilloud
 */
public class Cell extends JPanel implements Observer{
    
    public final Grid grid;
    
    public Cell(Grid g) {
        super();
        this.grid = g;
        
        //System.out.println(r);
        setBackground(Color.white);
        
    }
    

    @Override
    public void update(Observable o, Object arg) {
        CellModel m = (CellModel) o;
        if(m.flag){
            setBackground(Color.red);
        }
        else{
            setBackground(Color.white);
        }
        if(m.discovered){
            setBackground(Color.GRAY);
        }
    }
}
