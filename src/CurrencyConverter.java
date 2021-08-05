import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CurrencyConverter {

	public static List<List<String>> lines = new ArrayList<>();
	public static String[] countries = new String[61];
	public static Double[] vals = new Double[61];
	
	public static void main(String[] args) {
		
		try {
			Scanner inputStream = new Scanner(new File("Exchange_Rates.csv"));
			
			while(inputStream.hasNext()) {
				String[] values = inputStream.next().split(",");
				lines.add(Arrays.asList(values));
			}
			inputStream.close();
			
			for(int i = 1; i < 62; i++) {
				countries[i - 1] = lines.get(i).get(0);
				vals[i - 1] = Double.parseDouble(lines.get(i).get(1));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		new GUI();
	}

}
