package accountservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountServiceTestUsingMock {

    private AccountService accountService;
    private IAccountRepository accountRepository;

    @Before
    public void setUp() {
        accountRepository = mock(AccountRepository.class);
        accountService = new AccountService(accountRepository);
    }

    @Test
    public void shouldReturnFalseTestCanReadSalaryDetails() {
        //arranging
        User user = mock(User.class);
        when(accountRepository.canReadSalaryDetails(user)).thenReturn(false);
        // acting
        boolean result = accountService.canReadSalaryDetails(user);
        //Asserting  -- always have one assertion
        Assert.assertFalse(result);
    }

    @Test
    public void shouldReturnTrueTestCanReadSalaryDetails() {
        //arranging
        User user = mock(User.class);
        when(accountRepository.canReadSalaryDetails(user)).thenReturn(true);
        // acting
        boolean result = accountService.canReadSalaryDetails(user);
        //Asserting  -- always have one assertion
        Assert.assertTrue(result);
    }


}
