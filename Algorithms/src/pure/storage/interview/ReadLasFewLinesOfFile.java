package pure.storage.interview;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadLasFewLinesOfFile {
	
	// afilestoread.txt
	
	public static String getLastNlines(File file, int nLines)
	{
		StringBuilder sb = new StringBuilder();
		
		try
		{
			Process p = Runtime.getRuntime().exec("tail - "+ nLines + " " + file);
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			while((line = input.readLine()) != null)
			{
				sb.append(line + '\n');
			}
		} catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
        String fileName = "/Users/knidhi/eclipse-workspace/Algorithms/src/pure/storage/interview/afilestoread.txt";

		File file = new File(fileName);
		System.out.println(getLastNlines(file, 5));

	}

}
