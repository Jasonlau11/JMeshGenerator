package org.JMeshGenerator.Geometry.TwoDimensionalElements;

import org.JMeshGenerator.Geometry.AbstractNode;
import org.JMeshGenerator.Geometry.PolygonalElement;

import java.util.List;

public class QuadrilateralElement extends PolygonalElement {
    public QuadrilateralElement(List<AbstractNode> nodes) {
        super(nodes);
        if (nodes.size() != 4) {
            throw new IllegalArgumentException("A quadrilateral must have exactly 4 nodes.");
        }
    }
}
