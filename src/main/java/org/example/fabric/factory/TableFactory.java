package org.example.fabric.factory;

import org.example.fabric.components.Table;
import org.example.fabric.enums.Colors;
import org.example.fabric.enums.Materials;

public interface TableFactory {
    Table createStartTable(Colors underframeColor, Materials underframeMaterial, Colors counterColor, Materials counterMaterial);
    Table createMediumTable(Colors underframeColor, Materials underframeMaterial, Colors counterColor, Materials counterMaterial);
    Table createFullTable(Colors underframeColor, Materials underframeMaterial, Colors counterColor, Materials counterMaterial);
}
