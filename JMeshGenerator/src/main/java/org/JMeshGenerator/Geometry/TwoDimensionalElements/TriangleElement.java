package org.JMeshGenerator.Geometry.TwoDimensionalElements;

import org.JMeshGenerator.Geometry.AbstractNode;
import org.JMeshGenerator.Geometry.PolygonalElement;

import java.util.List;

public class TriangleElement extends PolygonalElement {
    public TriangleElement(List<AbstractNode> nodes) {
        super(nodes);
        if (nodes.size() != 3) {
            throw new IllegalArgumentException("A triangle must have exactly 3 nodes.");
        }
    }
}
