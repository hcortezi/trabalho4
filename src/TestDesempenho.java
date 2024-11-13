import java.util.Arrays;
import java.util.Random;

public class TestDesempenho{

    // Algoritmos de ordenação
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    // Função para gerar um array aleatório de inteiros
    public static int[] gerarArrayAleatorio(int tamanho) {
        Random rand = new Random();
        int[] arr = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            arr[i] = rand.nextInt();
        }
        return arr;
    }

    // Função para medir o tempo de execução de um algoritmo com média
    public static void medirTempoExecucao(String nomeAlgoritmo, int[] arr, Runnable algoritmo) {
        int vezes = 5;
        long somaTempo = 0;
        for (int i = 0; i < vezes; i++) {
            int[] copiaArray = Arrays.copyOf(arr, arr.length);
            long inicio = System.nanoTime();
            algoritmo.run();
            long fim = System.nanoTime();
            somaTempo += (fim - inicio);
        }
        double mediaTempo = somaTempo / (double) vezes;
        System.out.printf("%s - Tempo médio de execução em milissegundos: %.2f%n", nomeAlgoritmo, mediaTempo / 1_000_000.0);
    }

    public static void main(String[] args) {
        int[] tamanhos = {100, 1000, 10000, 50000, 100000};
        for (int tamanho : tamanhos) {
            System.out.printf("%nTeste para array de tamanho %d:%n", tamanho);
            int[] arr = gerarArrayAleatorio(tamanho);
            medirTempoExecucao("Selection Sort", arr, () -> selectionSort(Arrays.copyOf(arr, arr.length)));
            medirTempoExecucao("Insertion Sort", arr, () -> insertionSort(Arrays.copyOf(arr, arr.length)));
            medirTempoExecucao("Bubble Sort", arr, () -> bubbleSort(Arrays.copyOf(arr, arr.length)));
            medirTempoExecucao("Merge Sort", arr, () -> mergeSort(Arrays.copyOf(arr, arr.length), 0, arr.length - 1));
            medirTempoExecucao("Quick Sort", arr, () -> quickSort(Arrays.copyOf(arr, arr.length), 0, arr.length - 1));
            medirTempoExecucao("Heap Sort", arr, () -> heapSort(Arrays.copyOf(arr, arr.length)));
        }
    }
}
