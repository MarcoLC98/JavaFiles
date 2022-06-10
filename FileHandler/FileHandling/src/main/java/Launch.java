import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class Launch {

	public static void main(String [] args) throws IOException {

		File file = new File("src/main/resources/file.txt");

		if (file.exists()) {
			System.out.println("That file exists >)");
			//These two functions below return the path of the file
			System.out.println(file.getPath());
			System.out.println(file.getAbsolutePath());
			//Checks whether if it's a file or not. Returns true or false.
			System.out.println(file.isFile());
			//file.delete();
		} else {
			System.out.println("That file doesn't exists! :/");
		}
		String textFile = FileUtils.readFileToString(file, "UTF-8").toLowerCase();
		textFile = StringUtils.replaceChars(textFile, ',', ' ');
		textFile = StringUtils.replaceChars(textFile, ',', ' ');
		textFile = StringUtils.replaceChars(textFile, ',', ' ');

		HashMap<Integer, String> r = new HashMap<>();

		int c = 0;

		for (String var1 : StringUtils.split(textFile)) {
			if (r.containsKey(var1)) {
				r.put(Integer.valueOf(var1), r.get(var1) + 1);
			} else
				r.put(1, var1);
			c++;
		}
		FileUtils.writeStringToFile(new File("src/main/resources/filelog.txt"), "Number of unique words: " + c + "\n" +
				"Number of events of each word: " + r.toString(), "UTF-8");
		FileUtils.sizeOf(file);
	}

}