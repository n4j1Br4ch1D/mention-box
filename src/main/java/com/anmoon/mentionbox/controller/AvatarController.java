package com.anmoon.mentionbox.controller;

import com.anmoon.mentionbox.avatar.AvatarUtil;
import com.anmoon.mentionbox.exception.BusinessException;
import com.anmoon.mentionbox.exception.BusinessExceptionCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/avatar")
public class AvatarController {

    private final AvatarUtil avatarUtil;
//    @Autowired
//    private MailSenderUtil mailSenderUtil;

    @Autowired
    public AvatarController(AvatarUtil avatarUtil) {
        this.avatarUtil = avatarUtil;
    }

    @GetMapping("/{fullName}")
    public ResponseEntity<byte[]> getAvatar(@PathVariable String fullName) throws BusinessException {
        String[] nameParts = fullName.split("-");
        byte[] avatarImage = avatarUtil.generateAvatar(nameParts[0], nameParts[1],500); // Adjust the size as needed
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(avatarImage, headers, HttpStatus.OK);
    }

// throw new BusinessException(BusinessExceptionCodes.ARGUMENT_EXCEPTION_ERROR_CODE);
// mailSenderUtil.sendNewMail(JavaMailSender,"test@gmail.com", "Subject right here", "Body right there!");

}
