package com.example.concord.services;

import com.example.concord.dtos.IdDTO;
import com.example.concord.dtos.FioDTO;
import com.example.concord.models.User;
import com.example.concord.repositories.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @NonNull
    private final UserRepository userRepository;

    @NotNull
    private final Encryptor encryptor;

    @Override
    public FioDTO findFio(IdDTO idDTO) {
        User user = userRepository.findById(idDTO.id).orElseThrow(NoSuchElementException::new);
        return new FioDTO(user.getFio());
    }



}
