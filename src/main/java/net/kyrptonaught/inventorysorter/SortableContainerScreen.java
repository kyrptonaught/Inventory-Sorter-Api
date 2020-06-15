package net.kyrptonaught.inventorysorter;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.kyrptonaught.inventorysorter.impl.SortButtonWidget;

@Environment(EnvType.CLIENT)
public interface SortableContainerScreen {
    //Returns the Top Sort Button
    SortButtonWidget getUpperSortButton();
    
    //gets the top sort button x
    int getUpperBtnX();

    //gets the top sort button y
    int getUpperBtnY();

    //gets the bottom sort button x, defaults to the same as the upper
    default int getLowerBtnX() {
        return getUpperBtnX();
    }

    //gets the bottom sort button y
    int getLowerBtnY();

    //return true if the current inv can be sorted, defaults to true
    default boolean canSort(){
        return true;
    }
}
