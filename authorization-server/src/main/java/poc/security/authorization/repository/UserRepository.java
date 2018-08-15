package poc.security.authorization.repository;

import org.springframework.stereotype.Repository;
import poc.security.authorization.model.User;

import java.util.Objects;
import java.util.Optional;

import static poc.security.authorization.model.User.Builder.aUser;

@Repository
public class UserRepository {

    public Optional<User> findOneByUsername(String username) {
        if (Objects.equals(username, "bill")) {
            return Optional.of(aUser()
                    .username("bill")
                    .password("123")
                    .enabled(true)
                    .id(3L)
                    .build());

        }
        return Optional.empty();
    }
}
