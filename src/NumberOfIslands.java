public class NumberOfIslands {
    public static int numIslands(char[][] grid) { //hi again, hope you are here after having read whatever there is at the bottom
        if(grid.length==0){ //so teh first thing is that we check if the inputted character is null and if so we return 0, cuz well there are 0 islands if there is no water and land
            return 0;
        }
        int islands = 0; //this is the counter for our number of islands, the variable we are going to return
        for(int row =0; row<grid.length; row++){ //loops for checking each element in the matrix, each keeping count of the row and the column
            for(int column = 0; column<grid[0].length; column++){
                if(grid[row][column]=='1'){ //if the element is '1', i.e. if its a piece of land, we call oyr recursive function
                    dfs(grid,row,column);//lets head down
                    islands++;
                }
            }
        }
        return islands;
    }
    public static void dfs(char[][]grid,int row, int column){ //now what does our function exactly do? we check how big is a piece of land. yep, thats all. how do we do that? we check if the elements to the right, left, top and bottom are pieces of land as well, and if so,
                                                                // we move over to them and check if the pieces to their right, left, top and bottom is a land and this thing continues till there is no more land to either of these 4 sides. as we traverse through them, before moving to the next one,
        //                                                          we set the current piece of land to water, so that when we are backtracking, we dont encounter the same piece of land twice, which would break our recursion. if this seemed confusing, again, dont fear, just hold on dont give up, we will be delving even deeper

        if(row<0 || column<0 || row> grid.length -1 || column> grid[0].length - 1){ //this as you see, is our first base case what does it tell, well ofc, we are moving to all four sides from the current element, so we need to be careful about the bound of the array, and thats all we are checking here
            return;
        }
        if(grid[row][column]=='0'){ //whats this for? now what does this function do? we are checking how big is a piece of land right? so ofcourse if we encounter a piece if water, we know we have reached the end. also, as we are traversing through the pieces of lands, before we move on to the next one, we are making them '0',
                                    // so when we backtrack and we move back to the same index from where we moved ahead, its 0 by then, and we can return
            return;
        }
        grid[row][column] = '0'; //setting the piece of land to '0' before traversing to the next one, this step is important and comes to use when we are backtracking and then prevents the code from breaking down
        dfs(grid,row+1,column); //alright we have reached the recursion part of the code, lets understand whats really happening, head down south again now
        dfs(grid,row-1,column);
        dfs(grid,row,column-1);
        dfs(grid,row,column+1);

    }

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}));
    }
}
//alright, this is the journal to leetcode number 200, a medium array problem. we're not describing what should be done in this problem since we can easily refer to the leetcode page for the details, so lets us first discuss the intuition behind solving this problem
//so '1' is a piece of land and '0' is a piece of water. if there is a piece of land to the left or right or top or bottom of any piece of land, it is considered as a single chunk of land and not individual pieces.
//how do we proceed? well the intuition is to traverse through all the '1's placed in a contiguous sector and consider them as a single piece of land, thus increasing the island counter by 1. now, this didnt make sense right? okay lets delve a bit deeper

// so we have this piece of input --->       1  1  1  1  0
//                                           1  1  0  1  0
//                                           1  1  0  0  0
//                                           0  0  0  0  0

// now what do our eyes see? we see a single large piece of land right? so theres just 1 island, okay heres how the single chunk looks

//                                             1  1  1  1
///                                            1  1     1           <-- this is the piece of land right? now ho do we traverse over this
////                                           1  1
////

//now ofc we use recursion, more specifically, we will be using Depth First Search, which is a special application of recursion.
//how do we make use of dfs in this case? well, we tell our recursive function that hey, if the element at these indices i provided you is '1', can you please make this 0, and ask four recursive functions, one having indices for the element to its right, one to the left, one to the top and one the bottom, to check if they are '1' too and carry on like this?

// now alright alright alright that seemed a lot. yes, cuz well, recursion. but hey, fear not cuz we are going to the depth of this, if you have to fear something, fear giving up before having a grasp on this problem.

// for step one, refer to line by line descriptions now, and we will be waiting here when you come back(just like a recursive functions waits in the call stack till the next one is done).

// and we are back again from the line of recursion, now lets visualise the recursion -->

//so our first element itself is '1', and we enter the function dfs, we dont meet any of the base cases, we set the current element to 0, and check the bottom element (row+1) what happens next,

//                                            '0'  1  1  1  0       the matrix before executing the next recursive call, notice how the current element(between the ''s) is 0 now.
////                                           1  1  0  1  0
////                                           1  1  0  0  0
////                                           0  0  0  0  0

// in the second iteration this is how the matrix looks like
//                                             0  1  1  1  0
////                                          '1'  1  0  1  0  -- positioned at the '1' in next row
////                                           1  1  0  0  0
////                                           0  0  0  0  0

// before 2nd recursive call -->               0  1  1  1  0
////                                          '0'  1  0  1  0   -- element is 0 before moving to the next row
////                                           1  1  0  0  0
////                                           0  0  0  0  0

//similar to above iterations -->                0  1  1  1  0
//////                                           0  1  0  1  0
//////                                          '0'  1  0  0  0
//////                                           0  0  0  0  0

//now we move to the next step -->               0  1  1  1  0
//////                                           0  1  0  1  0     -->in this step, the position is already 0, and as per our base case, we exit, and we are back at the previous position
//////                                           0  1  0  0  0
//////                                          '0'  0  0  0  0

// back to here                 -->              0  1  1  1  0
//////                                           0  1  0  1  0    --> now once we are back here, we have executed the first line (out of 4) of our recursive functions, and we can safely move on to the next one
//////                                          '0'  1  0  0  0
//////                                           0  0  0  0  0

//the next function checks the row above, which already is 0, and we will backtrack to this position once again, having executed 2 out of 4 functions

//he next function checks the column previous to this, but since we are in the 0th column, we again will meet the base case checking the bounds and we will backtrack to this position

//now its time for the last function check, which checks the next column element, and voila! we have a '1', which means we can safely move ahead from this position


//                                                 0  1  1  1  0
////////                                           0  1  0  1  0
////////                                          0  '0'  0  0  0    --> we change this 1 to 0
////////                                           0  0  0  0  0

//again for the next function, we will check the first recursive function which checks the bottom element, and as we can see, the bottom element is 0, so we will go there, meet the base case, backtrack back to this position, ready to execute the 2nd line of recursive call

//as per the secnod line of recursion, we check if the element above is '1' and it sure is. so we move on

// and this is how the function flow goes. in the last step when everything is 0, it will meet the base case and exit, and the function before will process to execute the next lines of recursion but will find 0 everywhere and eventually like this, all functions will get popped off from the call stack

//and the dfs called in the main function will also pop from the stack, and we are back to the flow of the main function, and now we execute islands++, making it 1. and we return 1. the outer for loop will run again but will find every element to be '0' so, it will never again enter the if(grid[row][column]=='1'){ part, hence terminating the program