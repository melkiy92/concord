package com.example.concord.services;

import com.example.concord.dtos.IdDTO;
import com.example.concord.dtos.FioDTO;
import com.example.concord.models.User;
import com.example.concord.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @NotNull
    private final UserRepository userRepository;

    @NotNull
    private final Encryptor encryptor;

    @Override
    public FioDTO findFio(IdDTO idDTO) {
        Optional<User> optionalUser = userRepository.findById(idDTO.id);
        return optionalUser.map(user -> new FioDTO(user.getFio())).orElse(null);
    }



}
