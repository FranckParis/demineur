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
    private GameModel gm;
    
    public CellModel (GridModel g, GameModel gm){
        this.flagged = false;
        this.discovered = false;
        this.grid = g;
        this.trapped = false;
        this.gm = gm;
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
        
        if(!this.discovered){
            if(flagged){
                this.flagged = !this.flagged;
                this.grid.updateNbFlagsRemaining(flagged);
            }
            else if(!flagged && grid.getNbFlagsRemaining()>0){
                this.flagged = !this.flagged;
                this.grid.updateNbFlagsRemaining(flagged);
                this.grid.checkWin();
            }
                   
            notifyObservers();
        }
        
    }
    
    public void discover(){
        if(!flagged){
            this.discovered = true;
            if(trapped){
                this.grid.discoverAll();
                this.gm.setGameStatus(2);
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

    public void discoverCell(){
        this.discovered = true;
        notifyObservers();
    }
    
}
