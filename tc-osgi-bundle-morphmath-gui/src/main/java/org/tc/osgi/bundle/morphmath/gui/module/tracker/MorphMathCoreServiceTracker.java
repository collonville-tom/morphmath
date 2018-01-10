package org.tc.osgi.bundle.morphmath.gui.module.tracker;

import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.tc.osgi.bundle.morphmath.core.module.service.IMorphMathCoreService;
import org.tc.osgi.bundle.morphmath.gui.conf.MorphMathGuiPropertyFile;
import org.tc.osgi.bundle.morphmath.gui.module.service.MorphMathCoreServiceProxy;
import org.tc.osgi.bundle.morphmath.gui.module.service.UtilsServiceProxy;
import org.tc.osgi.bundle.utils.conf.XMLPropertyFile;
import org.tc.osgi.bundle.utils.exception.FieldTrackingAssignementException;

/**
 * MorphMathCoreServiceTracker.java.
 * @author Collonville Thomas
 * @version 0.0.1
 */
public class MorphMathCoreServiceTracker extends ServiceTracker {

    /**
     * String morphMathCoreDependencyBundleName.
     */
    private String morphMathCoreDependencyBundleName;

    /**
     * AptServiceTracker constructor.
     * @param context BundleContext
     */
    public MorphMathCoreServiceTracker(final BundleContext context) {
        super(context, IMorphMathCoreService.class.getName(), null);
        try {
            UtilsServiceProxy.getInstance().getBundleStarter().startBundle(this.context, getMorphMathCoreDependencyBundleName());
        } catch (BundleException | FieldTrackingAssignementException e) {
            UtilsServiceProxy.getInstance().getLogger(MorphMathCoreServiceTracker.class).error(e.getMessage(), e);
        }
    }

    /**
     * @param reference ServiceReference
     * @return Object
     * @see org.osgi.util.tracker.ServiceTracker#addingService(org.osgi.framework.ServiceReference)
     */
    @Override
    public Object addingService(final ServiceReference reference) {
        UtilsServiceProxy.getInstance().getLogger(MorphMathCoreServiceTracker.class).debug("Inside MorphMathCoreServiceTracker.addingService " + reference.getBundle());
        return super.addingService(reference);
    }

    /**
     * getMorphMathCoreDependencyBundleName.
     * @return String
     * @throws FieldTrackingAssignementException
     */
    public String getMorphMathCoreDependencyBundleName() throws FieldTrackingAssignementException {
        if (morphMathCoreDependencyBundleName == null) {
            XMLPropertyFile.getInstance(MorphMathGuiPropertyFile.getInstance().getXMLFile()).fieldTraking(this, "morphMathCoreDependencyBundleName");
        }
        UtilsServiceProxy.getInstance().getLogger(MorphMathCoreServiceTracker.class).debug("Lancement auto du bundle :" + morphMathCoreDependencyBundleName);
        return morphMathCoreDependencyBundleName;
    }

    /**
     * getMorphMathCoreService.
     * @return IMorphMathCoreService
     */
    public IMorphMathCoreService getMorphMathCoreService() {
        final IMorphMathCoreService service = (IMorphMathCoreService) super.getService();
        if (service == null) {
            UtilsServiceProxy.getInstance().getLogger(MorphMathCoreServiceProxy.class).debug("MorphMathCoreService null!");
        }
        return service;
    }

    /**
     * @param reference ServiceReference
     * @param service Object
     * @see org.osgi.util.tracker.ServiceTracker#removedService(org.osgi.framework.ServiceReference, java.lang.Object)
     */
    @Override
    public void removedService(final ServiceReference reference, final Object service) {
        UtilsServiceProxy.getInstance().getLogger(MorphMathCoreServiceTracker.class).debug("Inside MorphMathCoreServiceTracker.removedService " + reference.getBundle());
        super.removedService(reference, service);
    }

}
