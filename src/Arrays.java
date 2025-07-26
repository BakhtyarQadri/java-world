public class Arrays {
    public static void main(String[] args) {

        var border = "====================";

        // 1st Way
        int[] arr1 = new int[3];
        System.out.println(arr1); //
        System.out.println(java.util.Arrays.toString(arr1));
        System.out.println(border);

        // 2nd Way
        int[] arr2 = {1,2,3};
        System.out.println(arr2); //
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
        System.out.println(border);

        // 3rd Way
        int[] arr3 = new int[] {1,2,3};
        System.out.println(arr3); //
        System.out.println(java.util.Arrays.toString(arr3));

    }
}
