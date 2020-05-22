package generateIP;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GenetateIP {
    private static String genetateIP()
    {
        return "192.168."+(int)(Math.random()*255)+"."+(int)(Math.random()*255)+"\n";
    }
    public static void generateIpFile()  {
        File file=new File("IPLog.txt");
        FileWriter fileWriter= null;
        try {
            fileWriter = new FileWriter(file);
            for(int i=0;i<10000000;i++)
            {
                fileWriter.write(genetateIP());
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
         generateIpFile();
    }
}
