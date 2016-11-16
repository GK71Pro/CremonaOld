package com.gkaraffa.cremona.theoretical;

public class TriadFactory extends ChordFactory {

	public TriadFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Chord createChord(IntervalPattern intervalPattern, Tone tonic)
			throws IllegalArgumentException {

		if (!validateInputPattern(intervalPattern)) {
			throw new IllegalArgumentException("Not valid number of intervals.");
		}

		Tone[] tones = intervalPatternAndTonicToToneArray(intervalPattern, tonic);
		HarmonicTonality hTonality = evaluateTonality(tones);

		return new Triad(tones[0].getText() + " " + hTonality.getText(), tones,
				hTonality);
	}

	@Override
	public Chord createChord(Harmonizable harmonizableScale, int scaleDegree)
			throws IllegalArgumentException {

		Tone[] tones = harmonizableScaleandDegreeToToneArray(harmonizableScale, scaleDegree);
		HarmonicTonality hTonality = evaluateTonality(tones);

		return new Triad(tones[0].getText() + " " + hTonality.getText(), tones,
				hTonality);
	}

	/*
	@Override
	protected HarmonicTonality getHarmonicTonality(Tone[] toneArray) {
		//determine intervals from toneArray;
		Interval[] intervalArray = new Interval[2];
		intervalArray[0] = TonalSpectrum.measureInterval(toneArray[0], toneArray[1]);
		intervalArray[1] = TonalSpectrum.measureInterval(toneArray[0], toneArray[2]);
	
		
		return null;
	}
	
	protected Interval[] scaleAndDegreeToIntervalArray(Harmonizable harmonizableScale, int scaleDegree){
		Interval[] intervalArray = new Interval[2];
		
		TonalSpectrum.measureInterval(harmonizableScale.getFirst(scaleDegree), harmonizableScale.getThird(scaleDegree));
		TonalSpectrum.measureInterval(harmonizableScale.getFirst(scaleDegree), harmonizableScale.getFifth(scaleDegree));
		
		return intervalArray;
	}
	
	
	protected HarmonicTonality agetHarmonicTonality(Harmonizable harmonizableScale, int scaleDegree){
		Interval[] intervalArray = new Interval[2];
		
		TonalSpectrum.measureInterval(harmonizableScale.getFirst(scaleDegree), harmonizableScale.getThird(scaleDegree));
		TonalSpectrum.measureInterval(harmonizableScale.getFirst(scaleDegree), harmonizableScale.getFifth(scaleDegree));
	
		return evaluateTonality(intervalArray);
	}
	
	
	protected HarmonicTonality bgetHarmonicTonality(IntervalPattern intervalPattern){
		Interval[] intervalArray = new Interval[2];
		
		intervalArray[0] = intervalPattern.getInterval(0);
		intervalArray[1] = intervalPattern.getInterval(1);
		
		return evaluateTonality(intervalArray);
	}
	*/

	private HarmonicTonality evaluateTonality(Tone[] toneArray) {
		Interval[] intervalArray = new Interval[2];
		intervalArray[0] = TonalSpectrum.measureInterval(toneArray[0],
				toneArray[1]);
		intervalArray[1] = TonalSpectrum.measureInterval(toneArray[0],
				toneArray[2]);

		if (intervalArray[0] == Interval.MAJOR_THIRD) {
			// perfect fifth and augmented fifth are valid
			if (intervalArray[1] == Interval.PERFECT_FIFTH) {
				return HarmonicTonality.MAJOR;
			}
			else
				if (intervalArray[1] == Interval.AUGMENTED_FIFTH_MINOR_SIXTH) {
					return HarmonicTonality.AUGMENTED;
				}
		}
		else
			if (intervalArray[0] == Interval.MINOR_THIRD) {
				// perfect fifth and diminished fifth are valid
				if (intervalArray[1] == Interval.PERFECT_FIFTH) {
					return HarmonicTonality.MINOR;
				}
				else
					if (intervalArray[1] == Interval.AUGMENTED_FOURTH_DIMINISHED_FIFTH) {
						return HarmonicTonality.DIMINISHED;
					}
			}
			else
				if (intervalArray[0] == Interval.PERFECT_FOURTH) {
					if (intervalArray[1] == Interval.PERFECT_FIFTH) {
						return HarmonicTonality.SUSPENDED_FOURTH;
					}
				}

		throw new IllegalArgumentException("Not valid triad intervals.");
	}

	private Tone[] intervalPatternAndTonicToToneArray(IntervalPattern intervalPattern, Tone tonic) {
		int toneCount = intervalPattern.size() + 1;
		Tone[] tones = new Tone[toneCount];

		tones[0] = tonic;

		for (int index = 1; index < toneCount; index++) {
			Tone cur = TonalSpectrum.traverseDistance(tones[0],
					intervalPattern.getInterval(index - 1).getSteps());

			tones[index] = cur;
		}

		return tones;
	}

	private Tone[] harmonizableScaleandDegreeToToneArray(Harmonizable harmonizableScale,
			int scaleDegree) {
		Tone[] toneArray = new Tone[3];

		toneArray[0] = harmonizableScale.getFirst(scaleDegree);
		toneArray[1] = harmonizableScale.getThird(scaleDegree);
		toneArray[2] = harmonizableScale.getFifth(scaleDegree);

		return toneArray;
	}

	protected boolean validateInputPattern(IntervalPattern intervalPattern) {
		int intervalCount = intervalPattern.size();

		if (intervalCount != 2) {
			return false;
		}

		return true;
	}

	public static IntervalPattern majorPattern = new IntervalPattern("Major",
			"3,5");
	public static IntervalPattern minorPattern = new IntervalPattern("Minor", "M3,5");
	public static IntervalPattern diminishedPattern = new IntervalPattern("Minor", "M3,A4/D5");
	public static IntervalPattern augmentedPattern = new IntervalPattern("Augmented", "3,A5/M6");
	public static IntervalPattern suspendedFourthPattern = new IntervalPattern("Suspended 4th", "4,5");

}
