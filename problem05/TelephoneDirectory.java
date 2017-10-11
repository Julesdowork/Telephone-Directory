package exercises14.problem05;

/**
 * A telephone directory has a list of people that can be sorted and searched.
 * @author Julian McNeill
 */
public class TelephoneDirectory
{
	private boolean sortedByName;
	private Person[] directory;
	
	/**
	 * Constructs a telephone directory.
	 * @param aDirectory the people in this directory
	 */
	public TelephoneDirectory(Person[] aDirectory)
	{
		directory = aDirectory;
		sortedByName = true;
	}
	
	/**
	 * Finds the location of a user-supplied name in the directory.
	 * @param otherName the name to look for
	 * @return the location of the name in the directory, or -1 if that name
	 * couldn't be found
	 */
	public int find(String otherName)
	{
		if (!sortedByName)
		{
			PersonSorter sorter = new PersonSorter(directory);
			sorter.sort(true);
			directory = sorter.getPersonArray();
			sortedByName = true;
		}
		
		int low = 0;
		int high = directory.length - 1;
		while (low <= high)
		{
			int mid = (low + high) / 2;
			String thisName = directory[mid].getName();
			
			if (thisName.equalsIgnoreCase(otherName))
				return mid;
			else if (thisName.compareToIgnoreCase(otherName) < 0)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}
	
	/**
	 * Finds the location of a user-supplied number in the directory. The user
	 * must supply the number without punctuation.
	 * @param otherNumber the number to look for
	 * @return the location of the number in the directory, or -1 if that
	 * number couldn't be found
	 */
	public int find(long otherNumber)
	{
		if (sortedByName)
		{
			PersonSorter sorter = new PersonSorter(directory);
			sorter.sort(false);
			directory = sorter.getPersonArray();
			sortedByName = false;
		}
		
		int low = 0;
		int high = directory.length - 1;
		while (low <= high)
		{
			int mid = (low + high) / 2;
			long thisNumber = directory[mid].getNumber();
			
			if (thisNumber == otherNumber)
				return mid;
			else if (thisNumber < otherNumber)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}
	
	/**
	 * Prints the name and number of the person found at a given location.
	 * @param loc the location to print
	 */
	public void getPerson(int loc)
	{
		if (loc < 0 || loc >= directory.length)
			System.out.println("No person was found at this location.");
		System.out.println(directory[loc].getName() + " " + 
			directory[loc].formatNumber());
	}
}
