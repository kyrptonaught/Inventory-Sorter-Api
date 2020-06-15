package net.kyrptonaught.inventorysorterapi;

import net.minecraft.inventory.Inventory;

public interface SortableContainer {

    //return the inventory to be sorted
    Inventory getInventory();

    //return true if the current inv can be sorted, defaults to true
    default boolean canSort(){
        return true;
    }
}
