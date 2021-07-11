package com.spring.cache.demo.controller;

import com.spring.cache.demo.cache.impl.AccountCacheImpl;
import com.spring.cache.demo.model.Account;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/account")
@RestController
public class AccountController {
    AccountCacheImpl accountCache;

    public AccountController(AccountCacheImpl accountCache) {
        this.accountCache = accountCache;
    }

    @GetMapping("/{accountId}")
    public Account getAccount(@PathVariable Long accountId) {
        return accountCache.findAccount(accountId);

    }
    @PostMapping
    public Account postAccount(@RequestBody Account account) {
        return accountCache.save(account);
    }
    @DeleteMapping("/{accountId}")
    public void removeAccount(@PathVariable Long accountId) {
        accountCache.remove(accountId);
    }
}
