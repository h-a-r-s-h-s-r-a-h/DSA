package Code.TimeComplexity.Project01;

public class Main {
    public static void main(String[] args) {
        double now = System.currentTimeMillis();
        Main myObj = new Main();
        System.out.println(myObj.findSum1(99999));
//        System.out.println(myObj.findSum2(99999));
        System.out.println("Time taken - " + (System.currentTimeMillis() - now) + " millisecs. ");
    }

    public int findSum1(int n){
        return n * (n + 1) / 2;
    }

    public int findSum2(int n){
        int sum = 0;
        for(int i=1; i<=n; i++){
            sum = sum + i;
        }
        return sum;
    }

}