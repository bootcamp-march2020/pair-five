package accountservice;


import java.util.Objects;

class AccountService {
    private IAccountRepository accountRepository;

    public AccountService(IAccountRepository accountRepository) {
        this.accountRepository =  accountRepository;
    }

    public Boolean canReadSalaryDetails(User user) {

        return accountRepository.canReadSalaryDetails(user);
    }

}

class AccountRepository implements IAccountRepository{
    public Boolean canReadSalaryDetails(User user) {
        // connect to DB
        // fetch user
        // get account details
        // return if can read salary details
        return false;
    }
}

class User {
    private String email;

    public User(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}

interface Account {
    Boolean canReadSalaryDetails();
}

class UserAccount implements Account {

    @Override
    public Boolean canReadSalaryDetails() {
        return false;
    }
}

class AdminAccount implements Account {

    @Override
    public Boolean canReadSalaryDetails() {
        return true;
    }
}

interface IAccountRepository {
    Boolean canReadSalaryDetails(User user);
}