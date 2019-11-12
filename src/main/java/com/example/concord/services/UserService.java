package com.example.concord.services;

import com.example.concord.dtos.IdDTO;
import com.example.concord.dtos.FioDTO;

public interface UserService {
    FioDTO findFio(IdDTO idDTO);
}
