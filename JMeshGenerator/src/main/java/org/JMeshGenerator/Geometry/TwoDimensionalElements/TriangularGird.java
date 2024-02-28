package org.JMeshGenerator.Geometry.TwoDimensionalElements;

import lombok.Data;
import org.JMeshGenerator.Geometry.AbstractGrid;
import org.JMeshGenerator.Geometry.AbstractNode;

import java.util.Arrays;
import java.util.List;

@Data
public class TriangularGird extends AbstractGrid {
    private PlanarNode node1;
    private PlanarNode node2;
    private PlanarNode node3;

    @Override
    public List<AbstractNode> getAllNodes() {
        return Arrays.asList(node1, node2, node3);
    }
}
