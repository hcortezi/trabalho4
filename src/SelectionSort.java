public class SelectionSort {
    public static void sort(int[] arr) {
        int n = arr.length;
        // Percorre o array inteiro
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Assume que o menor elemento está na posição atual
            // Encontra o menor elemento no restante do array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // Atualiza o índice do menor elemento encontrado
                }
            }
            // Troca o elemento atual com o menor elemento encontrado
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
