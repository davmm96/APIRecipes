package validators;

import play.data.validation.Constraints;
import play.libs.F;

import javax.validation.ConstraintValidator;

public class PassValidator extends Constraints.Validator<String> implements ConstraintValidator<Password, String> {

    @Override
    public F.Tuple<String, Object[]> getErrorMessageKey() {
        return new F.Tuple<String, Object[]>("Password must contains 8 characters and at least one number valid and one capital letter", new Object[]{""});
    }

    @Override
    public boolean isValid(String value) {
        return value.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8}");
    }

}
