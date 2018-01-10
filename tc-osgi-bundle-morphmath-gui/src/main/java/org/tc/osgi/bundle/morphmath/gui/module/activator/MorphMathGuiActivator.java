package org.tc.osgi.bundle.morphmath.gui.module.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.InvalidSyntaxException;
import org.tc.osgi.bundle.morphmath.gui.conf.MorphMathGuiPropertyFile;
import org.tc.osgi.bundle.morphmath.gui.module.service.GuiUtilsServiceProxy;
import org.tc.osgi.bundle.morphmath.gui.module.service.MorphMathCoreServiceProxy;
import org.tc.osgi.bundle.morphmath.gui.module.service.UtilsServiceProxy;
import org.tc.osgi.bundle.morphmath.gui.module.tracker.GuiUtilsServiceTracker;
import org.tc.osgi.bundle.morphmath.gui.module.tracker.MorphMathCoreServiceTracker;
import org.tc.osgi.bundle.morphmath.gui.module.tracker.UtilsServiceTracker;
import org.tc.osgi.bundle.morphmath.gui.pane.MainFrame;
import org.tc.osgi.bundle.utils.exception.FieldTrackingAssignementException;
import org.tc.osgi.bundle.utils.logger.LoggerGestionnary;

/**
 * Activator.java.
 * @author Collonville Thomas
 * @version 0.0.1
 */
public class MorphMathGuiActivator implements BundleActivator {

    /**
     * String AUTO_BUNDLE_NAME.
     */
    public static final String AUTO_BUNDLE_NAME = "tc-osgi-bundle-morphmath-gui";

    /**
     * String guiUtilsDependencyBundleName.
     */
    private String guiUtilsDependencyBundleName;

    /**
     * GuiUtilsServiceTracker guiUtilsServiceTracker.
     */
    private GuiUtilsServiceTracker guiUtilsServiceTracker;

    /**
     * MainFrame mainApp.
     */
    private MainFrame mainApp;

    /**
     * MorphMathCoreServiceTracker morphMathCoreServiceTracker.
     */
    private MorphMathCoreServiceTracker morphMathCoreServiceTracker;

    /**
     * AptServiceTracker aptServiceTracker.
     */
    private UtilsServiceTracker utilsServiceTracker;

    /**
     * activeGuiUtilsServiceTracker.
     * @param context
     * @throws InvalidSyntaxException
     * @throws BundleException
     */
    private void activeGuiUtilsServiceTracker(final BundleContext context) throws InvalidSyntaxException, BundleException {
        guiUtilsServiceTracker = new GuiUtilsServiceTracker(context);
        guiUtilsServiceTracker.open();
        GuiUtilsServiceProxy.getInstance().setService(guiUtilsServiceTracker.getIGuiUtilsService());
        UtilsServiceProxy.getInstance().getLogger(MorphMathGuiActivator.class).debug("Start of gui-utils service tracking");

    }

    /**
     * activeMorphMathCoreServiceTracker.
     * @param context
     */
    private void activeMorphMathCoreServiceTracker(final BundleContext context) {
        morphMathCoreServiceTracker = new MorphMathCoreServiceTracker(context);
        morphMathCoreServiceTracker.open();
        MorphMathCoreServiceProxy.getInstance().setService(morphMathCoreServiceTracker.getMorphMathCoreService());
        UtilsServiceProxy.getInstance().getLogger(MorphMathGuiActivator.class).debug("Start of morphmath-core service tracking");

    }

    /**
     * activeTracker.
     */
    private void activeUtilsServiceTracker(final BundleContext context) {
        utilsServiceTracker = new UtilsServiceTracker(context);
        utilsServiceTracker.open();
        UtilsServiceProxy.getInstance().setService(utilsServiceTracker.getUtilsService());
        UtilsServiceProxy.getInstance().getLogger(MorphMathGuiActivator.class).debug("Start of utils service tracking");

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

    /**
     * @param context BundleContext
     * @throws Exception
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start(final BundleContext context) throws Exception {
        activeUtilsServiceTracker(context);
        activeMorphMathCoreServiceTracker(context);
        activeGuiUtilsServiceTracker(context);
        mainApp = new MainFrame(context);
        mainApp.setVisible(true);
    }

    /**
     * @param context BundleContext
     * @throws Exception
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop(final BundleContext context) throws Exception {
        stopGuiUtilsServiceTracker();
        stopMorphMathCoreServiceTracker();
        stopUtilsServiceTracker();
        mainApp.setVisible(false);
        mainApp = null;

    }

    /**
     * stopGuiUtilsServiceTracker.
     */
    private void stopGuiUtilsServiceTracker() {
        UtilsServiceProxy.getInstance().getLogger(MorphMathGuiActivator.class).debug("Stop of gui-utils service tracking");
        guiUtilsServiceTracker.close();
    }

    /**
     * stopTracker.
     *
     */
    private void stopMorphMathCoreServiceTracker() {
        LoggerGestionnary.getInstance(MorphMathGuiActivator.class).debug("Stop of morphmath-core service tracking");
        morphMathCoreServiceTracker.close();

    }

    /**
     * stopTracker.
     *
     */
    private void stopUtilsServiceTracker() {
        UtilsServiceProxy.getInstance().getLogger(MorphMathGuiActivator.class).debug("Stop of utils service tracking");
        utilsServiceTracker.close();
    }
}
