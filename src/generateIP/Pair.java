package generateIP;

import java.util.HashMap;
import java.util.Map;

public class Pair implements  Comparable<Pair>
{
    private String ip;
    private int frequency;
    public Pair(String ip,int frequency)
    {
        this.frequency=frequency;
        this.ip=ip;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public int hashCode() {
        return ip.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Pair))
            return  false;
        Pair obj1=(Pair)obj;
        return ip.equals((obj1).ip);
    }




    @Override
    public int compareTo(Pair o) {
        return this.frequency-o.frequency;
    }
}
