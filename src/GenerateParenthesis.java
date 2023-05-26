import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate("(",1,0,result,n);
        return result;
    }
     static void generate(String paren,int open, int close,List<String> result,int n){
         //System.out.println(paren);
        if(paren.length() == n*2){ //only allowing if the length of the string is twice the input n.
            result.add(paren);
        }
        if(open<n){// we have already added a "(" at the beginning, so we dont set open<=n
            generate(paren+"(",open+1,close,result,n);
        }
        if(close<open){// we only add closing parentheses when they are less than the existing opening parentheses in the tree
            generate(paren+")",open,close+1,result,n);
        }
    }
    public static void main(String[] args) {
        System.out.println(generateParenthesis(12));
    }
}

// so in this problem we have to generate all possible combinations of parentheses, of length n.

// example - n = 2 ---> ["(())" , "()()"]
// n = 3 ---> ["((()))","(()())","(())()","()(())","()()()"]

//Observations

// from the given set of examples, we can infer that for the given number of n, we return strings of length n*2
// it simply means that for 1 n, we have a pair of opening and closing parentheses so for n = 1, we can work with "(" and ")"

//as for the 2nd observation, we notice that the first parentheses is always an opening parentheses, and that the total number of opening (and closing) parentheses should never exceed n.
// so now lets make a little tree for how the intuition proceeds

//Process

//so we are beginning with a single open bracket as we per our observation, as we proceed down the tree, we will check if the total number of open brackets is less than n, (not <= since we are already starting with an open bracket beforehand)
// to the right of tree, if the condition of open brackets meet, we will add an open bracket to the existing string
//to the left of the tree, we will check if the number of closed brackets is less than the number of existing open brackets in the string and if this condition is satisfied, we will add a close bracket and continue



//                                     (
//                      ((                          ()
//                   x      (()             ()(            x
//                             (())       x    ()()

//the above diagram is a visualisation of the aforementioned process. observe it carefully to have a better understanding of the working
// now we see that this process takes four steps. at every recursive call, we will check if the length of our string is equal to twice of n. twice because we need to return combinations of parentheses pairs so 1 = "(" and ")", and if we satisfy this, we can add the string to the list

//function TraverInOrder(node,list){
//      if(node.left){
//          TraverInOrder(node.left,list);
//      }
//      list.push(node.value)
//      if(node.right){
////          TraverInOrder(node.right,list);
////      }
//      return list;
// }
