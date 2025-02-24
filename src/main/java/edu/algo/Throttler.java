//package edu.algo;
//
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class Throttler {
//
//  private final int maxNumMessages;
//  private final int windowSize;
//  private final Queue<Long> timestamps;
//
//  public Throttler(int maxNumMessages, int windowSize) {
//    this.maxNumMessages = maxNumMessages;
//    this.windowSize = windowSize;
//    this.timestamps = new LinkedList<>();
//  }
//
//  public boolean canSend(long time) {
//    long delta = time - windowSize;
//
//    if (!timestamps.isEmpty() && timestamps.peek())
//
//    return timestamps.size() < maxNumMessages;
//  }
//
//  public void send() {
//    long time = System.currentTimeMillis() / 100;
//
//    if (canSend(time)) {
//      timestamps.add(time);
//      System.out.println("Message #");
//    } else {
//      System.out.println("Message ignored");
//    }
//  }
//
//  public static void main(final String[] args) throws Exception {
//    Throttler throttler = new Throttler(100, 120);
//
//    for (int i = 0; i < 100; i++) {
//      throttler.send();
//      Thread.sleep(1000);
//    }
//  }
//}
