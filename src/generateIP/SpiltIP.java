package generateIP;

import java.io.*;
import java.util.HashMap;

public class SpiltIP
{
    private static final int MAXNUM=1024;
    //  E:\github\IPCount\split
    public static void splitFile(String fileName)
    {  try{
        FileReader fileReader=new FileReader("IPLog.txt");
        BufferedReader br = new BufferedReader(fileReader);
        String ip=null;
        HashMap<String, FileWriter> fileWriters = new HashMap<String, FileWriter>();
        while((ip=br.readLine())!=null)
        {   //ip的hashcode会在int型中越界，所以求绝对值
            int code=Math.abs(ip.hashCode()%MAXNUM);
            String name="E:\\github\\IPCount\\split\\"+""+code+".txt";
            FileWriter fileWriter=null;
            if(fileWriters.containsKey(name))
            {
                fileWriter=fileWriters.get(name);
            }else{
                fileWriter=new FileWriter(name);
                fileWriters.put(name,fileWriter);
            }
            fileWriter.write(ip+"\n");
        }
        for(FileWriter fileWriter:fileWriters.values())
        {
            fileWriter.close();
        }

    }catch (FileNotFoundException e)
    {
        System.out.println(e);
    }catch (IOException e)
    {
        System.out.println(e);
    }
    }
    public static void main(String[] args)
    {
        splitFile("IPLog.txt");
    }
}
