package Fabric.Factory;

import Fabric.Components.Table;
import Fabric.Enums.Colors;
import Fabric.Enums.Materials;

public interface TableFactory {
    Table createStartTable(Colors underframeColor, Materials underframeMaterial, Colors counterColor, Materials counterMaterial);
    Table createMediumTable(Colors underframeColor, Materials underframeMaterial, Colors counterColor, Materials counterMaterial);
    Table createFullTable(Colors underframeColor, Materials underframeMaterial, Colors counterColor, Materials counterMaterial);
}
