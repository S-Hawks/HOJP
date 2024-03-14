package com.newroztech.dizli.notifiactionmodule.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum NotificationType {
    TRANSFER_TO_PERSON("Transfer to Person"),
    TRANSFER_TO_BANK("Transfer to Bank"),
    TRANSFER_TO_MFS("Transfer to Mfs"),
    THROUGH_AGENT_TRANSFER_TO_BANK("Transfer Through Agent to Bank"),
    THROUGH_AGENT_TRANSFER_TO_IN_PERSON("Transfer Through Agent to Person"),
    THROUGH_AGENT_TRANSFER_TO_MFS("Transfer Through Agent to Mfs"),
    AGENT_TRANSFER_CASH_OUT("Agent Cash Out"),
    AGENT_TRANSFER_CASH_PICKUP("Agent Cash Pickup"),
    AGENT_TRANSFER_BANK("Agent Transfer to Bank"),
    AGENT_TRANSFER_MFS("Agent Transfer to Mfs"),
    AGENT_REQUEST("Agent Request"),
    AGENT_SIGNUP("Agent Signup"),
    SIGNUP("Signup"),
    FORGOT_PASSWORD("Forgot Password"),
    SUCCESSFUL_PASSWORD_CHANGE("Successful Password Change"),
    EKYC_VARIFIED("EKYC varified"),
    EKYC_APPROVED("EKYC Approved"),
    EKYC_DECLINED("EKYC Declined"),
    TIRE_UPDATED("Tire Updated"),
    TIRE_SUBMITTED("Tire Submitted"),
    TIRE_DECLINE("Tire Decline"),
    TIRE_FAILED("Tire Failed"),
    SUCCESSFULLY_MOBILE_NUMBER_CHANGE("Successfully Mobile Number Change"),
    MONEY_TRANSFER_INITIATED("Money Transfer Initiated"),
    MONEY_TRANSFER_SUCCESSFUL("Money Transfer Successful");



    private final String alias;

    @JsonValue
    public String toValue(){
        return alias;
    }

    @JsonCreator
    public static NotificationType fromValue(String value){
        for(NotificationType type: values()){
            if (type.alias.equals(value)){
                return type;
            }
    }
        throw new IllegalArgumentException("Invalid Notification type: " + value);
    }

}
