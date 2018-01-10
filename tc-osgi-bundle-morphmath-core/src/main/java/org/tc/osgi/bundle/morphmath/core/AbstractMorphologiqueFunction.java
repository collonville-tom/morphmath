package org.tc.osgi.bundle.morphmath.core;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

import org.tc.osgi.bundle.morphmath.core.conf.MorphMathCorePropertyFile;
import org.tc.osgi.bundle.morphmath.core.exception.MorphologiqueException;
import org.tc.osgi.bundle.morphmath.core.module.service.UtilsServiceProxy;
import org.tc.osgi.bundle.utils.exception.FieldTrackingAssignementException;

/**
 * AbstractMorphologiqueFunction.java.
 * @author collonville thomas
 * @version 0.0.1
 */
public abstract class AbstractMorphologiqueFunction {
    /**
     * String defaultNewNameBase.
     */
    private String defaultNewNameBase = null;

    /**
     * AbstractBasicFunction constructor.
     */
    public AbstractMorphologiqueFunction() {
        super();

    }

    /**
     * AbstractBasicFunction constructor.
     */
    public AbstractMorphologiqueFunction(final String _defaultNewNameBase) {
        this();
        defaultNewNameBase = _defaultNewNameBase;

    }

    /**
     * defaultellipse2DDilatation.
     * @param inputFileName String
     * @throws IOException
     * @throws MorphologiqueException
     * @throws FieldTrackingAssignementException
     */
    public void defaultEllipse2DExecute(final String inputFileName) throws IOException, MorphologiqueException, FieldTrackingAssignementException {
        final File file = new File(inputFileName);
        final StringTokenizer stk = new StringTokenizer(file.getName());
        final int x = MorphMathCorePropertyFile.getInstance().getEllipseX();
        final int y = MorphMathCorePropertyFile.getInstance().getEllipseY();
        final int w = MorphMathCorePropertyFile.getInstance().getEllipseW();
        final int h = MorphMathCorePropertyFile.getInstance().getEllipseH();

        execute(inputFileName, getDefaultNewNameBase() + stk.nextToken("."), stk.nextToken(), new Ellipse2D.Double(x, y, w, h));
    }

    /**
     * defaultDilatation.
     * @param inputFileName String
     * @param shape
     * @throws IOException
     * @throws MorphologiqueException
     * @throws FieldTrackingAssignementException
     */
    public void defaultExecute(final String inputFileName, final Shape shape) throws IOException, MorphologiqueException, FieldTrackingAssignementException {
        final File file = new File(inputFileName);
        final StringTokenizer stk = new StringTokenizer(file.getName());
        execute(inputFileName, getDefaultNewNameBase() + stk.nextToken("."), stk.nextToken("."), shape);
    }

    /**
     * ellipse2DDilatation.
     * @param inputFileName String
     * @param outputFileName String
     * @param outputExtention String
     * @throws IOException
     * @throws MorphologiqueException
     * @throws FieldTrackingAssignementException
     */
    public void ellipse2DExecute(final String inputFileName, final String outputFileName, final String outputExtention) throws IOException, MorphologiqueException, FieldTrackingAssignementException {
        execute(inputFileName, outputFileName, outputExtention, new Ellipse2D.Double(MorphMathCorePropertyFile.getInstance().getEllipseX(), MorphMathCorePropertyFile.getInstance().getEllipseY(),
            MorphMathCorePropertyFile.getInstance().getEllipseW(), MorphMathCorePropertyFile.getInstance().getEllipseH()));
    }

    /**
     * execute.
     * @param inputFileName String
     * @param outputFileName String
     * @param outputExtention String
     * @param shape Shape
     * @throws IOException
     * @throws MorphologiqueException
     * @throws FieldTrackingAssignementException
     */
    protected abstract void execute(String inputFileName, String outputFileName, String outputExtention, Shape shape) throws IOException, MorphologiqueException, FieldTrackingAssignementException;

    /**
     * getDefaultNewNameBase.
     * @return String
     * @throws FieldTrackingAssignementException
     */
    public String getDefaultNewNameBase() throws FieldTrackingAssignementException {
        if (defaultNewNameBase == null) {
            UtilsServiceProxy.getInstance().getXMLPropertyFile(MorphMathCorePropertyFile.MORPH_CORE_FILE).fieldTraking(this, "defaultNewNameBase");
        }
        return defaultNewNameBase;
    }

}
