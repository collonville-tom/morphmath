package org.tc.osgi.bundle.morphmath.gui.module.tracker;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.tc.osgi.bundle.utils.module.service.IUtilsService;

/**
 * AptServiceTracker.java.
 * @author Collonville Thomas
 * @version 0.0.1
 */
public class UtilsServiceTracker extends ServiceTracker {
    /**
     * AptServiceTracker constructor.
     * @param context BundleContext
     */
    public UtilsServiceTracker(final BundleContext context) {
        super(context, IUtilsService.class.getName(), null);
    }

    /**
     * @param reference ServiceReference
     * @return Object
     * @see org.osgi.util.tracker.ServiceTracker#addingService(org.osgi.framework.ServiceReference)
     */
    @Override
    public Object addingService(final ServiceReference reference) {
        if (reference.getBundle().getState() != Bundle.STARTING) {
            try {
                reference.getBundle().start();
            } catch (final BundleException e) {
                System.out.println("Le bundle " + reference.getBundle().getSymbolicName() + "n'a pas pu demarer");
            }
        }
        return super.addingService(reference);
    }

    /**
     * getUtilsService.
     * @return IUtilsService
     */
    public IUtilsService getUtilsService() {
        return (IUtilsService) super.getService();
    }

    /**
     * @param reference ServiceReference
     * @param service Object
     * @see org.osgi.util.tracker.ServiceTracker#removedService(org.osgi.framework.ServiceReference, java.lang.Object)
     */
    @Override
    public void removedService(final ServiceReference reference, final Object service) {
        super.removedService(reference, service);
    }

}
