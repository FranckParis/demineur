/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Francky
 */
public class GridModel {
    
    //Attributs
    private HashMap<CellModel, Point> map;
    private int nbMines;
    private int row;
    private int column;
    private GameModel gm;
    
    //Constructeur
    public GridModel(int r, int c, int n, GameModel gm){
        this.map = new HashMap<>();
        this.row = r;
        this.column = c;
        this.nbMines = n;
        this.gm = gm;
    }
    
    //Méthodes
    public void addCell(CellModel cell, int x, int y){
        map.put(cell, new Point(x, y));
    }
    
    public ArrayList<CellModel> findNeighbours(CellModel c){
       ArrayList<CellModel> res = new ArrayList();
       Point source = this.map.get(c);
       for(int i= source.x -1; i<=source.x+1; i++){
           for(int j = source.y-1; j<=source.y+1; j++){
               if(i != source.x || j!= source.y){
                   CellModel cellTemp = findCell(i, j);
                   if(cellTemp != null){
                       res.add(cellTemp);
                   }
               }
           }
       }
       return res;
    }
    
    public void findMines (){
        for(Map.Entry<CellModel, Point> entry : map.entrySet()){
            ArrayList<CellModel> temp = this.findNeighbours(entry.getKey());
            int compt =0;
            for(CellModel c : temp){
                if(c.getTrapped()){
                    compt++;
                }
            }
            entry.getKey().setNbNeighMines(compt);
        }
    }
    
    public CellModel findCell(int i, int j){
        for(Map.Entry<CellModel, Point> entry : map.entrySet()){
            if(entry.getValue().x == i && entry.getValue().y == j){
                return entry.getKey();
            }
        }
        return null;
    }
    
    public void setMines(){
        int i = 0;
        while(i<nbMines){
            Random r = new Random();
            int coordx = r.nextInt(this.column);
            int coordy = r.nextInt(this.row);
            CellModel c = findCell(coordx, coordy);
            if(!c.getTrapped()){
                c.setTrapped(true);
                i++;
            }
        }
    }
    
    public void checkWin(){
        int compt = 0;
        for(Map.Entry<CellModel, Point> entry : map.entrySet()){
            if(entry.getKey().getTrapped() && entry.getKey().getFlagged()){
                compt++;
            }
        }
        if (compt == this.nbMines){
           this.gm.setGameStatus(1);
        }
    }

    void discoverAll() {
        for(Map.Entry<CellModel, Point> entry : map.entrySet()){
            entry.getKey().discoverCell();
        }
    }
}
