package mx.edu.utez.MiProyectoServlet.model.person;

import mx.edu.utez.MiProyectoServlet.utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoPerson {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;

    private final String GET_PERSONS = "SELECT * FROM person";
    private final String INSERT_PERSON = "INSERT INTO person (name, lastname, age, email, phone)" +
            "VALUES (?, ?, ?, ?, ?)";
    private final String FIND_PERSON = "SELECT * FROM person WHERE id = ?";
    private final String UPDATE_PERSON = "UPDATE person SET name = ?, lastname = ?, age = ?, email = ?, phone = ?" +
            "WHERE id = ?";

    public List<BeanPerson> showPersons (){
        List<BeanPerson> personList = new LinkedList<>();
        BeanPerson person = null;
        try{
            conn = new MySQLConnection().getConnection();
            String query = GET_PERSONS;
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()){
                person = new BeanPerson();
                person.setId(rs.getLong("id"));
                person.setName(rs.getString("name"));
                person.setLastname(rs.getString("lastname"));
                person.setAge(rs.getInt("age"));
                person.setEmail(rs.getString("email"));
                person.setPhone(rs.getString("phone"));
                personList.add(person);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoPerson.class.getName())
                    .log(Level.SEVERE, "Error en showPersons -> ", e);
        }finally {
            closeConnections();
        }
        return personList;
    }

    public boolean savePerson(BeanPerson person){
        try {
            conn = new MySQLConnection().getConnection();
            String query = INSERT_PERSON;
            pstm = conn.prepareStatement(query);
            pstm.setString(1, person.getName());
            pstm.setString(2, person.getLastname());
            pstm.setInt(3, person.getAge());
            pstm.setString(4, person.getEmail());
            pstm.setString(5, person.getPhone());
            return pstm.executeUpdate()==1; //1==1
        }catch (SQLException e){
            Logger.getLogger(DaoPerson.class.getName())
                    .log(Level.SEVERE, "Error savePerson -> ", e);
            return false;
        } finally {
            closeConnections();
        }
    }

    public BeanPerson findPerson (Long id){
        try{
            conn = new MySQLConnection().getConnection();
            String query = FIND_PERSON;
            pstm = conn.prepareStatement(query);
            pstm.setLong(1, id);
            rs = pstm.executeQuery();
            while (rs.next()){
                BeanPerson person = new BeanPerson();
                person.setId(rs.getLong("id"));
                person.setName(rs.getString("name"));
                person.setLastname(rs.getString("lastname"));
                person.setAge(rs.getInt("age"));
                person.setEmail(rs.getString("email"));
                person.setPhone(rs.getString("phone"));
                return person;
            }
        }catch (SQLException e){
            Logger.getLogger(DaoPerson.class.getName())
                    .log(Level.SEVERE, "Error en findPerson -> ", e);
        }finally {
            closeConnections();
        }
        return null;
    }

    public boolean updatePerson(BeanPerson person){
        try {
            conn = new MySQLConnection().getConnection();
            String query = UPDATE_PERSON;
            pstm = conn.prepareStatement(query);
            pstm.setString(1, person.getName());
            pstm.setString(2, person.getLastname());
            pstm.setInt(3, person.getAge());
            pstm.setString(4, person.getEmail());
            pstm.setString(5, person.getPhone());
            pstm.setLong(6, person.getId());
            return pstm.executeUpdate()==1; //1==1
        }catch (SQLException e){
            Logger.getLogger(DaoPerson.class.getName())
                    .log(Level.SEVERE, "Error updatePerson -> ", e);
            return false;
        } finally {
            closeConnections();
        }
    }

    public void closeConnections(){
        try{
            if (conn!= null){
                conn.close();
            }
            if (pstm!= null){
                pstm.close();
            }
            if (rs!= null){
                rs.close();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
