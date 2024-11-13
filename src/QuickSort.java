public class QuickSort {
    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high); // Encontra o ponto de divisão
            // Ordena os elementos à esquerda do pivô
            sort(arr, low, pivotIndex - 1);
            // Ordena os elementos à direita do pivô
            sort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Escolhe o último elemento como pivô
        int i = (low - 1); // Índice do menor elemento
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Troca elementos menores que o pivô
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Coloca o pivô na posição correta
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1; // Retorna o índice do pivô
    }
}
