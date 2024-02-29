package org.JMeshGenerator.Geometry.PlanarElements;

import lombok.Data;
import org.JMeshGenerator.Exception.ElementIncompatibleException;
import org.JMeshGenerator.Geometry.AbstractPosition;

import java.util.Objects;

import static org.JMeshGenerator.Algorithm.Common.Constance.EPSILON;

@Data
public class PlanePosition extends AbstractPosition {
    private double x;
    private double y;

    @Override
    public double distanceTo(AbstractPosition other) {
        if (sameType(other)) {
            throw new ElementIncompatibleException("Incompatible position types.");
        }
        PlanePosition planePosition = (PlanePosition) other;
        return Math.sqrt(Math.pow(this.x - planePosition.x, 2) + Math.pow(this.y - planePosition.y, 2));
    }

    @Override
    public boolean same(AbstractPosition other) {
        if (sameType(other)) {
            throw new ElementIncompatibleException("Incompatible position types.");
        }
        PlanePosition planePosition = (PlanePosition) other;
        return Math.abs(this.getX() - planePosition.getX()) < EPSILON &&
                Math.abs(this.getY() - planePosition.getY()) < EPSILON;
    }

    @Override
    public double[] buildVector(AbstractPosition other) {
        if (sameType(other)) {
            throw new ElementIncompatibleException("Incompatible position types.");
        }
        if (Objects.isNull(other)) {
            return new double[0];
        }
        PlanePosition planePosition = (PlanePosition) other;
        return new double[]{this.getX() - planePosition.getX(), this.getY() - planePosition.getY()};
    }
}
