package net.kyrptonaught.inventorysorter.impl;

public class Sorting {
    private static Sorter sorter;

    public static void setSorter(Sorter sorter){
        Sorting.sorter = sorter;
    }

    public static boolean sort(WhichInv whichInv ){
        return sorter.sort();
    }
}
