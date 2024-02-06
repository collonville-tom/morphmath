package org.tc.osgi.bundle.morphmath.core.conf;

import org.tc.osgi.bundle.morphmath.core.module.service.PropertyServiceProxy;
import org.tc.osgi.bundle.utils.interf.conf.AbstractPropertyFile;
import org.tc.osgi.bundle.utils.interf.conf.exception.FieldTrackingAssignementException;

/**
 * DefaultConfig.java.
 * 
 * @author collonville thomas
 * @version 0.0.2
 */
public class MorphMathCorePropertyFile extends AbstractPropertyFile {

	/**
	 * String BUNDLE_RACINE.
	 */
	public final static String BUNDLE_RACINE = "tc.osgi.bundle.morphmath-core.";

	/**
	 * DefaultConfig conf.
	 */
	private static MorphMathCorePropertyFile instance = null;

	/**
	 * String MORPH_CORE_FILE.
	 */
	public static final String MORPH_CORE_FILE = "morph-core";

	/**
	 * getInstance.
	 * 
	 * @return DefaultConfig
	 * @throws MorphConfigException
	 * @throws FieldTrackingAssignementException
	 */
	public static MorphMathCorePropertyFile getInstance() {
		if (MorphMathCorePropertyFile.instance == null) {
			MorphMathCorePropertyFile.instance = new MorphMathCorePropertyFile();
		}
		return MorphMathCorePropertyFile.instance;
	}

	/**
	 * Integer ellipse_h.
	 */
	private final String ellipse_h = null;

	/**
	 * Integer ellipse_w.
	 */
	private final String ellipse_w = null;

	/**
	 * Integer ellipse_x.
	 */
	private final String ellipse_x = null;

	/**
	 * Integer ellipse_y.
	 */
	private final String ellipse_y = null;

	/**
	 * DefaultConfig constructor.
	 * 
	 * @throws MorphConfigException
	 * @throws FieldTrackingAssignementException
	 */
	private MorphMathCorePropertyFile() {
		super(MorphMathCorePropertyFile.MORPH_CORE_FILE, MorphMathCorePropertyFile.class.getClassLoader());
	}

	@Override
	public String getBundleRacine() {
		return MorphMathCorePropertyFile.BUNDLE_RACINE;
	}

	@Override
	public String getConfFile() {
		return MorphMathCorePropertyFile.MORPH_CORE_FILE;
	}

	/**
	 * getEllipse_H.
	 * 
	 * @return Integer
	 * @throws FieldTrackingAssignementException
	 */
	public Integer getEllipseH() throws FieldTrackingAssignementException {
		if (ellipse_h == null) {
			PropertyServiceProxy.getInstance().getYamlPropertyFile(getYamlFile()).fieldTraking(this, "ellipse_h");
		}
		return Integer.valueOf(ellipse_h);
	}

	/**
	 * getEllipse_W.
	 * 
	 * @return String
	 * @throws FieldTrackingAssignementException
	 */
	public Integer getEllipseW() throws FieldTrackingAssignementException {
		if (ellipse_w == null) {
			PropertyServiceProxy.getInstance().getYamlPropertyFile(getYamlFile()).fieldTraking(this, "ellipse_w");
		}
		return Integer.valueOf(ellipse_w);
	}

	/**
	 * getEllipse_X.
	 * 
	 * @return Integer
	 * @throws FieldTrackingAssignementException
	 */
	public Integer getEllipseX() throws FieldTrackingAssignementException {
		if (ellipse_x == null) {
			PropertyServiceProxy.getInstance().getYamlPropertyFile(getYamlFile()).fieldTraking(this, "ellipse_x");
		}
		return Integer.valueOf(ellipse_x);
	}

	/**
	 * getEllipse_Y.
	 * 
	 * @return Integer
	 * @throws FieldTrackingAssignementException
	 */
	public Integer getEllipseY() throws FieldTrackingAssignementException {
		if (ellipse_y == null) {
			PropertyServiceProxy.getInstance().getYamlPropertyFile(getYamlFile()).fieldTraking(this, "ellipse_y");
		}
		return Integer.valueOf(ellipse_y);
	}

	/**
	 * @return String
	 * @see org.tc.osgi.bundle.utils.conf.AbstractPropertyFile#getYamlFile()
	 */
	@Override
	public String getXMLFile() {
		return MorphMathCorePropertyFile.getInstance().getConfigDirectory() + getConfFile();
	}

	@Override
	public String getYamlFile() {
		// TODO Auto-generated method stub
		return MorphMathCorePropertyFile.getInstance().getConfigDirectory() + getConfFile();
	}

}
