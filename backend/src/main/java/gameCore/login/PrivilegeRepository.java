package gameCore.login;

import org.springframework.data.repository.CrudRepository;

public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {
    Privilege findByName(String name);

    @Override
    void delete(Privilege privilege);
}
