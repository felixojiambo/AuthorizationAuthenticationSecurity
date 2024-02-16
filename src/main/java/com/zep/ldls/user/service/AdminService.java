package com.zep.ldls.user.service;

import com.zep.ldls.user.model.AdminInvitation;

public interface AdminService {


    AdminInvitation generateInvitation(String email);

    boolean sendInvitation(AdminInvitation adminInvitation);

    boolean validateInvitation(String email, String invitationCode);

    public interface AdminInvitationService {

        AdminInvitation generateInvitation(String email);

        boolean sendInvitation(AdminInvitation invitation);

        boolean validateInvitation(String email, String invitationCode);
    }

}
