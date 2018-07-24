package gameCore.modifiers;

import org.springframework.data.repository.CrudRepository;

public interface ModifiersRepository extends CrudRepository<Modifiers, Long> {
    Modifiers findByModifiersId(Long modifiersId);
}
