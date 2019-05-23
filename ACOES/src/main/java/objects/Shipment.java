package objects;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import java.sql.Date;
import javax.persistence.ManyToOne;

@Entity
public class Shipment implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(nullable = false)
  private String content;

  @Column(nullable = false)
  private Date date;

  @ManyToOne
  private Worker sender;

  @ManyToOne
  private Beneficiary target;

  public Shipment(){}
  
  public Shipment(Worker _sender, Beneficiary _target, String _content, Date _date){
      sender  = _sender;
      target  = _target;
      content = _content;
      date    = _date;
  }

  public int getId(){
      return id;
  }

  public String getContent(){
      return content;
  }

  public void setContent(String _content){
      content = _content;
  }

  public Date getDate(){
      return date;
  }

  public Worker getSender(){
      return sender;
  }

  public Beneficiary getTarget(){
      return target;
  }
}
