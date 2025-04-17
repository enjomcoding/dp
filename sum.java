class sum{
    public static void main(String[] args) {
        int n = 5;
        int[] arr = new int[n + 1];
        for(int i = 1; i <= arr.length - 1; i++){
            arr[i] = arr[i - 1] + i;
        }
        System.out.println(arr[n]);
    }
}