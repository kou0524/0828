package com.example.user.management.domain.service.account;

import ANACONDA.Account;

public interface AccountSharedService {
    Account findOne(String userID);
    //Account findUser(String UserName);
}

