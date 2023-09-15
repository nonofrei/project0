import com.revature.daos.AccountDAO;
import com.revature.models.Account;
import com.revature.models.User;
import com.revature.services.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountServicesTest {

    @Mock
    AccountDAO aDAO;

    @InjectMocks
    AccountService aService = new AccountService();

    @Test
    public void testInsertNewAccount() {
        // User testUser = new User("Test", "User");
        Account testAcc = new Account("new_account", 1000, 0);

        when(aDAO.insertAccount(testAcc)).thenReturn(testAcc);

        Account returnedAcc = aService.insert_new_account(testAcc);

        verify(aDAO, times(1)).insertAccount(testAcc);

        assertNotNull(returnedAcc);
        assertEquals(returnedAcc.getAccount_balance(), 1000);
        assertEquals(returnedAcc.getUser_id_fk(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsertInvalidAccount() {

        Account testAcc1 = new Account(null, -1, -1);
        Account testAcc2 = new Account("new_account", -1, -1);
        Account testAcc3 = new Account("new_account", 0, -1);
        Account returnedAcc1 = aService.insert_new_account(testAcc1);
        Account returnedAcc2 = aService.insert_new_account(testAcc2);
        Account returnedAcc3 = aService.insert_new_account(testAcc3);
        verifyNoInteractions(aDAO);
        assertNull(returnedAcc1);
        assertNull(returnedAcc2);
        assertNull(returnedAcc3);

    }

    @Test
    public void testDepositByAccountId() {

        //Account testAcc = new Account(0,"new_account", 100, 0);
        //when(aDAO.updateAccountBalanceByAccountId(0, 1)).thenReturn(1);
        AccountService temp = new AccountService();
        int result = temp.depositByAccountId(2, 1);
        assertEquals(706, result);
        //temp.withdrawByAccountId(2, 1);

    }
    @Test
    public void testWithdrawByAccountId() {

        AccountService temp = new AccountService();

        int result = temp.withdrawByAccountId(2, 1);
        assertEquals(705, result);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDepositByAccountId() {

        Account testAcc = new Account(0,"new_account", 0, 0);
        int result = aService.depositByAccountId(0, -1);

    }



    @Test(expected = IllegalArgumentException.class)
    public void testInvalidWithdrawByAccountId() {

        Account testAcc = new Account(0,"new_account", 0, 0);
        int result = aService.withdrawByAccountId(0, -1);
        int result1 = aService.withdrawByAccountId(0, 1);

    }

    @Test
    public void testGetAccountBalanceByAccountId() {

        AccountService temp = new AccountService();
        assertEquals(temp.getAccountBalanceByAccountId(2), 705);

    }
    // updateAccountTitleByAccountId
    // getAllAccountsByUserId
    // delete_account
    // getAccountBalanceByAccountId

}
