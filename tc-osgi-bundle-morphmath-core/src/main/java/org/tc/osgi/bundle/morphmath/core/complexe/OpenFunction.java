package org.tc.osgi.bundle.morphmath.core.complexe;

import java.awt.Shape;
import java.io.File;
import java.io.IOException;

import org.tc.osgi.bundle.morphmath.core.exception.MorphologiqueException;
import org.tc.osgi.bundle.utils.interf.conf.exception.FieldTrackingAssignementException;

/**
 * OpenFunction.java.
 * @author thomas collonvillé
 * @version 0.0.2
 */
public class OpenFunction extends AbstractComplexeFunction {

    /**
     * OpenFunction constructor.
     */
    public OpenFunction() {
        super("open of ");
    }

    /**
     * OpenFunction constructor.
     * @param _name String
     */
    public OpenFunction(final String _name) {
        super(_name);
    }

    /**
     * @param inputFileName String
     * @param outputFileName String
     * @param outputExtention String
     * @param shape Shape
     * @throws IOException
     * @throws MorphologiqueException
     * @throws FieldTrackingAssignementException
     * @see org.tc.osgi.bundle.morphmath.AbstractMorphologiqueFunction#execute(java.lang.String, java.lang.String, java.lang.String, java.awt.Shape)
     */
    @Override
    protected void execute(final String inputFileName, final String outputFileName, final String outputExtention, final Shape shape) throws IOException, MorphologiqueException,
    FieldTrackingAssignementException {
        getErosion().defaultExecute(inputFileName, shape);
        final File file = new File(inputFileName);
        getDilatation().dilatation(file.getParent() + File.separator + getErosion().getDefaultNewNameBase() + file.getName(), outputFileName, outputExtention, shape);

    }

    /**
     * open.
     * @param inputFileName String
     * @param outputFileName String
     * @param outputExtention String
     * @param shape Shape
     * @throws IOException
     * @throws MorphologiqueException
     * @throws FieldTrackingAssignementException
     */
    public void open(final String inputFileName, final String outputFileName, final String outputExtention, final Shape shape) throws IOException, MorphologiqueException,
    FieldTrackingAssignementException {
        execute(inputFileName, outputFileName, outputExtention, shape);
    }
}
