/** The class StringArrayTools implements a variety of basic array tasks
  * using an array of string.
  * 
  * The array has a fixed length MAX_NUMS but the actual number of elements
  * that are used can vary.
  */

import java.util.Scanner;

public class StringArrayTools
{
  
  private String[] arrayData;
  private int arrayCount;
  public final int MAX_NUMS = 100;
  
  // ------------------ CONSTRUCTOR ----------------------------
  /** The contsructor merely creates the array.
    * It does not fill it with any data.  That is left up to 
    * the fillRandom or fillKeyboard methods.
    */
  public StringArrayTools ()
  {
    arrayData = new String[MAX_NUMS];
    arrayCount = 0;
  }
  
  /** Returns the number of objects in the array.
    * @return the count of items in the array. */
  public int getCount ()
  {
    return arrayCount;
  }
  
  // ------------------- METHODS TO FILL THE ARRAY -------------------------
  /** Adds an element to the end of the array. 
    * @param n The element to add
    * @return whether the element was successfully added
    */
  public boolean addItem (String n)
  {
    if (arrayCount < MAX_NUMS)
    {
      arrayData[arrayCount] = n;
      arrayCount++;
      return true;
    }
    else
      return false;
  }

    /** Fills the array nums with strings from 1 to n
    * @param n Upper bound for numbers with which to fill the array.
    * @param count the array to fill.  Returns a modified array.
    */
 /** public void fillRandom (int n, int count)
  {
    if (count > MAX_NUMS)       // check that it's not too many items
      count = MAX_NUMS;
    for (int i = 0; i < count; i++)
      addItem((int)(Math.random() * n) + 1);
  }**/
  
  /** Fills the array with strings entered by the user
    * @param nums the array to fill.  Returns a modified array.
    */
  public void fillKeyboard ()
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.println ("Please enter string on one line, separated by spaces.");
    System.out.println ("Press enter to signal the end of the list.");
    
    arrayCount = 0;
    String n = null;
    while (!(n = keyboard.nextLine()).isEmpty())                 // stop input when user enters blank string
    {
      addItem(n);
    }
    keyboard.close();
  }
  
  // -------------------- METHODS TO WORK WITH THE ARRAY --------------------------
  /** Prints the array, spaces between numbers.
    */
  public void printArray ()
  {
    for (int i = 0; i < arrayCount; i++)
      System.out.print (arrayData[i] + "  ");
    System.out.println();
  }
  
  /** Find the sum of a string array
    * @return the sum of the elements in the array
    */
  public int sumArray ()
  {
    int sum = 0;
    for (int i = 0; i < arrayCount; i++)
      sum = sum + arrayData[i].length();
    return sum;
  }
  
  /** Find the largest element in a String array
   * @return the largest element in the array
   */
  public String getMax ()
  {
    String max = arrayData[0];
    for (int i = 1; i < arrayCount; i++)
      if (arrayData[i].compareToIgnoreCase(max) > 0)
        max = arrayData[i];
    return max;
  }
  
  /**Find where the max is in a string array
    * @return the location of the largest element in the array
    */
  public int getMaxIndex()
  {
    int maxPos = 0;
    for (int i = 1; i < arrayCount; i++)
    {
      if (arrayData[i].equals(getMax()))
        maxPos = i;
    }
    return maxPos;
  }
  
  /** Find the smallest element in a String array
   * @return the smallest element in the array
   */
  public String getMin ()
  {
    String min = arrayData[0];
    for (int i = 1; i < arrayCount; i++)
      if (arrayData[i].compareToIgnoreCase(min) < 0)
        min = arrayData[i];
    return min;
  }
  
  /**Find where the min is in a string array
    * @return the location of the smallest element in the array
    */
  public int getMinIndex()
  {
    int minPos = 0;
    for (int i = 1; i < arrayCount; i++)
    {
      if (arrayData[i].equals(getMin()))
        minPos = i;
    }
    return minPos;
  }
  
  /** Find where the min is in a string array
    * using a sort method
    * @param start
    * @return the location of the smallest element in the array
    **/
  public int getMinIndex(int start)
  {
    int pos = start;
    for (int i = start; i < arrayCount; i++)
    {
      if (arrayData[i].compareTo(arrayData[pos]) < 0)
        pos = i;
    }
    return pos;
  }
  
  /**Sort method to find next largest element and swaps it in the correct position
    * used with getMinIndex()
    */ 
  public void sort()
  {
    int position = 0;
    while (position < arrayCount - 1)
    {
      int min = getMinIndex(position);
      String temp = arrayData[min];
      arrayData[min] = arrayData[position];
      arrayData[position] = temp;
      position++;                             //array is sorted from () to position
    }
  } 
  /** Tests the various array tools */
  public static void main (String[] args)
  {
    StringArrayTools myArray = new StringArrayTools();
    //myArray.fillRandom(100, 12);
    myArray.fillKeyboard ();
    myArray.printArray ();
    System.out.println ("There are " + myArray.getCount() + " words in the array.");
    System.out.println ("The sum of all of the characters in the array is " + myArray.sumArray());
    
    // Un-comment these lines one at a time after you have written the appropriate code
    System.out.println ("The largest item (alphabetically) is " + myArray.getMax() ); 
    System.out.println ("The largest item is at index " + myArray.getMaxIndex());

    System.out.println ("The smallest item (alphabetically) is " + myArray.getMin() );
    System.out.println ("The smallest item is at index " + myArray.getMinIndex());
    
    
    System.out.println ("The array in ascending order (lexicographically) is "); 
    myArray.sort();
    myArray.printArray();
  }
}

    
    
  