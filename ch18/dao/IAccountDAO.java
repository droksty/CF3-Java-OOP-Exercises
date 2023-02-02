package gr.aueb.cf.testbed.ch18.dao;

import gr.aueb.cf.testbed.ch18.model.Account;
import gr.aueb.cf.testbed.ch18.model.User;

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
     * @return          TBA
     */
    Account update(Account account);

    /**
     * Returns an {@link Account} based on input iban
     * @param iban  TBA
     * @return      TBA
     */
    Account get(String iban);

    /**
     * Checks is an {@link Account} already exists in the datasource.
     * @param iban TBA
     * @return true, if account already exists in the datasource. False, otherwise.
     */
    boolean accountExists(String iban);

    /**
     * Checks is an {@link User} already exists in the datasource.
     * @param ssn TBA
     * @return true, if user already exists in the datasource. False, otherwise.
     */

    /*boolean userExists(String ssn);*/

    boolean isSsnValid(Account account, String ssn);
}
