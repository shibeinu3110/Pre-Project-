package com.example.l3.consts;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Status {
    CREATED("created"), //manager
    UPDATED("updated"), //manager
    ADDITIONAL("additional"), //manager
    REJECTED("rejected"), //leader
    ACCEPTED("accepted"), //leader
    PENDING("pending"); //leader

    //created, updated ==> submit
    //pending ==> update by leader
    //created, updated, additional ==> update by manager


    private final String value;

    public static boolean validStatus(String status) {
        return Arrays.stream(Status.values())
                .anyMatch(singleStatus -> singleStatus.value.equalsIgnoreCase(status));
    }

    public static boolean validStatusForManagerUpdate(String status) {
        return (status.equalsIgnoreCase(Status.CREATED.value)||   //created
                status.equalsIgnoreCase(Status.UPDATED.value) ||  //manager update by themselves
                status.equalsIgnoreCase(ADDITIONAL.value)); //additional requirements by leader
    }

    public static boolean validStatusForManagerSubmit(String status) {
        return (status.equalsIgnoreCase(Status.CREATED.value)||   //created
                status.equalsIgnoreCase(Status.UPDATED.value)); //additional requirements by leader
    }

    // doc --> pending --> leader ==> (accepted || rejected || additional)
    public static boolean validStatusForLeaderUpdate(String status) {
        return (status.equalsIgnoreCase(Status.PENDING.value));
    }

    public static boolean validStatusForLeader(String status) {
        return (status.equalsIgnoreCase(Status.ACCEPTED.value))||   //created
                status.equalsIgnoreCase(Status.REJECTED.value) ||  //manager update by themselves
                status.equalsIgnoreCase(ADDITIONAL.value); //additional requirements by leader
    }
}
