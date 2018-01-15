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
    	LoggerServiceProxy.getInstance().setService(new LoggerUtilsServiceImpl());
    	PropertyServiceProxy.getInstance().setService(new PropertyUtilsServiceImpl());
        final CloseFunction close = new CloseFunction();
        try {
            close.defaultEllipse2DExecute("src/test/resources/docvierge.bmp");
        }  catch (final Exception e) {
        	e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

}
