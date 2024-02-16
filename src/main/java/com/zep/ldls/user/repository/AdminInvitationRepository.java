package com.zep.ldls.user.repository;
import com.zep.ldls.user.model.AdminInvitation;
import org.springframework.data.jpa.repository.JpaRepository;
    public interface AdminInvitationRepository extends JpaRepository<AdminInvitation, Long> {

        AdminInvitation findByEmailAndInvitationCode(String email, String invitationCode);


}
