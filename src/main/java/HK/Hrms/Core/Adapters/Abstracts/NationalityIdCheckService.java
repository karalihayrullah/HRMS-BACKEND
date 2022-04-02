package HK.Hrms.Core.Adapters.Abstracts;

import HK.Hrms.Core.Utilities.Results.Result;

public interface NationalityIdCheckService {
    Result isValid(String nationalityId);
}
