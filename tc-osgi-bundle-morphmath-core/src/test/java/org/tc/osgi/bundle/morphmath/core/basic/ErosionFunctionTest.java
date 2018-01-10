package org.tc.osgi.bundle.morphmath.core.basic;

import java.awt.geom.Ellipse2D;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.tc.osgi.bundle.morphmath.core.exception.MorphologiqueException;
import org.tc.osgi.bundle.morphmath.core.module.service.UtilsServiceProxy;
import org.tc.osgi.bundle.utils.module.service.impl.UtilsServiceImpl;

/**
 * ErosionFunctionTest.java.
 * @author thomas collonvillé
 * @version 0.0.1
 * @req STD_BUNDLE_MORPHPATH_020
 * @track SRS_BUNDLE_MORPHPATH_015
 */
public class ErosionFunctionTest {

    /**
     * testErosionString.
     */
    @Test
    public void testErosionString() {
        UtilsServiceProxy.getInstance().setService(new UtilsServiceImpl());
        final ErosionFunction ero = new ErosionFunction();
        try {
            ero.erosion("src/test/resources/docvierge.bmp", "erosion of docvierge", "bmp", new Ellipse2D.Double(0, 0, 5, 5));
        } catch (final IOException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        } catch (final MorphologiqueException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }

    }
}
