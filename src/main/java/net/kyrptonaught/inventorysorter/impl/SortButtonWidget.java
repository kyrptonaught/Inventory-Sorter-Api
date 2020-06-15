package net.kyrptonaught.inventorysorter.impl;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.kyrptonaught.inventorysorter.impl.Sorting;
import net.kyrptonaught.inventorysorter.impl.WhichInv;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.util.Identifier;
import org.apache.commons.lang3.StringUtils;

@Environment(EnvType.CLIENT)
public class SortButtonWidget extends TexturedButtonWidget {
    private static final Identifier texture = new Identifier(InventorySorterMod.MOD_ID, "textures/gui/button.png");
    private final WhichInv whichInv;

    public SortButtonWidget(int int_1, int int_2, WhichInv whichInv) {
        super(int_1, int_2, 10, 9, 0, 0, 19, texture, 20, 37, null, "");
        this.whichInv = whichInv;
    }

    @Override
    public void onPress() {
       Sorting.sort(whichInv);
    }

    @Override
    public void renderButton(int int_1, int int_2, float float_1) {
        RenderSystem.pushMatrix();
        MinecraftClient minecraftClient_1 = MinecraftClient.getInstance();
        minecraftClient_1.getTextureManager().bindTexture(texture);
        RenderSystem.scalef(.5f, .5f, 1);
        RenderSystem.translatef(this.x, this.y, 0);
        blit(this.x, this.y, 0, this.isHovered() ? 19 : 0, 20, 18, 20, 37);
        this.renderToolTip(int_1, int_2);
        RenderSystem.disableLighting();
        RenderSystem.popMatrix();
    }

    @Override
    public void renderToolTip(int x, int y) {
        if (InventorySorterMod.getConfig().displayTooltip && this.isHovered())
            MinecraftClient.getInstance().currentScreen.renderTooltip("Sort by: " + StringUtils.capitalize(InventorySorterMod.getConfig().sortType.toString().toLowerCase()), x, y);
    }
}
