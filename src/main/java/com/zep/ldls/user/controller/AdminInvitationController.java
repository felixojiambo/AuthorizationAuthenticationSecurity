package com.zep.ldls.user.controller;
import com.zep.ldls.user.model.AdminInvitation;
import com.zep.ldls.user.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminInvitationController {

    private final AdminService adminInvitationService;


    @Autowired
    public AdminInvitationController(AdminService adminService) {
        this.adminInvitationService = adminService;
    }

    @PostMapping("/admin/invitation")
    public ResponseEntity<String> sendAdminInvitation(@RequestBody AdminInvitation adminInvitation) {
        try {
            adminInvitationService.sendInvitation(adminInvitation);
            return ResponseEntity.ok("Invitation sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send invitation: " + e.getMessage());
        }
    }
}
