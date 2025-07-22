package fabric.factory;

import fabric.components.Table;
import fabric.enums.Colors;
import fabric.enums.Materials;

public interface TableFactory {
    Table createStartTable(Colors underframeColor, Materials underframeMaterial, Colors counterColor, Materials counterMaterial);
    Table createMediumTable(Colors underframeColor, Materials underframeMaterial, Colors counterColor, Materials counterMaterial);
    Table createFullTable(Colors underframeColor, Materials underframeMaterial, Colors counterColor, Materials counterMaterial);
}
