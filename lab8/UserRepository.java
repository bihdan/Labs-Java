/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.security;

/**
 *
 * @author bogda
 */
import org.springframework.data.jpa.repository.JpaRepository;
import sumdu.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);

}
