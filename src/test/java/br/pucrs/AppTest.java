package br.pucrs;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    @DisplayName("Testando caso da lista [2,3,5,1]")
    public void shouldAnswerWithTrue()
    {   ArrayList<Integer> lista = new ArrayList<>();
        lista.add(2);
        lista.add(3);
        lista.add(5);
        lista.add(1);
        System.out.println("Print da lista antes\n"+lista.toString());
        System.out.println("Print da lista odenada\n"+App.mergeSort(lista));
    }
}
