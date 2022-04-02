package HK.Hrms.Core.Utilities.Results;

public class SuccessResult extends Result{

    public SuccessResult() {
        super(true);
    }

    public SuccessResult(String message) {
        super(message,true);
    }
}
