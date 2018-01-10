package org.tc.osgi.bundle.morphmath.gui.module.tracker;

import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.tc.osgi.bundle.gui.utils.module.service.IGuiUtilsService;
import org.tc.osgi.bundle.morphmath.gui.conf.MorphMathGuiPropertyFile;
import org.tc.osgi.bundle.morphmath.gui.module.service.UtilsServiceProxy;
import org.tc.osgi.bundle.utils.exception.FieldTrackingAssignementException;

/**
 * UtilsServiceTracker.java.
 * @author Collonville Thomas
 * @version 0.0.1
 */
public class GuiUtilsServiceTracker extends ServiceTracker {

    /**
     * String guiUtilsDependencyBundleName.
     */
    private String guiUtilsDependencyBundleName;

    /**
     * AptServiceTracker constructor.
     * @param context BundleContext
     * @throws InvalidSyntaxException
     * @throws BundleException
     */
    public GuiUtilsServiceTracker(final BundleContext context) throws InvalidSyntaxException, BundleException {
        super(context, IGuiUtilsService.class.getName(), null);
        try {
            UtilsServiceProxy.getInstance().getBundleStarter().startBundle(this.context, getGuiUtilsDependencyBundleName());
            Thread.sleep(5000);
        } catch (BundleException | FieldTrackingAssignementException e) {
            UtilsServiceProxy.getInstance().getLogger(GuiUtilsServiceTracker.class).error(e.getMessage(), e);
        } catch (final InterruptedException e) {
            UtilsServiceProxy.getInstance().getLogger(GuiUtilsServiceTracker.class).error(e.getMessage(), e);
        }
    }

    /**
     * @param reference ServiceReference
     * @return Object
     * @see org.osgi.util.tracker.ServiceTracker#addingService(org.osgi.framework.ServiceReference)
     */
    @Override
    public Object addingService(final ServiceReference reference) {
        UtilsServiceProxy.getInstance().getLogger(GuiUtilsServiceTracker.class).debug("Inside GuiUtilsServiceTracker.addingService " + reference.getBundle());
        return super.addingService(reference);
    }

    /**
     * getGuiUtilsDependencyBundleName.
     * @return String
     * @throws FieldTrackingAssignementException
     */
    private String getGuiUtilsDependencyBundleName() throws FieldTrackingAssignementException {
        if (guiUtilsDependencyBundleName == null) {
            UtilsServiceProxy.getInstance().getXMLPropertyFile(MorphMathGuiPropertyFile.getInstance().getXMLFile()).fieldTraking(this, "guiUtilsDependencyBundleName");
        }

        return guiUtilsDependencyBundleName;
    }

    public IGuiUtilsService getIGuiUtilsService() {
        return (IGuiUtilsService) super.getService();
    }

    /**
     * @param reference ServiceReference
     * @param service Object
     * @see org.osgi.util.tracker.ServiceTracker#removedService(org.osgi.framework.ServiceReference, java.lang.Object)
     */
    @Override
    public void removedService(final ServiceReference reference, final Object service) {
        UtilsServiceProxy.getInstance().getLogger(GuiUtilsServiceTracker.class).debug("Inside GuiUtilsServiceTracker.removedService " + reference.getBundle());
        super.removedService(reference, service);
    }

}
