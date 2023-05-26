import java.util.Scanner;
public class Name {
    public static void main(String[] args) {
        int j = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name ");
        String name = sc.nextLine();
        String newName = "";
        name=name.trim();
        for(int i = 0; i<name.length(); i++){
            if(name.charAt(i)==' '){ //rahul kumar shit
                newName+=name.charAt(j) + ".";
                j=i+1;
            }
            if(i==name.lastIndexOf(' ')){
                newName+=name.substring(i+1);
            }
        }
        System.out.println(newName);
    }
}
