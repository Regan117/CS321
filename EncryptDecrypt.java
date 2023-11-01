import java.util.Random;

/**
 * This program encrypts and decrypts the plainText received from ThreeTenCipher
 * class. Its job is to first randomly fill the selectAlpha array, next it
 * encrypts the plainText and saves it as cipherText. At the end, it decrypts
 * the cipherText back to plainText and returns it.
 * 
 * @author Mohammad Tariq Hussain
 * @since 02/19/23
 */
public class EncryptDecrypt {

	/**
	 * this instance variable contains the size of the plainText in the
	 * ThreeTenCipher class.
	 *
	 */
	private int plainTextSize;

	/**
	 * plainTextSize setter.
	 * 
	 * @param s set equal to the length of plainText from ThreeTenCipher class
	 */
	public void setPlainTextSize(int s) {
		this.plainTextSize = s;

	}

	/**
	 * plainTextSize getter.
	 * 
	 * @return the plainTextSize
	 */
	public int getPlainTextSize() {
		return this.plainTextSize;// returns the variable plainTextSize
	};

	/**
	 * This integer array of size equal to plainTextSize contains the random numbers
	 * to be used by the encrypt/decrypt methods.
	 * 
	 */
	private int[] selectAlpha;

	/**
	 * First randomly sets the selectAlpha array to random numbers between 0 and 4.
	 * This number indicates which alphabet cipher is used for each letter in
	 * plainText accesses the plainText in the ThreeTenCipher then encrypts it and
	 * sets the cipherText in the ThreeTenCipher.
	 */
	public void encrypt() {
		// The random function is used here in order to fill the elements of
		// selectAlpha.
		// SelectAlpha is also set to the size of plainText.
		// A for loop is used to fill the elements of selectAlpha with random numbers
		// between 0-4.
		Random rand = new Random();
		int temp;
		selectAlpha = new int[plainTextSize];
		for (int i = 0; i < selectAlpha.length; i++) {
			selectAlpha[i] = rand.nextInt(5);
		}
		// The plainText gotten from the main function is changed to lower case.
		ThreeTenCipher.plainText = ThreeTenCipher.plainText.toLowerCase();
		// cipherText is initialized to an empty string.
		ThreeTenCipher.cipherText = "";
		// A loop is run from 0 to the size of selectAlpha i.e the size of plainText
		for (int x = 0; x < selectAlpha.length; x++) {
			// An integer is used to hold the ASCII value of each letters. This is done
			// using the charAt function.
			// If the letter is between the value of 97 and 122, it is considered as lower
			// case alphabets.
			// An if statement check the temp int value to make sure only the letters are
			// encrypted.
			// Else, the cipherText saves whatever is in the plainText using the charAt
			// function. Each time the if/else statement runs, it appends letters or
			// anything else to the cipherText.
			temp = ThreeTenCipher.plainText.charAt(x);
			if (temp >= 97 && temp <= 122) {
				ThreeTenCipher.cipherText = ThreeTenCipher.cipherText
						+ ThreeTenCipher.keys[selectAlpha[x]][(int) ThreeTenCipher.plainText.charAt(x) - 97];
			} else {
				ThreeTenCipher.cipherText = ThreeTenCipher.cipherText + ThreeTenCipher.plainText.charAt(x);
			}
		}
		// Since the elements inside the keys array is all upper case, I put it back to
		// lower case.
		ThreeTenCipher.cipherText = ThreeTenCipher.cipherText.toLowerCase();
	}

	/**
	 * uses the cipherText from the ThreeTenCipher and the instance variable
	 * selectAlpha decrypts the cipher text then calls the archiveDecrypted to store
	 * the resulting string in the ThreeTenCipher testArchive instance variable.
	 * 
	 * @return returns the resulting text.
	 */
	public String decrypt() {
		// initializing a String variable that will store the elements after each letter
		// is decrypted.
		// initializing a char variable gets the variables from keys and maps it back to
		// the plain text letter.
		String decoded = "";
		char letter = ' ';
		// Making cipher text uppercase because the all the elements inside keys is
		// uppercase in order to do the comparison.
		ThreeTenCipher.cipherText = ThreeTenCipher.cipherText.toUpperCase();
		// A nested for loop is placed here that will check each character inside
		// cipherText if it matches with any of the elements of the ith index of
		// selectAlpha of keys.
		// If a match occurs, the specific index that the letter was discovered at
		// is used. That index is then added to the ASCII value of the first lower
		// case letter in order to get the specific letter behind that key element.
		// It is then casted into char and saved inside a char variable.
		// If the cipherText character is not found inside keys of selectAlpha, it
		// saves the character of the ith element of plainText, inside the decoded
		// text. After the inside loop finishes, the letter is appended to the
		// string.
		for (int i = 0; i < selectAlpha.length; i++) {
			for (int x = 0; x < 26; x++) {
				if (ThreeTenCipher.keys[selectAlpha[i]][x] == ThreeTenCipher.cipherText.charAt(i)) {
					letter = (char) (x + 97);
				} else {
					letter = ThreeTenCipher.plainText.charAt(i);
				}
			}
			decoded = decoded + letter;
		}
		return decoded;
	}

}