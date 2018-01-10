package org.tc.osgi.bundle.morphmath.core.complexe;

import java.awt.Shape;
import java.io.File;
import java.io.IOException;

import org.tc.osgi.bundle.morphmath.core.exception.MorphologiqueException;
import org.tc.osgi.bundle.utils.exception.FieldTrackingAssignementException;

/**
 * CloseFunction.java.
 * @author collonville thomas
 * @version 0.0.2
 */
public class CloseFunction extends AbstractComplexeFunction {

    /**
     * CloseFunction constructor.
     */
    public CloseFunction() {
        super("close of ");
    }

    /**
     * CloseFunction constructor.
     * @param _name String
     */
    public CloseFunction(final String _name) {
        super(_name);
    }

    /**
     * close.
     * @param inputFileName String
     * @param outputFileName String
     * @param outputExtention String
     * @param shape Shape
     * @throws IOException
     * @throws MorphologiqueException
     * @throws FieldTrackingAssignementException
     */
    public void close(final String inputFileName, final String outputFileName, final String outputExtention, final Shape shape) throws IOException, MorphologiqueException,
    FieldTrackingAssignementException {
        execute(inputFileName, outputFileName, outputExtention, shape);
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
        getDilatation().defaultExecute(inputFileName, shape);
        final File file = new File(inputFileName);
        getErosion().erosion(file.getParent() + File.separator + getDilatation().getDefaultNewNameBase() + file.getName(), outputFileName, outputExtention, shape);

    }
}
