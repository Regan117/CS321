/**
 * This program is a class of an encryption program. It has key variables such
 * as keys (a 2d array that holds shuffled alphabets), plainText (a string that
 * needs to be encrypted), cipherText (a string that has been encrypted and now
 * needs to be decrypted), textArchive (an array that stores all the cipherText
 * that have been decrypted), and a sizeStored (an integer that counts the exact
 * amount of size all the characters have taken inside textArchive).
 * 
 * @author Mohammad Tariq Hussain
 * @since 02/19/23
 */
public class ThreeTenCipher {

	/**
	 * // constructor that initializes the keys array, the textArchive, the
	 * cipherText, the plaintext, and sets the sizeStored to 0.
	 * 
	 */
	public ThreeTenCipher() {
		// Keys is initialized to null
		ThreeTenCipher.keys = null;
		// textArchive is initialized to the 100
		this.textArchive = new char[100];
		// cipherText is initialized to null
		ThreeTenCipher.cipherText = null;
		// plainText is initialized to null
		ThreeTenCipher.plainText = null;
		// sizeStored is initialized to null
		this.sizeStored = 0;
	}

	/**
	 * stores the 5 cipher alphabets each of 26 characters length.
	 */
	public static char[][] keys;
	/**
	 * This is the cipher text to be decrypted.
	 * 
	 */

	public static String cipherText;

	/**
	 * This is the plain text to be encrypted.
	 * 
	 */
	public static String plainText;

	/**
	 * A character array with initial capacity of 100 that contains all decoded text
	 * blocks.
	 * 
	 */
	private char textArchive[];

	/**
	 * the size of the stored text in textArchive.
	 * 
	 */
	private int sizeStored;

	/**
	 * Adds a new text to the textArchive. If textArchive is full, it will increase
	 * the size to 1.5 the original size to accommodate the new text inserted. This
	 * method should be O(n)
	 * 
	 * @param newText the new text to be added to textArchive
	 */
	public void insertText(char[] newText) {
		// To insert text inside textArchive a check is done first to see if
		// the size permits newText to be entered. If sizeStored is maxed out
		// meaning there is no more space remaining, it will increase size to
		// 1.5 times the previous size of textArchive. Or if sizeStored and
		// the size of newText added together is more than the size of
		// textArchive, it will again increase size 1.5 times previous.
		int temp = 0;
		if ((sizeStored == textArchive.length) || (sizeStored + newText.length >= textArchive.length)) {
			// An array is created here which references back to textArchive in order to
			// copy all data back to textArchive.
			// Next the size of textArchive is initialized with new size that is 1.5 times
			// the previous size. In order to round up, .5 is added each time that always
			// makes it round up.
			char arr[] = textArchive;
			textArchive = new char[(int) (textArchive.length * 1.5 + .5)];
			// A loop is run that copies elements from arr array back to textAchive.
			for (int i = 0; i < sizeStored; i++) {
				textArchive[i] = arr[i];
			}
			// At the end of copying, the arr array is assigned null.
			arr = null;
		}
		// Another loop is run that starts from the sizeStored to the size of newText +
		// sizeStored.
		for (int x = sizeStored; x < newText.length + sizeStored; x++) {
			textArchive[x] = newText[temp];
			temp++;
		}
		// At the end of inserting to textArchive, the sizeStored is adding the size of
		// newText to itself.
		sizeStored += newText.length;
	}

	/**
	 * removes all the character data from start to size-1. It throws
	 * NoTextException, if there is no data to remove. It should shrink the size
	 * after deleting the corresponding character data by setting it to a new
	 * capacity of capacity-size. You need to check that the indices are valid or
	 * else throw an ArrayIndexOutOfBounds exception. Returns true if successful.
	 * This method should be O(n).
	 * 
	 * @param start the index in textArchive from which to start removing
	 * @param size  the number of elements to remove from textArchive
	 * @return returns true if successful
	 * @throws Exception THis throws an exception if sizeStored is empty or indices
	 *                   aren't in bounds.
	 */
	public boolean cleanArchivedText(int start, int size) {
		// First the method checks if the sizeStored is 0, then it throws
		// an exception.
		char temp[] = new char[textArchive.length - (size - 1)];
		try {
			if (sizeStored == 0) {
				throw new Exception();
			}

			// Next, we are checking if the indices are the appropriate size
			// and length. If not, an exception is thrown.
			if (start >= sizeStored || size + start > sizeStored || start < 0) {
				throw new ArrayIndexOutOfBoundsException();
			}

			// If the above statements don't throw an exception, then
			// a temp array is created with the size of textArchive minus
			// the size - 1.

			System.out.println(temp.length);
			// The sizeStored is also shrinked.
			sizeStored = sizeStored - (size);
			// A loop is run from the start of array to the size of temp array.
			// If the ith index is less than start or more than or equal to size,
			// it saves the element of textArchive to temp array.

			for (int i = 0, x = 0; x < sizeStored; i++) {
				if (i < start || i >= size + start) {
					temp[x] = textArchive[i];
					System.out.print(temp[x]);
					x++;
				}
			}
		} catch (Exception e) {
			System.out.println("Incorrect!");
		}
		// At the end, textArchive, references to temp array.
		textArchive = temp;
		return true;

	}

	/**
	 * maximum storage capacity of textArchive.
	 * 
	 * @return returns the maximum storage capacity of textArchive.
	 */
	public int getStorageCapacity() {
		// getStorageCapacity returns the maximum size of textArchive.
		return textArchive.length;
	}

	/**
	 * This method returns the size used of textArchive.
	 * 
	 * @return returns the size of character data inserted in the textArchive.
	 */
	public int getSize() {
		return sizeStored;
	}

	/**
	 * checks if the textArchive is empty.
	 * 
	 * @return true if empty
	 */
	public boolean isEmpty() {
		// Checking isEmpty by seeing if the sizeStore is 0, thus it means its empty
		// else it is not empty, the we return false
		if (sizeStored == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * checks if the textArchive is full.
	 * 
	 * @return true if textArchive is full
	 */
	public boolean isFull() {
		// isFull is checked when sizeStored is the maximum size of textArchive
		// else, it returns false if it is less than size of textArchive.
		if (sizeStored == textArchive.length) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * cipherText setter.
	 * 
	 * @param cipher to set cipherText
	 */
	public void setCipherText(String cipher) {
		ThreeTenCipher.cipherText = cipher;
	}

	/**
	 * cipherText getter.
	 * 
	 * @return cipherText
	 */
	public String getCipherText() {
		return ThreeTenCipher.cipherText;
	}

	/**
	 * plainText setter.
	 * 
	 * @param plain to set plainText
	 */
	public void setPlainText(String plain) {
		ThreeTenCipher.plainText = plain;
	}

	/**
	 * plainText getter.
	 * 
	 * @return plainText
	 */
	public String getPlainText() {
		return ThreeTenCipher.plainText;
	}

	/**
	 * sets the keys set the size of keys to be 5 of 26 length cipher alphabets.
	 *
	 * @param keys the cipher alphabets of 26 length each
	 * @param size 5 cipher alphabet keys
	 */
	public void setKeys(char[][] keys, int size) {
		// This method sets the keys given from the main method.
		ThreeTenCipher.keys = new char[5][26];
		ThreeTenCipher.keys = keys;

	}

	/**
	 * This method is responsible of getting a specific array starting from int
	 * start and the size is size -1.
	 * 
	 * @param start This is an int that means the index to retrieve array from.
	 * @param size  This is the size of the array to retrieve.
	 * @return Returns an array from start to size -1.
	 */
	public char[] getTextArchive(int start, int size) {
		// To get a specific array from the textArchive, we have to
		// establish a new array of size given.
		// The int temp is used to count which elements from textArchive
		// need to be copied inside arr.
		// The loop goes until the size and adds inside arr.
		int temp = start;
		char arr[] = new char[size];
		for (int i = 0; i < size; i++) {
			arr[i] = textArchive[temp];
			temp++;
		}
		// At the end, it returns that array.
		return arr;
	}

}