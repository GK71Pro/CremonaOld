package com.gkaraffa.cremona.workbench;

import com.gkaraffa.cremona.theoretical.*;

public class Main {

  public Main() {
  }

  public static void main(String[] args) {
    try {
      System.out.println(Interval.values().length);
      for (Interval interval : Interval.values()) {
        System.out.println(interval.getHalfSteps() +  ", " + interval.getIntervalNumber().getPosition());
      }

        
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  
}

