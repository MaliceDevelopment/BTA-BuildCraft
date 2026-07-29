package malicedev.buildcraft.client.render;

import malicedev.buildcraft.api.core.Serializable;
import malicedev.buildcraft.util.PipeConnectionMatrix;
import malicedev.buildcraft.util.TextureMatrix;
import malicedev.buildcraft.util.WireMatrix;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PipeRenderState implements Serializable {
    public final PipeConnectionMatrix pipeConnectionMatrix = new PipeConnectionMatrix();
    public final TextureMatrix textureMatrix = new TextureMatrix();
    public final WireMatrix wireMatrix = new WireMatrix();
    public boolean glassColorDirty = false;
    private byte glassColor = -127;

    private boolean dirty = true;

    public void clean(){
        dirty = false;
        glassColorDirty = false;
        pipeConnectionMatrix.clean();
        textureMatrix.clean();
        wireMatrix.clean();
    }

    public byte getGlassColor() {
        return glassColor;
    }

    public void setGlassColor(byte color) {
        this.glassColor = color;
    }

    public boolean isDirty(){
        return dirty || pipeConnectionMatrix.isDirty() || textureMatrix.isDirty() || wireMatrix.isDirty() || glassColorDirty;
    }

    public boolean needsRenderUpdate(){
        return pipeConnectionMatrix.isDirty() || textureMatrix.isDirty() || wireMatrix.isDirty() || glassColorDirty;
    }

    public void writeData(DataOutputStream stream) throws IOException {
        stream.writeByte(glassColor < -1 ? -1 : glassColor);
        pipeConnectionMatrix.writeData(stream);
        textureMatrix.writeData(stream);
        wireMatrix.writeData(stream);
    }

    public void readData(DataInputStream stream) throws IOException {
        byte g = stream.readByte();
        if (g != glassColor) {
            this.glassColor = g;
            this.glassColorDirty = true;
        }
        pipeConnectionMatrix.readData(stream);
        textureMatrix.readData(stream);
        wireMatrix.readData(stream);
    }
}
