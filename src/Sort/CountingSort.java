package Sort;

public class CountingSort {
    public static void main(String[] args) {
        int maxValue =9;
        int n =15;
        int []arr = {0,3,3,7,4,2,2,9,9,4,5,8,6,6,6};
        int []cnt = new int[maxValue+1];
        for(int i=0;i<n;i++){
            cnt[arr[i]]+=1;
        }//arr에 담긴 element값 갯수 담기
        for(int i=0;i<maxValue+1;i++){
            for(int j=0;j<cnt[i];j++)
                System.out.print(i+" ");
        }


    }
}
