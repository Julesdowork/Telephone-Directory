package exercises14.problem05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Tests the TelephoneDirectory class.
 * @author Julian McNeill
 */
public class TelephoneLookupTester
{
	public static void main(String[] args) throws FileNotFoundException
	{
		System.out.println("Telephone Lookup Tester\n");
	
		final int AR_SIZE = 1000;
		String[] listings = new String[AR_SIZE];
		File inFile = new File("telephone_numbers.txt");
		Scanner in = new Scanner(inFile);
		for (int i = 0; i < AR_SIZE; i++)
			listings[i] = in.nextLine();
		
		Arrays.sort(listings);
		Person[] people = new Person[AR_SIZE];
		for (int i = 0; i < AR_SIZE; i++)
			people[i] = new Person(listings[i]);
		
		TelephoneDirectory directory = new TelephoneDirectory(people);
		String lookup = "";
		in = new Scanner(System.in);
		System.out.print("Enter name or number (DIGITS ONLY) to lookup: ");
		lookup = in.nextLine();
		while (!lookup.equals("done"))
		{
			int loc;
			if (Character.isDigit(lookup.charAt(0)))
			{
				long number = Long.parseLong(lookup);
				loc = directory.find(number);
			}
			else
				loc = directory.find(lookup);
			
			if (loc == -1)
				System.out.println("Couldn't find entry in directory.");
			else
				directory.getPerson(loc);
			System.out.print("Enter name or number to lookup: ");
			lookup = in.nextLine();
		}
		
		in.close();
	}
}
