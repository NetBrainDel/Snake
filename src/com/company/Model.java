package com.company;

import java.util.ArrayList;

public class Model extends Thread{
        int n;
        Point head;
        ArrayList<Point> tail = new ArrayList<>();
        Direction direction;
        Point food;
        Point p_in = new Point(10, 10);
        Point p_out = new Point(40,40);
        double speed = 10;

        public Model(int n){
            this.n = n;
            head = new Point(n/2,n/2);
            for (int i = 1; i <=3 ; i++) {
                tail.add(new Point(n/2+i,n/2));
                direction = Direction.LEFT;
                generateFood();
            }
        }
        void refresh(){
            head = new Point(n/2,n/2);
            tail.clear();
            for (int i = 1; i <=3 ; i++) {
                tail.add(new Point(n/2+i,n/2));
                direction = Direction.LEFT;
                generateFood();
            }
        }
        private void generateFood(){
            do {
             int x = (int)(Math.random()*n);
             int y = (int)(Math.random()*n);
             food = new Point(x,y);
            }while (isPointInTail(food) || food.equals(head));

        }
        private boolean isPointInTail(Point p){
            for(Point point: tail){
                if (p.equals(point))
                    return true;
            }
            return false;
        }

        public GameObject[][] getMap(){
            GameObject[][] map = new GameObject[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    map[i][j] = GameObject.EMPTY;
                }
                map[food.y][food.x] = GameObject.FOOD;
                map[head.y][head.x] = GameObject.HEAD;
                map[p_in.y][p_in.x] = GameObject.PORTAL;
                map[p_out.y][p_out.x] = GameObject.PORTAL;
                for (Point p: tail)
                    map[p.y][p.x] = GameObject.TAIL;

            return map;
        }
        public void tick(){
            tail.add(0,new Point(head.x,head.y)) ;
            head.add(direction.dir);
            head.x = (head.x+n)%n;
            head.y = (head.y+n)%n;
            if(head.equals(food)){
                generateFood();
            }
            else {
                tail.remove(tail.size()-1);

                if(head.equals(p_in)){
                    head.x = p_out.x;
                    head.y = p_out.y;
                }else
                if(head.equals(p_out)){
                    head.x = p_in.x;
                    head.y = p_in.y;
                }
            }
            if (isPointInTail(head))
                refresh();


        }
        @Override
    public void run(){
            while (true){
                tick();
                speed *= 1.0001;
                try {
                    Thread.sleep((int)(1000/speed));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
}

class Point{
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }
    public void add(Point p){
        x += p.x;
        y += p.y;
    }

}
enum Direction{
    LEFT(-1,0),
    UP(0,-1),
    RIGHT(1,0),
    DOWN(0,1);
    Point dir;
    private Direction(int x, int y){
        dir = new Point(x,y);
    }

}