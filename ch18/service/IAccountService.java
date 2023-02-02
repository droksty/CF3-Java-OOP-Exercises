package gr.aueb.cf.testbed.ch18.service;


import gr.aueb.cf.testbed.ch18.dto.AccountDTO;
import gr.aueb.cf.testbed.ch18.service.exceptions.*;
import gr.aueb.cf.testbed.ch18.model.Account;
import gr.aueb.cf.testbed.ch18.model.User;

public interface IAccountService {

    /**
     * Opens a new {@link Account} based on data carried from {@link AccountDTO}
     * @param accountDTO    the DTO object containing new account data
     * @return              the new {@link Account}
     * @throws AccountAlreadyExistsException    if passed {@link Account#iban} already exists on another {@link Account}
     */
    Account openAccount(AccountDTO accountDTO) throws AccountAlreadyExistsException;

    /**
     * Updates an {@link Account}'s fields
     * @param accountDTO    the DTO object containing account data
     * @return              TBA
     * @throws AccountNotFoundException     if passed iban does not match an existing {@link Account} in the datasource.
     */
    Account updateAccount(AccountDTO accountDTO) throws AccountNotFoundException;

    /**
     * Returns the {@link Account} matching the passed IBAN
     * @param iban  TBA
     * @return      TBA
     * @throws AccountNotFoundException     if passed iban does not match an existing {@link Account} in the datasource.
     */
    Account getAccount(String iban) throws AccountNotFoundException;

    /**
     * Deposits the passed amount to the {@link Account} of the passed IBAN
     * @param iban      The IBAN to deposit to
     * @param amount    The amount to deposit
     * @throws AccountNotFoundException         if passed iban does not match an existing {@link Account} in the datasource.
     * @throws InsufficientAmountException      if passed amount is invalid
     */
    void deposit(String iban, double amount) throws AccountNotFoundException, InsufficientAmountException;

    /**
     * Withdraws the passed amount from the {@link Account} of the passed IBAN
     * @param iban      The IBAN to withdraw from
     * @param ssn       The {@link User#ssn} of the {@link User} requesting the withdrawal.
     * @param amount    The amount to withdraw
     * @throws AccountNotFoundException         if passed iban does not match an existing {@link Account} in the datasource.
     * @throws SsnNotValidException             if passed SSN does not match the {@link Account#holder}'s SSN
     * @throws InsufficientBalanceException     if there is not enough {@link Account#balance}
     */
    void withdraw(String iban, String ssn, double amount) throws AccountNotFoundException, SsnNotValidException, InsufficientBalanceException;
}
