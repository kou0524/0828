package com.example.user.management.domain.service.account;
import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;

import com.example.user.management.domain.model.Account;
import com.example.user.management.domain.repository.account.AccountRepository;

@Service
public class AccountSharedServiceImpl implements AccountSharedService {
    @Inject
    AccountRepository accountRepository;

    @Transactional(readOnly=true)
    @Override
    public Account findOne(String userID) {
        // (1)
        Account account = accountRepository.findOne(userID);
        // (2)
        if (account == null) {
            throw new ResourceNotFoundException("The given account is not found! userID="
                    + userID);
        }
        return account;
    }

}
