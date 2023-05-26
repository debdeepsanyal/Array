public class ArraySortCheckRecursion {
    public static void main(String[] args) {
        int[] array = new int[]{1,1,2,4,6};
        System.out.println(check(array,1));
    }
    static boolean check(int[]array, int index){
        if(index== array.length){
            return true;
        }
        if(array[index]>=array[index-1]){
            return check(array,index+1);
        }
        else{
            return false;
        }
    }
}
