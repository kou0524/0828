package com.example.user.management.domain.service.account;

import com.example.user.management.domain.model.Account;

public interface AccountSharedService {
    Account findOne(String userID);
    //Account findUser(String UserName);
}

