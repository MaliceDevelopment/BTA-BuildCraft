package malicedev.buildcraft.api.energy;

import malicedev.nyalib.fluid.Fluid;

public class EngineCoolant {
    private final float degreesCooledPerMb;
    public final Fluid fluid;

    public EngineCoolant(Fluid fluid, float degreesCooledPerMb) {
        this.fluid = fluid;
        this.degreesCooledPerMb = degreesCooledPerMb;
    }

    public float getDegreesCooledPerMb(float currentHeat) {
        return degreesCooledPerMb;
    }
}
