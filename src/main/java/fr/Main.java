
/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fr;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

import fr.potajaime.core.entities.Carte;
import fr.potajaime.core.repositories.CarteRepository;
import fr.potajaime.core.repositories.UtilisateurRepository;
import fr.potajaime.sigfox.utils.SigfoxParser;



@Controller
@SpringBootApplication
public class Main {
	
	@Autowired
	private CarteRepository carteRepository;

  public static void main(String[] args) throws Exception {
    SpringApplication.run(Main.class, args);
  }
  
  
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean 
	SigfoxParser sigfoxParser() {
		return new SigfoxParser();
	}
	
	
	@Bean
	  CommandLineRunner init(final UtilisateurRepository utilisateurRepository) {
	    
	    return new CommandLineRunner() {

	      @Override
	      public void run(String... arg0) throws Exception {
	    	  
	    	Carte carte1 = new Carte();
	    	carte1.setIdCarte("124");
	    	carte1.setNomCarte("Carte test 1");
	        carteRepository.save(carte1);
	        
	        
	        Carte carte2 = new Carte();
	    	carte2.setIdCarte("123");
	    	carte2.setNomCarte("Carte test 2");
	        carteRepository.save(carte2);
	      }
	      
	    };
	    
	}
  


}