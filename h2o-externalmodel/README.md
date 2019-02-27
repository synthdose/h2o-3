# H2O External Model

This module provides means for H<sub>2</sub>O to embrace external models.

What can be done with models imported into H<sub>2</sub>O ?
- Scoring
- Model inspection

Any implementer of H2O's ExternalModel interface is required to provide both functionalities mentioned above.
A successfully implemented ExternalModel enables H<sub>2</sub>O to perform **scoring** of new observations without
any limits. However, **model inspection** support may vary. In general, implementers are required to provide only
few basic model attributes in order for scoring to be possible, like feature/column names, domain levels of categorical
columns and few others. Information about model training phase and model performance & precision parameters
are purely optional.


