package com.gkaraffa.cremona.workbench;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.gkaraffa.cremona.theoretical.*;

public class Main {

  public Main() {
  }

  public static void main(String[] args) {
    try {
      ChordFactory cF = new TriadFactory();
      Chord chord = cF.createChordFromIntervalPattern(ChordIntervalPattern.majorPattern, Tone.C);
      System.out.println(chord);
      System.out.println(chord.getSpellingString());

      ScaleFactory sF = new DiatonicScaleFactory();
      chord = cF.createChordFromHarmonizable(
          (Harmonizable) sF.createScale(ScalarIntervalPattern.ionianPattern, Tone.C),
          IntervalNumber.FIRST);
      System.out.println(chord);
      System.out.println(chord.getSpellingString());
      System.out.println(":" + (1 / 0));
    }
    catch (Exception e) {
      StringWriter sW = new StringWriter();
      e.printStackTrace(new PrintWriter(sW));
      System.out.println(sW);
    }
  }
}

/*
 * try { Tone[] tones = new Tone[4]; tones[0] = Tone.A; for (int i = 1; i <= 3;
 * i++) { tones[i] = TonalSpectrum.traverseInterval(tones[i - 1],
 * Interval.PERFECT_FIFTH); }
 * 
 * for (Tone tone : tones) { System.out.println(tone); }
 * 
 * System.out.println(TonalSpectrum.traverseInterval(Tone.DSHARP_EFLAT,
 * Interval.PERFECT_FIFTH));
 * System.out.println(TonalSpectrum.traverseInterval(Tone.ASHARP_BFLAT,
 * Interval.PERFECT_FOURTH));
 * System.out.println(TonalSpectrum.reverseInterval(Tone.DSHARP_EFLAT,
 * Interval.PERFECT_FOURTH)); } catch (Exception e) { e.printStackTrace(); }
 * 
 */
/*
 * try { ScaleFactory sF = new DiatonicScaleFactory(); Scale cScale =
 * sF.createScale(DiatonicScaleFactory.ionianPattern, Tone.C); Scale gScale =
 * sF.createScale(DiatonicScaleFactory.ionianPattern, Tone.G);
 * System.out.println(cScale + ", " + "a " + cScale.getScaleQuality() +
 * " scale.");
 * 
 * for (Tone t : cScale) { System.out.println(t); }
 * 
 * System.out.println();
 * 
 * if (gScale instanceof Harmonizable) { Harmonizable h = (Harmonizable) gScale;
 * ChordFactory cF = new TriadFactory();
 * 
 * for (int i = 0; i <= 6; i++){ Chord c = cF.createChord(h,
 * IntervalNumber.integerToIntervalNumber(i)); System.out.println(c + " " +
 * cScale.contains(c)); } }
 * 
 * ToneCollection tC = cScale.intersection(gScale); for(Tone tone: tC){
 * System.out.println(tone); } System.out.println(tC);
 * 
 * Guitar g = new Guitar(); System.out.println(g.displayToneSeries(new
 * DiatonicScaleFactory().createScale(DiatonicScaleFactory.ionianPattern,
 * Tone.C)));
 * 
 * Keyboard k = new Keyboard(); System.out.println(k.toCSV()); } catch
 * (Exception e) { e.printStackTrace(); }
 */
