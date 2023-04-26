package cz.jakvitov.jwtauthimpl.service;

import cz.jakvitov.jwtauthimpl.entity.SecUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<SecUser, String> {}
