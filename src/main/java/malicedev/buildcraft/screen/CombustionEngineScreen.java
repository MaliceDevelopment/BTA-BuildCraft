package malicedev.buildcraft.screen;

import malicedev.buildcraft.block.entity.CombustionEngineBlockEntity;
import malicedev.buildcraft.screen.handler.CombustionEngineScreenHandler;
import malicedev.buildcraft.util.ScreenUtil;
import malicedev.nyalib.fluid.FluidStack;
import net.minecraft.client.render.Tessellator;
import net.minecraft.core.entity.player.Player;
import net.modificationstation.stationapi.api.client.StationRenderAPI;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlas;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlases;
import org.lwjgl.opengl.GL11;

public class CombustionEngineScreen extends EngineScreen {
    CombustionEngineBlockEntity engine;

    public CombustionEngineScreen(Player player, CombustionEngineBlockEntity engine) {
        super(new CombustionEngineScreenHandler(player, engine), engine);
        this.engine = engine;
    }

    @Override
    protected void drawForeground() {
        textRenderer.draw("Combustion Engine", 54, 6, 4210752);
        textRenderer.draw("Inventory", 8, this.backgroundHeight - 96 + 2, 4210752);
    }

    @Override
    protected void drawBackground(float tickDelta) {
        int bgTextureId = minecraft.textureManager.getTextureId("/assets/buildcraft/stationapi/textures/gui/combustion_engine.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        minecraft.textureManager.bindTexture(bgTextureId);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        drawTexture(x, y, 0, 0, backgroundWidth, backgroundHeight);
        ScreenUtil.drawFluid(engine.getFluid(1, null), engine.getScaledBurnTime(58), x + 104, y + 19, 16, 58, zOffset);
        drawTankLines(x + 104, y + 19);
        ScreenUtil.drawFluid(engine.getFluid(0, null), engine.getScaledCoolant(58), x + 122, y + 19, 16, 58, zOffset);
        drawTankLines(x + 122, y + 19);
    }

    private void drawTankLines(int x, int y){
        minecraft.textureManager.bindTexture(minecraft.textureManager.getTextureId("/assets/buildcraft/stationapi/textures/gui/combustion_engine.png"));
        drawTexture(x, y, 176, 0, 16, 60);
    }
}
