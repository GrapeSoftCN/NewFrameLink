

import common.java.httpServer.booter;
import common.java.nlogger.nlogger;

public class TestAd {
    public static void main(String[] args) {
        booter booter = new booter();
        try {
            System.out.println("flink");
            System.setProperty("AppName", "flink");
            booter.start(1008);
        } catch (Exception e) {
            nlogger.logout(e);
        }
    }
}
