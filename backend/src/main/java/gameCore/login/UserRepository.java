package gameCore.login;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByFirstName(String firstName);
    User findByEmail(String email);

    @Override
    void delete(User user);
}
