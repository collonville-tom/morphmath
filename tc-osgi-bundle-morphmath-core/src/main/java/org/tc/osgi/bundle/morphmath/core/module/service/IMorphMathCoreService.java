package org.tc.osgi.bundle.morphmath.core.module.service;

import java.io.File;
import java.io.IOException;

import org.tc.osgi.bundle.morphmath.core.exception.MorphologiqueException;
import org.tc.osgi.bundle.utils.interf.conf.exception.FieldTrackingAssignementException;


/**
 * IMorphMathCoreService.java.
 * @author collonville thomas
 * @version
 * @track
 */
public interface IMorphMathCoreService {

    /**
     * close.
     * @param input File
     * @return File
     * @throws IOException
     * @throws MorphologiqueException
     * @throws FieldTrackingAssignementException
     */
    public File close(File input) throws IOException, MorphologiqueException, FieldTrackingAssignementException;

    /**
     * dilatation.
     * @param input File
     * @return File
     * @throws IOException
     * @throws MorphologiqueException
     */
    public File dilatation(File input) throws IOException, MorphologiqueException;

    /**
     * erosion.
     * @param input File
     * @return File
     * @throws IOException
     * @throws MorphologiqueException
     */
    public File erosion(File input) throws IOException, MorphologiqueException;

    /**
     * gradient.
     * @param input File
     * @return File
     * @throws IOException
     * @throws MorphologiqueException
     * @throws FieldTrackingAssignementException
     */
    public File gradient(File input) throws IOException, MorphologiqueException, FieldTrackingAssignementException;

    /**
     * open.
     * @param input File
     * @return File
     * @throws IOException
     * @throws MorphologiqueException
     * @throws FieldTrackingAssignementException
     */
    public File open(File input) throws IOException, MorphologiqueException, FieldTrackingAssignementException;

}
