package dao;

import entities.Animal;

import java.sql.*;


public class DaoPostgres {
    Connection con;

    public DaoPostgres() throws SQLException {
        con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/mydb",
                "elizaveta",
                "admin202");
    }

    public String createByNameSql(Animal animal) throws SQLException {
        String query = "INSERT INTO animal (name, type) VALUES ('" + animal.getName() + "', '" + animal.getType() + "')";
        con.createStatement().executeUpdate(query);
        return "Create successful";
    }

    public String createByName(Animal animal) {
        animal.setId(null);
        animal.persist();
        return "Create successful";
    }


    public Animal readOneSQL(String id) throws SQLException {
        String query = "SELECT * FROM animal WHERE id = " + id;
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(query);
        while (result.next()) {
            return new Animal(result.getLong("id"),
                    result.getString("name"),
                    result.getString("type"));
        }
        return null;
    }

    public Animal readOne(String id) {
        return Animal.findById(id);
    }

    public Animal readByNameSQL(String name) throws SQLException {
        String query = "SELECT * FROM animal WHERE name = '" + name + "'";
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(query);
        while (result.next()) {
            return new Animal(result.getLong("id"),
                    result.getString("name"),
                    result.getString("type"));
        }
        return null;
    }

    public Animal readByName(String name) {
        return Animal.find("name", name).firstResult();
    }

    public String updateByNameSQL(String name) throws SQLException {
        String query = "UPDATE animal SET type = 'Fox' WHERE name = '" + name + "'";
        con.createStatement().executeUpdate(query);
        return "Update successful";
    }

    public String updateByName(String name) {
        Animal.update("type = 'Fox' where name = ?1", name);
        return "Update successful";
    }

    public String deleteByNameSQL(String name) throws SQLException {
        String query = "DELETE FROM animal WHERE name = '" + name + "'";
        con.createStatement().executeUpdate(query);
        return "Delete successful";
    }

    public String deleteByName(String name) {
        Animal.delete("name", name);
        return "Delete successful";
    }
}
