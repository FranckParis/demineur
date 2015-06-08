/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

/**
 *
 * @author Francky
 */
public class GameModel {
    
    //Attributs
    private int gameStatus = 0;  //0 : partie en cours  1: partie gagnée  2: partie perdue
    
    
    //Méthodes
    public int getGameStatus(){
        return this.gameStatus;
    }
    
    public void setGameStatus(int gs){
        this.gameStatus = gs;
        this.checkGameStatus();
    }

    public void checkGameStatus() {
        if(this.gameStatus == 1){
            System.out.println("Partie gagnée !");
        }
        else if(this.gameStatus == 2){
            System.out.println("Partie perdue ! ");
        }
    }
}
