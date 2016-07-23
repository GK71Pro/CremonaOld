package com.gkaraffa.cremona.playable;

import com.gkaraffa.cremona.theoretical.*;

public class Note extends PlayableObject {
	private Pitch pitch;
	private Duration duration;

	public Pitch getPitch() {
		return pitch;
	}

	public Duration getDuration() {
		return duration;
	}

	public Note() {
		super();
	}

	public Note(Note note) {
		super();
		this.pitch = note.getPitch();
		this.duration = note.getDuration();
		this.setName(note.getName());
		this.setDefined(true);
	}

	public Note(Pitch pitch, Duration duration) {
		super();
		this.pitch = pitch;
		this.duration = duration;
		this.setName("(Pitch: " + (pitch.getName() + ", Duration: " + duration.getName()) + ")");
		this.setDefined(true);
	}
}
