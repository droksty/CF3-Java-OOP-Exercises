package gr.aueb.cf.testbed.ch19.account;

import gr.aueb.cf.testbed.ch19.account.dao.AccountDAOImpl;
import gr.aueb.cf.testbed.ch19.account.dto.AccountDTO;
import gr.aueb.cf.testbed.ch19.account.dto.UserDTO;
import gr.aueb.cf.testbed.ch19.account.model.Account;
import gr.aueb.cf.testbed.ch19.account.model.User;
import gr.aueb.cf.testbed.ch19.account.service.AccountServiceImpl;
import gr.aueb.cf.testbed.ch19.account.service.exceptions.*;

public class AnotherMain {

    public static void main(String[] args) throws AccountAlreadyExistsException, AccountNotFoundException, InsufficientAmountException, InsufficientBalanceException, SsnNotValidException {
        // Model Test
        /*User user1  = new User();
        User user2 = new User();
        System.out.println(user1);
        System.out.println(user2);
        System.out.println();
        Account acc1 = new Account();
        Account acc2 = new Account();
        System.out.println(acc1.toString());
        System.out.println(acc2.toString());*/

        AccountDAOImpl dataAccessor = new AccountDAOImpl();
        AccountServiceImpl serv = new AccountServiceImpl(dataAccessor);

        UserDTO user1 = new UserDTO(1L, "001", "Lincoln", "Abraham");
        UserDTO user2 = new UserDTO(2L, "002", "Wilkes Booth", "John");
        AccountDTO acc1 = new AccountDTO(1L, "US11", user1, 200D);
        AccountDTO acc2 = new AccountDTO(2L, "US22", user2, 500D);
        // DTO Test
        /*System.out.println(user1);
        System.out.println(user2);
        System.out.println(acc1);
        System.out.println(acc2);*/

        serv.openAccount(acc1);
        serv.openAccount(acc2);
        // Open account test
        /*serv.openAccount(new AccountDTO(5L, "US22", new UserDTO(), 400D));          // Expected exception
        serv.openAccount(new AccountDTO(2L, "GR42", new UserDTO(), 1000D));         // Expected exception*/
        /*System.out.println(serv.getAccount("US11"));
        System.out.println(serv.getAccount("US22"));*/
        // Update account test
        /*acc1.setHolder(acc2.getHolder());               // Change a field from acc1
        serv.updateAccount(acc1);                       // Persist updates
        System.out.println(serv.getAccount("US11"));    // Expected
        acc2.setIban("918");
        serv.updateAccount(acc2);                       // Expected exception*/

        // Deposit/ Withdraw test
        /*serv.deposit("US11", 200D);                     // Expected
        serv.withdraw("US11", "001", 400D);             // Expected
        System.out.println(serv.getAccountBalance("US11"));
        //serv.withdraw("US11", "001", 1D);               // Expected InsufficientBalanceException
        //serv.withdraw("US12", "001", 100D);             // Expected AccountNotFoundException
        System.out.println(serv.getAccount("US11"));    // Expected*/
    }
}
