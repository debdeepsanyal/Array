import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class SubsetRecursive {
    public static List<List<Integer>> Subsets(int[]nums){
        Arrays.sort(nums);
        List<List<Integer>> final_list = new ArrayList<>();
        generate(0,nums, new ArrayList<>(), final_list);
        return final_list;
    }
    public static void generate(int start, int[]nums, List<Integer> list, List<List<Integer>> final_list){
        final_list.add(new ArrayList<>(list));
        for(int i = start; i< nums.length; i++){
            System.out.println(i);
            list.add(nums[i]);
            generate(i+1,nums,list,final_list);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
        System.out.println(Subsets(new int[]{2,5,2,1,2}));
    }


}

//lets review how this recursion is working. initially, our list is empty. so when we execute the first line of the function, our empty list gets added to our empty final_list, which makes it look like [[]].
//then, we step inside the loop. the loop starts from 0, and first we add the 0th element to our list, making teh list [1], and then we move to the next recursive call, with 1 as index.

// call stack rn  |          |
//                |          |     --> the generate of 0 function is present above the main() and after calling generate(1), it will chill in the stack till the above functions are done working
//                |_gen_(0)__|
//                |___main___|
//

//so when generate(1) is called, in the first step we are adding the list containing [1] that we had passed as argument in the function call to our final_list, which now looks like [[],[1]]
//and the we enter the loop, we add the 2nd element to our list and now it looks like [1,2] and we make a recursive cal again, passing 2 as the index


// call stack rn  |          |
//                |_gen_(1)__|     -->the gen(1) function also implements recursion passing index as 2, and retires to the call stack
//                |_gen_(0)__|
//                |___main___|
//

// we have 2 as the index, and as usual, we add the current list to our final_list [[],[1],[1,2]].
//we enter the loop, index as 3. we add the 2nd element of the array to the list, making it [1,2,3], and this again implements recursion, passing 3 as the next index

// call stack rn  |_gen_(2)__|
//                |_gen_(1)__|     -->the gen(2) function also implements recursion passing index as 3, and retires to the call stack
//                |_gen_(0)__|
//                |___main___|
//

//having 3 as the index, our first task is to add the updated list to our final list, which now looks like [[],[1],[1,2],[1,2,3].
//but now, with the index as 3, it will never enter the loop body since the length of the input array is 3 and according to the conditions of the loop, 3 is not less than 3, so this function generation(3) terminates and gets popped off from the stack


//and we are back to gen(2) now, which will remove the last element from the list now, so our list looks like [1,2]. and with this, gen(2) too terminates and will pop from the stack since the loop would end as 2 is the last number which can be iterated over (2 < 3).

// call stack rn  |          |
//                |_gen_(1)__|     -->the gen(2) function has popped, and the control is back to gen(1).
//                |_gen_(0)__|
//                |___main___|
//


//with the control back to gen(1), it will resume from the function call and will delete the last element from the list, making it [1], and now the loop continues, i++ making the index 2.
//with 2, we add the 2nd element to our existing list making it look like [1,3] and we enter the recursive call again with 3 as the index, which would simply add [1,3] to the final list, making it look like [[],[1],[1,2],[1,2,3],[1,3] and terminate like it did in the above function.
//so after this call, gen(1) (now gen(2)) will remove the last element from the list making it [1] and stop iterating, since the index is now 3 which simply wont enter the loop, and with this we are back to the control of gen(0).

// call stack rn  |          |
//                |          |
//                |_gen_(0)__|
//                |___main___|
//

//and gen(0) too will remove the last element from the list, and now we are back to the empty list, and this loop will iterate, with the index as 1.

// call stack rn  |          |
//                |          |     --> the generate of 0 function is present above the main() and after calling generate(1), it will chill in the stack till the above functions are done working
//                |_gen_(1)__|
//                |___main___|
//

//and from here, the same steps will be repeated.