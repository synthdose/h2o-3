package ai.h2o.model.info;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Information about an external model.
 */
public class ExternalModelInfo {

    private String _modelName;

    // The following properties are required by H2O
    private final ModelCategory _modelCategory;
    private final boolean _isSupervised;
    private final String[][] _domains;
    private final String[][] _originalDomains;

    private final String _offsetColumnName;
    private final String _weightsColumnName;
    private final String _foldColumn;
    private final String _h2oVersion;
    private final Integer _numberOfFeatures;

    private String[] _columnNames;
    private double[] _classDistributon;
    private double[] _priorClassDistribution;

    private final Set<ModelInfoAttribute> _additionalAttributes;

    /**
     * Constructs ExternalModelInfo with only the minimum-required information about the model.
     *
     * @param _modelCategory
     * @param _isSupervised
     * @param _domains
     * @param _originalDomains
     * @param _columnNames
     * @param _classDistributon
     * @param _priorClassDistribution
     */
    public ExternalModelInfo(ModelCategory _modelCategory, boolean _isSupervised, String[][] _domains,
                             String[][] _originalDomains, String[] _columnNames, double[] _classDistributon, double[] _priorClassDistribution) {
        Objects.requireNonNull(_modelCategory, "Model category is required.");
        Objects.requireNonNull(_domains, "Features domains are required.");
        Objects.requireNonNull(_originalDomains, "Original domains of the model features are required");
        Objects.requireNonNull(_columnNames, "Names of model's columns are required.");
        Objects.requireNonNull(_classDistributon, "Classses distributions are required.");
        Objects.requireNonNull(_priorClassDistribution, "A priori distributions are required");

        this._modelCategory = _modelCategory;
        this._isSupervised = _isSupervised;
        this._domains = _domains;
        this._originalDomains = _originalDomains;
        this._columnNames = _columnNames;
        this._classDistributon = _classDistributon;
        this._priorClassDistribution = _priorClassDistribution;

        _offsetColumnName = null;
        _weightsColumnName = null;
        _foldColumn = null;
        _h2oVersion = null;
        _numberOfFeatures = null;
        _additionalAttributes = null;
    }


    public String getModelName() {
        return _modelName;
    }

    public ModelCategory getModelCategory() {
        return _modelCategory;
    }

    public boolean isSupervised() {
        return _isSupervised;
    }

    public String[][] getDomains() {
        return _domains;
    }

    /**
     * A two-dimensional array with domain of each column/feature observed in the training dataset.
     * The first dimension represents column names. The second dimension are levels of the domain specific for the
     * column.
     *
     * @return
     */
    public String[][] getOriginalDomains() {
        return _originalDomains;
    }

    public String getOffsetColumnName() {
        return _offsetColumnName;
    }

    public String getWeightsColumnName() {
        return _weightsColumnName;
    }

    /**
     * Name of fold column used for cross validation.
     *
     * @return A {@link String} with name of the column. Otherwise null.
     */
    public String getFoldColumn() {
        return _foldColumn;
    }

    public String getH2OVersion() {
        return _h2oVersion;
    }

    public Integer getNumberOfFeatures() {
        return _numberOfFeatures;
    }

    public String[] getColumnNames() {
        return _columnNames;
    }

    public double[] getModelClassDistributon() {
        return _classDistributon;
    }

    public double[] getpPriorClassDistribution() {
        return _priorClassDistribution;
    }

    public enum ModelCategory {
        Unknown,
        Binomial,
        Multinomial,
        Ordinal,
        Regression,
        Clustering,
        AutoEncoder,
        DimReduction,
        WordEmbedding,
        CoxPH,
        AnomalyDetection
    }

    public Set<ModelInfoAttribute> getAdditionalAttributes() {
        // Additional attributes class instances are immutable, thus a new set is sufficient to 
        // ensure immutability of locally owned set.
        return new HashSet<>(_additionalAttributes);
    }
}
