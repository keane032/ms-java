package com.ms.email.dtos;

import java.util.UUID;

public record EmailRecorderDto(
        UUID userID,
        String emailTo,
        String subject,
        String text
) { }
