package org.tc.osgi.bundle.morphmath.gui.pane;

import org.fest.swing.annotation.RunsInEDT;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.junit.testcase.FestSwingJUnitTestCase;
import org.junit.Assert;
import org.junit.Test;
import org.tc.osgi.bundle.morphmath.core.module.service.impl.MorphMathCoreServiceImpl;
import org.tc.osgi.bundle.morphmath.gui.module.service.MorphMathCoreServiceProxy;
import org.tc.osgi.bundle.utils.exception.FieldTrackingAssignementException;
import org.tc.osgi.bundle.utils.module.service.impl.UtilsServiceImpl;

public class MainFrameTest extends FestSwingJUnitTestCase {

    /**
     * createNewEditor.
     * @return MainFrame
     */
    @RunsInEDT
    private static MainFrame createNewEditor() {
        final GuiQuery<MainFrame> query = new GuiQuery<MainFrame>() {
            @Override
            protected MainFrame executeInEDT() {
                MainFrame app = null;
                try {
                    app = new MainFrame(null);

                } catch (final FieldTrackingAssignementException e) {
                    Assert.fail(e.getMessage());
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

        org.tc.osgi.bundle.morphmath.core.module.service.UtilsServiceProxy.getInstance().setService(new UtilsServiceImpl());
        org.tc.osgi.bundle.morphmath.gui.module.service.UtilsServiceProxy.getInstance().setService(new UtilsServiceImpl());
        MorphMathCoreServiceProxy.getInstance().setService(new MorphMathCoreServiceImpl());

        editor = new FrameFixture(robot(), MainFrameTest.createNewEditor());
        editor.show();
    }

    /**
     * profilCreationSelection.
     */
    @Test
    public void profilCreationSelection() {
        editor.menuItem("Select MorphMath Action").click();
        editor.comboBox("combo1").selectItem("dilatation").click();

        editor.menuItem("GO").click();

        editor.fileChooser().fileNameTextBox().setText("X:/repo_java/tc-osgi-parent/tc-osgi-morphmath/tc-osgi-bundle-morphmath-gui/src/test/resources/docvierge.bmp");
        editor.fileChooser().approve();

        try {
            Thread.sleep(500);
        } catch (final InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        editor.close();

    }

    @Test
    public void profilCreationSelection2() {
        editor.menuItem("Select MorphMath Action").click();
        editor.comboBox("combo1").selectItem("erosion").click();

        editor.menuItem("GO").click();

        editor.fileChooser().fileNameTextBox().setText("X:/repo_java/tc-osgi-parent/tc-osgi-morphmath/tc-osgi-bundle-morphmath-gui/src/test/resources/docvierge.bmp");
        editor.fileChooser().approve();

        try {
            Thread.sleep(500);
        } catch (final InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        editor.close();

    }

    @Test
    public void profilCreationSelection3() {
        editor.menuItem("Select MorphMath Action").click();
        editor.comboBox("combo1").selectItem("close").click();

        editor.menuItem("GO").click();

        editor.fileChooser().fileNameTextBox().setText("X:/repo_java/tc-osgi-parent/tc-osgi-morphmath/tc-osgi-bundle-morphmath-gui/src/test/resources/docvierge.bmp");
        editor.fileChooser().approve();

        try {
            Thread.sleep(500);
        } catch (final InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        editor.close();

    }

    @Test
    public void profilCreationSelection4() {
        editor.menuItem("Select MorphMath Action").click();
        editor.comboBox("combo1").selectItem("open").click();

        editor.menuItem("GO").click();

        editor.fileChooser().fileNameTextBox().setText("X:/repo_java/tc-osgi-parent/tc-osgi-morphmath/tc-osgi-bundle-morphmath-gui/src/test/resources/docvierge.bmp");
        editor.fileChooser().approve();

        try {
            Thread.sleep(500);
        } catch (final InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        editor.close();

    }

    /**
     * profilCreationSelection.
     */
    @Test
    public void profilCreationSelection5() {
        editor.menuItem("Select MorphMath Action").click();
        editor.comboBox("combo1").selectItem("gradient").click();

        editor.menuItem("GO").click();

        editor.fileChooser().fileNameTextBox().setText("X:/repo_java/tc-osgi-parent/tc-osgi-morphmath/tc-osgi-bundle-morphmath-gui/src/test/resources/docvierge.bmp");
        editor.fileChooser().approve();

        try {
            Thread.sleep(500);
        } catch (final InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        editor.close();

    }

}
