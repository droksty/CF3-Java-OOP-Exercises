package gr.aueb.cf.testbed.ch18.service;


import gr.aueb.cf.testbed.ch18.dao.IAccountDAO;
import gr.aueb.cf.testbed.ch18.dto.AccountDTO;
import gr.aueb.cf.testbed.ch18.dto.UserDTO;
import gr.aueb.cf.testbed.ch18.service.exceptions.*;
import gr.aueb.cf.testbed.ch18.model.Account;
import gr.aueb.cf.testbed.ch18.model.User;

public class AccountServiceImpl implements IAccountService {
    private final IAccountDAO dao;


    public AccountServiceImpl(IAccountDAO dao) {
        this.dao = dao;
    }


    @Override
    public Account openAccount(AccountDTO accountDTO) throws AccountAlreadyExistsException {
        Account account;
        try {
            account = new Account();
            mapAccount(account, accountDTO);

            if (dao.accountExists(accountDTO.getIban())) throw new AccountAlreadyExistsException(account);

            return dao.insert(account);
        } catch (AccountAlreadyExistsException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Account updateAccount(AccountDTO accountDTO) throws AccountNotFoundException {
        Account account;
        try {
            account = new Account();
            mapAccount(account, accountDTO);

            if (!dao.accountExists(accountDTO.getIban())) {
                throw new AccountNotFoundException(accountDTO.getIban());
            }
            return dao.update(account);
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
            throw e;
        }

    }

    @Override
    public Account getAccount(String iban) throws AccountNotFoundException {
        Account account;
        try {
            account = dao.get(iban);
            if (account == null) {
                throw new AccountNotFoundException(iban);
            }
            return dao.get(iban);
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deposit(String iban, double amount) throws InsufficientAmountException, AccountNotFoundException {
        try {
            if (amount <= 0 ) {
                throw new InsufficientAmountException(amount);
            }

            Account account = getAccount(iban);
            account.setBalance(account.getBalance() + amount);
        } catch (InsufficientAmountException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void withdraw(String iban, String ssn, double amount) throws AccountNotFoundException, InsufficientBalanceException, SsnNotValidException {
        //implement withdraw standalone or withdraw via update?
        Account account = getAccount(iban);

        try {
            if (!dao.isSsnValid(account, ssn)) throw new SsnNotValidException(ssn);
            if (amount > account.getBalance()) throw new InsufficientBalanceException(account.getBalance());

            account.setBalance(account.getBalance() - amount);

        } catch (InsufficientBalanceException | SsnNotValidException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * TBA
     * @param account       TBA
     * @param accountDTO    TBA
     */
    private void mapAccount(Account account, AccountDTO accountDTO) {
        account.setIban(accountDTO.getIban());
        User user = new User();
        mapUser(user, accountDTO.getHolder());
        account.setHolder(user);
        account.setBalance(accountDTO.getBalance());
    }

    /**
     * TBA
     * @param user      TBA
     * @param userDTO   TBA
     */
    private void mapUser(User user, UserDTO userDTO) {
        user.setSsn(userDTO.getSsn());
        user.setLastname(userDTO.getLastname());
        user.setFirstname(userDTO.getFirstname());
    }
}
