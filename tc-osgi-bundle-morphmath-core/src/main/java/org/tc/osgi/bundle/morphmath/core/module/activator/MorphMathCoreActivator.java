package org.tc.osgi.bundle.morphmath.core.module.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceRegistration;
import org.tc.osgi.bundle.morphmath.core.module.factory.MorphMathCoreServiceFactory;
import org.tc.osgi.bundle.morphmath.core.module.service.IMorphMathCoreService;
import org.tc.osgi.bundle.morphmath.core.module.service.UtilsServiceProxy;
import org.tc.osgi.bundle.morphmath.core.module.tracker.UtilsServiceTracker;
import org.tc.osgi.bundle.utils.logger.LoggerGestionnary;

/**
 * Activator.java.
 * @author Collonville Thomas
 * @version 0.0.1
 */
public class MorphMathCoreActivator implements BundleActivator {

    /**
     * ServiceRegistration helloServiceRegistration.
     */
    private ServiceRegistration morphMathServiceRegistration;

    /**
     * AptServiceTracker aptServiceTracker.
     */
    private UtilsServiceTracker utilsServiceTracker;

    /**
     * activeMorphMathService.
     * @param context BundleContext
     */
    private void activeMorphMathService(final BundleContext context) {
        final MorphMathCoreServiceFactory factory = new MorphMathCoreServiceFactory();
        morphMathServiceRegistration = context.registerService(IMorphMathCoreService.class.getName(), factory, null);
        UtilsServiceProxy.getInstance().getLogger(MorphMathCoreActivator.class).debug("MorphMathCoreService start");
    }

    /**
     * activeTracker.
     * @throws BundleException
     * @throws InvalidSyntaxException
     */
    private void activeUtilsServiceTracker(final BundleContext context) throws InvalidSyntaxException, BundleException {
        utilsServiceTracker = new UtilsServiceTracker(context);
        utilsServiceTracker.open();
        UtilsServiceProxy.getInstance().setService(utilsServiceTracker.getUtilsService());
        UtilsServiceProxy.getInstance().getLogger(MorphMathCoreActivator.class).debug("Start of utils service tracking");

    }

    /**
     * @param context BundleContext
     * @throws Exception
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start(final BundleContext context) throws Exception {
        activeUtilsServiceTracker(context);
        activeMorphMathService(context);

    }

    /**
     * @param context BundleContext
     * @throws Exception
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop(final BundleContext context) throws Exception {
        stopUtilsServiceTracker();
        stopMorphMathService();

    }

    /**
     * stopMorphMathService.
     */
    private void stopMorphMathService() {
        morphMathServiceRegistration.unregister();
        UtilsServiceProxy.getInstance().getLogger(MorphMathCoreActivator.class).debug("MorphMathCoreService stop");
    }

    /**
     * stopTracker.
     *
     */
    private void stopUtilsServiceTracker() {
        LoggerGestionnary.getInstance(MorphMathCoreActivator.class).debug("Stop of utils service tracking");
        utilsServiceTracker.close();
    }

}
