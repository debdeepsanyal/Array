import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num); //here we are simply copying the contents of the array to a hash set
        }

        int longest = 0;
        for (int n : nums) { //we are again looping through all the items in the array
            // check if it's the start of a sequence
            if (!numSet.contains(n - 1)) { //to check the beginning of a sequence, we are checking if the current number is the starting of a sequence. How are we doing that? we are simply checking if our hash contains the number prior to our current element.
                                                //suppose our current looping element is 1, and how do we check if 1 is the beginning of a sequence? we simply check if we have 0 in our hashSet. if we do have 0, 1 can never be the first element of a sequence, and so we cannot start counting from 1 we have to start counting from 0 (if -1 is not present in the set)

                int length = 0;
                while (numSet.contains(n + length)) { //here we are checking the length of the sequence. suppose 1 is the starting of a sequence.
                                                        //for the first iteration, set does contain 1+0, and so we increment the length. next, we check if he set contains 1+1, if it does, the next time we check 1+2 and so on
                    length++;
                }
                longest = Math.max(length, longest);//since the first time longest is 0, the current length of the sequence is stored, for the next sequence, we are going to compare the length of that sequence with the length of the previous sequence.
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{9,1,4,7,3,-1,0,5,8,6}));
    }
}
