package com.spring.batch.batchdemo.cache;

import com.spring.batch.batchdemo.model.Account;

public interface AccountCache {
    Account findAccount(Long accountId);
    Account save(Account account);
    void remove(Long accountId);
}
