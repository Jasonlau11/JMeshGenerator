package org.JMeshGenerator.Algorithm.Common;

import org.JMeshGenerator.Geometry.AbstractNode;

public class CommonAlgorithm {
    public static double distance(AbstractNode node1, AbstractNode node2) {
        return node1.distanceTo(node2);
    }
}
