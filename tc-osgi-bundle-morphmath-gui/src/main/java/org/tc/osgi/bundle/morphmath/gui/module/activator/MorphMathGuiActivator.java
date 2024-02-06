package org.tc.osgi.bundle.morphmath.gui.module.activator;

import org.osgi.framework.BundleContext;
import org.tc.osgi.bundle.morphmath.core.module.service.IMorphMathCoreService;
import org.tc.osgi.bundle.morphmath.gui.module.service.LoggerServiceProxy;
import org.tc.osgi.bundle.morphmath.gui.module.service.MorphMathCoreServiceProxy;
import org.tc.osgi.bundle.morphmath.gui.module.service.PropertyServiceProxy;
import org.tc.osgi.bundle.morphmath.gui.pane.MainFrame;
import org.tc.osgi.bundle.utils.interf.exception.TcOsgiException;
import org.tc.osgi.bundle.utils.interf.module.service.ILoggerUtilsService;
import org.tc.osgi.bundle.utils.interf.module.service.IPropertyUtilsService;
import org.tc.osgi.bundle.utils.interf.module.utils.AbstractTcOsgiActivator;
import org.tc.osgi.bundle.utils.interf.module.utils.TcOsgiProxy;

/**
 * Activator.java.
 * 
 * @author Collonville Thomas
 * @version 0.0.1
 */
public class MorphMathGuiActivator extends AbstractTcOsgiActivator {

	private TcOsgiProxy<ILoggerUtilsService> iLoggerUtilsService;
	private TcOsgiProxy<IPropertyUtilsService> iPropertyUtilsService;
	private TcOsgiProxy<IMorphMathCoreService> iMorphMathCoreService;
	/**
	 * String AUTO_BUNDLE_NAME.
	 */
	public static final String AUTO_BUNDLE_NAME = "tc-osgi-bundle-morphmath-gui";

	/**
	 * MainFrame mainApp.
	 */
	private MainFrame mainApp;

	@Override
	protected void checkInitBundleUtilsService(BundleContext context) throws TcOsgiException {
		throw new TcOsgiException("checkInitBundleUtilsService not implemented");

	}

	@Override
	protected void initProxys(BundleContext context) throws TcOsgiException {
		this.iPropertyUtilsService = new TcOsgiProxy<IPropertyUtilsService>(context, IPropertyUtilsService.class);
		PropertyServiceProxy.getInstance().setService(this.iPropertyUtilsService.getInstance());
		this.iLoggerUtilsService = new TcOsgiProxy<ILoggerUtilsService>(context, ILoggerUtilsService.class);
		LoggerServiceProxy.getInstance().setService(this.iLoggerUtilsService.getInstance());
		this.iMorphMathCoreService = new TcOsgiProxy<IMorphMathCoreService>(context, IMorphMathCoreService.class);
		MorphMathCoreServiceProxy.getInstance().setService(this.iMorphMathCoreService.getInstance());

	}

	@Override
	protected void initServices(BundleContext context) throws TcOsgiException {
		// No services

	}

	@Override
	protected void detachProxys(BundleContext context) throws TcOsgiException {
		this.iLoggerUtilsService.close();
		this.iPropertyUtilsService.close();
		this.iMorphMathCoreService.close();

	}

	@Override
	protected void detachServices(BundleContext context) throws TcOsgiException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void beforeStart(BundleContext context) throws TcOsgiException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void beforeStop(BundleContext context) throws TcOsgiException {
		mainApp.setVisible(false);
		mainApp = null;

	}

	@Override
	protected void afterStart(BundleContext context) throws TcOsgiException {
		mainApp = new MainFrame(context);
		mainApp.setVisible(true);

	}

	@Override
	protected void afterStop(BundleContext context) throws TcOsgiException {
		// TODO Auto-generated method stub

	}
}
