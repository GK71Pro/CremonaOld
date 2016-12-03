package com.gkaraffa.cremona.theoretical;

public interface Harmonizable {
	public Tone getFirst(int scaleDegree);

	public Tone getThird(int scaleDegree);

	public Tone getFifth(int scaleDegree);

	public Tone getSeventh(int scaleDegree);

	public Tone getEleventh(int scaleDegree);

	public Tone getThirteenth(int scaleDegree);
}
