package server.util;

/**
 * This Timer is definitly not good, its just useful at one point in server, no need to make it more useful, cuz were lazy
 */
public class Timer {
    private long endTime;
    private boolean active = true;

    public Timer(int time) {
        endTime = System.currentTimeMillis()+time*1000;
        new Thread(()->{
            while(endTime > System.currentTimeMillis()&&active) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(active) {
                //Todo: handle timeout via a function, which is going to be implemented by logic
            }
        }).start();
    }

    public boolean check() {
        return endTime > System.currentTimeMillis()&&active;
    }

    public void deactivate() {
        active = false;
    }
}
