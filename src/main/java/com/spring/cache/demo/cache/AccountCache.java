package com.spring.cache.demo.cache;

import com.spring.cache.demo.model.Account;

public interface AccountCache {
    Account findAccount(Long accountId);
    Account save(Account account);
    void remove(Long accountId);
}
