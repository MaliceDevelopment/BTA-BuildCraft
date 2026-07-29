package malicedev.buildcraft.api.core;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public interface Serializable {
    void writeData(DataOutputStream stream) throws IOException;

    void readData(DataInputStream stream) throws IOException;
}
