package org.tc.osgi.bundle.morphmath.core.complexe;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.tc.osgi.bundle.morphmath.core.exception.MorphologiqueException;
import org.tc.osgi.bundle.morphmath.core.module.service.LoggerServiceProxy;
import org.tc.osgi.bundle.morphmath.core.module.service.PropertyServiceProxy;
import org.tc.osgi.bundle.utils.interf.conf.exception.FieldTrackingAssignementException;
import org.tc.osgi.bundle.utils.module.service.impl.LoggerUtilsServiceImpl;
import org.tc.osgi.bundle.utils.module.service.impl.PropertyUtilsServiceImpl;



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
    	LoggerServiceProxy.getInstance().setService(new LoggerUtilsServiceImpl());
    	PropertyServiceProxy.getInstance().setService(new PropertyUtilsServiceImpl());
        final OpenFunction open = new OpenFunction();
        try {
            open.defaultEllipse2DExecute("./src/test/resources/docvierge.bmp");
        } catch (final Exception e) {
            Assert.fail(e.getMessage());
        }
    }

}
