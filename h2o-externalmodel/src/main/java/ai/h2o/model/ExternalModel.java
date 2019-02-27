package ai.h2o.model;

import ai.h2o.model.info.ExternalModelInfo;

import java.io.Serializable;

/**
 * Defines basic interface between an external model, created or living outside of H2O and H2O itself.
 * Implementations of this interface provide the necessary functionality for external models to be pluggable into H2O
 *
 * @author Pavel Pscheidl
 */
public interface ExternalModel extends Serializable {

    /**
     * Performs scoring operation on a single observation.
     *
     * @param data        Data to perform scoring on
     * @param predictions Pre-allocated array for the predictions to be placed into. Prevents excessive memory allocation
     *                    and allows for reusability.
     * @return Pointer to the predictions array supplied as method's argument.
     * @throws ScoringError Thrown when scoring us unable to be done, e.g. input data are malformed.
     */
    double[] score(double[] data, double[] predictions) throws ScoringError;

    /**
     * Returns an immutable instance of {@link ExternalModelInfo} with all information about the model.
     *
     * @return
     */
    ExternalModelInfo modelInfo();


}
