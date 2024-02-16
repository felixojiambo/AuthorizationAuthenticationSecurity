package com.zep.ldls.user.service;
import com.zep.ldls.user.model.AdminInvitation;
import com.zep.ldls.user.repository.AdminInvitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

    @Service
    public class AdminServiceImpl implements AdminService {

        private static final int INVITATION_CODE_LENGTH = 8;
        private static final String INVITATION_CODE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        @Autowired
        private JavaMailSender emailSender;
        @Autowired
        private AdminInvitationRepository adminInvitationRepository;

        @Override
        public AdminInvitation generateInvitation(String email) {
            // Generate random invitation code
            String invitationCode = generateRandomInvitationCode();

            // Create AdminInvitation entity
            AdminInvitation invitation = new AdminInvitation();
            invitation.setEmail(email);
            invitation.setInvitationCode(invitationCode);
            invitation.setCreatedDate(LocalDateTime.now());
            invitation.setAccepted(false);

            // Save invitation to database
            return adminInvitationRepository.save(invitation);
        }

        @Override
        public boolean sendInvitation(AdminInvitation invitation) {

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(invitation.getEmail());
            message.setSubject("Invitation to become an admin");
            message.setText("Hello,\n\nYou have been invited to become an admin. Please use the following code to register: " + invitation.getInvitationCode());

            emailSender.send(message);

            System.out.println("Sending invitation to: " + invitation.getEmail());
            System.out.println("Invitation code: " + invitation.getInvitationCode());

            return true;
        }

        @Override
        public boolean validateInvitation(String email, String invitationCode) {
            // Check if the provided email and invitation code match an existing invitation in the database
            AdminInvitation invitation = adminInvitationRepository.findByEmailAndInvitationCode(email, invitationCode);
            return invitation != null && !invitation.isAccepted();
        }

        private String generateRandomInvitationCode() {
            Random random = new Random();
            StringBuilder sb = new StringBuilder(INVITATION_CODE_LENGTH);
            for (int i = 0; i < INVITATION_CODE_LENGTH; i++) {
                int index = random.nextInt(INVITATION_CODE_CHARS.length());
                sb.append(INVITATION_CODE_CHARS.charAt(index));
            }
            return sb.toString();
        }
    }

