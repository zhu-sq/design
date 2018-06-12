package study;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main{

    public static void main(String[] args) {

        System.out.println(isVaildDate("2018-4-29 16:00:00"));
    }

    private static Boolean isVaildDate(String date){
        Boolean isVail=true;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            isVail=false;
        }
        return isVail;
    }

    static void quicksort1(int n[][], int left, int right) {
        int dp;
        if (left < right) {
            dp = pation1(n, left, right);
            quicksort1(n, left, dp - 1);
            quicksort1(n, dp + 1, right);
        }
    }

    static int pation1(int n[][], int left, int right) {
        int pivot = n[0][left];
        while (left < right) {
            while (left < right && n[0][right] >= pivot)
                right--;
            if (left < right)
                n[left++] = n[right];
            while (left < right && n[0][left] <= pivot)
                left++;
            if (left < right)
                n[right--] = n[left];
        }
        n[0][left] = pivot;
        return left;
    }



    static class Query{
        public int[] query= new int[3];
        public int position;
    }


    public static void main4(String[] args){
        Scanner sc = new Scanner(System.in);

        while(true) {
            int n = sc.nextInt();
            int res = 0, m = 1, s = 1;
            if(n==1 ||n==2){
                System.out.println(1);
                return;
            }
            res = isRight(m,s,1,n,0);
            if(res==0){
                isRight(m,s,2,n,0);
            }
            System.out.print(res);
        }
    }

    public static int isRight(int m,int s,int methes,int target,int res){
        switch (methes){
            case 1:
                m=s;
                s=2*s;
                break;
            case 2:
                s=m+s;
                break;
        }

        res++;
        int tem =0;
        if(s==target){
            return res;
        }else if(s<target){
            tem=isRight(m,s,1,target,res);
            if(tem==0) tem = isRight(m,s,2,target,res);
        }else{
            res=0;
        }
        res=tem;
        return res;
    }

    public static void main5(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k=sc.nextInt();
        int[] arry = new int[n];
        for(int i=0;i<n;i++){
            arry[i] = sc.nextInt();
        }

        quickSort(arry);
        int p=0,res=0;
        for(;p<n;p++){
            int tem=n-1;
            while (true){
                if(arry[tem]-arry[p]<k) break;
                if(arry[tem]-arry[p]==k){
                    res++;
                    break;
                }
                tem = (p+tem-1)/2;

                if((p+tem-1)/2>p){

                }else if(p==tem){

                }else{
                    break;
                }
            }
        }
        System.out.println(res);

    }
    public static void quickSort(int[] arr){
        qsort(arr, 0, arr.length-1);
    }
    private static void qsort(int[] arr, int low, int high){
        if (low < high){
            int pivot=partition(arr, low, high);        //将数组分为两部分
            qsort(arr, low, pivot-1);                   //递归排序左子数组
            qsort(arr, pivot+1, high);                  //递归排序右子数组
        }
    }
    private static int partition(int[] arr, int low, int high){
        int pivot = arr[low];     //枢轴记录
        while (low<high){
            while (low<high && arr[high]>=pivot) --high;
            arr[low]=arr[high];             //交换比枢轴小的记录到左端
            while (low<high && arr[low]<=pivot) ++low;
            arr[high] = arr[low];           //交换比枢轴小的记录到右端
        }
        //扫描完成，枢轴到位
        arr[low] = pivot;
        //返回的是枢轴的位置
        return low;
    }



    public static void main1(){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] users = new int[n];
        for(int i=0;i<n;i++){
            users[i]=sc.nextInt();
        }
        int q = sc.nextInt();

        ArrayList<Query> queries = new ArrayList<>(q);
        for(int i=0;i<q;i++){
            int[] arry=new int[3];
            for(int j=0;j<3;j++){
                arry[j]=sc.nextInt();
            }
            Query query= new Query();
            query.position=i;
            query.query=arry;
            queries.add(query);
        }

        int[] result = new int[q];
        for(int i=1;i<=n;i++){
            for(int j=0;j<queries.size();++j){
                Query itemQuery = queries.get(j);
                if(itemQuery.query[0]<=i && itemQuery.query[1]>=i){
                    if(itemQuery.query[2]==users[i-1]){
                        result[itemQuery.position]++;
                    }
                }else if(itemQuery.query[1]<i){
                    queries.remove(itemQuery);
                }
            }
        }


        for(int i=0;i<q;i++){
            System.out.println(result[i]);
        }

//        int[][] query = new int[q][3];
//        int[] result = new int[q];
//        for(int i=0;i<q;i++){
//            for(int j=0;j<3;j++){
//                query[i][j]=sc.nextInt();
//            }
//        }
//
//
//        for(int i=0;i<q;i++){
//            for(int j=query[i][0];j<=query[i][1];j++){
//                if(users[j-1]==query[i][2])
//                    result[i]++;
//            }
//        }
//
//        for(int i=0;i<q;i++){
//            System.out.println(result[i]);
//        }
    }



}