public class BubbleSort {
    public static void sort(int[] arr) {
        int n = arr.length;
        // Realiza várias passagens pelo array
        for (int i = 0; i < n - 1; i++) {
            // Comparações de elementos adjacentes
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Troca elementos se estiverem fora de ordem
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
