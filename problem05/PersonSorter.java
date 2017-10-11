package exercises14.problem05;

/**
 * Uses a merge sort to sort person objects by name or by telephone number.
 * @author Julian McNeill
 *
 */
public class PersonSorter
{
	private Person[] arr;
	
	/**
	 * Constructs a PersonSorter object.
	 * @param anArray the original array to be sorted
	 */
	public PersonSorter(Person[] anArray)
	{
		arr = anArray;
	}
	
	/**
	 * Gets the sorted array.
	 * @return the sorted array
	 */
	public Person[] getPersonArray()
	{
		return arr;
	}
	
	/**
	 * Sorts the array of people by name or by telephone number.
	 * @param byName If true, sort by name. Otherwise, sort by number
	 */
	public void sort(boolean byName)
	{
		if (arr.length <= 1) return;	// You're done sorting!
		Person[] first = new Person[arr.length / 2];
		Person[] second = new Person[arr.length - first.length];
		for (int i = 0; i < first.length; i++) { first[i] = arr[i]; }
		for (int i = 0; i < second.length; i++)
		{
			second[i] = arr[first.length + i];
		}
		PersonSorter firstSorter = new PersonSorter(first);
		PersonSorter secondSorter = new PersonSorter(second);
		firstSorter.sort(byName);
		secondSorter.sort(byName);
		if (byName)
			mergeByName(first, second);
		else
			mergeByNumber(first, second);
	}
	
	/**
	 * Sorts two halves of an array of people by name.
	 * @param first the first half
	 * @param second the second half
	 */
	private void mergeByName(Person[] first, Person[] second)
	{
		int iFirst = 0;
		int iSecond = 0;
		int j = 0;
		
		while (iFirst < first.length && iSecond < second.length)
		{
			if (first[iFirst].getName().compareTo(second[iSecond].getName()) < 0)
			{
				arr[j] = first[iFirst];
				iFirst++;
			}
			else
			{
				arr[j] = second[iSecond];
				iSecond++;
			}
			j++;
		}
		while (iFirst < first.length)
		{
			arr[j] = first[iFirst];
			iFirst++; j++;
		}
		if (iSecond < second.length)
		{
			arr[j] = second[iSecond];
			iSecond++; j++;
		}
	}
	
	/**
	 * Sorts two halves of an array of people by number.
	 * @param first the first half
	 * @param second the second half
	 */
	private void mergeByNumber(Person[] first, Person[] second)
	{
		int iFirst = 0;
		int iSecond = 0;
		int j = 0;
		
		while (iFirst < first.length && iSecond < second.length)
		{
			if (first[iFirst].getNumber() < second[iSecond].getNumber())
			{
				arr[j] = first[iFirst];
				iFirst++;
			}
			else
			{
				arr[j] = second[iSecond];
				iSecond++;
			}
			j++;
		}
		while (iFirst < first.length)
		{
			arr[j] = first[iFirst];
			iFirst++; j++;
		}
		if (iSecond < second.length)
		{
			arr[j] = second[iSecond];
			iSecond++; j++;
		}
	}
}
