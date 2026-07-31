package malicedev.buildcraft.util.raycast;

import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.core.util.helper.Direction;

public class RaycastResult {
    public final HitResult hit;
    public final Box box;
    public final Direction sideHit;

    public RaycastResult(HitResult hit, Box box, Direction sideHit){
        this.hit = hit;
        this.box = box;
        this.sideHit = sideHit;
    }
}
