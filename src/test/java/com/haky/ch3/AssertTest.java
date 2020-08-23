package com.haky.ch3;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author hakyoung lee
 */
public class AssertTest {

    private Account account;

    @Before
    public void create() {
        account = new Account("haky");
    }

    @Test
    public void hasPositiveBalance() {
        account.deposit(50);
        assertTrue(account.hasPositiveBalance());
    }

    @Test
    public void depositIncreasesBalance() {
        int initialBalance = account.getBalance();
        account.deposit(100);
        assertTrue(account.getBalance() > initialBalance);
        assertThat(account.getBalance() > 0, is(true));
        assertThat(account.getName(), startsWith("ha"));
        assertThat(account.getBalance(), equalTo(100));
        // is = decorator. nothing to do. redundant
        assertThat(account.getName(), is(equalTo("haky")));
        assertThat(account.getName(), not(equalTo("abc")));
        // not valueable. equalTo() is better.
        assertThat(account.getName(), not(nullValue()));

//        assertThat(2.32 * 3, equalTo(6.96));
//        assertTrue(Math.abs((2.32 * 3) - 6.96) < 0.0005);
        // range
        assertThat(2.32 * 3, closeTo(6.96, 0.0005));
    }

    @Test
    public void hamcrestTest() {
        assertThat(Arrays.asList("a", "ab"), equalTo(Arrays.asList("a", "ab")));
        assertThat(new String[] {"a", "b", "c"}, equalTo(new String[] {"a", "b", "c"}));
    }

    @Test
    public void testWithWorthlessAssertionComment() {
        account.deposit(50);
        // not goot using message(reason)
        // test naming, using constant, renaming variable.. are better
        assertThat("account balance is 100", account.getBalance(), equalTo(50));
    }

    @Test(expected = InsufficientFundsException.class)
    public void throwsWhenWithdrawingTooMuch() {
        account.withdraw(100);
    }

    @Test
    public void throwsWhenWithdrawingTooMuch2() {
        try {
            account.withdraw(100);
            fail();
        } catch (InsufficientFundsException e) {
            assertThat(e.getMessage(), equalTo("balance only 0"));
        }
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void exceptionRule() {
        thrown.expect(InsufficientFundsException.class);
        thrown.expectMessage("balance only 0");

        account.withdraw(100);
    }

    public class InsufficientFundsException extends RuntimeException {
        public InsufficientFundsException(String message) {
            super(message);
        }

        private static final long serialVersionUID = 1L;
    }

    public class Account {
        int balance;
        String name;

        Account(String name) {
            this.name = name;
        }

        void deposit(int dollars) {
            balance += dollars;
        }

        void withdraw(int dollars) {
            if (balance < dollars) {
                throw new InsufficientFundsException("balance only " + balance);
            }
            balance -= dollars;
        }

        public String getName() {
            return name;
        }

        public int getBalance() {
            return balance;
        }

        public boolean hasPositiveBalance() {
            return balance > 0;
        }
    }
}
