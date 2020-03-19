package accountservice;

import org.junit.Assert;
import org.junit.Test;

public class AccountServiceTest {

    /*
       Stub method for testing account service
     */
    class AccountRepositoryStubTest implements IAccountRepository {

        @Override
        public Boolean canReadSalaryDetails(User user) {
            if (user.getEmail().equals("abc@gmail.com")) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Test
    public void shouldReturnTrueTestCanReadSalaryDetails() {
        //Arrange
        IAccountRepository accountRepositoryMockInstance = new AccountRepositoryStubTest();
        User user=new User("abc@gmail.com");
        AccountService accountServiceInstance=new AccountService(accountRepositoryMockInstance);

        //Acting
        boolean result=accountServiceInstance.canReadSalaryDetails(user);

        // Assert
        Assert.assertTrue(result);

    }
    @Test
    public void shouldReturnFalseTestCanReadSalaryDetails() {
        //Arrange
        IAccountRepository accountRepositoryMockInstance = new AccountRepositoryStubTest();
        User user=new User("ac@gmail.com");
        AccountService accountServiceInstance=new AccountService(accountRepositoryMockInstance);
        //acting
        boolean result=accountServiceInstance.canReadSalaryDetails(user);
        //Assert
        Assert.assertFalse(result);

    }

}
