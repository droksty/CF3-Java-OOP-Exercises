package gr.aueb.cf.testbed.ch18;

import gr.aueb.cf.testbed.ch18.dao.AccountDAOImpl;
import gr.aueb.cf.testbed.ch18.dto.AccountDTO;
import gr.aueb.cf.testbed.ch18.dto.UserDTO;
import gr.aueb.cf.testbed.ch18.service.exceptions.*;
import gr.aueb.cf.testbed.ch18.service.AccountServiceImpl;

public class Main {

    public static void main(String[] args) throws AccountAlreadyExistsException, AccountNotFoundException, InsufficientAmountException, InsufficientBalanceException, SsnNotValidException {
        AccountDAOImpl dataAccessor = new AccountDAOImpl();
        AccountServiceImpl serv = new AccountServiceImpl(dataAccessor);

        UserDTO user1 = new UserDTO("001", "Lincoln", "Abraham");
        UserDTO user2 = new UserDTO("002", "Wilkes Booth", "John");
        /*System.out.println(user1);
        System.out.println(user2);*/

        AccountDTO acc1 = new AccountDTO("US11", user1, 200D);
        AccountDTO acc2 = new AccountDTO("US22", user2, 500D);
        /*System.out.println(acc1);
        System.out.println(acc2);*/


        serv.openAccount(acc1);
        System.out.println(serv.getAccount("US11"));    // Expected
        serv.deposit("US11", 200D);                     // Expected
        serv.withdraw("US11", "001", 400D);             // Expected
        //serv.withdraw("US11", "001", 1D);               // Expected InsufficientBalanceException
        //serv.withdraw("US12", "001", 100D);             // Expected AccountNotFoundException
        //System.out.println(serv.getAccount("US11"));    // Expected

        acc1.setHolder(acc2.getHolder());               // Change a field from acc1
        serv.updateAccount(acc1);                       // Persist updates
        System.out.println(serv.getAccount("US11"));    // Expected



//        acc1.setHolder(user2);
//        System.out.println(acc2);

    }
}
