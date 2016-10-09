package com.gkaraffa.cremona.workbench;

import java.util.*;
import com.gkaraffa.cremona.theoretical.*;

public class Workbench {

	public Workbench() {
	}

	public static void main(String[] args) {
		ScaleFactory sF = new DiatonicScaleFactory();
		Scale cIonian = sF.createScale(StepPattern.ionianPattern, Tone.C);
		Collection c = cIonian.getTones();
		Iterator i = c.iterator();
		while(i.hasNext()){
			System.out.println((Tone) i.next()); 
		}
		System.out.println(cIonian.getClass().getName());
	}
}

