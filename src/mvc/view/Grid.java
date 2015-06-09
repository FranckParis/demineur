/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.Border;
import mvc.model.CellModel;
import mvc.model.GameModel;
import mvc.model.GridModel;
import mvc.model.Timer;

/**
 *
 * @author alexisrabilloud
 */
public class Grid extends JPanel {

    public int row;
    public int col;
    
    public Grid(int r, int c, int n, Dimension d, GameModel gm) {
        super();
        build(r, c, n, d, gm);
    }
    
    public void build(int r, int c, int n, Dimension d, GameModel gm)
    {        
        
        JComponent pan = new JPanel (new GridLayout(r,c));
        Border blackline = BorderFactory.createLineBorder(Color.black,1);
        GridModel gridmodel = new GridModel(r, c, n, gm);
        gm.setGridModel(gridmodel);
        System.out.println(gridmodel.getNbMines());
        gm.setNbFlagsRemaining(gridmodel.getNbMines());
        Timer timer = new Timer(gm);
        gm.setTimer(timer);
        
        for(int i = 0; i<r;i++){
            for(int j = 0; j<c; j++){
                Cell cell = new Cell(this,d);
                CellModel m = new CellModel(gridmodel, gm);
                
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
        timer.start();
    }
    
}
