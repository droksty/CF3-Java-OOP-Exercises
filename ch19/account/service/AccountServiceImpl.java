package gr.aueb.cf.testbed.ch19.account.service;


import gr.aueb.cf.testbed.ch19.account.dao.IAccountDAO;
import gr.aueb.cf.testbed.ch19.account.dto.AccountDTO;
import gr.aueb.cf.testbed.ch19.account.dto.UserDTO;
import gr.aueb.cf.testbed.ch19.account.model.Account;
import gr.aueb.cf.testbed.ch19.account.model.User;
import gr.aueb.cf.testbed.ch19.account.service.exceptions.*;

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

            if (dao.accountExists(accountDTO.getAccountID())) throw new AccountAlreadyExistsException(account.getId());
            if (dao.accountExists(accountDTO.getIban())) throw new AccountAlreadyExistsException(account.getIban());

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

            if (!dao.accountExists(accountDTO.getIban())) throw new AccountNotFoundException(accountDTO.getIban());

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
    public Double getAccountBalance(String iban) throws AccountNotFoundException {
        Account account;
        try {
            account = dao.get(iban);
            if (account == null) {
                throw new AccountNotFoundException(iban);
            }
            return dao.get(iban).getBalance();
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deposit(String iban, double amount) throws InsufficientAmountException, AccountNotFoundException {
        try {
            if (amount <= 0 ) throw new InsufficientAmountException(amount);

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
//            if (!dao.isSsnValid(account, ssn)) throw new SsnNotValidException(ssn);
            if (amount > account.getBalance()) throw new InsufficientBalanceException(account.getBalance());

            account.setBalance(account.getBalance() - amount);

        } catch (InsufficientBalanceException /*| SsnNotValidException*/ e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Maps {@link AccountDTO} to {@link Account}
     * @param account       the {@link Account} to be created
     * @param accountDTO    the {@link AccountDTO} data transfer object
     */
    private void mapAccount(Account account, AccountDTO accountDTO) {
        account.setId(accountDTO.getAccountID());
        account.setIban(accountDTO.getIban());
        User user = new User();
        mapUser(user, accountDTO.getHolder());
        account.setHolder(user);
        account.setBalance(accountDTO.getBalance());
    }

    /**
     * Maps {@link UserDTO} to {@link User}
     * @param user      the {@link User} to be created
     * @param userDTO   the {@link UserDTO} data transfer object
     */
    private void mapUser(User user, UserDTO userDTO) {
        user.setId(userDTO.getUserID());
        user.setSsn(userDTO.getSsn());
        user.setLastname(userDTO.getLastname());
        user.setFirstname(userDTO.getFirstname());
    }
}
