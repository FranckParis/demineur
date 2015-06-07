/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.Border;
import mvc.model.CellModel;
import mvc.model.GridModel;

/**
 *
 * @author alexisrabilloud
 */
public class Grid extends JPanel {

    public int row;
    public int col;
    
    public Grid(int r, int c, int n) {
        super();
        build(r, c, n);
    }
    
    public void build(int r, int c, int n)
    {        
        
        JComponent pan = new JPanel (new GridLayout(r,c));
        Border blackline = BorderFactory.createLineBorder(Color.black,1);
        
        GridModel gridmodel = new GridModel(r, c, n);
        for(int i = 0; i<r;i++){
            for(int j = 0; j<c; j++){
                Cell cell = new Cell(this);
                CellModel m = new CellModel(gridmodel);
                
                gridmodel.addCell(m, i, j);
                
                cell.setBorder(blackline);
                pan.add(cell);
                m.addObserver(cell);
                
                cell.addMouseListener(new MouseAdapter() {
        
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(e.getButton()==MouseEvent.BUTTON3){
                             m.toggleFlag();
                        }
                        if(e.getButton()==MouseEvent.BUTTON1){
                            m.discover();
                        }
                    }
            
                });
            }
            
        }
        pan.setBorder(blackline);
        add(pan);
        gridmodel.setMines();
        gridmodel.findMines();
    }
    
}
