import matplotlib.pyplot as plt

# Dados para os tempos médios de execução em milissegundos para cada algoritmo e tamanho de array
tamanhos = [100, 1000, 10000, 50000, 100000]
tempos_selection = [0.04, 0.91, 17.17, 402.48, 1618.10]
tempos_insertion = [0.02, 0.62, 6.59, 101.72, 482.13]
tempos_bubble = [0.11, 1.48, 74.64, 2604.58, 12836.09]
tempos_merge = [0.04, 0.13, 2.67, 5.74, 10.84]
tempos_quick = [0.06, 0.11, 0.52, 3.01, 6.30]
tempos_heap = [0.04, 0.13, 1.02, 4.42, 8.89]

# Configurando o gráfico
plt.figure(figsize=(10, 6))
plt.plot(tamanhos, tempos_selection, label="Selection Sort", marker='o')
plt.plot(tamanhos, tempos_insertion, label="Insertion Sort", marker='o')
plt.plot(tamanhos, tempos_bubble, label="Bubble Sort", marker='o')
plt.plot(tamanhos, tempos_merge, label="Merge Sort", marker='o')
plt.plot(tamanhos, tempos_quick, label="Quick Sort", marker='o')
plt.plot(tamanhos, tempos_heap, label="Heap Sort", marker='o')

# Configurando os eixos com escala logarítmica para melhor visualização
plt.xscale('log')
plt.yscale('log')

# Títulos e legendas
plt.title("Comparação de Desempenho dos Algoritmos de Ordenação")
plt.xlabel("Tamanho do Array")
plt.ylabel("Tempo Médio de Execução (ms)")
plt.legend()
plt.grid(True, which="both", linestyle="--", linewidth=0.5)

# Exibindo o gráfico
plt.show()
