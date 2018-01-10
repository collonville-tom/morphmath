package org.tc.osgi.bundle.morphmath.core.complexe;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.tc.osgi.bundle.morphmath.core.exception.MorphologiqueException;
import org.tc.osgi.bundle.morphmath.core.module.service.UtilsServiceProxy;
import org.tc.osgi.bundle.utils.exception.FieldTrackingAssignementException;
import org.tc.osgi.bundle.utils.module.service.impl.UtilsServiceImpl;

/**
 * CloseFunctionTest.java.
 * @author thomas collonvillé
 * @version 0.0.2
 * @req STD_BUNDLE_MORPHPATH_030
 * @track SRS_BUNDLE_MORPHPATH_020
 */
public class CloseFunctionTest {

    /**
     * testCloseString.
     */
    @Test
    public void testCloseString() {
        UtilsServiceProxy.getInstance().setService(new UtilsServiceImpl());
        final CloseFunction close = new CloseFunction();
        try {
            close.defaultEllipse2DExecute("src/test/resources/docvierge.bmp");
        } catch (final IOException e) {
            Assert.fail(e.getMessage());
        } catch (final MorphologiqueException e) {

            Assert.fail(e.getMessage());
        } catch (final FieldTrackingAssignementException e) {
            Assert.fail(e.getMessage());
        }
    }

}
