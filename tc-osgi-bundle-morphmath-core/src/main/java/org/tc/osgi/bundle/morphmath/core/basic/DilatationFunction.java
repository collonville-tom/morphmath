package org.tc.osgi.bundle.morphmath.core.basic;

import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.IOException;

import org.tc.osgi.bundle.morphmath.core.exception.MorphologiqueException;
import org.tc.osgi.bundle.morphmath.core.module.service.LoggerServiceProxy;

/**
 * DilatationFunction.java.
 * 
 * @author collonville thomas
 * @version 0.0.1
 */
public class DilatationFunction extends AbstractBasicFunction {

	/**
	 * DilatationFunction constructor.
	 */
	public DilatationFunction() {
		this("dilatation of ");
	}

	/**
	 * DilatationFunction constructor.
	 * 
	 * @param _defaultNewNameBase String
	 */
	public DilatationFunction(final String _defaultNewNameBase) {
		super(_defaultNewNameBase);
	}

	/**
	 * dilatation.
	 * 
	 * @param inputFileName   String
	 * @param outputFileName  String
	 * @param outputExtention String
	 * @param shape           Shape
	 * @throws IOException
	 * @throws MorphologiqueException
	 */
	public void dilatation(final String inputFileName, final String outputFileName, final String outputExtention, final Shape shape) throws IOException, MorphologiqueException {
		execute(inputFileName, outputFileName, outputExtention, shape);
	}

	/**
	 * dilatation.
	 * 
	 * @param inputFileName   String
	 * @param outputFileName  String
	 * @param outputExtention String
	 * @param shape           Shape
	 * @throws IOException
	 * @throws MorphologiqueException
	 */
	@Override
	protected void execute(final String inputFileName, final String outputFileName, final String outputExtention, final Shape shape) throws IOException, MorphologiqueException {
		LoggerServiceProxy.getInstance().getLogger(this.getClass()).debug("dilatation");
		imageCheking(inputFileName, outputFileName, outputExtention, shape);
	}

	/**
	 * @param inputSubImage BufferedImage
	 * @param area          Area
	 * @param globalX       int
	 * @param globalY       int
	 * @return boolean
	 * @see org.tc.osgi.bundle.morphmath.basic.AbstractBasicFunction#operation(java.awt.image.BufferedImage,
	 *      java.awt.geom.Area, int, int)
	 */
	@Override
	protected boolean operation(final BufferedImage inputSubImage, final Area area, final int globalX, final int globalY) {
		final int globalYValuePos = (int) (globalY + ((area.getBounds().getHeight()) / 2));
		final int globalYValueNeg = (int) ((1 + globalY) - ((area.getBounds().getHeight()) / 2));
		final int globalXValuePos = (int) (globalX + ((area.getBounds().getWidth()) / 2));
		final int globalXValueNeg = (int) ((1 + globalX) - ((area.getBounds().getWidth()) / 2));
		for (int localY = globalYValueNeg; localY < globalYValuePos; localY++) {
			for (int localX = globalXValueNeg; localX < globalXValuePos; localX++) {
				if ((localX >= 0) && (localX < inputSubImage.getWidth()) && (localY >= 0) && (localY < inputSubImage.getHeight())) {
					if (area.contains(localX, localY)) {
						int[] tmp = { 0 };
						tmp = inputSubImage.getRaster().getPixel(localX, localY, tmp);
						if (tmp[0] <= 0) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

}
