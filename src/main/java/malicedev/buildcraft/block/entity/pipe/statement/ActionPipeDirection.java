package malicedev.buildcraft.block.entity.pipe.statement;

import malicedev.buildcraft.Buildcraft;
import malicedev.buildcraft.api.transport.statement.ActionInternal;
import malicedev.buildcraft.api.transport.statement.Statement;
import malicedev.buildcraft.api.transport.statement.StatementContainer;
import malicedev.buildcraft.api.transport.statement.StatementParameter;
import malicedev.buildcraft.init.StatementListener;
import malicedev.buildcraft.util.DirectionUtil;
import net.minecraft.client.resource.language.TranslationStorage;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlases;
import net.modificationstation.stationapi.api.util.math.Direction;

import java.util.Locale;

public class ActionPipeDirection extends BCStatement implements ActionInternal {

    public final Direction direction;

    public ActionPipeDirection(Direction direction){
        super(Buildcraft.NAMESPACE.id("pipe.dir." + direction.name().toLowerCase(Locale.ENGLISH)));
        this.direction = direction;
    }

    @Override
    public void actionActivate(StatementContainer source, StatementParameter[] parameters) {
        // Pipe listens to this so no implementation here
    }

    @Override
    public void registerTextures() {
        icon = Atlases.getGuiItems().addTexture(Buildcraft.NAMESPACE.id("item/trigger/action_direction_" + direction.name().toLowerCase(Locale.ENGLISH)));
    }

    @Override
    public Statement rotateLeft() {
        return StatementListener.actionPipeDirection[direction.rotateYCounterclockwise().ordinal()];
    }

    @Override
    public String getDescription() {
        return TranslationStorage.INSTANCE.get("gate.buildcraft.action.pipe_direction." + direction.name().toLowerCase(Locale.ENGLISH));
    }
}
