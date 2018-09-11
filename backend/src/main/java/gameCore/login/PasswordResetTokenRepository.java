package gameCore.login;

import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.stream.Stream;

public interface PasswordResetTokenRepository extends CrudRepository <PasswordResetToken, Long> {
    PasswordResetToken findByToken(String token);
    PasswordResetToken findByUser(User user);
    Stream<PasswordResetToken> findAllByExpiryDateLessThan(Date now);

    // Untested
    void deleteByExpiryDateLessThan(Date now);
    void deleteAllExpiredSince(Date now);
}
