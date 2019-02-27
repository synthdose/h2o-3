import h2o
import tempfile
from h2o.estimators import H2OGradientBoostingEstimator, H2OGenericEstimator
from tests import pyunit_utils


def mojo_model_test():

   
    # Test constructor generating the model from existing MOJO file
    model = H2OGenericEstimator.from_mojo_file("/home/pavel/mojo.zip")
    model.show()
    assert model is not None
    
    
    
    
if __name__ == "__main__":
    pyunit_utils.standalone_test(mojo_model_test)
else:
    mojo_model_test()
