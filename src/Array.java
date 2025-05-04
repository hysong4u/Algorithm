import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Array {
    public static void main(String[] args){
        //이차원 배열
        int[][] arr = {{1,2},{1,3}};
        System.out.println(arr[1][1]);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        Collections.sort(list);

        System.out.println(list);


    }

}
