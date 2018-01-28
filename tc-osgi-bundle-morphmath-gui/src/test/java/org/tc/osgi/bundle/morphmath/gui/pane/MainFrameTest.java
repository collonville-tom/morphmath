package org.tc.osgi.bundle.morphmath.gui.pane;

import java.io.File;

import org.fest.swing.annotation.RunsInEDT;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.junit.testcase.FestSwingJUnitTestCase;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.osgi.framework.BundleContext;
import org.tc.osgi.bundle.gui.utils.module.service.impl.GuiUtilsServiceImpl;
import org.tc.osgi.bundle.morphmath.core.module.service.LoggerServiceProxy;

import org.tc.osgi.bundle.morphmath.core.module.service.impl.MorphMathCoreServiceImpl;
import org.tc.osgi.bundle.morphmath.gui.module.service.GuiUtilsServiceProxy;
import org.tc.osgi.bundle.utils.interf.module.exception.TcOsgiException;
import org.tc.osgi.bundle.utils.module.service.impl.LoggerUtilsServiceImpl;
import org.tc.osgi.bundle.utils.module.service.impl.PropertyUtilsServiceImpl;

public class MainFrameTest extends FestSwingJUnitTestCase {

	static {

        System.setProperty("java.awt.headless", "false");
	}
	
	/**
	 * createNewEditor.
	 * 
	 * @param context
	 * @return MainFrame
	 */
	@RunsInEDT
	private static MainFrame createNewEditor(BundleContext context) {
		final GuiQuery<MainFrame> query = new GuiQuery<MainFrame>() {
			@Override
			protected MainFrame executeInEDT() {
				MainFrame app = null;
				try {
					app = new MainFrame(context);// mettre un mock du bundle context ou degager les utilisations du
													// bundle context pour les tests

				} catch (final TcOsgiException e) {
					e.printStackTrace();
				}
				return app;
			}
		};
		return GuiActionRunner.execute(query);
		
	}

	/**
	 * FrameFixture editor.
	 */
	private FrameFixture editor;

	/**
	 *
	 * @see org.fest.swing.junit.testcase.FestSwingJUnitTestCase#onSetUp()
	 */
	@Override
	protected void onSetUp() {
		try {
			PropertyUtilsServiceImpl p = new PropertyUtilsServiceImpl();
			LoggerUtilsServiceImpl l = new LoggerUtilsServiceImpl();

			LoggerServiceProxy.getInstance().setService(new LoggerUtilsServiceImpl());

			org.tc.osgi.bundle.morphmath.core.module.service.PropertyServiceProxy.getInstance().setService(p);
			org.tc.osgi.bundle.morphmath.core.module.service.LoggerServiceProxy.getInstance().setService(l);
			org.tc.osgi.bundle.morphmath.gui.module.service.PropertyServiceProxy.getInstance().setService(p);
			org.tc.osgi.bundle.morphmath.gui.module.service.LoggerServiceProxy.getInstance().setService(l);

			GuiUtilsServiceProxy.getInstance().setService(new GuiUtilsServiceImpl());

			BundleContext context = Mockito.mock(BundleContext.class);

			org.tc.osgi.bundle.morphmath.gui.module.service.MorphMathCoreServiceProxy.getInstance()
					.setService(new MorphMathCoreServiceImpl());

			editor = new FrameFixture(robot(), MainFrameTest.createNewEditor(context));
			editor.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * profilCreationSelection.
	 */
	@Test
	public void profilCreationSelection() {
		try {
			editor.menuItem("Select MorphMath Action").click();
			editor.comboBox("combo1").selectItem("dilatation").click();

			editor.menuItem("GO").click();
			System.out.println(new File(".").getAbsolutePath());
			editor.fileChooser().fileNameTextBox().setText(
					"X:/repo_java/tc-osgi-parent/tc-osgi-morphmath/tc-osgi-bundle-morphmath-gui/src/test/resources/docvierge.bmp");
			editor.fileChooser().approve();

			Thread.sleep(500);
			editor.close();
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

	@Test
	public void profilCreationSelection2() {
		try {
			editor.menuItem("Select MorphMath Action").click();
			editor.comboBox("combo1").selectItem("erosion").click();

			editor.menuItem("GO").click();

			editor.fileChooser().fileNameTextBox().setText(
					"X:/repo_java/tc-osgi-parent/tc-osgi-morphmath/tc-osgi-bundle-morphmath-gui/src/test/resources/docvierge.bmp");
			editor.fileChooser().approve();

			Thread.sleep(500);
			editor.close();
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

	@Test
	public void profilCreationSelection3() {
		try {
			editor.menuItem("Select MorphMath Action").click();
			editor.comboBox("combo1").selectItem("close").click();

			editor.menuItem("GO").click();

			editor.fileChooser().fileNameTextBox().setText(
					"X:/repo_java/tc-osgi-parent/tc-osgi-morphmath/tc-osgi-bundle-morphmath-gui/src/test/resources/docvierge.bmp");
			editor.fileChooser().approve();

			Thread.sleep(500);
			editor.close();
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

	@Test
	public void profilCreationSelection4() {
		try {
			editor.menuItem("Select MorphMath Action").click();
			editor.comboBox("combo1").selectItem("open").click();

			editor.menuItem("GO").click();

			editor.fileChooser().fileNameTextBox().setText(
					"X:/repo_java/tc-osgi-parent/tc-osgi-morphmath/tc-osgi-bundle-morphmath-gui/src/test/resources/docvierge.bmp");
			editor.fileChooser().approve();

			Thread.sleep(500);
			editor.close();
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

	/**
	 * profilCreationSelection.
	 */
	@Test
	public void profilCreationSelection5() {
		try {
			editor.menuItem("Select MorphMath Action").click();
			editor.comboBox("combo1").selectItem("gradient").click();

			editor.menuItem("GO").click();

			editor.fileChooser().fileNameTextBox().setText(
					"X:/repo_java/tc-osgi-parent/tc-osgi-morphmath/tc-osgi-bundle-morphmath-gui/src/test/resources/docvierge.bmp");
			editor.fileChooser().approve();

			Thread.sleep(500);
			editor.close();
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

}
