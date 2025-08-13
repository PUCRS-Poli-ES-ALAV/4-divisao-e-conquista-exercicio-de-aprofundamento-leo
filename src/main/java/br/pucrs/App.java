package br.pucrs;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App {

    private static long quantidadeIteracoes;

    public static void main(String[] args) {
        realizarExercicio1();
        
    }

    public static void realizarExercicio1(){
        // criando lista randomica
        ArrayList<Integer> listaRandomica1 = popularLista(36);
        ArrayList<Integer> listaRandomica2 = popularLista(2048);
        ArrayList<Integer> listaRandomica3 = popularLista(1048576);

        quantidadeIteracoes = 0;
        Instant inicio = Instant.now(); // Marca o início de contagem de tempo
        ArrayList<Integer> arrayOrdenado = mergeSort(listaRandomica1);
        Instant finalExecucao = Instant.now(); // Marca o início de contagem de tempo
        //System.out.println("o vetor ordenado é: \n" + arrayOrdenado);
        System.out.println("A quantidade de iterações para ordenar um array de tamanho 36 é: " + quantidadeIteracoes);
        Duration duracao = Duration.between(inicio, finalExecucao);
        System.out.println("Tempo decorrido: " + duracao.toMillis() + " milissegundos");

        Instant inicio2 = Instant.now(); // Marca o início de contagem de tempo
        ArrayList<Integer> arrayOrdenado2 = mergeSort(listaRandomica2);
        Instant finalExecucao2 = Instant.now(); // Marca o início de contagem de tempo
        //System.out.println("o vetor ordenado é: \n" + arrayOrdenado2);
        System.out.println("A quantidade de iterações para ordenar um array de tamanho 2048 é: " + quantidadeIteracoes);
        Duration duracao2 = Duration.between(inicio2, finalExecucao2);
        System.out.println("Tempo decorrido: " + duracao2.toMillis() + " milissegundos");

        Instant inicio3 = Instant.now(); // Marca o início de contagem de tempo
        ArrayList<Integer> arrayOrdenado3 = mergeSort(listaRandomica3);
        Instant finalExecucao3 = Instant.now(); // Marca o início de contagem de tempo
       // System.out.println("o vetor ordenado é: \n" + arrayOrdenado3);
        System.out.println(
                "A quantidade de iterações para ordenar um array de tamanho 1048576 é: " + quantidadeIteracoes);
        Duration duracao3 = Duration.between(inicio3, finalExecucao3);
        System.out.println("Tempo decorrido: " + duracao3.toMillis() + " milissegundos");

        //Terminal ao final da execução:
        /*
         *  A quantidade de iterações para ordenar um array de tamanho 36 é: 71
            Tempo decorrido: 0 milissegundos
            A quantidade de iterações para ordenar um array de tamanho 2048 é: 4166
            Tempo decorrido: 3 milissegundos
            A quantidade de iterações para ordenar um array de tamanho 1048576 é: 2101317
            Tempo decorrido: 426 milissegundos
         */
    }

    /*
     * Exercicio 1
     * 1. Vamos começar com um algorítmo já estudado e conhecido (em AEDI).
     * O Merge Sort é um algorítmo de ordenação baseado nos seguintes passos:
     * 
     * recursivamente ordene a metade esquerda do vetor
     * recursivamente ordene a metade direita do vetor
     * mescle (faça o merge) das duas metades para ter o vetor ordenado.
     * 
     * Assim:
     * 
     * implemente o algortimo abaixo;
     * teste-o para vetores de inteiros com conteúdos randômicos, e tamanho 32, 2048
     * e 1.048.576. Nestes testes, contabilize o número de iterações que o algoritmo
     * executa, e o tempo gasto;
     * 
     * ```java
     * MERGE-SORT(L: List with n elements) : Ordered list with n elements
     * IF (list L has one element)
     * RETURN L.
     * 
     * Divide the list into two halves A and B.
     * 
     * A ← MERGE-SORT(A).
     * B ← MERGE-SORT(B).
     * L ← MERGE(A, B).
     * RETURN L.
     */
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> lista) {
        quantidadeIteracoes++;
        if (lista.size() == 1) {
            return lista;
        }
        // crio as duas listas
        ArrayList<Integer> listaEsquerda = new ArrayList<>();
        ArrayList<Integer> listaDireita = new ArrayList<>();
        // populo as duas listas
        for (int i = 0; i < lista.size(); i++) {
            if (i < (lista.size() / 2)) {
                listaEsquerda.add(lista.get(i));
            } else {
                listaDireita.add(lista.get(i));
            }
        }
        listaEsquerda = mergeSort(listaEsquerda);
        listaDireita = mergeSort(listaDireita);
        lista = mergeSort(listaEsquerda, listaDireita);
        return lista;
    }

    private static ArrayList<Integer> mergeSort(ArrayList<Integer> listaEsquerda, ArrayList<Integer> listaDireita) {
        ArrayList<Integer> listaOrdenada = new ArrayList<>();
        for (int i = 0; i < listaEsquerda.size(); i++) {
            if (listaEsquerda.get(i) < listaDireita.get(i)) {
                listaOrdenada.add(listaEsquerda.get(i));
                listaOrdenada.add(listaDireita.get(i));
            } else {
                listaOrdenada.add(listaDireita.get(i));
                listaOrdenada.add(listaEsquerda.get(i));
            }
        }
        // System.out.println("lista ordenada \n"+listaOrdenada.toString());
        return listaOrdenada;

    }

    public static ArrayList<Integer> popularLista(int tamanho) {
        ArrayList<Integer> listaRandomica = new ArrayList<>();
        Random gerador = new Random();

        for (int i = 0; i < tamanho; i++) {
            int numeroRandomico = gerador.nextInt(2000000);
            listaRandomica.add(numeroRandomico);
        }

        return listaRandomica;
    }
}