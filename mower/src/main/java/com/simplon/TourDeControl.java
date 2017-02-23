package com.simplon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alonso on 18/02/17.
 */
public class TourDeControl {
    private List<Mower> mowers = new ArrayList<>();
    private File instructions;

    public TourDeControl(String instructions) {
        this.instructions = new File(instructions);
    }

    public boolean start(){
        String line;
        Position position = null;
        String sequence;
        Point max = new Point(0,0);

        try {
            BufferedReader fichier = new BufferedReader(new FileReader(instructions));
            int i = 0;
            while ((line = fichier.readLine()) != null) {
                if (i == 0 ) {
                    if (line.length() < 3) {

                        max = new Point(Integer.parseInt(line.substring(0, 1)), Integer.parseInt(line.substring(1, 2)));
                        i++;
                    } else {
                        System.out.println("erreur sur les dimensions de la surface");
                        return false;
                    }
              

                } else if (i%2 != 0) { // on traite la position initiale
                        int x = Integer.parseInt(line.substring(0,1));
                        int y = Integer.parseInt(line.substring(1,2));

                        if (x + y >= 0 &&  x<= max.getX() && y<=max.getY()) {
                            String cardinal = extractCardinal(line);
                            if (cardinal !=null) {
                                position = new Position(new Point(x,y), cardinal);
                                i++;
                            }
                        }else{
                            System.out.println("erreur sur le positionnement initial du mower "+((i+1)/2));
                            fichier.readLine();
                            i = i+2;
                        }
                    } else {
                        sequence = line;
                        this.mowers.add(new Mower(position, sequence, max));
                        i++;
                    }
                }

            fichier.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
         mowersInAction();
         return true;

    }

    private String extractCardinal(String line) {
        String cardinal = line.substring(2);
        try {
            Compass.valueOf(cardinal).name();
            return cardinal;
        }catch (IllegalArgumentException e){
            System.out.println("Erreur dans le cardinal");
            return null;
        }
    }

    public void mowersInAction(){
        for (Mower m : mowers){
            System.out.println(m.readSequence());
        }
    }

    public static void main( String[] args )
    {
        TourDeControl tDC = new TourDeControl("./src/main/java/com/simplon/mowers.txt");
        tDC.start();

    }
}
