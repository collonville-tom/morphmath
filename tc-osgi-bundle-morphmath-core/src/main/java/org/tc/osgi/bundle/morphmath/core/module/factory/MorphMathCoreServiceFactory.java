package org.tc.osgi.bundle.morphmath.core.module.factory;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;
import org.tc.osgi.bundle.morphmath.core.module.service.IMorphMathCoreService;
import org.tc.osgi.bundle.morphmath.core.module.service.UtilsServiceProxy;
import org.tc.osgi.bundle.morphmath.core.module.service.impl.MorphMathCoreServiceImpl;

/**
 * MorphMathCoreServiceFactory.java.
 * @author Collonville Thomas
 * @version 0.0.3
 */
public class MorphMathCoreServiceFactory implements ServiceFactory {

    /**
     * int usageCounter.
     */
    private int usageCounter = 0;

    /**
     * @param bundle Bundle
     * @param registration ServiceRegistration
     * @return Object
     * @see org.osgi.framework.ServiceFactory#getService(org.osgi.framework.Bundle, org.osgi.framework.ServiceRegistration)
     */
    @Override
    public Object getService(final Bundle bundle, final ServiceRegistration registration) {
        UtilsServiceProxy.getInstance().getLogger(MorphMathCoreServiceFactory.class).debug("Get MorphMathCoreService for " + bundle.getSymbolicName());
        usageCounter++;
        UtilsServiceProxy.getInstance().getLogger(MorphMathCoreServiceFactory.class).debug("Number of bundles using service " + usageCounter);
        final IMorphMathCoreService aptService = new MorphMathCoreServiceImpl();
        return aptService;
    }

    /**
     * @param bundle Bundle
     * @param registration ServiceRegistration
     * @param service Object
     * @see org.osgi.framework.ServiceFactory#ungetService(org.osgi.framework.Bundle, org.osgi.framework.ServiceRegistration, java.lang.Object)
     */
    @Override
    public void ungetService(final Bundle bundle, final ServiceRegistration registration, final Object service) {
        UtilsServiceProxy.getInstance().getLogger(MorphMathCoreServiceFactory.class).debug("Release MorphMathCoreService for " + bundle.getSymbolicName());
        usageCounter--;
        UtilsServiceProxy.getInstance().getLogger(MorphMathCoreServiceFactory.class).debug("Number of bundles using service " + usageCounter);
    }
}
