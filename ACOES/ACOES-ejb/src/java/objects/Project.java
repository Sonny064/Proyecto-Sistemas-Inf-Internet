package objects;

import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import java.sql.Date;
import javax.persistence.OneToMany;

@Entity
public class Project implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(unique = true, nullable = false)
  private String name;

  private String description;

  @Column(nullable = false)
  private Date creationDate;

  @OneToMany(mappedBy = "project")
  private List<Center> centers = new ArrayList<Center>();

  public Project(){}
  
  public Project(String _name, Date _creationDate){
      name = _name;
      creationDate = _creationDate;
  }

  public int getId(){
      return id;
  }

  public String getName(){
      return name;
  }

  public void setName(String _name){
      name = _name;
  }

  public Date getCreationDate(){
      return creationDate;
  }

  public String getDescription(){
      return description;
  }

  public void setDescription(String _description){
      description = _description;
  }

  public List<Center> getCenters(){
      return centers;
  }
}
