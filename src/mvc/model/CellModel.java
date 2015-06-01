/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author alexisrabilloud
 */
public class CellModel extends Observable {
    
    private boolean flagged;
    private boolean discovered;
    private GridModel grid;
    private boolean trapped;
    private int nbNeighMines;
    
    public CellModel (GridModel g){
        this.flagged = false;
        this.discovered = false;
        this.grid = g;
        this.trapped = false;
    }
    
    public boolean getTrapped(){
        return this.trapped;
    }
    
    public void setTrapped(boolean t){
        this.trapped = t;
    }
    
    public boolean getFlagged(){
        return this.flagged;
    }
    
    public void setFlagged(boolean f){
        this.flagged = f;
    }
    
    public int getNbNeighMines() {
        return this.nbNeighMines;
    }
    
    public void setNbNeighMines(int n){
        this.nbNeighMines = n;
    }
    
    public boolean getDiscovered(){
        return this.discovered;
    }
    
    public void setDiscovered(boolean d){
        this.discovered = d;
    }
    
    @Override
    public void notifyObservers(){
        this.setChanged();
        super.notifyObservers();
    }

    public void toggleFlag() {
        this.flagged = !this.flagged;
        notifyObservers();
    }
    
    public void discover(){
        this.discovered = true;
        
        if(trapped){
            System.out.println("Case piegée");
        }
        
        else if (nbNeighMines == 0){
            ArrayList<CellModel> neighbours = this.grid.findNeighbours(this);
            for(CellModel c : neighbours){
                if(!c.trapped && !c.discovered){
                    c.discover();
                }
            }
        }
        
        notifyObservers();
    }

    
    
}
