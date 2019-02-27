package hex.mojo;

import ai.h2o.model.info.ExternalModelInfo;
import hex.Model;
import hex.ModelCategory;

public class GenericModelOutput extends Model.Output {
    
    private final ModelCategory _modelCategory;
    private final int _nfeatures;
    private final String _h2oVersion;


    public GenericModelOutput(final ExternalModelInfo externalModelInfo) {
        _isSupervised = externalModelInfo.isSupervised();
        _domains = externalModelInfo.getDomains();
        _origDomains = externalModelInfo.getOriginalDomains();
        _hasOffset = externalModelInfo.getOffsetColumnName() != null;
        _hasWeights = externalModelInfo.getWeightsColumnName() != null;
        _hasFold = externalModelInfo.getFoldColumn() != null;
        _distribution = externalModelInfo.getModelClassDistributon();
        _priorClassDist = externalModelInfo.getpPriorClassDistribution();
        _names = externalModelInfo.getColumnNames();
        _h2oVersion = externalModelInfo.getH2OVersion();
        _modelCategory = ModelCategory.valueOf(externalModelInfo.getModelCategory().name());
        _nfeatures = externalModelInfo.getNumberOfFeatures() == null ? -1 : externalModelInfo.getNumberOfFeatures();
    }

    @Override
    public ModelCategory getModelCategory() {
        return _modelCategory;
    }

    @Override
    public int nfeatures() {
        return _nfeatures;
    }
}
