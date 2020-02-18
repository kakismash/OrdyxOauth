/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OAuth2.OrdyxOAuth2.repos;

import com.OAuth2.OrdyxOAuth2.entity.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alfia
 */
@Repository
public interface UsersRepository extends CrudRepository<User, Long> {
    
}
