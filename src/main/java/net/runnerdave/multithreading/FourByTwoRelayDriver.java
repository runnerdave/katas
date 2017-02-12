package net.runnerdave.multithreading;

import java.util.concurrent.CountDownLatch;

/**
 * Created by runnerdave on 11/02/17.
 */
public class FourByTwoRelayDriver {
    public static void main(String[] args){
        Thread[] grp1 = new Thread[2];
        Thread[] grp2 = new Thread[2];
        CountDownLatch c1 = new CountDownLatch(1);
        CountDownLatch c2 = new CountDownLatch(1);

        grp1[0]=new Thread(new Player1(c1, "grp1:player1"));
        grp1[1]=new Thread(new Player2(c2, "grp1:player2"));


        grp2[0]=new Thread(new Player1(c2, "grp2:player1"));
        grp2[1]=new Thread(new Player2(c2, "grp2:player2"));

        grp1[0].start();
        grp2[0].start();
        grp1[1].start();
        grp2[1].start();
    }
}

class Player1 implements Runnable{
    private final CountDownLatch countDownLatch;
    private final String s;
    public Player1(CountDownLatch c, String s){
        this.countDownLatch=c;
        this.s=s;
    }
    @Override
    public void run() {
        for(int i=0;i<200;i++){
            if (i%50==0) {
                System.out.println(s + ":" + i);
            }
        }
        countDownLatch.countDown();
    }

}


class Player2 implements Runnable{
    private final CountDownLatch countDownLatch;
    private final String s;
    public Player2(CountDownLatch c, String s){
        this.countDownLatch = c;
        this.s=s;
    }
    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        for(int i=0;i<200;i++){
            if (i%50==0) {
                System.out.println(s+":"+i);
            }
        }
    }
}
