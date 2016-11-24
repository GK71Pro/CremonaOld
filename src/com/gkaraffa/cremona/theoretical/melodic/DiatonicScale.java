package com.gkaraffa.cremona.theoretical;

public class DiatonicScale extends Scale implements Harmonizable {

	public DiatonicScale(String name, Tone[] tones, MelodicTonality tonality) {
		super(name, tones, tonality);
	}
	
	private int calculateEndPoint(int startPoint, int offset){
		if (startPoint > 6){
			startPoint -=6;
		}
		
		startPoint--;
		int endPoint = startPoint + offset;
		if (endPoint > 6){
			endPoint -= 6;
		}
		
		return endPoint;
	}

	@Override
	public Tone getFirst(int scaleDegree) {
		return getTone(scaleDegree - 1);
	}

	@Override
	public Tone getThird(int scaleDegree) {
		return getTone(calculateEndPoint(scaleDegree, 2));
	}

	@Override
	public Tone getFifth(int scaleDegree) {
		return getTone(calculateEndPoint(scaleDegree, 4));
	}

	@Override
	public Tone getSeventh(int scaleDegree) {
		return getTone(calculateEndPoint(scaleDegree, 6));
	}

	@Override
	public Tone getEleventh(int scaleDegree) {
		return getTone(calculateEndPoint(scaleDegree, 8));	
	}

	@Override
	public Tone getThirteenth(int scaleDegree) {
		return getTone(calculateEndPoint(scaleDegree, 10));	
	}

}
