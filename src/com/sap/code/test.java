package com.sap.code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class test {
  static volatile boolean isDone = false;
  public static void main(String[] args) {

    AtomicLong sum = new AtomicLong(0);
    AtomicInteger countRow = new AtomicInteger(0);
    final long totalRows = 1000000;
    LinkedBlockingDeque<Number> que = new LinkedBlockingDeque();

    new Thread(
        new Runnable() {
          @Override
          public void run() {
            File file = new File("C:\\\\random.txt");
            BufferedReader reader = null;
            try {
              int row = 0;
              reader = new BufferedReader(new FileReader(file));
              String tempString;
              int index = 0;
              while ((tempString = reader.readLine()) != null) {
                index = row % 5;
                Number temp = new Number(index, Integer.valueOf(tempString));
                que.addLast(temp);
                row++;
              }
              reader.close();
            } catch (Exception e) {
              e.printStackTrace();
            } finally {
              if (reader != null) {
                try {
                  reader.close();
                } catch (IOException e1) {
                }
              }
            }
          }
        }
    ).start();
    for (int i = 0; i < 5; i++) {
      new Thread(new Runnable() {
        @Override
        public void run() {
          String name = Thread.currentThread().getName();
          Number tempNumber = null;
          while (!isDone) {
            tempNumber = que.peekFirst();
            if (tempNumber != null && name.equals(String.valueOf(tempNumber.indexNumber))) {
              tempNumber = que.pollFirst();
              sum.addAndGet(tempNumber.rowValue);
              if (countRow.incrementAndGet() == totalRows) {
                isDone=true;
              }
            }
          }
        }
      }, String.valueOf(i)).start();
    }
    while (true) {
      if (isDone) {
        System.out.println("Sum: " + sum.get());
        DecimalFormat df=new DecimalFormat("0.00");
        System.out.println("avg:"+df.format((float)sum.get()/totalRows));
        break;
      } else {
        try {
          System.out.println("continue");
          Thread.sleep(1000);
        } catch (Exception e) {
          e.printStackTrace();
        }

      }
    }
  }

  static class Number {
    public int indexNumber;
    public int rowValue;

    public Number(int indexNumber,int rowValue) {
      this.indexNumber=indexNumber;
      this.rowValue=rowValue;
    }

    @Override
    public String toString() {
      return String.valueOf(indexNumber)+ ":"+String.valueOf(rowValue);
    }
  }
}