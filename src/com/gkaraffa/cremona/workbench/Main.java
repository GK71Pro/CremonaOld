package com.gkaraffa.cremona.workbench;

import java.util.ArrayList;

import com.gkaraffa.cremona.theoretical.*;

public class Main {

  public Main() {}

  public static void main(String[] args) {
    try {
      for (int halfSteps = 0; halfSteps <= 24; halfSteps++) {
        System.out.println(halfSteps + " half steps.");
        ArrayList<Interval> intervalList = Interval.halfStepsToIntervalList(halfSteps);
        for (Interval currentInterval : intervalList) {
          System.out.println("\t" + currentInterval.getText());
        }
      }

    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

}

