package org.tc.osgi.bundle.morphmath.gui.conf;

import org.tc.osgi.bundle.utils.conf.AbstractPropertyFile;

/**
 * MorphMathGuiPropertyFile.java.
 * @author collonville thomas
 * @version
 * @track
 */
public class MorphMathGuiPropertyFile extends AbstractPropertyFile {

    /**
     * String BUNDLE_RACINE.
     */
    public final static String BUNDLE_RACINE = "tc.osgi.bundle.morphmath-gui.";

    /**
     * MorphMathGuiPropertyFile instance.
     */
    public static MorphMathGuiPropertyFile instance = null;

    /**
     * String MORPH_GUI_FILE.
     */
    public static final String MORPH_GUI_FILE = "morph-gui";

    /**
     * getInstance.
     * @return
     */
    public static MorphMathGuiPropertyFile getInstance() {
        if (MorphMathGuiPropertyFile.instance == null) {
            MorphMathGuiPropertyFile.instance = new MorphMathGuiPropertyFile();
        }
        return MorphMathGuiPropertyFile.instance;
    }

    /**
     * String actionGo.
     */
    private String actionGo = null;

    /**
     * String actionSelect.
     */
    private String actionSelect = null;

    /**
     * String close.
     */
    private String close = null;

    /**
     * String dilatation.
     */
    private String dilatation = null;

    /**
     * String erosion.
     */
    private String erosion = null;

    /**
     * String error.
     */
    private String error = null;

    /**
     * String gradient.
     */
    private String gradient = null;

    /**
     * String open.
     */
    private String open = null;

    /**
     * MorphMathGuiPropertyFile constructor.
     */
    private MorphMathGuiPropertyFile() {
        super(MorphMathGuiPropertyFile.MORPH_GUI_FILE, MorphMathGuiPropertyFile.class.getClassLoader());
    }

    /**
     * getActionGo.
     * @return String
     */
    public String getActionGo() {
        if (actionGo == null) {
            actionGo = getResourceBundle().getString(getBundleRacine() + "action.go");
        }
        return actionGo;
    }

    /**
     * getActionSelect.
     * @return String
     */
    public String getActionSelect() {
        if (actionSelect == null) {
            actionSelect = getResourceBundle().getString(getBundleRacine() + "action.select");
        }
        return actionSelect;
    }

    /**
     * @return String
     * @see org.tc.osgi.bundle.utils.conf.AbstractPropertyFile#getBundleRacine()
     */
    @Override
    public String getBundleRacine() {
        return MorphMathGuiPropertyFile.BUNDLE_RACINE;
    }

    /**
     * getClose.
     * @return String
     */
    public String getClose() {
        if (close == null) {
            close = getResourceBundle().getString(getBundleRacine() + "fonction.close");
        }
        return close;
    }

    /**
     * @return String
     * @see org.tc.osgi.bundle.utils.conf.AbstractPropertyFile#getConfFile()
     */
    @Override
    public String getConfFile() {
        return MorphMathGuiPropertyFile.MORPH_GUI_FILE;
    }

    /**
     * getDilatation.
     * @return String
     */
    public String getDilatation() {
        if (dilatation == null) {
            dilatation = getResourceBundle().getString(getBundleRacine() + "fonction.dilatation");
        }
        return dilatation;
    }

    /**
     * getErosion.
     * @return String
     */
    public String getErosion() {
        if (erosion == null) {
            erosion = getResourceBundle().getString(getBundleRacine() + "fonction.erosion");
        }
        return erosion;
    }

    /**
     * getError.
     * @return String
     */
    public String getError() {
        if (error == null) {
            error = getResourceBundle().getString(getBundleRacine() + "message.error");
        }
        return error;
    }

    /**
     * getGradient.
     * @return String
     */
    public String getGradient() {
        if (gradient == null) {
            gradient = getResourceBundle().getString(getBundleRacine() + "fonction.gradient");
        }
        return gradient;
    }

    /**
     * getOpen.
     * @return String
     */
    public String getOpen() {
        if (open == null) {
            open = getResourceBundle().getString(getBundleRacine() + "fonction.open");
        }
        return open;
    }

    /**
     * @return String
     * @see org.tc.osgi.bundle.utils.conf.AbstractPropertyFile#getXMLFile()
     */
    @Override
    public String getXMLFile() {
        return MorphMathGuiPropertyFile.getInstance().getConfigDirectory() + getConfFile();
    }

}
