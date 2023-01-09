package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearch_Practice3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        //n(입력될 떡의 개수) m(자르고 오른쪽 떡의 양)
        String []input = s.split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int [] arr =new int[n];
        s= br.readLine();
        String [] dduckLen = s.split(" ");
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(dduckLen[i]);
        }
        int start = 0;
        int end = (int)(1e9);//10억
        int answer = 0;
        while (start <= end) {
            int dducksum =0;
            int mid =(start+end)/2;//중간값
            //잘려진(오른쪽) 떡의 총합
            for(int i=0;i<n;i++){
                if(arr[i]>mid)
                    dducksum +=arr[i]-mid;
            }
            //짤려진(오른쪽) 떡의 양이 합이 요구된 m보다 크다면?
            if(dducksum>m)
                start = mid+1;
            else{
                answer = mid;
                end=mid-1;
            }
            System.out.println("절단기 높이의 최댓값은>>"+answer);
            // Binary Search 과정을 확인할 수 있음...

        }

    }
}
