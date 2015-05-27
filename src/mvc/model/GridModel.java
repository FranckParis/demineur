/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import java.awt.Point;
import java.util.HashMap;

/**
 *
 * @author Francky
 */
public class GridModel {
    
    //Attributs
    private HashMap<CellModel, Point> map;
    
    //Constructeur
    public GridModel(){
        this.map = new HashMap<>();
    }
    
    //Méthodes
    public void addCell(CellModel cell, int x, int y){
        map.put(cell, new Point(x, y));
    }
}
