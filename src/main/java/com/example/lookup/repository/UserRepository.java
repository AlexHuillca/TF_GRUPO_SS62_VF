package com.example.lookup.repository;
import com.example.lookup.dtos.UserPorGeneroDTO;
import com.example.lookup.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.Nombre_Usuario = :userName")
    User findByUserName(@Param("userName") String userName);
    //FORMA METODO QUERY ...
    @Query("select new com.example.lookup.dtos.UserPorGeneroDTO(u.genero, count(u)) from User u group by u.genero")
    public List<UserPorGeneroDTO> usuariosPorGenero();
}
