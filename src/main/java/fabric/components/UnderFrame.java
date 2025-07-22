package fabric.components;

import fabric.enums.Colors;
import fabric.enums.Materials;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UnderFrame {
    Colors colors;
    Materials materials;
    int minHeight;
    int maxHeight;
}
