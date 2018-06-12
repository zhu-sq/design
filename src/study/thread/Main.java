package study.thread;

import java.util.*;
public class Main {

    public static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arry =  new int[n];
        for(int i=0;i<n;i++){
            arry[i]=sc.nextInt();
        }

        arry=solve(arry);
        for(int i=0;i<n;i++){
            System.out.println(arry[i]);
        }
    }

    static int[] solve(int[] a) {
        int len =a.length;
        if(len==1){
            return new int[]{a[len-1]};
        }
        if(len==2){
            return new int[]{a[len-2]+a[len-1],a[len-1]};
        }
        if(len==3){
            return new int[]{a[len-3]-a[len-1]+a[len+1]};
        }
        int[] res = new int[len];
        res[len-1]=a[len-1];
        res[len-2]=a[len-2]-a[len-1];
        res[len-3]=a[len-3]-a[len-1]+a[len-2];
        solveItem(len-4,a,res);
        return  res;
    }

     static void solveItem(int p,int[] a,int[] res){
        if(p<1) return;
        res[p]=a[p]-a[p+1]+res[p+2];
        solveItem(p-1,a,res);
    }

    public static  void main5(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arry[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arry[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            int j=n-1;
            for(;j>0;j--){
                System.out.printf("%d ",arry[j][i]);
            }
            System.out.printf("%d\n",arry[j][i]);
        }
    }

    public static  void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arry[][] = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arry[i][j]=sc.nextInt();
            }
        }


        for(int i=0;i<n;i++){
            int j=n-1;
            for(;j>0;j--){
                System.out.printf("%d ",arry[j][i]);
            }
            System.out.print(arry[j][i]);
            System.out.printf("\n");
        }
    }

    public static  void main1(String[] args){
        Scanner sc= new Scanner(System.in);
        int n =sc.nextInt();
        int[] arry = new int[n];
        for(int i=0;i<n;i++){
            arry[i]=sc.nextInt();
        }

        int zeroNum=0;
        int p=0;
        for(int i=0;i<n;i++){
            if(arry[i]!=0){
                arry[p++]=arry[i];

            }else{
                ++zeroNum;
            }
        }


    }
}
//10 2 0 1 5 6 0 2 1 0 0
