package gameCore.login;

public interface IUserService {
    gameCore.login.User registerNewUserAccount(UserDto accountDto) throws EmailExistsException;
}