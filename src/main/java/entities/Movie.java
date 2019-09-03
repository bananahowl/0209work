package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name = "Movie.deleteAllRows", query = "DELETE from Movie")
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    public Movie() {
    }
        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    // TODO, delete this class, or rename to an Entity class that makes sense for what you are about to do
    // Delete EVERYTHING below if you decide to use this class, it's dummy data used for the initial demo
    private String Title;
    private String Director;

    public Movie(String title, String director) {
        this.Title = title;
        this.Director = director
;    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        this.Director = director;
    }

    @Override
    public String toString() {
        return "Movie:" + "id=" + id + ", Title=" + Title + ", Director=" + Director + '}';
    }
    
    
    

   
}
