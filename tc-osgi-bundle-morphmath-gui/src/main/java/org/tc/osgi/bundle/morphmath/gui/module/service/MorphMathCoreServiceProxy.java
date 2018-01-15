package org.tc.osgi.bundle.morphmath.gui.module.service;

import java.io.File;
import java.io.IOException;

import org.tc.osgi.bundle.morphmath.core.exception.MorphologiqueException;
import org.tc.osgi.bundle.morphmath.core.module.service.IMorphMathCoreService;
import org.tc.osgi.bundle.utils.interf.conf.exception.FieldTrackingAssignementException;


/**
 * MorphMathCoreServiceProxy.java.
 * @author collonville thomas
 * @version
 * @track
 */
public class MorphMathCoreServiceProxy implements IMorphMathCoreService {

    /**
     * MorphMathCoreServiceProxy instance.
     */
    private static MorphMathCoreServiceProxy instance = null;

    /**
     * getInstance.
     * @return MorphMathCoreServiceProxy
     */
    public static MorphMathCoreServiceProxy getInstance() {
        if (MorphMathCoreServiceProxy.instance == null) {
            MorphMathCoreServiceProxy.instance = new MorphMathCoreServiceProxy();
        }
        return MorphMathCoreServiceProxy.instance;
    }

    /**
     * IMorphMathCoreService service.
     */
    private IMorphMathCoreService service = null;

    /**
     * MorphMathCoreServiceProxy constructor.
     */
    private MorphMathCoreServiceProxy() {

    }

    /**
     * @param input File
     * @return File
     * @throws IOException
     * @throws MorphologiqueException
     * @throws FieldTrackingAssignementException
     * @see org.tc.osgi.bundle.morphmath.core.module.service.IMorphMathCoreService#close(java.io.File)
     */
    @Override
    public File close(final File input) throws IOException, MorphologiqueException, FieldTrackingAssignementException {
        return service.close(input);
    }

    /**
     * @param input File
     * @return File
     * @throws IOException
     * @throws MorphologiqueException
     * @see org.tc.osgi.bundle.morphmath.core.module.service.IMorphMathCoreService#dilatation(java.io.File)
     */
    @Override
    public File dilatation(final File input) throws IOException, MorphologiqueException {
        return service.dilatation(input);
    }

    /**
     * @param input File
     * @return File
     * @throws IOException
     * @throws MorphologiqueException
     * @see org.tc.osgi.bundle.morphmath.core.module.service.IMorphMathCoreService#erosion(java.io.File)
     */
    @Override
    public File erosion(final File input) throws IOException, MorphologiqueException {
        return service.erosion(input);
    }

    /**
     * getService.
     * @return IMorphMathCoreService
     */
    public IMorphMathCoreService getService() {
        return service;
    }

    /**
     * @param input File
     * @return File
     * @throws IOException
     * @throws MorphologiqueException
     * @throws FieldTrackingAssignementException
     * @see org.tc.osgi.bundle.morphmath.core.module.service.IMorphMathCoreService#gradient(java.io.File)
     */
    @Override
    public File gradient(final File input) throws IOException, MorphologiqueException, FieldTrackingAssignementException {
        return service.gradient(input);
    }

    /**
     * @param input File
     * @return File
     * @throws IOException
     * @throws MorphologiqueException
     * @throws FieldTrackingAssignementException
     * @see org.tc.osgi.bundle.morphmath.core.module.service.IMorphMathCoreService#open(java.io.File)
     */
    @Override
    public File open(final File input) throws IOException, MorphologiqueException, FieldTrackingAssignementException {
        return service.open(input);
    }

    /**
     * setService.
     * @param service IMorphMathCoreService
     */
    public void setService(final IMorphMathCoreService service) {
        this.service = service;
    }

}
