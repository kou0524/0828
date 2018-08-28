package com.example.user.management.domain.service.delete;

import java.sql.Timestamp;

import javax.inject.Inject;

import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.example.user.management.domain.model.Account;
import com.example.user.management.domain.repository.delete.DeleteRepository;

@Service
public class DeleteServiceImpl implements DeleteService{
	
	@Inject
	DeleteRepository deleteRepository;	
	

	@Override
	public void delete(Account account) {
		deleteRepository.delete(account);
	}
	
    @Transactional(readOnly=true)
    @Override
    public Account findOne(String userID) {
        // (1)
        Account account = deleteRepository.findOne(userID);
        // (2)
        if (account == null) {
            throw new ResourceNotFoundException("お探しのユーザIDを持つユーザは見つかりません。 userID="
                    + userID);
        }
        return account;
    }
}
