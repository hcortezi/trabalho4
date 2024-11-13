public class InsertionSort {
    public static void sort(int[] arr) {
        // Itera sobre cada elemento a partir do segundo
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i]; // Armazena o valor do elemento atual
            int j = i - 1;
            // Desloca os elementos maiores que a chave uma posição à frente
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key; // Insere a chave na posição correta
        }
    }
}
