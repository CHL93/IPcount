package generateIP;


import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.PriorityQueue;

class Calculate
{
    private static final Integer K=10;
    private static final String  PATH="E:\\github\\IPCount\\split\\";
    public static void main(String[] args)
    {
        PriorityQueue<Pair> queue=new PriorityQueue<>();// offer() poll()
        for(int i=0;i<1024;i++)
        {
            try{
                BufferedReader br=new BufferedReader(new FileReader(PATH+i+".txt"));
                HashMap<String,Integer> map=new HashMap<>();
                String ip=null;
                while((ip=br.readLine())!=null)
                {
                    if(map.containsKey(ip)){
                        map.put(ip,map.get(ip)+1);
                    }else {
                        map.put(ip,1);
                    }
                 }
                 MaxKIP(map,queue);
                 map.clear();
            }catch (FileNotFoundException e){
                System.out.println(e);
            }catch (IOException e)
            {
                System.out.println(e);
            }
        }
        try{
            WrieFile(queue);
        }catch (IOException e)
        {
            System.out.println("写入统计结果IO异常："+e.getMessage());
        }

    }
    public static PriorityQueue<Pair> MaxKIP(HashMap<String,Integer> map,PriorityQueue<Pair> queue)
    {
        for(String key:map.keySet())
        {
            int value=map.get(key);
            Pair pair=new Pair(key,value);
            if(queue.size()<K)
            {
             queue.offer(pair);
            }else
                {
                    Pair top=queue.poll();
                    if(top.getFrequency()>pair.getFrequency())
                        queue.offer(top);
                    else
                        queue.offer(pair);
                }
        }
        return  queue;
    }

    public static void WrieFile(PriorityQueue<Pair> queue) throws IOException
    {
        FileWriter fileWriter=new FileWriter("MaxKIP.txt");
        while(!queue.isEmpty())
        {
            Pair pair=queue.poll();
            fileWriter.write(pair.getIp()+"   "+pair.getFrequency()+"\n");
        }
        fileWriter.close();
    }


}