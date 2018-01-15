package org.tc.osgi.bundle.morphmath.core.complexe;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.tc.osgi.bundle.morphmath.core.exception.MorphologiqueException;
import org.tc.osgi.bundle.morphmath.core.module.service.LoggerServiceProxy;
import org.tc.osgi.bundle.morphmath.core.module.service.PropertyServiceProxy;
import org.tc.osgi.bundle.utils.interf.conf.exception.FieldTrackingAssignementException;
import org.tc.osgi.bundle.utils.module.service.impl.LoggerUtilsServiceImpl;
import org.tc.osgi.bundle.utils.module.service.impl.PropertyUtilsServiceImpl;
import org.tc.osgi.bundle.utils.module.service.impl.UtilsServiceImpl;


/**
 * GradientFunctionTest.java.
 * @author thomas collonvillé
 * @version 0.0.2
 * @req STD_BUNDLE_MORPHPATH_040
 * @track SRS_BUNDLE_MORPHPATH_030
 */
public class GradientFunctionTest {

    /**
     * testGradientString.
     */
    @Test
    public void testGradientString() {
    	LoggerServiceProxy.getInstance().setService(new LoggerUtilsServiceImpl());
    	PropertyServiceProxy.getInstance().setService(new PropertyUtilsServiceImpl());
        final GradientFunction grad = new GradientFunction();
        try {
            grad.defaultEllipse2DExecute("src/test/resources/docvierge.bmp");

        }  catch (final Exception e) {
            Assert.fail(e.getMessage());
        }
    }

}
