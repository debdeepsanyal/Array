import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list1 = new ArrayList<>();
        List<List<Integer>> final_list = new ArrayList<>();
        list1.add(new ArrayList<>());
        for(int num =1 ; num<=n; num++ ){
            int j = list1.size(); //in this step, we are fixing the size of the list to as it was before we enter the inner loop, because while in the inner loop, we are updating this list.
            for(int i = 0; i<j;i++){ //and had we set this i<list1.size(), we couldnt have worked on the elements priorly present in the loop since everytime this loop runs, list1.size() changes
                List<Integer> temp = new ArrayList<>(list1.get(i));
                temp.add(num);
                list1.add(temp);
            }
        }
        for(int i = 0; i<list1.size(); i++){//in this step, we are fixing the size of the list to as it was before we enter the inner loop, because while in the inner loop, we are updating this list.
            if(list1.get(i).size() == k){//and had we set this i<list1.size(), we couldnt have worked on the elements priorly present in the loop since everytime this loop runs, list1.size() changes
                final_list.add(list1.get(i));
            }
        }
        return final_list;
    }

    public static void main(String[] args) {
        System.out.println(combine(6,2));
    }
}
//so the approach to this problem is quite similar to our subsets problem. unlike the subsets problem,we are not provided with an array here, so we need to make 1.


//Step 1 --> Create subsets of all elements in the from 1 to n.

//to create subsets, we will apply the same algorithm that we used in the subsets problem.
//first step we add a null set to the list1
//then we loop from 1 to n.
// for every element, we are adding that element to every list present in the list1, and we need a loop for the same.
// so in the first iteration, we are adding 1 to the only element present in the list1, i.e. the null set.
//in the next iteration, there are 2 elements in the list 1, we will loop through them and add the next number in the loop of 1 to n (for iteration 2 it is 2) to the 2 present lists in loop 1.
// in 3rd iteration, we will be adding the 3rd element to the 3 lists present in list 1, and this process will continue till we have done the process for all the elements from 1 to n.
//now once we are finished with this operation, we will have all possible subsets of numbers from 1 to n in our list 1, but we need only the lists which is of size k.

// Step 2 --> Filter out elements from list1, and add the rest to our final list

//in this step, we simply if size of every element of list 1 is equal to the k mentioned in the arguments, if so, we pass them to our final list.

//and we are done, we have the combination. this code works.
