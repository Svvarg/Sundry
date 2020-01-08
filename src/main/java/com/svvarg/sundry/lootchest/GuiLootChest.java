package com.svvarg.sundry.lootchest;

import static com.svvarg.sundry.Sundry.MODID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 *
 * @author Swarg
 */
public class GuiLootChest extends GuiContainer {

    private TileEntityLootChest teLootChest;

    private static final ResourceLocation textures = new ResourceLocation(MODID, "textures/gui/container/lootChest.png");

    public GuiLootChest(InventoryPlayer invPlayer, TileEntityLootChest te) {
        super(new ContainerLootChest(invPlayer, te));
        this.teLootChest = te;
    }

    /**
     * Метод для отрисовки текстов и проч
     */

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
        // Отрисовать название инвентаря игрока, где оно обычно находится.
        fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, ySize - 96 + 2,
                4210752);
        // Отрисовать название GUI (TileEntity), учитывая его переименование и локализацию.
        String s = this.teLootChest.hasCustomInventoryName() ? this.teLootChest.getInventoryName()
                : I18n.format(this.teLootChest.getInventoryName(), new Object[0]);
        fontRendererObj.drawString(s, 6, 6, 4210752);
    }

    /**
     * Метод отрисовки задника GUI (фон, etc).
     */
    @Override
    public void drawGuiContainerBackgroundLayer(float size, int x, int y) {
        // Окрасить все в белый цвет и в полную непрозрачность, не уверен в нужности.
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        
        Minecraft.getMinecraft().getTextureManager().bindTexture(textures);
        drawTexturedModalRect(guiLeft,guiTop,0,0,176,166);
        // Привязать текстуру
        //mc.getTextureManager().bindTexture(textures);
    }

}
