package web.app.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//mark class as an Entity 
@Entity
//defining class name as Table name
@Table
public class Car
{
//mark id as primary key
@Id
//defining id as column name
@Column
private int id;
//defining name as column name
@Column
private String paint;
//defining paint as column name
@Column
private int engine;
//defining engine as column name
@Column
private String features;
public int getId() 
{
return id;
}
public void setId(int id) 
{
this.id = id;
}
public String getPaint()
    {
        return paint;
    }
    public void setPaint(String paint)
    {
        this.paint = paint;
    }
    public int getEngine()
    {
        return engine;
    }
    public void setEngine(int engine)
    {
        this.engine = engine;
    }
    public String getFeatures()
    {
        return features;
    }
    public void setFeatures()
    {
        this.features = features;
    }
}