package poc.security.api.drinks.security;

import io.vavr.control.Option;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.Objects;

import static io.vavr.control.Option.none;
import static io.vavr.control.Option.some;
import static poc.security.api.drinks.security.User.Builder.aUser;

@Repository
public class UserRepository {

    Option<User> findOneByUsername(String username) {
        if (Objects.equals(username, "bill")) {
            return some(aUser()
                    .username("bill")
                    .password("123")
                    .enabled(true)
                    .id(3L)
                    .build());

        }
        return none();
    }
}
