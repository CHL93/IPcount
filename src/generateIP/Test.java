package generateIP;

public class Test
{
    public static int mySqrt(int x) {
        if(x==0)
            return x;
        if(x<=3)
            return 1;
        //使用二分查找找到平方根
        int high=x,low=0;
        while(low<high)
        {
            int mid=(high+low+1)/2;
            if((mid*mid)>x)
                high=mid-1;
            else if((mid*mid==x))
                return mid;
            else
                low=mid;
        }
        return high;
    }
    public static void main(String[] args)
    {
        System.out.println(mySqrt(8));

    }
}
