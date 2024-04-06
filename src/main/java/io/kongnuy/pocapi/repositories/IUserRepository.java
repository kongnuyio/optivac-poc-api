package io.kongnuy.pocapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.kongnuy.pocapi.entities.User;

@Repository("userRepository")
public interface IUserRepository extends JpaRepository<User, Long> {

  Optional<User> findByUuidOrExternalUuid(String uuid, String externalUuid);
}
