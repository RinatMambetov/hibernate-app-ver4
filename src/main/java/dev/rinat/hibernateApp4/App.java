package dev.rinat.hibernateApp4;

import dev.rinat.hibernateApp4.model.Actor;
import dev.rinat.hibernateApp4.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Actor.class).addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.beginTransaction();

//            1
//            Movie movie = new Movie("The Shawshank Redemption", 1994);
//            Actor actor1 = new Actor("Leonardo DiCaprio", 1974);
//            Actor actor2 = new Actor("Morgan Freeman", 1970);
//
//            movie.setActors(new ArrayList<>(List.of(actor1, actor2)));
//            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//
//            currentSession.persist(movie);
//            currentSession.persist(actor1);
//            currentSession.persist(actor2);

//            2
//            Movie movie = currentSession.get(Movie.class, 1);
//            System.out.println(movie.getActors());

//            3
//            Actor actor = currentSession.get(Actor.class, 1);
//            System.out.println(actor.getMovies());

//            4
//            Movie movie = new Movie("The Shawshank Redemption2", 1999);
//            Actor actor = currentSession.get(Actor.class, 1);
//            movie.setActors(new ArrayList<>(List.of(actor)));
//            actor.getMovies().add(movie);
//            currentSession.persist(movie);

//            5
            Actor actor = currentSession.get(Actor.class, 1);
            System.out.println(actor.getMovies());
            Movie movie = actor.getMovies().get(0);

            actor.getMovies().remove(movie);
            movie.getActors().remove(actor);

            currentSession.getTransaction().commit();
        }
    }
}
