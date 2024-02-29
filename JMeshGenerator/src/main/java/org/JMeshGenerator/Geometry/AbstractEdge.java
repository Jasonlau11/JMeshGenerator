package org.JMeshGenerator.Geometry;

import lombok.Data;
import org.JMeshGenerator.Exception.ElementIncompatibleException;
import org.la4j.Vector;
import org.la4j.vector.dense.BasicVector;

import java.util.List;

@Data
public abstract class AbstractEdge extends AbstractGeometryElement{
    private BasicVector vector;
    private AbstractNode node1;
    private AbstractNode node2;
    private List<AbstractEdge> adjacentEdges;

    public boolean parallel(AbstractEdge other) {
        if (!sameType(other)) {
            throw new ElementIncompatibleException("Incompatible edge types.");
        }

        Vector v1 = this.getVector();
        Vector v2 = other.getVector();
        // 二维向量没有直接的叉乘方法，所以使用点积和长度比较
        double dotProduct = v1.innerProduct(v2);
        double lengthsProduct = v1.euclideanNorm() * v2.euclideanNorm();

        // 如果点积等于长度乘积的绝对值，向量平行（或反向）
        return Math.abs(dotProduct) == lengthsProduct;
    };

    public boolean adjacent(AbstractEdge other) {
        if (!sameType(other)) {
            throw new ElementIncompatibleException("Incompatible edge types.");
        }

        boolean adjacent = getCommonNode(other) != null;
        if (adjacent) {
            this.adjacentEdges.add(other);
            other.getAdjacentEdges().add(this);
        }
        return adjacent;
    }

    public AbstractNode getCommonNode(AbstractEdge other) {
        if (this.getNode1().equals(other.getNode1()) || this.getNode1().equals(other.getNode2())) {
            return this.getNode1();
        }
        if (this.getNode2().equals(other.getNode1()) || this.getNode2().equals(other.getNode2())) {
            return this.getNode2();
        }
        return null;
    }
}
