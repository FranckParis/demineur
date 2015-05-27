/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import java.util.Observable;

/**
 *
 * @author alexisrabilloud
 */
public class CellModel extends Observable {
    
    public boolean flag;
    public boolean discovered;
    public GridModel grid;
    
    public CellModel (GridModel g){
        this.flag = false;
        this.discovered = false;
        this.grid = g;
    }
    
    @Override
    public void notifyObservers(){
        this.setChanged();
        super.notifyObservers();
    }

    public void toggleFlag() {
        this.flag = !this.flag;
        notifyObservers();
    }
    
    public void discover(){
        this.discovered = true;
        notifyObservers();
    }
}
