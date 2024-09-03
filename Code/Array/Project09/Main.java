package Code.Array.Project09;

public class Main {
    public int findMissingNumber(int[] arr){
        int n = arr.length + 1;
        int sum = n * (n + 1)/2;
        for(int i = 0; i < arr.length; i++){
            sum = sum - arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Main myObj = new Main();
        int[] arr = {2,4,1,8,6,3,7};
        int missingNumber = myObj.findMissingNumber(arr);
        System.out.println("Missing Number :- " + missingNumber);
    }
}
