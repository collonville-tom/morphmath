package org.tc.osgi.bundle.morphmath.core.complexe;

import org.tc.osgi.bundle.morphmath.core.AbstractMorphologiqueFunction;
import org.tc.osgi.bundle.morphmath.core.basic.DilatationFunction;
import org.tc.osgi.bundle.morphmath.core.basic.ErosionFunction;

/**
 * ComplexeMorphologiqueFunction.java.
 * @author collonville thomas
 * @version 0.0.2
 */
public abstract class AbstractComplexeFunction extends AbstractMorphologiqueFunction {

    /**
     * DilatationFunction dilatation.
     */
    private DilatationFunction dilatation = new DilatationFunction();

    /**
     * ErosionFunction erosion.
     */
    private ErosionFunction erosion = new ErosionFunction();

    /**
     * AbstractComplexeFunction constructor.
     * @param _name
     */
    public AbstractComplexeFunction(final String _name) {
        super(_name);
    }

    /**
     * @return Returns the dilatation.
     */
    public DilatationFunction getDilatation() {
        return dilatation;
    }

    /**
     * @return Returns the erosion.
     */
    public ErosionFunction getErosion() {
        return erosion;
    }

    /**
     * @param dilatation The dilatation to set.
     */
    public void setDilatation(final DilatationFunction dilatation) {
        this.dilatation = dilatation;
    }

    /**
     * @param erosion The erosion to set.
     */
    public void setErosion(final ErosionFunction erosion) {
        this.erosion = erosion;
    }

}
