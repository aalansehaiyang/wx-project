package frame.validation;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.*;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @Author Tom哥
 * @create 2023/4/7
 */

@Data
@AllArgsConstructor
public class User {

    @Size(min = 6, max = 12, payload = Error.class)
    private String username;

    @Size(min = 8, max = 20, payload = Warning.class)
    private String password;


    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        User user = new User("admin", "password");
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        for (ConstraintViolation<User> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getConstraintDescriptor().getPayload());
        }
    }

    public interface Warning extends Payload {

    }

    public interface Error extends Payload {

    }
}
