package Fabric.Components;

import Fabric.Enums.Colors;
import Fabric.Enums.Materials;
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
