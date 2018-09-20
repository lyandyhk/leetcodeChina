package September;

import sun.applet.Main;

public class abc {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (abc.class){
                    for(int i=0;i<=99;i=i+2){
                        System.out.println(i);
                        try {
                            abc.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        abc.class.notify();

                    }

                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (abc.class){
                    for(int i=1;i<=99;i=i+2){
                        System.out.println(i);
                        abc.class.notify();
                        try {
                            abc.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                    }

                }
            }
        }).start();
    }

}
