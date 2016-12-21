package com.gkaraffa.cremona.theoretical;

public interface Harmonizable {
	public Tone getToneAtRelativeInterval(IntervalNumber rootInterval,
			IntervalNumber offsetInterval);
}
