package org.tc.osgi.bundle.morphmath.core.complexe;

import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.tc.osgi.bundle.morphmath.core.exception.MorphologiqueException;
import org.tc.osgi.bundle.utils.interf.conf.exception.FieldTrackingAssignementException;

/**
 * GradientFunction.java.
 * 
 * @author collonville thomas
 * @version 0.0.2
 */
public class GradientFunction extends AbstractComplexeFunction {

	/**
	 * GradientFunction constructor.
	 */
	public GradientFunction() {
		super("gradient of ");
	}

	/**
	 * GradientFunction constructor.
	 * 
	 * @param _name String
	 */
	public GradientFunction(final String _name) {
		super(_name);
	}

	/**
	 * @param inputFileName   String
	 * @param outputFileName  String
	 * @param outputExtention String
	 * @param shape           Shape
	 * @throws IOException
	 * @throws MorphologiqueException
	 * @throws FieldTrackingAssignementException
	 * @see org.tc.osgi.bundle.morphmath.AbstractMorphologiqueFunction#execute(java.lang.String,
	 *      java.lang.String, java.lang.String, java.awt.Shape)
	 */
	@Override
	protected void execute(final String inputFileName, final String outputFileName, final String outputExtention, final Shape shape)
			throws IOException, MorphologiqueException, FieldTrackingAssignementException {
		getDilatation().defaultExecute(inputFileName, shape);
		getErosion().defaultExecute(inputFileName, shape);

		final File file = new File(inputFileName);
		final File inputFileDil = new File(file.getParent() + File.separator + getDilatation().getDefaultNewNameBase() + file.getName());
		final File inputFileEro = new File(file.getParent() + File.separator + getErosion().getDefaultNewNameBase() + file.getName());

		final BufferedImage dilImage = ImageIO.read(inputFileDil);
		final BufferedImage eroImage = ImageIO.read(inputFileEro);

		final WritableRaster raster = eroImage.getRaster().createCompatibleWritableRaster();
		final int[] blanc = { -1 };
		for (int y = 0; y < eroImage.getHeight(); y++) {
			for (int x = 0; x < eroImage.getWidth(); x++) {
				final int[] tmp1 = { 0 };
				final int[] tmp2 = { 0 };
				if (eroImage.getRaster().getPixel(x, y, tmp1)[0] == dilImage.getRaster().getPixel(x, y, tmp2)[0]) {
					raster.setPixel(x, y, blanc);
				}
			}
		}
		final BufferedImage outputImage = new BufferedImage(eroImage.getWidth(), eroImage.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
		outputImage.setData(raster);
		ImageIO.write(outputImage, outputExtention, new File(file.getParent() + File.separator + outputFileName + "." + outputExtention));

	}

	/**
	 * gradient.
	 * 
	 * @param inputFileName   String
	 * @param outputFileName  String
	 * @param outputExtention String
	 * @param shape           Shape
	 * @throws IOException
	 * @throws MorphologiqueException
	 * @throws FieldTrackingAssignementException
	 */
	public void gradient(final String inputFileName, final String outputFileName, final String outputExtention, final Shape shape)
			throws IOException, MorphologiqueException, FieldTrackingAssignementException {
		execute(inputFileName, outputFileName, outputExtention, shape);
	}
}
