package org.JMeshGenerator.Geometry.SolidElements;

import lombok.Data;
import org.JMeshGenerator.Exception.CalculationException;
import org.JMeshGenerator.Geometry.AbstractPosition;

@Data
public class SolidPosition extends AbstractPosition {
    private double x;
    private double y;
    private double z;
    @Override
    public double distanceTo(AbstractPosition other) {
        if (!(other instanceof SolidPosition)) {
            throw new CalculationException("Incompatible position types.");
        }
        SolidPosition otherPos = (SolidPosition) other;
        return Math.sqrt(Math.pow(this.x - otherPos.x, 2) + Math.pow(this.y - otherPos.y, 2) + Math.pow(this.z - otherPos.z, 2));
    }
}
