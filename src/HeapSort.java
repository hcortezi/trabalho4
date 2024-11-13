public class HeapSort {
    public static void sort(int[] arr) {
        int n = arr.length;
        // Constrói um max-heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // Extrai elementos do heap
        for (int i = n - 1; i > 0; i--) {
            // Move a raiz para o fim
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // Chama heapify na subárvore reduzida
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // Inicializa o maior como a raiz
        int left = 2 * i + 1; // Filho à esquerda
        int right = 2 * i + 2; // Filho à direita

        // Se o filho à esquerda é maior que a raiz
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        // Se o filho à direita é maior que o maior até agora
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        // Se o maior não é a raiz, troca os elementos
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            // Recursivamente aplica heapify à subárvore
            heapify(arr, n, largest);
        }
    }
}
