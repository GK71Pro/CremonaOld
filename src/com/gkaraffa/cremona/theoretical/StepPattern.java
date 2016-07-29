package com.gkaraffa.cremona.theoretical;

import java.util.*;

public class StepPattern {
	private List<StepUnit> list = new ArrayList<StepUnit>();

	public StepPattern(){
	}
	
	public StepPattern(StepUnit[] units){
		this.list.addAll(Arrays.asList(units));
	}
	
	public void insertStepUnit(int location, StepUnit unit){
		list.add(location, unit);
	}
	
	public void appendStepUnit(StepUnit unit){
		list.add(unit);
	}
	
	public StepUnit getStepUnit(int location){
		return list.get(location);
	}
	

	public static StepPattern ionianPattern = new StepPattern(
			new StepUnit[]{StepUnit.WHOLE_STEP,
					StepUnit.WHOLE_STEP,
					StepUnit.HALF_STEP,
					StepUnit.WHOLE_STEP,
					StepUnit.WHOLE_STEP,
					StepUnit.WHOLE_STEP,
					StepUnit.HALF_STEP}
			);
}
