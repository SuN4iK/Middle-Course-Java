package org.example.fabric.components;

import org.example.fabric.enums.Colors;
import org.example.fabric.enums.Materials;
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
