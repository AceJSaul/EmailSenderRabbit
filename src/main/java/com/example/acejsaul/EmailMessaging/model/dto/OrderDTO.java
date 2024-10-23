package com.example.acejsaul.EmailMessaging.model.dto;

import java.util.List;

public record OrderDTO(Long clientId, List<Long> productId) {
}
