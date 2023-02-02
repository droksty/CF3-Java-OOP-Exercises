package gr.aueb.cf.testbed.ch19.account.dao;

import gr.aueb.cf.testbed.ch19.account.model.Account;
import gr.aueb.cf.testbed.ch19.account.model.User;

public interface IAccountDAO {

    /**
     * Inserts a new {@link Account} in the datasource.
     * @param account   The model object that contains the account data.
     * @return          The resulting {@link Account}
     */
    Account insert(Account account);

    /**
     * Updates an {@link Account}
     * @param account   The model object that contains the account data
     * @return          The updated account
     */
    Account update(Account account);

    /**
     * Returns an {@link Account} based on input iban
     * @param iban  the IBAN to look for an {@link Account} with
     * @return      The {@link Account} with the passed iban
     */
    Account get(String iban);

    /**
     * Checks is an {@link Account} already exists in the datasource.
     * @param iban  the IBAN to look for an {@link Account} with
     * @return      true, if account already exists in the datasource. False, otherwise.
     */
    boolean accountExists(String iban);
    /**
     * Checks is an {@link Account} already exists in the datasource.
     * @param id    the {@link Account#id} to look for an {@link Account} with
     * @return      true, if account already exists in the datasource. False, otherwise.
     */
    boolean accountExists(Long id);

    /*boolean isSsnValid(Account account, String ssn);*/
}
