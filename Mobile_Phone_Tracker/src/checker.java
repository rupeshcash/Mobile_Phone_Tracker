
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class checker
{
	public static void main ( String args []) throws Exception
	{
		BufferedReader br = null;
		RoutingMapTree r = new RoutingMapTree();
		try {
			String actionString;
			br = new BufferedReader(new FileReader("Sample_Input.txt"));

			while ((actionString = br.readLine()) != null) {
				System.out.println(actionString);
				r.performAction(actionString);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}

