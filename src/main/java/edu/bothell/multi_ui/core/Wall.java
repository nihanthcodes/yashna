package edu.bothell.multi_ui.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Wall extends Thing {
    public Wall(){super(2);}

    public static void build(Location l, Random die){
        if(l.getTerrain() == null)  return;

        ArrayList<Directions> edges = new ArrayList<>(Arrays.asList(Directions.values()));
        ArrayList<Directions> openings = new ArrayList<>();
        for(Directions d : edges) if(!l.hasWall(d)) openings.add(d);
        
        //Add minimum walls
        int min = (l.getTerrain() != null)? l.getTerrain().getWallsMin() : 3;
        for(int i = 0; i < min - l.getWallCount(); i++ ){
            int roll = die.nextInt(openings.size());
            l.addWall( openings.get(roll) );
            openings.remove(roll);
        }

        //Roll for maximum walls
        int range = (int) Math.pow(2, openings.size() );
        int roll = die.nextInt(range);
        
        for(int i = 0; i < openings.size(); i++){
            if ((roll & (1 << i)) != 0) l.addWall(openings.get(i));
        }
        
    }

    @Override
    public String toString(){
        return "#";
    }
}
