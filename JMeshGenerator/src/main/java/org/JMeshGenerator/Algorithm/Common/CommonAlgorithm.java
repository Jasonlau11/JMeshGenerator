package org.JMeshGenerator.Algorithm.Common;

import org.JMeshGenerator.Geometry.AbstractEdge;
import org.JMeshGenerator.Geometry.AbstractNode;
import org.la4j.vector.dense.BasicVector;

import java.util.Objects;

public class CommonAlgorithm {
    public static double distance(AbstractNode node1, AbstractNode node2) {
        return node1.distanceTo(node2);
    }

    public static boolean parallel(AbstractEdge edge1, AbstractEdge edge2) {
        return edge1.parallel(edge2);
    }

    public static BasicVector buildVector(AbstractNode node1, AbstractNode node2) {
        if (Objects.isNull(node1) || Objects.isNull(node2)) {
            return new BasicVector();
        }
        return new BasicVector(node1.getPosition().buildVector(node2.getPosition()));
    }

}
