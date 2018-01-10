package org.tc.osgi.bundle.morphmath.core.basic;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.tc.osgi.bundle.morphmath.core.AbstractMorphologiqueFunction;
import org.tc.osgi.bundle.morphmath.core.exception.FileTypeException;
import org.tc.osgi.bundle.morphmath.core.exception.ImageTypeException;
import org.tc.osgi.bundle.morphmath.core.exception.MorphologiqueException;
import org.tc.osgi.bundle.morphmath.core.module.service.UtilsServiceProxy;

/**
 * AbstractBasicFunction.java.
 * @author collonville thomas
 * @version 0.0.1
 */
public abstract class AbstractBasicFunction extends AbstractMorphologiqueFunction {

    /**
     * AbstractBasicFunction constructor.
     * @param _defaultNewNameBase String
     */
    public AbstractBasicFunction(final String _defaultNewNameBase) {
        super(_defaultNewNameBase);
    }

    /**
     * imageCheking.
     * @param inputFileName String
     * @param outputFileName String
     * @param outputExtention String
     * @param shape Shape
     * @throws IOException
     * @throws MorphologiqueException
     */
    protected void imageCheking(final String inputFileName, final String outputFileName, final String outputExtention, final Shape shape) throws IOException, MorphologiqueException {
        UtilsServiceProxy.getInstance().getLogger(this.getClass()).debug("Verification de l'image " + inputFileName);
        final File inputFile = new File(inputFileName);
        final BufferedImage inputImage = ImageIO.read(inputFile);
        if (inputImage == null) {
            throw new FileTypeException("Le fichier d'entrée n'est pas une image");
        }
        if (inputImage.getType() != BufferedImage.TYPE_BYTE_BINARY) {
            throw new ImageTypeException("L'image doit etre de type binaire");
        }
        final BufferedImage outputImage = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
        iterationOnImage(inputImage, outputImage, shape);
        ImageIO.write(outputImage, outputExtention, new File(inputFile.getParent() + File.separator + outputFileName + "." + outputExtention));
    }

    /**
     * iterationOnImage.
     * @param inputImage BufferedImage
     * @param outputImage BufferedImage
     * @param shape Shape
     */
    private void iterationOnImage(final BufferedImage inputImage, final BufferedImage outputImage, final Shape shape) {
        final Area area = new Area(shape);
        UtilsServiceProxy.getInstance().getLogger(this.getClass()).debug("Iteration en cours");
        final AffineTransform centrage = new AffineTransform();
        centrage.setToTranslation(-(area.getBounds().getCenterX()), -area.getBounds().getCenterY());
        final AffineTransform translation = new AffineTransform();
        translation.setToTranslation(1, 0);
        final AffineTransform retourLigne = new AffineTransform();
        retourLigne.setToTranslation(-inputImage.getWidth(), 1);
        area.transform(centrage);

        final int[] blanc = { -1 };
        final WritableRaster raster = inputImage.getRaster().createCompatibleWritableRaster();

        for (int y = 0; y < inputImage.getHeight(); y++) {
            for (int x = 0; x < inputImage.getWidth(); x++) {
                if (operation(inputImage, area, x, y)) {
                    raster.setPixel(x, y, blanc);
                }
                area.transform(translation);
            }
            area.transform(retourLigne);
        }
        outputImage.setData(raster);
        UtilsServiceProxy.getInstance().getLogger(this.getClass()).debug("fin de traitement");
    }

    /**
     * operation.
     * @param inputSubImage BufferedImage
     * @param area Area
     * @param globalX int
     * @param globalY int
     * @return boolean
     */
    protected abstract boolean operation(BufferedImage inputSubImage, Area area, int globalX, int globalY);

}
