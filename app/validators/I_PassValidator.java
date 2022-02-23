package validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.FIELD})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PassValidator.class)
public @interface I_PassValidator {
    String message() default "Password must contains 8 characters and at least one number valid and one capital letter";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}