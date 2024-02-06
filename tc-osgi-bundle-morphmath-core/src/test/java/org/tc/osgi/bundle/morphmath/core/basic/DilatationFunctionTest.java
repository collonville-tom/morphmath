package org.tc.osgi.bundle.morphmath.core.basic;

import java.awt.geom.Ellipse2D;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.tc.osgi.bundle.morphmath.core.exception.MorphologiqueException;
import org.tc.osgi.bundle.morphmath.core.module.service.LoggerServiceProxy;
import org.tc.osgi.bundle.morphmath.core.module.service.PropertyServiceProxy;
import org.tc.osgi.bundle.utils.module.service.impl.LoggerUtilsServiceImpl;
import org.tc.osgi.bundle.utils.module.service.impl.PropertyUtilsServiceImpl;

/**
 * DilatationFunctionTest.java.
 * 
 * @author thomas collonvillé
 * @version 0.0.1
 * @req STD_BUNDLE_MORPHPATH_010
 * @track SRS_BUNDLE_MORPHPATH_010
 */
public class DilatationFunctionTest {

	/**
	 * testDilatationString.
	 */
	@Test
	public void testDilatationString() {
		LoggerServiceProxy.getInstance().setService(new LoggerUtilsServiceImpl());
		PropertyServiceProxy.getInstance().setService(new PropertyUtilsServiceImpl());
		final DilatationFunction dil = new DilatationFunction();
		try {
			dil.dilatation("src/test/resources/docvierge.bmp", "dilatation of docvierge", "bmp", new Ellipse2D.Double(0, 0, 5, 5));
		} catch (final IOException e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		} catch (final MorphologiqueException e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

}
