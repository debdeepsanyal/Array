import java.util.Arrays;
import java.util.HashSet;

public class removeDuplicates_leet {
    public static int removeDuplicates(int[] nums) {
        int check = nums[0];
        int c,c1;
        if(nums[0]<0){
            c=0;
        }
        else{
            c=nums[0];
        }
        c1=c;
        HashSet<Integer> hash = new HashSet<>();
        for(int i = 0; i<nums.length; i++){ //this makes a O(n)
            if(nums[i]>check){
                if(!hash.contains(nums[i])){
                    hash.add(nums[i]);
                    check = nums[i];
                }
            }
        }
        System.out.println(hash);
        System.out.println(check);
        for(int i = 0; i< nums.length; i++){
            if(i==0){
                c++;
                continue;
            }
            c++;
            if(nums[i]<=nums[i-1]){
                c--;
                if(c<=check){
                    if(hash.contains(c)){
                        nums[i] = c;
                    }
                    else{
                        nums[i] = check;
                        System.out.println(Arrays.toString(nums));
                        System.out.println("********");
                        //System.out.println(c+1);
                        return c+1;
                    }
                }
                else{
                    System.out.println(Arrays.toString(nums));
                    return c-c1;
                }
                c++;
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println("---------");
        return c;
    }

    public static void main(String[] args) {
        //System.out.println(removeDuplicates(new int[]{-3,-1,-1,0,0,0,0,0,2}));
        Integer i = 234;
        String i1 = i.toString();
        System.out.println(i1.length());

    }
}
