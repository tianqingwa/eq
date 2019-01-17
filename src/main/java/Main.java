/**
 * @author tianqinghua
 * @date 2018/12/23 14:43
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        int s = in.nextInt();
//        int q = in.nextInt();
//        int temp = 0;
//        int xz = s;
//        int tg = 0;
//        int count = 1;
//        while (tg < t) {
//            xz += q - 1;
//            if (xz > t) {
//                xz = t;
//            }
//            tg += q;
//            if (tg > t) {
//                tg = t;
//            }
//            if (tg >= xz &&tg!=t) {
//                ++count;
//                tg = 0;
//            }
//
//        }
//        System.out.println(count);
        int n = in.nextInt();
        double[] arr = new double[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = in.nextDouble();
        }
        for (int i=0;i<arr.length;++i){
            System.out.print(accu(arr,arr[i])+" ");
        }

    }
    public static int accu(double[]arr,double e){
        int res=0;
        for (int i=0;i<arr.length;++i){
            res+=(int)(e/(arr[i]+1));
        }
        return res;
    }
}