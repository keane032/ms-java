package com.ms.user.services;

import com.ms.user.exceptions.UsuarioNaoEncontradoException;
import com.ms.user.models.Telefone;
import com.ms.user.models.UserModel;
import com.ms.user.producers.UserProducer;
import com.ms.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserProducer userProducer;

    @Transactional
    public UserModel save(UserModel user){
        UserModel userModel = userRepository.save(user);
        //comentar para teste
//        userProducer.publishMessageEmail(userModel);
        return userModel;
    }

    @Transactional
    public List<UserModel> findAll(){
        return userRepository.findAll();
    }

    @Transactional
    public void delete(UserModel user){
        userRepository.delete(user);
    }

    @Transactional
    public UserModel update(UserModel user){
        try{
            UUID id = user.getUserId();

            UserModel currentUser = userRepository.findById(id).orElse(null);
//            if(user != null){
                currentUser.setEmail(user.getEmail());
                currentUser.setName(user.getName());
                return userRepository.save(currentUser);
//            }
        }catch (Exception e){
            throw new UsuarioNaoEncontradoException();
        }

    }

    @Transactional
    public UserModel adicionarTelefone(UUID id, Telefone telefone){
        try{

            UserModel currentUser = userRepository.findById(id).orElse(null);
//            if(user != null){
            currentUser.adicinarTelefone(telefone);
            return userRepository.save(currentUser);
//            }
        }catch (Exception e){
            throw new UsuarioNaoEncontradoException();
        }

    }
}
