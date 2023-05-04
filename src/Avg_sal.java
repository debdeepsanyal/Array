import java.util.Arrays;

class Avg_sal {
    public static double average(int[] salary) {
        boolean t = true;
        int i = 0, j = 0,c = 0;
        while (t){
            if(j< salary.length){
                if(salary[i]<=salary[j]){
                    j++;
                    c++;
                    continue;
                }
                else{
                    i++;
                    j=0;
                    c=0;
                    continue;
                }
            }
            System.out.println(c);
            if(c== salary.length){
                salary[i] = 0;
                System.out.println(Arrays.toString(salary));
                break;
            }
        }
        i = 0;
        j=0;
        c=0;
        while (t){
            if(j< salary.length){
                if(salary[i]>=salary[j]){
                    j++;
                    c++;
                    continue;
                }
                else{
                    i++;
                    j=0;
                    c=0;
                    continue;
                }
            }
            if(c== salary.length){
                salary[i] = 0;
                System.out.println(Arrays.toString(salary));
                break;
            }
        }
        c=0;
        double sum = 0;
        for(i=0;i< salary.length;i++){
            if(salary[i] == 0){
                continue;
            }
            sum+=salary[i];
            c++;
        }
        return sum/c;
    }
    public static void main(String[] args) {
        int [] sal = new int[]{6000,1000,3000,10000,4000};
        //System.out.println(Arrays.toString(sal));
        average(sal);

    }
}