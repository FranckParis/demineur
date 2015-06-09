/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import java.util.Observable;

/**
 *
 * @author Francky
 */
public class GameModel extends Observable {
    
    //Attributs
    private int gameStatus = 0;  //0 : partie en cours  1: partie gagnée  2: partie perdue
    private GridModel grid;
    private int nbFlagsRemaining;
    private int timeVal = 0;
    private Timer timer;
    
    
    //Méthodes
    public int getGameStatus(){
        return this.gameStatus;
    }
    
    public void setGameStatus(int gs){
        this.gameStatus = gs;
        timer.setRunning(false);
        this.checkGameStatus();
    }
    
    public GridModel getGridModel(){
        return this.grid;
    }
    
    public void setGridModel(GridModel g){
        this.grid = g;
    }
    
    public int getNbFlagsRemaining(){
        return this.nbFlagsRemaining;
    }
    
    public void setNbFlagsRemaining(int f){
        this.nbFlagsRemaining = f;
    }

    public void checkGameStatus() {
        grid.discoverAll();
        notifyObservers();
    }
    
    @Override
    public void notifyObservers(){
        this.setChanged();
        super.notifyObservers();
    }

    public void updateNbFlagsRemaining(int nbFlagsRemaining) {
        this.nbFlagsRemaining = nbFlagsRemaining;
        notifyObservers();
    }

    public void updateTime() {
        timeVal++;
        notifyObservers();
    }

    public void setTimer(Timer timer) {
        this.timer = timer;    
    }

    public int getVal() {
        return this.timeVal;
    }
}
