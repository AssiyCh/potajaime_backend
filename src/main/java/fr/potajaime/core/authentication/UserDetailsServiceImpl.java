package fr.potajaime.core.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.potajaime.core.entities.Utilisateur;
import fr.potajaime.core.repositories.UtilisateurRepository;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	
	@Autowired
    private UtilisateurRepository utilisateurRepository;

    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
        System.out.println("email : "+email);
        if (utilisateur == null) {
            throw new UsernameNotFoundException(email);
        }
        return new User(utilisateur.getEmail(), utilisateur.getPassword(), emptyList());
    }
    
    
}