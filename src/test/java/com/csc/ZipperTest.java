package com.csc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;  // Correct import for JUnit 5
import java.util.ArrayList;

public class ZipperTest {

  private Zipper<Integer> intZipper;
  private Zipper<String> stringZipper;

  @BeforeEach
  void setUp() {
    intZipper = new Zipper<>();
    stringZipper = new Zipper<String>();
  }

  @Test
  public void testZipEqualSizedIntegerLists() {
      ArrayList<Integer> listOne = new ArrayList<>();
      ArrayList<Integer> listTwo = new ArrayList<>();
      
      listOne.add(1);
      listOne.add(3);
      listTwo.add(2);
      listTwo.add(4);
      
      intZipper.zip(listOne, listTwo);
      
      ArrayList<Integer> expected = new ArrayList<>();
      expected.add(1);
      expected.add(2);
      expected.add(3);
      expected.add(4);

      assertEquals(expected, intZipper.getList(), "Zipping equal-sized integer lists failed");
  }

  @Test
  public void testZipFirstIntegerListLarger() {
      ArrayList<Integer> listOne = new ArrayList<>();
      ArrayList<Integer> listTwo = new ArrayList<>();
      
      listOne.add(1);
      listOne.add(3);
      listOne.add(5);
      listTwo.add(2);
      
      intZipper.zip(listOne, listTwo);
      
      ArrayList<Integer> expected = new ArrayList<>();
      expected.add(1);
      expected.add(2);
      expected.add(3);
      expected.add(5);

      assertEquals("Zipping where first integer list is larger failed", expected, intZipper.getList());
  }

}
