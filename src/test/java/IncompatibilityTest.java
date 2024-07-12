import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.constraints.NotBlank;
import org.junit.jupiter.api.Test;

import static org.hibernate.validator.testutil.ConstraintViolationAssert.assertThat;
import static org.hibernate.validator.testutil.ConstraintViolationAssert.violationOf;

public class IncompatibilityTest {

    @SuppressWarnings("resource")
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    void shouldValidateCorrectly() {
        var invalidBook = new Book("");
        var violations = validator.validate(invalidBook);
        assertThat(violations).containsOneOfViolations(violationOf(NotBlank.class));
    }
}
