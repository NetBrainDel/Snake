package com.company;

public class Main {

    static Controller controller = new Controller();
    static View view = new View();
    static Model model = new Model(50);

    public static void main(String[] args) {
        Thread thread = new Thread(view);
        thread.start();
        model.start();
    }
}
