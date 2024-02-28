package org.JMeshGenerator.Geometry.TwoDimensionalElements;

import lombok.Data;
import org.JMeshGenerator.Geometry.AbstractGrid;
import org.JMeshGenerator.Geometry.AbstractNode;

import java.util.Arrays;
import java.util.List;

@Data
public class QuadrilateralGrid extends AbstractGrid {
    private PlanarNode node1;
    private PlanarNode node2;
    private PlanarNode node3;
    private PlanarNode node4;
    @Override
    public List<AbstractNode> getAllNodes() {
        return Arrays.asList(node1, node2, node3, node4);
    }
}
