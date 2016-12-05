package com.gkaraffa.cremona.theoretical;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class TriadFactory extends ChordFactory {

	public TriadFactory() {
	}

	@Override
	public Chord createChord(IntervalPattern intervalPattern, Tone tonic)
			throws IllegalArgumentException {

		if (!validateIntervalPattern(intervalPattern)) {
			throw new IllegalArgumentException("Not valid number of intervals.");
		}

		Tone[] tones = intervalPatternAndTonicToToneArray(intervalPattern, tonic);
		HarmonicProfile harmonicProfile = evaluateProfile(tones);

		return new Triad(
				tones[0].getText() + " "
						+ harmonicProfile.chordQuality.getText(),
				tones, harmonicProfile.chordQuality, harmonicProfile.intervalNumberSet);

	}

	@Override
	public Chord createChord(Harmonizable harmonizableScale, int scaleDegree)
			throws IllegalArgumentException {

		Tone[] tones = harmonizableScaleAndDegreeToToneArray(harmonizableScale,
				scaleDegree);
		HarmonicProfile harmonicProfile = evaluateProfile(tones);

		return new Triad(
				tones[0].getText() + " "
						+ harmonicProfile.chordQuality.getText(),
				tones, harmonicProfile.chordQuality, harmonicProfile.intervalNumberSet);
	}

	private HarmonicProfile evaluateProfile(Tone[] toneArray) {
		HarmonicProfile harmonicProfile = new HarmonicProfile();
		HashSet<IntervalNumber> intervalNumber = new LinkedHashSet<IntervalNumber>();

		Interval[] intervalArray = new Interval[2];

		intervalArray[0] = 
				Interval.halfStepsAndIntervalNumberToInterval(
						TonalSpectrum.measureDistance(toneArray[0], toneArray[1]), 
						IntervalNumber.THIRD);
		
		if (intervalArray[0] == null){
			intervalArray[0] = 
					Interval.halfStepsAndIntervalNumberToInterval(
							TonalSpectrum.measureDistance(toneArray[0], toneArray[1]), 
							IntervalNumber.FOURTH);
		}
		
		intervalArray[1] = 
				Interval.halfStepsAndIntervalNumberToInterval(
						TonalSpectrum.measureDistance(toneArray[0], toneArray[2]), 
						IntervalNumber.FIFTH);
		
		if (intervalArray[0] == Interval.MAJOR_THIRD) {
			intervalNumber.add(IntervalNumber.THIRD);
			if (intervalArray[1] == Interval.PERFECT_FIFTH) {
				intervalNumber.add(IntervalNumber.FIFTH);
				harmonicProfile.chordQuality = ChordQuality.MAJOR;
				harmonicProfile.intervalNumberSet = intervalNumber;
				return harmonicProfile;
			}
			else
				if (intervalArray[1] == Interval.AUGMENTED_FIFTH) {
					intervalNumber.add(IntervalNumber.FIFTH);
					harmonicProfile.chordQuality = ChordQuality.AUGMENTED;
					harmonicProfile.intervalNumberSet = intervalNumber;
					return harmonicProfile;
				}
		}
		else
			if (intervalArray[0] == Interval.MINOR_THIRD) {
				intervalNumber.add(IntervalNumber.THIRD);
				if (intervalArray[1] == Interval.PERFECT_FIFTH) {
					intervalNumber.add(IntervalNumber.FIFTH);
					harmonicProfile.chordQuality = ChordQuality.MINOR;
					harmonicProfile.intervalNumberSet = intervalNumber;
					return harmonicProfile;
				}
				else
					if (intervalArray[1] == Interval.DIMINISHED_FIFTH) {
						intervalNumber.add(IntervalNumber.FIFTH);
						harmonicProfile.chordQuality = ChordQuality.DIMINISHED;
						harmonicProfile.intervalNumberSet = intervalNumber;
						return harmonicProfile;
					}
			}
			else
				if (intervalArray[0] == Interval.PERFECT_FOURTH) {
					intervalNumber.add(IntervalNumber.FOURTH);
					if (intervalArray[1] == Interval.PERFECT_FIFTH) {
						intervalNumber.add(IntervalNumber.FIFTH);
						harmonicProfile.chordQuality = ChordQuality.SUSPENDED_FOURTH;
						harmonicProfile.intervalNumberSet = intervalNumber;
						return harmonicProfile;
					}
				}

		throw new IllegalArgumentException("Not valid triad intervals.");
	}

	private Tone[] intervalPatternAndTonicToToneArray(
			IntervalPattern intervalPattern, Tone tonic) {
		int toneCount = intervalPattern.getSize() + 1;
		Tone[] tones = new Tone[toneCount];

		tones[0] = tonic;

		for (int index = 1; index < toneCount; index++) {
			Tone cur = TonalSpectrum.traverseDistance(tones[0],
					intervalPattern.getInterval(index - 1).getHalfSteps());

			tones[index] = cur;
		}

		return tones;
	}

	private Tone[] harmonizableScaleAndDegreeToToneArray(
			Harmonizable harmonizableScale, int scaleDegree) {
		Tone[] toneArray = new Tone[3];

		toneArray[0] = harmonizableScale.getFirst(scaleDegree);
		toneArray[1] = harmonizableScale.getThird(scaleDegree);
		toneArray[2] = harmonizableScale.getFifth(scaleDegree);
		
		return toneArray;
	}

	private boolean validateIntervalPattern(IntervalPattern intervalPattern) {
		int intervalCount = intervalPattern.getSize();

		if (intervalCount != 2) {
			return false;
		}

		return true;
	}

	class HarmonicProfile {
		ChordQuality chordQuality = null;
		HashSet<IntervalNumber> intervalNumberSet = null;
	}

	public static IntervalPattern majorPattern = new IntervalPattern("Major",
			"M3,P5");
	public static IntervalPattern minorPattern = new IntervalPattern("Minor",
			"m3,P5");
	public static IntervalPattern diminishedPattern = new IntervalPattern(
			"Minor", "m3,d5");
	public static IntervalPattern augmentedPattern = new IntervalPattern(
			"Augmented", "M3,A5");
	public static IntervalPattern suspendedFourthPattern = new IntervalPattern(
			"Suspended 4th", "P4,P5");

}
