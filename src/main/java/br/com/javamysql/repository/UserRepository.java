package br.com.javamysql.repository;

import br.com.javamysql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    //@Query("from Users where firstName = : firstName")
    //public User findByFirstName(@Param('firstName')) throws Exception;

}
