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
    
    public int row;
    public int col;
    public boolean flag;
    
    public CellModel (int r, int c){
        this.row = r;
        this.col = c;
        this.flag = false;
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
}
