package com.anmoon.mentionbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.anmoon.mentionbox.entity.TokenEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<TokenEntity, Integer> {

//    @Query(value = """
//      select t from Token t inner join User u\s
//      on t.user.id = u.id\s
//      where u.id = :id and (t.expired = false or t.revoked = false)\s
//      """)
//    List<TokenEntity> findAllValidTokenByUser(Integer id);
//
//    Optional<TokenEntity> findByToken(String token);
}
