package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class View extends JFrame implements Runnable {
        Model model;
        Controller controller = Main.controller;

    public View(){
        setSize(800,800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(Main.controller);
        setVisible(true);
    }
    @Override
    public void paint(Graphics g){
        model = Main.model;
        if(model==null)
            return;
        double w = getWidth();
        double h = getHeight();
        double cellW = w/model.n;
        double cellH = h/ model.n;
        GameObject[][] map = model.getMap();
        BufferedImage image = new BufferedImage(getWidth(),
                getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j <map[i].length ; j++) {
                for (int x = 0; x < cellW; x++) {
                    for (int y = 0; y < cellH; y++) {
                        image.setRGB((int)(j*cellW+x), (int)(i*cellH+y),
                                map[i][j].getColor().getRGB());
                    }
                }
            }
        }
        g.drawImage(image,0,0, null);
    }

    @Override
    public void run() {
        while (true){
            repaint();
            try {
                Thread.sleep(1000/30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
