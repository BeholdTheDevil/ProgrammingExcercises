package Graphics;

import Datastructures.CustomLists.CustomArrayList;

import java.awt.*;
import java.util.Random;

/**
 * Created by anton on 2017-05-22.
 */
public class World {

    //Objects for world
    int[] order;
    Square[] tiles;
    Color a = new Color(200, 200, 200);
    Color b = new Color(185, 185, 185);
    int scale;
    int rowSize = 15;
    int mines;

    World(int size, int xmargin, int ymargin) {
        scale = size / rowSize;
        tiles = new Square[rowSize * rowSize];
        order = new int[]{-rowSize-1, -rowSize, -rowSize+1, -1, 1, rowSize-1, rowSize, rowSize+1};

        mines = rowSize*rowSize/7;

        for(int i = 0; i < tiles.length; i++) {
            int x = i % rowSize;
            int y = (i - x) / rowSize;
            tiles[i] = new Square(xmargin + x * scale, ymargin + y * scale, scale, i % 2 == 0 ? a : b);
        }


        CustomArrayList<Integer> available = new CustomArrayList<>();
        for(int i = 0; i < tiles.length; i++) {
            available.add(i);
        }

        Random rand = new Random();
        int r, checking;
        for(int i = 0; i < mines; i++) {
            r = rand.nextInt(available.size());
            tiles[available.get(r)].content = -1;
            for(int j = 0; j < order.length; j++) {
                int x = available.get(r) % rowSize;
                checking = available.get(r) + order[j];
                int xdist = checking % rowSize - x;
                if((xdist >= -1 && xdist <= 1) && (checking >= 0 && checking < rowSize*rowSize) && tiles[checking].content != -1) {
                    tiles[checking].content += 1;
                }
            }
            available.remove(r);
        }

    }

    public void draw(Graphics g) {
        //Draw graphics

        for(int i = 0; i < tiles.length; i++) {
            if(tiles[i] != null) tiles[i].draw(g);
        }
    }

    public void reveal(int pos) {

        //Add special case for specified number of markings around tile

        if(tiles[pos].flag == false) {
            tiles[pos].state = true;
            if(tiles[pos].content == 0) {
                for(int i = 0; i < order.length; i++) {
                    int x = pos % rowSize;
                    int checking = pos + order[i];
                    int xdist = checking % rowSize - x;
                    if((xdist >= -1 && xdist <= 1) && (checking >= 0 && checking < rowSize*rowSize) && tiles[checking].content != -1) {
                        if(tiles[checking].content == 0 && tiles[checking].state == false && tiles[checking].flag == false ) {
                            reveal(checking);
                        }
                        if(tiles[checking].content > -1 && tiles[checking].flag == false) {
                            tiles[checking].state = true;
                        }
                    }
                }
            }
        }
    }
}
