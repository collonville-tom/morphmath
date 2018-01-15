package org.tc.osgi.bundle.morphmath.core.module.service.impl;

import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;

import org.tc.osgi.bundle.morphmath.core.basic.DilatationFunction;
import org.tc.osgi.bundle.morphmath.core.basic.ErosionFunction;
import org.tc.osgi.bundle.morphmath.core.complexe.CloseFunction;
import org.tc.osgi.bundle.morphmath.core.complexe.GradientFunction;
import org.tc.osgi.bundle.morphmath.core.complexe.OpenFunction;
import org.tc.osgi.bundle.morphmath.core.exception.MorphologiqueException;
import org.tc.osgi.bundle.morphmath.core.module.service.IMorphMathCoreService;
import org.tc.osgi.bundle.utils.interf.conf.exception.FieldTrackingAssignementException;


/**
 * MorphMathCoreServiceImpl.java.
 * @author collonville thomas
 * @version
 * @track
 */
public class MorphMathCoreServiceImpl implements IMorphMathCoreService {

    /**
     * @param input File
     * @return File
     * @throws IOException
     * @throws MorphologiqueException
     * @throws FieldTrackingAssignementException
     * @see org.tc.osgi.bundle.morphmath.core.module.service.IMorphMathCoreService#close(java.io.File)
     */
    @Override
    public File close(final File input) throws IOException, MorphologiqueException, FieldTrackingAssignementException {
        final CloseFunction trans = new CloseFunction();
        final String output = getOutputFileName(input, "close of");
        final String ext = getOutputFileExt(input);
        trans.close(input.getAbsolutePath(), "close of " + input.getName().replaceAll("\\." + ext, ""), ext, new Ellipse2D.Double(0, 0, 5, 5));
        return new File(output + ext);
    }

    /**
     * @param input File
     * @return File
     * @throws IOException
     * @throws MorphologiqueException
     * @see org.tc.osgi.bundle.morphmath.core.module.service.IMorphMathCoreService#dilatation(java.io.File)
     */
    @Override
    public File dilatation(final File input) throws IOException, MorphologiqueException {
        final DilatationFunction trans = new DilatationFunction();
        final String output = getOutputFileName(input, "dilatation of");
        final String ext = getOutputFileExt(input);
        trans.dilatation(input.getAbsolutePath(), "dilatation of " + input.getName().replaceAll("\\." + ext, ""), ext, new Ellipse2D.Double(0, 0, 5, 5));
        return new File(output + ext);
    }

    /**
     * @param input File
     * @return File
     * @throws IOException
     * @throws MorphologiqueException
     * @see org.tc.osgi.bundle.morphmath.core.module.service.IMorphMathCoreService#erosion(java.io.File)
     */
    @Override
    public File erosion(final File input) throws IOException, MorphologiqueException {
        final ErosionFunction trans = new ErosionFunction();
        final String output = getOutputFileName(input, "erosion of");
        final String ext = getOutputFileExt(input);

        trans.erosion(input.getAbsolutePath(), "erosion of " + input.getName().replaceAll("\\." + ext, ""), ext, new Ellipse2D.Double(0, 0, 5, 5));
        return new File(output + ext);
    }

    /**
     * getOutputFileExt.
     * @param input File
     * @return String
     */
    private String getOutputFileExt(final File input) {
        return input.getName().split("\\.")[1];
    }

    /**
     * getOutputFileName.
     * @param input File
     * @param transforType String
     * @return String
     */
    private String getOutputFileName(final File input, final String transforType) {

        return input.getParent() + File.separator + transforType + " " + input.getName().replaceAll(getOutputFileExt(input), "");
    }

    /**
     * @param input File
     * @return File
     * @throws IOException
     * @throws MorphologiqueException
     * @throws FieldTrackingAssignementException
     * @see org.tc.osgi.bundle.morphmath.core.module.service.IMorphMathCoreService#gradient(java.io.File)
     */
    @Override
    public File gradient(final File input) throws IOException, MorphologiqueException, FieldTrackingAssignementException {
        final GradientFunction trans = new GradientFunction();
        final String output = getOutputFileName(input, "gradient of");
        final String ext = getOutputFileExt(input);
        trans.gradient(input.getAbsolutePath(), "gradient of " + input.getName().replaceAll("\\." + ext, ""), ext, new Ellipse2D.Double(0, 0, 5, 5));
        return new File(output + ext);
    }

    /**
     * @param input File
     * @return File
     * @throws IOException
     * @throws MorphologiqueException
     * @throws FieldTrackingAssignementException
     * @see org.tc.osgi.bundle.morphmath.core.module.service.IMorphMathCoreService#open(java.io.File)
     */
    @Override
    public File open(final File input) throws IOException, MorphologiqueException, FieldTrackingAssignementException {
        final OpenFunction trans = new OpenFunction();
        final String output = getOutputFileName(input, "open of");
        final String ext = getOutputFileExt(input);
        trans.open(input.getAbsolutePath(), "open of " + input.getName().replaceAll("\\." + ext, ""), ext, new Ellipse2D.Double(0, 0, 5, 5));
        return new File(output + ext);
    }

}
