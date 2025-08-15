package org.example.fabric.factory;

import org.example.fabric.components.Table;
import org.example.fabric.components.UnderFrame;
import org.example.fabric.enums.Colors;
import org.example.fabric.enums.Materials;
import org.example.fabric.enums.Models;

public class TableFactoryImpl implements TableFactory {
    @Override
    public Table createStartTable(Colors underframeColor, Materials underframeMaterial, Colors counterColor, Materials counterMaterial) {
        TableConfig tableConfig = TableConfigFactory.getTableConfig(Models.START);
        return null;
    }

    @Override
    public Table createMediumTable(Colors underframeColor, Materials underframeMaterial, Colors counterColor, Materials counterMaterial) {
        TableConfig tableConfig = TableConfigFactory.getTableConfig(Models.MEDIUM);
        return null;
    }

    @Override
    public Table createFullTable(Colors underframeColor, Materials underframeMaterial, Colors counterColor, Materials counterMaterial) {
        TableConfig tableConfig = TableConfigFactory.getTableConfig(Models.FULL);
        return null;
    }
    private Table getTableAndComponents(Colors underframeColor, Materials underframeMaterial, Colors counterColor, Materials counterMaterial, TableConfig tableConfig) {
        UnderFrame underFrame = getUnderFrame(underframeColor, underframeMaterial, tableConfig);
        return null;
    }
    private UnderFrame getUnderFrame(Colors underframeColor, Materials underframeMaterial, TableConfig tableConfig) {
        return UnderFrame.builder()
                .colors(underframeColor)
                .materials(underframeMaterial)
                .minHeight(tableConfig.getUnderframeMinHeight())
                .maxHeight(tableConfig.getUnderframeMaxHeight()).build();
    }
}
