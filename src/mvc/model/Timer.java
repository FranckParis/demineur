/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francky
 */
public class Timer extends Thread {
    
    //Attributs
    private boolean running = true;
    private GameModel gm;
    
    //Constructeurs
    public Timer (GameModel gm){
        this.gm = gm;
    }
    
    //Méthodes
    public void run(){
        while(running){
            try {
                sleep(1000);
                gm.updateTime();
            } catch (InterruptedException ex) {
                Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setRunning(boolean b) {
        this.running = b;
    }
}
