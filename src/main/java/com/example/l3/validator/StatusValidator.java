package com.example.l3.validator;

import com.example.l3.commons.exception.ErrorMessages;
import com.example.l3.commons.exception.OctException;
import com.example.l3.consts.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StatusValidator {
    public void checkValidStatus(String status) {
        if(!Status.validStatus(status)) {
            throw new OctException(ErrorMessages.INVALID_STATUS);
        }
    }

    public void checkValidStatusForManagerUpdate(String status) {
        if(!Status.validStatusForManagerUpdate(status)) {
            throw new OctException(ErrorMessages.NOT_ALLOW_UPDATE);
        }
    }

    public void checkValidStatusForMangerSubmit(String status) {
        if(!Status.validStatusForManagerSubmit(status)) {
            throw new OctException(ErrorMessages.NOT_ALLOW_UPDATE, "status is not allowed for manager to submit");
        }
    }

    public void checkValidStatusForLeaderUpdate(String status) {
        if(!Status.validStatusForLeaderUpdate(status)) {
            throw new OctException(ErrorMessages.NOT_ALLOW_UPDATE);
        }
    }

    public void checkValidStatusForLeader(String status) {
        if(!Status.validStatusForLeader(status)) {
            throw new OctException(ErrorMessages.INVALID_STATUS);
        }
    }


}
