package com.gkaraffa.cremona.theoretical;

public class ScalarIntervalPattern extends IntervalPattern {

	public ScalarIntervalPattern(String name, String inPatternString)
			throws IllegalArgumentException {
		super(name, inPatternString);
	}
	
	public static ScalarIntervalPattern ionianPattern = new ScalarIntervalPattern("Ionian",
			"M2,M3,P4,P5,M6,M7,P8");
	public static ScalarIntervalPattern dorianPattern = new ScalarIntervalPattern("Dorian",
			"M2,m3,P4,P5,M6,m7,P8");
	public static ScalarIntervalPattern phrygianPattern = new ScalarIntervalPattern(
			"Phrygian", "m2,m3,P4,P5,m6,m7,P8");
	public static ScalarIntervalPattern lydianPattern = new ScalarIntervalPattern("Lydian",
			"M2,M3,A4,P5,M6,M7,P8");
	public static ScalarIntervalPattern mixolydianPattern = new ScalarIntervalPattern(
			"Mixolydian", "M2,M3,P4,P5,M6,m7,P8");
	public static ScalarIntervalPattern aeolianPattern = new ScalarIntervalPattern("Aeolian",
			"M2,m3,P4,P5,m6,m7,P8");
	public static ScalarIntervalPattern locrianPattern = new ScalarIntervalPattern("Locrian",
			"m2,m3,P4,d5,m6,m7,P8");
	public static ScalarIntervalPattern harmonicMinorPattern = new ScalarIntervalPattern(
			"Harmonic Minor", "M2,m3,P4,P5,m6,M7,P8");
	public static ScalarIntervalPattern melodicMinorPattern = new ScalarIntervalPattern(
			"Melodic Minor", "M2,m3,P4,P5,M6,M7,P8");
	public static ScalarIntervalPattern pentatonicMajorPattern = new ScalarIntervalPattern(
			"Pentatonic Major", "M2,M3,P5,M6,P8");
	public static ScalarIntervalPattern pentatonicMinorPattern = new ScalarIntervalPattern(
			"Pentatonic Minor", "m3,P4,P5,m7,P8");

}
