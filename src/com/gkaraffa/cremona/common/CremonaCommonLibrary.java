package com.gkaraffa.cremona.common;

public class CremonaCommonLibrary {

  public CremonaCommonLibrary() {}

  public static int inheritanceDepth(Class<?> c) {
    Class<?> subject = c.getSuperclass();
    if (subject == null) {
      return 1;
    }

    return (inheritanceDepth(subject) + 1);
  }
}
