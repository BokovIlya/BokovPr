package com.mycompany.bokovpr;

import java.util.ArrayList;
import java.util.List;

public class BokovPr 
{

class Film {
    private String title;
    private int year;
    private double rentalCost;
    private String actorLastName;
    private List<Filmography> filmography;

    public Film(String title, int year, double rentalCost, String actorLastName, List<Filmography> filmography) {
        this.title = title;
        this.year = year;
        this.rentalCost = rentalCost;
        this.actorLastName = actorLastName;
        this.filmography = filmography;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public String getActorLastName() {
        return actorLastName;
    }

    public List<Filmography> getFilmography() {
        return filmography;
    }
}

class Actor {
    private String countryOfBirth;
    private int yearOfBirth;

    public Actor(String countryOfBirth, int yearOfBirth) {
        this.countryOfBirth = countryOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}

class Filmography {
    private String film;
    private int releaseYear;
    private String roleType;

    public Filmography(String film, int releaseYear, String roleType) {
        this.film = film;
        this.releaseYear = releaseYear;
        this.roleType = roleType;
    }

    public String getFilm() {
        return film;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getRoleType() {
        return roleType;
    }
}

public class FilmStore {
    private List<Film> films;

    public FilmStore() {
        this.films = new ArrayList<>();
    }

    public void addFilm(Film film) {
        films.add(film);
    }

    
   // Метод для поиска фильма по названию или актеру ( надо было добавить страну фильма) Я написал год потому, что страны фильма нет вообще.
public static List<Film> searchFilm(List<Film> films, String searchTerm) {
List<Film> searchResults = new ArrayList<>();
for (Film film: films) {
if (film.title.toLowerCase().contains(searchTerm.toLowerCase()) || film.actor.toLowerCase().contains(searchTerm.toLowerCase())) {
searchResults.add(film);
}
}
return searchResults;
 }
    
// Метод для редактирования страны фильма
public void editYear(String newYear) {
 this.year = newYear;
}
 // Метод для вывода полной информации о фильме
 public void printInfo() {
System.out.println("Название фильма: " + title);
System.out.println("Актер: " + actor);
//System.out.println("Страна: " + country);
 }

  
    public void updateRole(String actorLastName, String filmTitle, String newRoleType) {
        for (Film film : films) {
            if (film.getActorLastName().equals(actorLastName)) {
                List<Filmography> filmographyList = film.getFilmography();
                for (Filmography filmography : filmographyList) {
                    if (filmography.getFilm().equals(filmTitle)) {
                        filmography.setRoleType(newRoleType);
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        FilmStore filmStore = new FilmStore();

        List<Filmography> filmography1 = new ArrayList<>();
        filmography1.add(new Filmography("Фильм 1", 2020, "главная роль"));
        filmography1.add(new Filmography("Фильм 2", 2018, "роль второго плана"));
        filmStore.addFilm(new Film("Фильм 1", 2020, 10.0, "Актер1", filmography1));

        List<Filmography> filmography2 = new ArrayList<>();
        filmography2.add(new Filmography("Фильм 3", 2016, "главная роль"));
        filmography2.add(new Filmography("Фильм 4", 2019, "роль второго плана"));
        filmStore.addFilm(new Film("Фильм 2", 2017, 15.0, "Актер2", filmography2));

        // Добавьте информацию о еще 8 фильмах

        // Пример вызова метода для изменения роли актера
        filmStore.updateRole("Актер1", "Фильм 1", "роль второго плана");
    }
}
}