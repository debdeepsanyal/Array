import java.util.*;

public class LetterCombinationOfPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        HashMap<String,String> map = new HashMap<>(); //declaring a HashMap for storing the associated strings
        List<String> list = new ArrayList<>();//the list in which we will return our strings
        map.put("2","abc");map.put("3","def");map.put("4","ghi");map.put("5","jkl") //in this line and the next we are simply tapping in the strings to the digits they associate to, as we do in a HashMap
        ;map.put("6","mno");map.put("7","pqrs");map.put("8","tuv");map.put("9","wxyz");
        if(digits.length() == 0){ //now in this step we check in the input string is an empty string, i.e. "", in that case we would simply return an empty list. work done there
            return list;
        }
        Deque<String> deque = new ArrayDeque<>(); //here, we declare the double ended Queue or Deque
        deque.add(""); //now we are adding an empty string to the deque first, and we will shortly get into the significance of this step, just hold on, dont give up
        for(int i = 0; i<digits.length(); i++){ //in this loop, we are dissecting the input string one digit at a time, suppose the input string is 432, so we want the digit 4 first and then operate on it, then 3 and operate on it and then 2.
            String s = map.get(String.valueOf(digits.charAt(i)));// long line, but no fear, cuz what even will you be afraid of without trying. lets break this down. digits.charAt(i) --> gives the first digit from the inputted string, i.e. if its 432, we get '4', note that we are getting a char value and not a string value
                                                                //String.valueOf(digits.charAt(i)) now simply translates to --> String.valueOf('4'), which simply returns "4", as a String, not a character. why do we need a string? character seemed just fine. well, why are we really extracting this "4", to tap into the associated string "ghi" right
                                                                //so if you observe our HashMap carefully, both the datatypes in our diamond brackets is String, which means the digits which are serving as the key values are of String datatype. thus, the value we extract needs to be of String datatype too. now yes we couldve passed the digits as chars to the HashMap but, its okay. we get the logic

            int n = deque.size(); //here we are storing the length of our deque, which now is 1 since we are storing a null string in it at the moment
            for(int j = 0; j< n; j++){ //heres a loop which iterates till the current length of the deque.
                String pull = deque.pollFirst(); //in the first step, we extract the foremost value of the deque, like we do in any Queue with the poll() function, following the FIFO technique. in the first iteration it simply extracts the "", and now our deque is totally empty.
                for(int k=0; k <s.length();k++){ //here we iterate over the tapped in string of thr digit, for "4", it was "ghi", so we are looping over "ghi"
                    String temp = pull.concat(String.valueOf(s.charAt(k)));//now we simply add the individual characters from our "ghi" and them to the foremost element of the deque we extracted. which means that since we extracted "" in the first step, our temp becomes "g", "h", and "i" respectively.
                    deque.add(temp); //the string gets added to the deque. in the first iteration "g" gets added, followed by "h" and "i". so now, our deque looks like ["g", "h","i"]
                }
            }//refer to the bottom section for the next part
        }
        while(!deque.isEmpty()) {
            list.add(deque.poll());
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("2"));
    }
}
//so lets have a go at how to solve this problem. so we have numbers, and a certain string associated to those numbers. like for 2, we have a string "abc" associated with it.
//this association reminds us of a HashMap, a key and a value. let the key be the number, and we tap into the number to get the associated string. so now we have a way to access the string by inputting digits (in the form of string).
// now here, we are using a doubly Queue (Deque), which simply means that its a special form of Queue which supports insertion and removal of elements from either sides, as in contrast to a normal Queue, which works on the FIFO technique.
// so what we do is we keep inserting characters to our Deque, remove them from the beginning, only to concat them to the next set of characters from the next string. didnt make much sense right? yep, so lets delve deeper, refer to the code for step by step anatomy


//hopefully now, we have an understanding of how the first iteration works, our deque now looking like ["g","h","i"], now we go back to line 15, and we extract the next digit from our argument string, we have already extracted and operated on "4", th next is "3".
// so again we tap into the values associated with "3" and we have our String s as "def", and next we store the length of our queue in n, which now, is 3. we again loop through our deque elements, extracting the first element from the deque, which is now "g". and in the next loop, we are adding "g" to every element of "def"
// which yields "gd", "ge", "gf"; and we are adding these values to our deque. so after this iteration, our deque looks like ["h", "i", "gd", "ge", "gf"].
//in a similar fashion we extract "h" from our queue in the next iteration the deque looks like ["i", "gd", "ge", "gf","hd", "he", "hf"].
//and finally we will be having ["gd", "ge", "gf","hd", "he", "hf", "id", "ie", "if"]. and voila, our second iteration is complete.
//for the last digit in our inputted string, i.e. "2", we follow a similar pattern, we store the tapped value "abc", iterate over the current length of our deque, which is 9 now, and extract every of those 9 values from the beginning and add them to every character of the tapped in values of "2".
//it is pointless to go step by step over the entire process again but we will just show the iteration in each step.


//["gd", "ge", "gf","hd", "he", "hf", "id", "ie", "if"]
//["ge", "gf","hd", "he", "hf", "id", "ie", "if", "gda", "gdb", "gdc"]
//["gf","hd", "he", "hf", "id", "ie", "if", "gda", "gdb", "gdc", "gea", "geb", "gec"]
//["hd", "he", "hf", "id", "ie", "if", gda", "gdb", "gdc", "gea", "geb", "gec","gfa", "gfb", "gfc ]
//["he", "hf", "id", "ie", "if", gda", "gdb", "gdc", "gea", "geb", "gec","gfa", "gfb", "gfc, "hda", "hdb", "hdc ]
//["hf", "id", "ie", "if", gda", "gdb", "gdc", "gea", "geb", "gec","gfa", "gfb", "gfc, "hda", "hdb", "hdc", "hea", "heb", "hec"]
//["id", "ie", "if", gda", "gdb", "gdc", "gea", "geb", "gec","gfa", "gfb", "gfc, "hda", "hdb", "hdc", "hea", "heb", "hec", "hfa", "hfb", "hfc"]
//["ie", "if", gda", "gdb", "gdc", "gea", "geb", "gec","gfa", "gfb", "gfc, "hda", "hdb", "hdc", "hea", "heb", "hec", "hfa", "hfb", "hfc", "ida", "idb", "idc"]
//["if", "gda", "gdb", "gdc", "gea", "geb", "gec","gfa", "gfb", "gfc, "hda", "hdb", "hdc", "hea", "heb", "hec", "hfa", "hfb", "hfc", "ida", "idb", "idc", "iea", "ieb", "iec"]
//["gda", "gdb", "gdc", "gea", "geb", "gec","gfa", "gfb", "gfc, "hda", "hdb", "hdc", "hea", "heb", "hec", "hfa", "hfb", "hfc", "ida", "idb", "idc", "iea", "ieb", "ifc", "ifa", "ifb", "ifc"]

//and thats how we complete with our desired list. i hope its a bit clear now, its simple, extract first element from deque, and keep adding new elements to it, keep adding concatenated strings to the deque
