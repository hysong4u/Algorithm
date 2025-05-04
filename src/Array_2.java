import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import static java.util.Arrays.stream;

public class Array_2
{
   public static int[] solution_1 (int[] arr) {
       int[] clone = arr;
       Arrays.sort(clone);
       return clone;
   }

   public static int[] solution_2(int[] arr){
       return stream(arr)
               .distinct()
               .boxed()
               .sorted(Collections.reverseOrder())
               .mapToInt(Integer::intValue)
               .toArray();
   }
    public static int[] solution_3(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i <arr.length-1; i++){
            for(int j = i+1 ; j<arr.length; j++){
                set.add(arr[i] + arr[j]);
            }
        }
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();

    }

   public static void main(String[] args){
       int[] org = {1,2,3,4,5};
       System.out.print(org.length);
       int[] sorted = solution_3(org);
       System.out.println(Arrays.toString(sorted));
   }


}
