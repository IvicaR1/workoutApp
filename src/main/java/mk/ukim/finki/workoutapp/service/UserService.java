package mk.ukim.finki.workoutapp.service;

import mk.ukim.finki.workoutapp.model.User;
import mk.ukim.finki.workoutapp.model.WorkoutFrequency;

import java.util.List;

public interface UserService {

    // so ovoj metod ke go registrirame korisnikot
    // @return go preoptovaruva userot so dadenite attributi, sprotivno frla null
    User registerUser(String username, String password, Integer height, Integer weight, WorkoutFrequency workoutFrequency);

    // ovoj metod pronaogja dali userot postoi so dadeni username i password
    // @return vrakja user, sprotivno null
    User authenticate(String username, String password);


    // zemanje na site korisnici
    List<User> getAllUsers();

    // naogjanje korisnik spored id
    User getUserById(Long id);

    // metod za azuriranje na podatocite na korisnikot
    // @return vrakjame korisnik so azurirani podatoci
    User updateUserProfile(Long id, String username, String password, Integer height, Integer weight);

    // metod za brisenje na korisnik
    User deleteUser(Long id);

    // metod za presmetuvanje na bmi spored vneseni height i weight od userot
    double calculateBmi(Integer height, Integer weight);

    // metod za postavuvanje na korisnicite vo kategorija spored nivnata tezina
    String getWeightCategory(double bmi);

}

