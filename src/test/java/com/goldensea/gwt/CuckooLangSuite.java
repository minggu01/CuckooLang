package com.goldensea.gwt;

import com.goldensea.gwt.client.CuckooLangTest;
import com.google.gwt.junit.tools.GWTTestSuite;
import junit.framework.Test;
import junit.framework.TestSuite;

public class CuckooLangSuite extends GWTTestSuite {
  public static Test suite() {
    TestSuite suite = new TestSuite("Tests for CuckooLang");
    suite.addTestSuite(CuckooLangTest.class);
    return suite;
  }
}
