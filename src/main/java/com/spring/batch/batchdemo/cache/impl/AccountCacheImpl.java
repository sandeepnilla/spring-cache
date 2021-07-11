package com.spring.batch.batchdemo.cache.impl;

import com.spring.batch.batchdemo.cache.AccountCache;
import com.spring.batch.batchdemo.model.Account;
import com.spring.batch.batchdemo.repo.AccountRepository;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@CacheConfig(cacheNames = "accountCache")
@Component
public class AccountCacheImpl implements AccountCache {
    AccountRepository accountRepository;

    public AccountCacheImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Cacheable(key="#accountId", condition = "#accountId != null", unless = "#result.accountId == null")
    public Account findAccount(Long accountId) {
        if (accountRepository.findById(accountId).isPresent()) {
            return accountRepository.findById(accountId).get();
        }
        return new Account();
    }

    @Override
    @CachePut(key="#account.accountId")
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    @CacheEvict(key="#accountId")
    public void remove(Long accountId) {
        accountRepository.deleteById(accountId);
    }
}
