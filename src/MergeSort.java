public class MergeSort {
    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2; // Divide o array ao meio
            // Ordena a primeira metade
            sort(arr, left, middle);
            // Ordena a segunda metade
            sort(arr, middle + 1, right);
            // Junta as duas metades ordenadas
            merge(arr, left, middle, right);
        }
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1; // Tamanho da primeira metade
        int n2 = right - middle;    // Tamanho da segunda metade
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copia dados para os arrays temporários L[] e R[]
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, middle + 1, R, 0, n2);

        int i = 0, j = 0;
        int k = left;
        // Junta os arrays L[] e R[] em ordem
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        // Copia os elementos restantes de L[], se houver
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        // Copia os elementos restantes de R[], se houver
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
