import java.util.*;
public class trapping_water {
    public static int trappedrainwater(int height[]) {
        int n=height.length;
        //calculate left max baundary
        int leftMax[]=new int [height.length];
        leftMax[0]=height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i]=Math.max(height[i], leftMax[i-1]);
        }
        //calculate right max bounday
        int rightMax[]=new int [n];
        rightMax[n-1]=height[n-1];
        for(int i = n-2; i>=0; i--) {
            rightMax[i]=Math.max(height[i], leftMax[i+1]);
        }
        //water level=min(leftmax baund,rightmax bound)
        int trappedWater=0;
        for (int i = 0; i < n; i++) {
           int waterLevel=Math.min(leftMax[i],rightMax[i]); 
           trappedWater+=waterLevel-height[i];
        }
        //trapped water=waterlevel-height[i]
        return trappedWater;
    } 
    public static void main(String[] args) {
        int height[]={4,2,0,6,3,2,5};
               
        System.out.println(trappedrainwater(height));
    }
}
