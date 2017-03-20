package com.gkaraffa.cremona.theoretical;

import java.util.ArrayList;
import java.util.Iterator;

public class ToneCollectionBuilder extends TheoreticalObject implements Iterable<Tone> {
  private final ArrayList<Tone> toneList;

  public ToneCollectionBuilder(String text) {
    super(text);
    toneList = new ArrayList<Tone>();
  }

  public ToneCollectionBuilder(String text, ToneCollection toneCollection) {
    super(text);

    toneList = new ArrayList<Tone>();

    for (Tone tone : toneCollection) {
      toneList.add(tone);
    }
  }

  public int getSize() {
    return toneList.size();
  }

  public Tone getTone(int position) {
    if (position > (toneList.size() - 1)) {
      return toneList.get(position - toneList.size());
    }
    else {
      return toneList.get(position);
    }
  }

  public void insert(Tone subject) {
    if (!contains(subject)) {
      toneList.add(subject);
    }
  }

  public boolean contains(Tone target) {
    for (Tone tone : toneList) {
      if (tone == target) {
        return true;
      }
    }

    return false;
  }

  public ToneCollection toToneCollection() {
    if (toneList.isEmpty()) {
      return null;
    }

    return new ToneCollection(this.getText(), toneList.toArray(new Tone[toneList.size()]));
  }

  public Iterator<Tone> iterator() {
    return new ToneIterator();
  }

  class ToneIterator implements Iterator<Tone> {
    private int index = 0;

    public boolean hasNext() {
      return index < getSize();
    }

    public Tone next() {
      return getTone(index++);
    }

    public void remove() {
      throw new UnsupportedOperationException("not supported yet");
    }
  }

}
