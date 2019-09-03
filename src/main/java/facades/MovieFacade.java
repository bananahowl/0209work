package facades;

import entities.Movie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class MovieFacade {

    private static MovieFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private MovieFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static MovieFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MovieFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();

    }

    //TODO Remove/Change this before use
    public long getRenameMeCount() {
        EntityManager em = emf.createEntityManager();
        try {
            long renameMeCount = (long) em.createQuery("SELECT COUNT(m) FROM Movie m").getSingleResult();
            return renameMeCount;
        } finally {
            em.close();
        }

    }

    public List<Movie> getAllTitles() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Movie> movies = em.createQuery("SELECT m FROM Movie m ", Movie.class);

            return movies.getResultList();
        } finally {
            em.close();
        }

    }

    //TODO later ..
//        @Entity
//@NamedQueries({
//@NamedQuery(name = "Movie.deleteAllRows", query = "DELETE from Movie"),
//@NamedQuery(name = "Movie.getAll", query = "SELECT m FROM Movie m"),
//@NamedQuery(name = "Movie.getByName", query = "SELECT m FROM Movie m WHERE m.name = :name")
//})
    public Movie aa(String title) {
         EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Movie> movie = em.createQuery("SELECT m FROM Movie m WHERE m.title = :title", Movie.class);
            movie.setParameter("title", title);
            return movie.getSingleResult();
        } finally {
            em.close();
        }
    }
    
    
  
    }
