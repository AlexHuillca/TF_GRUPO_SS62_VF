package com.example.lookup.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DTOToken {
    String jwtToken;
    Object user;
}
