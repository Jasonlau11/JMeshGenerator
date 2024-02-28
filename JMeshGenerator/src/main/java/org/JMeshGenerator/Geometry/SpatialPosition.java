package org.JMeshGenerator.Geometry;

import lombok.Data;
import org.JMeshGenerator.Exception.CalculationException;

@Data
public class SpatialPosition extends AbstractPosition {
    private double x;
    private double y;
    private double z;

    @Override
    public double distanceTo(AbstractPosition other) {
        if (!(other instanceof SpatialPosition)) {
            throw new CalculationException("Incompatible position types.");
        }
        SpatialPosition otherPos = (SpatialPosition) other;
        return Math.sqrt(Math.pow(this.x - otherPos.x, 2) + Math.pow(this.y - otherPos.y, 2) + Math.pow(this.z - otherPos.z, 2));
    }
}
