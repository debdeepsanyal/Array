public class waterContainer {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,3,2,5,2,6}));
    }
//    public static int maxArea(int[] height) {  //this was the naive approach with O(n^2) complexity
//        int volume,final_volume = 0, c = 1;
//        for(int i = 0; i<height.length; i++){
//            c=1;
//            for(int j = i+1; j<height.length; j++){
//                if(height[j]>height[i]){
//                    volume = c*height[i];
//                }
//                else{
//                    volume = c*height[j];
//                }
//                if(volume>final_volume){
//                    final_volume = volume;
//                }
//                c++;
//            }
//        }
//        return final_volume;
//    }
//so what we are doing in this problem is that for every height we are checking the volume of water it can make with consecutive heights and we are storing the max volume.
//if the height of the consecutive bar is greater than the one we are checking against, we simply consider the height of the smaller bar and  multiply it with the breadth, which increases with each loop
    public static int maxArea(int[]height){
        int volume,c= height.length-1,max_volume=0,k = 0, l = height.length -1 ;
        while(k<l){
            int left = height[k];
            int right = height[l];
            volume = Math.min(left,right) * c;
            if(volume>max_volume){
                max_volume = volume;
            }
            if(left<right){
                k++;
            }
            else{
                l--;
            }
            c--;
        }
        return max_volume;
    }
}
//this approach is well documented in the copy
