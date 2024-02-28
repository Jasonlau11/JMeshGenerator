package org.JMeshGenerator.Geometry;

import lombok.Data;

import java.util.List;

@Data
public abstract class PolygonalElement {
    protected List<AbstractNode> nodes;

    public PolygonalElement(List<AbstractNode> nodes) {
        this.nodes = nodes;
    }
}
