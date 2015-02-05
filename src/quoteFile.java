import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class quoteFile {
		//vars
		static ArrayList<String> arr;
		List<String> quotes = new ArrayList<String>();
		// reader
		public static ArrayList<String> reader() throws IOException{
			BufferedReader InFile = new BufferedReader(new FileReader("quotes.txt"));

			String Line; 
			while ((Line = InFile.readLine()) != null) //Read line-by-line, until end of file
			{
			    	arr.add(Line);
			}
			InFile.close(); //We've finished reading the file 
			
			return arr;
			
		}
		// writer
		  public static void writer(ArrayList<String> UnsavedQuotes) throws Exception {
				int arraysize = arr.size();
			    FileWriter fw = new FileWriter("quotes.txt");
			    if (arraysize != 0){
				    for (int i = arr.size(); i < UnsavedQuotes.size(); i++) {
					      fw.write(UnsavedQuotes.get(i) + "\n");
					    }	
				  }
			    fw.close();
			  }
}
