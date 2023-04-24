import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class FileIO {
	public static void main(String[] args) {
		try {
			InputStream fis = new FileInputStream("input.txt");
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			
			FileOutputStream fos = new FileOutputStream("output.txt");
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			
			String data;
			
			ArrayList<String> lines = new ArrayList<String>();
			
			while((data = br.readLine()) != null) {
				lines.add(data);
			}
			
			Collections.reverse(lines);
			
			boolean flag = false;
			
			for(Object l : lines.toArray()) {
				if(flag)
					bw.newLine();
				else
					flag = true;
				bw.write((String)l);
				bw.flush();
			}
			
			bw.close();
			fos.close();
			osw.close();
			
			br.close();
			isr.close();
			fis.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
