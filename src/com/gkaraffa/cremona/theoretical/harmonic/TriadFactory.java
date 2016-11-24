package com.gkaraffa.cremona.theoretical.harmonic;

import java.util.HashSet;
import java.util.LinkedHashSet;

import com.gkaraffa.cremona.theoretical.Harmonizable;
import com.gkaraffa.cremona.theoretical.Interval;
import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.TonalSpectrum;
import com.gkaraffa.cremona.theoretical.Tone;

public class TriadFactory extends ChordFactory {

	public TriadFactory() {
	}

	@Override
	public Chord createChord(IntervalPattern intervalPattern, Tone tonic)
			throws IllegalArgumentException {

		if (!validateInputPattern(intervalPattern)) {
			throw new IllegalArgumentException("Not valid number of intervals.");
		}

		Tone[] tones = intervalPatternAndTonicToToneArray(intervalPattern, tonic);
		/*
		HarmonicTonality hTonality = evaluateTonality(tones);
		
		return new Triad(tones[0].getText() + " " + hTonality.getText(), tones,
				hTonality);
				*/

		HarmonicProfile harmonicProfile = evaluateProfile(tones);
		return new Triad(
				tones[0].getText() + " "
						+ harmonicProfile.harmonicTonality.getText(),
				tones, harmonicProfile.harmonicTonality, harmonicProfile.degreeSet);

	}

	@Override
	public Chord createChord(Harmonizable harmonizableScale, int scaleDegree)
			throws IllegalArgumentException {

		Tone[] tones = harmonizableScaleAndDegreeToToneArray(harmonizableScale,
				scaleDegree);

		/*
		HarmonicTonality hTonality = evaluateTonality(tones);
		
		return new Triad(tones[0].getText() + " " + hTonality.getText(), tones,
				hTonality);
				*/

		HarmonicProfile harmonicProfile = evaluateProfile(tones);
		return new Triad(
				tones[0].getText() + " "
						+ harmonicProfile.harmonicTonality.getText(),
				tones, harmonicProfile.harmonicTonality, harmonicProfile.degreeSet);
	}

/*	private HarmonicTonality evaluateTonality(Tone[] toneArray) {
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
	}*/

	private HarmonicProfile evaluateProfile(Tone[] toneArray) {
		HarmonicProfile harmonicProfile = new HarmonicProfile();
		HashSet<Integer> degreeSet = new LinkedHashSet<Integer>();

		Interval[] intervalArray = new Interval[2];

		intervalArray[0] = TonalSpectrum.measureInterval(toneArray[0],
				toneArray[1]);
		intervalArray[1] = TonalSpectrum.measureInterval(toneArray[0],
				toneArray[2]);

		if (intervalArray[0] == Interval.MAJOR_THIRD) {
			degreeSet.add(3);
			// perfect fifth and augmented fifth are valid
			if (intervalArray[1] == Interval.PERFECT_FIFTH) {
				degreeSet.add(5);
				harmonicProfile.harmonicTonality = HarmonicTonality.MAJOR;
				harmonicProfile.degreeSet = degreeSet;
				return harmonicProfile;
			}
			else
				if (intervalArray[1] == Interval.AUGMENTED_FIFTH_MINOR_SIXTH) {
					degreeSet.add(5);
					harmonicProfile.harmonicTonality = HarmonicTonality.AUGMENTED;
					harmonicProfile.degreeSet = degreeSet;
					return harmonicProfile;
				}
		}
		else
			if (intervalArray[0] == Interval.MINOR_THIRD) {
				degreeSet.add(3);
				if (intervalArray[1] == Interval.PERFECT_FIFTH) {
					degreeSet.add(5);
					harmonicProfile.harmonicTonality = HarmonicTonality.MINOR;
					harmonicProfile.degreeSet = degreeSet;
					return harmonicProfile;
				}
				else
					if (intervalArray[1] == Interval.AUGMENTED_FOURTH_DIMINISHED_FIFTH) {
						degreeSet.add(5);
						harmonicProfile.harmonicTonality = HarmonicTonality.DIMINISHED;
						harmonicProfile.degreeSet = degreeSet;
						return harmonicProfile;
					}
			}
			else
				if (intervalArray[0] == Interval.PERFECT_FOURTH) {
					degreeSet.add(4);
					if (intervalArray[1] == Interval.PERFECT_FIFTH) {
						degreeSet.add(5);
						harmonicProfile.harmonicTonality = HarmonicTonality.SUSPENDED_FOURTH;
						harmonicProfile.degreeSet = degreeSet;
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
					intervalPattern.getInterval(index - 1).getSteps());

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

	private boolean validateInputPattern(IntervalPattern intervalPattern) {
		int intervalCount = intervalPattern.getSize();

		if (intervalCount != 2) {
			return false;
		}

		return true;
	}

	class HarmonicProfile {
		HarmonicTonality harmonicTonality = null;
		HashSet<Integer> degreeSet = null;
	}

	public static IntervalPattern majorPattern = new IntervalPattern("Major",
			"3,5");
	public static IntervalPattern minorPattern = new IntervalPattern("Minor",
			"M3,5");
	public static IntervalPattern diminishedPattern = new IntervalPattern(
			"Minor", "M3,A4/D5");
	public static IntervalPattern augmentedPattern = new IntervalPattern(
			"Augmented", "3,A5/M6");
	public static IntervalPattern suspendedFourthPattern = new IntervalPattern(
			"Suspended 4th", "4,5");

}
