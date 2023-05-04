import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class SubSet {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>final_list = new ArrayList<>();
        final_list.add(new ArrayList<>()); //the first step, we are adding an empty subset to our list which serves as the base to following subsets
        for(int num : nums){ //we are looping through all the items in the array nums
            int n = final_list.size();
//            System.out.println("--------");
//            System.out.println(n);
//            System.out.println("--------");
            for(int i = 0; i<n;i++){

                List<Integer> temp = new ArrayList<>(final_list.get(i)); // here, for every temporary list that we are creating, the list which contains all the elements and gets added ot the final_list,
//                                                                        // we are importing the previous elements and adding the new ones to them, one by one
//                System.out.println("**********");
//                System.out.println(temp);
//                System.out.println("**********");
                temp.add(num);
//                System.out.println("^^^^^^^^^");
//                System.out.println(temp);
//                System.out.println("^^^^^^^^^");
                final_list.add(temp);
            }
        }
        return final_list;
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3,6,9}));
    }
}

//so the approach to solving this problem is that initially, no matter what, we are adding an empty list to our final_list, since we know that no matter what the combinations will be, this will be a common element and our basic building block for the other combinations.
// after adding the empty set, we are beginning our final set with 1 element(i.e. the length of our final list is 1).
// the next step we take is looping through the elements of the array we are provided with. for every element, we run a loop from 0 to 1 less than the current length of the final list, to access all the present elements in our final list.
//so for the first element, the length of the final list is 1 and we are looping from 0 to <1, i.e. the loop runs one time.
// in the loop we create a temporary list for storing the new combinations, and the first thing we do, is add the ith element from the final list (this i is of the loop running from 0 to final_list.length - 1), to this temporary list that we created in this loop
// so for the first element, we are adding the empty list to the temporary list, and then, we add the array element from the outer loop, i.e we are adding the first element to the empty list that we just added to our temp list and we are adding this updates temp list, which now only has the first element of the array(since adding anything to a null/empty list results in that element itself).
// now our final list has 2 elements, the initial empty list and the newly added first element. this marks the end of the inner loop and we revert back to the outer loop.
//now it is worth noticing that everytime we are looping back to the outer loop, the length of the final list is updated, for we are adding elements to the inner loop.
//now, the final list consists of the initial mull set and the first element. now we again enter the inner loop, about to loop through the elements of the final loop. now we since the size of the final list has been updated, this loop will run twice now.
//for the first iteration, we are adding the 1st element of the final list, i.e. the null set to our temp list(which is empty now since it gets reset everytime we enter the inner loop). the second element get added to the null set, and we get a element to be added to the final list.
//for the 2nd iteration, the set with the first element in the final list will be added to the temp list and we are adding the 2nd element to the list of the first element, so we yield a set which consists of both the first and the second element, and we add this list to our final list.
//and this is how the process continues
//in this algo, or every element of the array looping through the inner loop, 2^n times the loop index is being added.
//for the 1st element or the 0th index, only 1 element is  being added to the list, that is the first array element.
//for the 2nd iteration(1st index), 2 elements are being added (2^1). similarly for index 2 (2^2) 4 elements are added.
//so for every iteration, if n number of elements are present in the final list, n number of elements get added. (if 2 elements are present in the final list, 2 more elements will be added in the iteration)