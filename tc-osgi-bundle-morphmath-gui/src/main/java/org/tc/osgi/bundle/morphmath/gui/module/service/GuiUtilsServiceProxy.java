package org.tc.osgi.bundle.morphmath.gui.module.service;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;

import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.osgi.framework.BundleContext;
import org.tc.osgi.bundle.gui.utils.interf.location.IDialogLocationControl;
import org.tc.osgi.bundle.gui.utils.interf.module.service.IGuiUtilsService;
import org.tc.osgi.bundle.utils.interf.exception.TcOsgiException;

/**
 * GuiUtilsServiceProxy.java.
 * 
 * @author collonville thomas
 * @version
 * @track
 */
public class GuiUtilsServiceProxy implements IGuiUtilsService {

	/**
	 * GuiUtilsServiceProxy instance.
	 */
	private static GuiUtilsServiceProxy instance = null;

	/**
	 * getInstance.
	 * 
	 * @return
	 */
	public static GuiUtilsServiceProxy getInstance() {
		if (GuiUtilsServiceProxy.instance == null) {
			GuiUtilsServiceProxy.instance = new GuiUtilsServiceProxy();
		}
		return GuiUtilsServiceProxy.instance;
	}

	/**
	 * IGuiUtilsService service.
	 */
	private IGuiUtilsService service = null;

	/**
	 * GuiUtilsServiceProxy constructor.
	 */
	private GuiUtilsServiceProxy() {
	}

	/**
	 * @param menu JMenuItem
	 * @return BasicMouseAdapter
	 * @see org.tc.osgi.bundle.gui.utils.module.service.IGuiUtilsService#getBasicMouseAdapter(javax.swing.JMenuItem)
	 */
	@Override
	public MouseAdapter getBasicMouseAdapter(final JMenuItem menu) {
		return service.getBasicMouseAdapter(menu);
	}

	@Override
	public WindowAdapter getBundleClosingWindowsAdapter(final BundleContext context, final String autoBundleName) throws TcOsgiException {
		return service.getBundleClosingWindowsAdapter(context, autoBundleName);
	}

	/**
	 * @param image Image
	 * @return ImagePane
	 * @see org.tc.osgi.bundle.gui.utils.module.service.IGuiUtilsService#getImagePane(java.awt.Image)
	 */
	@Override
	public JPanel getImagePane(final Image image) {
		return service.getImagePane(image);
	}

	/**
	 * @param dialog JDialog
	 * @return DialogLocationControl
	 * @see org.tc.osgi.bundle.gui.utils.module.service.IGuiUtilsService#getLocationControl(javax.swing.JDialog)
	 */
	@Override
	public IDialogLocationControl getLocationControl(final JDialog dialog) {
		return service.getLocationControl(dialog);
	}

	/**
	 * getService.
	 * 
	 * @return IGuiUtilsService
	 */
	public IGuiUtilsService getService() {
		return service;
	}

	/**
	 * setService.
	 * 
	 * @param service IGuiUtilsService
	 */
	public void setService(final IGuiUtilsService service) {
		this.service = service;
	}

}
