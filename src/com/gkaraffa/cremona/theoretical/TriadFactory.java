package com.gkaraffa.cremona.theoretical;

public class TriadFactory extends ChordFactory {

	public TriadFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Chord createChord(IntervalPattern intervalPattern, Tone key)
			throws IllegalArgumentException {
		if (!validateInputPattern(intervalPattern)) {
			throw new IllegalArgumentException("Not valid number of intervals.");
		}

		HarmonicTonality hTonality = evaluateTonality(intervalPattern);
		Tone[] tones = createToneArray(intervalPattern, key);
		intervalPattern.getName();

		return new Triad(intervalPattern.getName(), tones, hTonality);
	}

	private HarmonicTonality evaluateTonality(IntervalPattern intervalPattern)
			throws IllegalArgumentException {
		Interval firstInterval = intervalPattern.getInterval(0);
		Interval secondInterval = intervalPattern.getInterval(1);

		if (firstInterval == Interval.MAJOR_THIRD) {
			// perfect fifth and augmented fifth are valid
			if (secondInterval == Interval.PERFECT_FIFTH) {
				return HarmonicTonality.MAJOR;
			}
			else
				if (secondInterval == Interval.AUGMENTED_FIFTH_MINOR_SIXTH) {
					return HarmonicTonality.AUGMENTED;
				}
		}
		else
			if (firstInterval == Interval.MINOR_THIRD) {
				// perfect fifth and diminished fifth are valid
				if (secondInterval == Interval.PERFECT_FIFTH) {
					return HarmonicTonality.MINOR;
				}
				else
					if (secondInterval == Interval.AUGMENTED_FOURTH_DIMINISHED_FIFTH) {
						return HarmonicTonality.DIMINISHED;
					}
			}
			else
				if (firstInterval == Interval.PERFECT_FOURTH) {
					if (secondInterval == Interval.PERFECT_FIFTH) {
						return HarmonicTonality.SUSPENDED_FOURTH;
					}
				}

		throw new IllegalArgumentException("Not valid triad intervals.");
	}

	@Override
	protected Tone[] createToneArray(IntervalPattern intervalPattern, Tone key) {
		int toneCount = intervalPattern.size() + 1;
		Tone[] tones = new Tone[toneCount];

		tones[0] = key;
		// Tone last = key;

		for (int index = 1; index < toneCount; index++) {
			Tone cur = TonalSpectrum.traverseDistance(tones[0],
					intervalPattern.getInterval(index - 1).getSteps());

			tones[index] = cur;
		}

		return tones;
	}

	@Override
	protected boolean validateInputPattern(IntervalPattern intervalPattern) {
		// TODO Auto-generated method stub
		// must have two intervals
		int intervalCount = intervalPattern.size();
		if (intervalCount != 2) {
			return false;
		}

		return true;
	}
	
	public static IntervalPattern majorPattern = new IntervalPattern("Major", "3,5");

}
