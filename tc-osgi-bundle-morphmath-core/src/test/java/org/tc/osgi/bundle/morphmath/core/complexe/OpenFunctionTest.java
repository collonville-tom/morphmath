package org.tc.osgi.bundle.morphmath.core.complexe;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.tc.osgi.bundle.morphmath.core.exception.MorphologiqueException;
import org.tc.osgi.bundle.morphmath.core.module.service.UtilsServiceProxy;
import org.tc.osgi.bundle.utils.exception.FieldTrackingAssignementException;
import org.tc.osgi.bundle.utils.module.service.impl.UtilsServiceImpl;

/**
 * OpenFunctionTest.java.
 * @author thomas collonvillé
 * @version 0.0.2
 * @req STD_BUNDLE_MORPHPATH_050
 * @track SRS_BUNDLE_MORPHPATH_040
 */
public class OpenFunctionTest {

    /**
     * testOpenString.
     */
    @Test
    public void testOpenString() {
        UtilsServiceProxy.getInstance().setService(new UtilsServiceImpl());
        final OpenFunction open = new OpenFunction();
        try {
            open.defaultEllipse2DExecute("src/test/resources/docvierge.bmp");
        } catch (final IOException e) {
            Assert.fail(e.getMessage());
        } catch (final MorphologiqueException e) {
            Assert.fail(e.getMessage());
        } catch (final FieldTrackingAssignementException e) {
            Assert.fail(e.getMessage());
        }
    }

}
