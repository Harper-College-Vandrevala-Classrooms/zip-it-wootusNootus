package com.csc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

public class ZipperTest {

  private Zipper<Integer> intZipper;
  private Zipper<String> stringZipper;
  private Zipper<Character> charZipper;

  @BeforeEach
  void setUp() {
    intZipper = new Zipper<>();
    stringZipper = new Zipper<String>();
    charZipper = new Zipper<>();
  }

  // Both lists equal size
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
      expected.add(2);
      expected.add(1);
      expected.add(4);
      expected.add(3);

      assertEquals(expected, intZipper.getList());
  }

  // One list larger than other
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

      assertEquals(expected, intZipper.getList());
  }

  // One list larger than the other (String)
  @Test
  public void testZipDifferentSizedStringLists() {
      ArrayList<String> listOne = new ArrayList<>();
      ArrayList<String> listTwo = new ArrayList<>();
      
      listOne.add("apple");
      listOne.add("cherry");
      listTwo.add("banana");
      
      stringZipper.zip(listOne, listTwo);
      
      ArrayList<String> expected = new ArrayList<>();
      expected.add("apple");
      expected.add("banana");
      expected.add("cherry");

      assertEquals(expected, stringZipper.getList(), "Zipping different-sized string lists failed");
  }

  // One list larger than the other (Char)
  @Test
  public void testZipCharacterLists() {
      ArrayList<Character> listOne = new ArrayList<>();
      ArrayList<Character> listTwo = new ArrayList<>();
      
      listOne.add('A');
      listOne.add('C');
      listTwo.add('B');
      
      charZipper.zip(listOne, listTwo);
      
      ArrayList<Character> expected = new ArrayList<>();
      expected.add('A');
      expected.add('B');
      expected.add('C');

      assertEquals(expected, charZipper.getList(), "Zipping character lists failed");
  }

  // Two empty lists 
  @Test
  public void testZipEmptyLists() {
      ArrayList<Integer> listOne = new ArrayList<>();
      ArrayList<Integer> listTwo = new ArrayList<>();

      intZipper.zip(listOne, listTwo);

      ArrayList<Integer> expected = new ArrayList<>(); // Expect an empty list

      assertEquals(expected, intZipper.getList(), "Zipping empty lists failed");
  }

  // One empty list 
  @Test
  public void testZipOneEmptyList() {
      ArrayList<Integer> listOne = new ArrayList<>();
      ArrayList<Integer> listTwo = new ArrayList<>();

      listTwo.add(1);
      listTwo.add(2);
      listTwo.add(3);

      intZipper.zip(listOne, listTwo);

      ArrayList<Integer> expected = new ArrayList<>(listTwo); // Expect the result to be the same as listTwo

      assertEquals(expected, intZipper.getList(), "Zipping with one empty list failed");
  }
}
