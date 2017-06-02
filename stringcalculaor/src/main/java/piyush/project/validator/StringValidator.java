package piyush.project.validator;

/**
 * Created by devil jin on 5/18/2017.
 */
public class StringValidator implements IStringValidator {
    @Override
    public boolean validate(String input) {
        if(input == null || input.trim().equals("") ) {
            return false;
        }
        return true;
    }
}
