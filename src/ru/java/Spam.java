package ru.java;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

public class Spam extends Thread {

    private int[] latency;
    private String[] messages;

    public Spam(int[] latency, String[] messages) {
        if (latency.length != messages.length) {
            throw new IllegalArgumentException("Error");
        }
        this.latency = latency;
        this.messages = messages;
        start();
    }


    @Override
    public void run() {
        try {
            for (int i = 0; i < messages.length; i++) {
                TimeUnit.MILLISECONDS.sleep(latency[i]);
                System.out.println(messages[i]);
            }
        } catch (InterruptedException ex) {
        }
    }


    static class Listener extends Thread {

        Thread thread;

        public static final InputStream IN_DEFAULT = System.in;


        public Listener(Thread thread) {
            super();
            this.thread = thread;
            start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(1000);
                    if (System.in.available() > 0 && System.in.read() == '\n') {
                        System.setIn(IN_DEFAULT);
                        thread.interrupt();
                    }
                }
            } catch (IOException e) {
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int[] latency = { 1500, 1500, 1500, 1500, 1500, 1500 };
        String[] messages = { "First", "Second", "Third", "Fourth", "Fifth", "Sixth" };
        Thread spam = new Spam(latency, messages);
        Thread listener = new Listener(spam);
        Part2 p = new Part2();
        p.main();
    }

}