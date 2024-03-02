package org.JMeshGenerator.Geometry.SolidElements;

import lombok.Data;
import org.JMeshGenerator.Exception.ElementIncompatibleException;
import org.JMeshGenerator.Geometry.AbstractPosition;

import java.util.Objects;

import static org.JMeshGenerator.Common.Constance.EPSILON;

@Data
public class SolidPosition extends AbstractPosition {
    private double x;
    private double y;
    private double z;
    @Override
    public double distanceTo(AbstractPosition other) {
        if (!(other instanceof SolidPosition)) {
            throw new ElementIncompatibleException("Incompatible position types.");
        }
        SolidPosition otherPos = (SolidPosition) other;
        return Math.sqrt(Math.pow(this.x - otherPos.x, 2) + Math.pow(this.y - otherPos.y, 2) + Math.pow(this.z - otherPos.z, 2));
    }

    @Override
    public boolean same(AbstractPosition other) {
        if (sameType(other)) {
            throw new ElementIncompatibleException("Incompatible position types.");
        }

        SolidPosition solidPosition = (SolidPosition) other;
        return this.getX() - solidPosition.getX() < EPSILON &&
                this.getY() - solidPosition.getY() < EPSILON &&
                this.getZ() - solidPosition.getZ() < EPSILON;
    }

    @Override
    public double[] buildVector(AbstractPosition other) {
        if (sameType(other)) {
            throw new ElementIncompatibleException("Incompatible position types.");
        }
        if (Objects.isNull(other)) {
            return new double[0];
        }
        SolidPosition solidPosition = (SolidPosition) other;
        return new double[]{this.getX() - solidPosition.getX(),
                this.getY() - solidPosition.getY(),
                this.getZ() - solidPosition.getZ()};
    }
}
