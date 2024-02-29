package org.JMeshGenerator.Geometry;

public abstract class AbstractPosition extends AbstractGeometryElement {
    public abstract double distanceTo(AbstractPosition other);

    public abstract boolean same(AbstractPosition other);

    public abstract double[] buildVector(AbstractPosition other);
}

