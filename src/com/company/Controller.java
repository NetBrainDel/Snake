package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 37 && Main.model.direction !=Direction.RIGHT){
            Main.model.direction = Direction.LEFT;
        }
        if(e.getKeyCode() == 38 && Main.model.direction !=Direction.DOWN){
            Main.model.direction = Direction.UP;
        }
        if(e.getKeyCode() == 39 && Main.model.direction !=Direction.LEFT){
            Main.model.direction = Direction.RIGHT;
        }
        if(e.getKeyCode() == 40 && Main.model.direction !=Direction.UP){
            Main.model.direction = Direction.DOWN;
        }
        System.out.println(e.getKeyCode());
        if(e.getKeyCode() == 65 && Main.model.direction !=Direction.RIGHT){
            Main.model.direction = Direction.LEFT;
        }
        if(e.getKeyCode() == 87 && Main.model.direction !=Direction.DOWN){
            Main.model.direction = Direction.UP;
        }
        if(e.getKeyCode() == 68 && Main.model.direction !=Direction.LEFT){
            Main.model.direction = Direction.RIGHT;
        }
        if(e.getKeyCode() == 83 && Main.model.direction !=Direction.UP){
            Main.model.direction = Direction.DOWN;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
