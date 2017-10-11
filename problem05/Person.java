package exercises14.problem05;

/**
 * A person is a listing in a telephone directory. The person has a name and
 * a telephone number.
 * @author Julian McNeill
 */
public class Person
{
	private String name;
	private long number;
	
	/**
	 * Constructs a Person object and parses their name and number.
	 * @param aString the listing of this person in a phonebook
	 */
	public Person(String aString)
	{
		int index = aString.indexOf("(");
		name = aString.substring(0, index).trim();
		String telNum = aString.substring(index);
		telNum = telNum.replaceAll("[^0-9]", "");
		number = Long.parseLong(telNum);
	}
	
	/**
	 * Prints this person's telephone number in a readable format.
	 * @return the number as a readable string
	 */
	public String formatNumber()
	{
		String numberFmt = "(";
		String numberText = Long.toString(number);
		numberFmt += numberText.substring(0, 3) + ") " + numberText.substring(3, 6) +
				"-" + numberText.substring(6);
		return numberFmt;
	}
	
	/**
	 * Gets this person's name.
	 * @return the person's name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Gets this person's telephone number.
	 * @return the person's number
	 */
	public long getNumber()
	{
		return number;
	}
}
