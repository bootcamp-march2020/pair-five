package accountservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountServiceMockTest {

    private AccountService accountService;
    private AccountRepository accountRepository;
    @Before
    public void setUp() {
        accountRepository= mock(AccountRepository.class);
        accountService=new AccountService(accountRepository);
    }


    @Test
    public void testShouldReturnTrueForCanReadSalaryDetailsWithDomain(){

        //Arrange
        User userMock= mock(User.class);
        Account accountMock=mock(Account.class);
        when(accountRepository.getUserAccount(userMock)).thenReturn(accountMock);
        when(accountMock.canReadSalaryDetails()).thenReturn(true);
        //Acting
        boolean result=accountService.canReadSalaryDetailsWithDomain(userMock);
        //Assert
        Assert.assertTrue(result);
    }

    @Test
    public void testShouldReturnFalseForCanReadSalaryDetailsWithDomain(){
        //Arrange
        Account accountMock=mock(Account.class);
        User userMock= mock(User.class);

        when(accountRepository.getUserAccount(userMock)).thenReturn(accountMock);
        when(accountMock.canReadSalaryDetails()).thenReturn(false);
        //Acting
        boolean result=accountService.canReadSalaryDetailsWithDomain(userMock);

        //Assert
        Assert.assertTrue(result);
    }
}
