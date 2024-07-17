import java.util.*;
import java.io.*;

public class Convert {
   
	public static void convertFile(String fileName) throws IOException, FileNotFoundException {
       
		Scanner keyboard = new Scanner(new File(fileName));
        
        String newFile = "triplog.csv";
        
        File readFile = new File(newFile);
       
        readFile.setWritable(true);

        FileWriter file = new FileWriter(readFile);

        keyboard.nextLine();keyboard.nextLine(); keyboard.nextLine();

        String firstLine = "Time,Latitude,Longitude\n";
        
        file.write(firstLine);

        int t = 0;

        while (keyboard.hasNext()) {
            String line = keyboard.nextLine();

            if (line.isEmpty() || !line.contains("<trkpt")) {
                continue; 
            }
            else {
           
	            String lineLat= "";
	            String lineLon = "";
	
	            int iLat = line.indexOf("lat=") + 5;
	            int iLon = line.indexOf("lon=") + 5;
	
	            StringBuilder latitudeBuilder = new StringBuilder();
	           
	            for (int i = iLat; i < iLon; i++) {
	                char currChar = line.charAt(i);
	                if (Character.isDigit(currChar) || currChar == '.' || currChar == '-') {
	                    latitudeBuilder.append(currChar);
	                }
	            }
	            lineLat = latitudeBuilder.toString();
	
	            
	            StringBuilder longitudeBuilder = new StringBuilder();
	           
	            for (int i = iLon; i < line.length(); i++) {
	                char currChar = line.charAt(i);
	                if (Character.isDigit(currChar) || currChar == '.' || currChar == '-') {
	                    longitudeBuilder.append(currChar);
	                }
	            }
	            lineLon = longitudeBuilder.toString();
	
	            String heading = t + "," + lineLat + "," + lineLon + '\n';
	            file.write(heading);
	
	            t = t + 5;
	        }
        }
        
       
        keyboard.close();
        
        readFile.setWritable(false);
        
        file.close();
    }
}
