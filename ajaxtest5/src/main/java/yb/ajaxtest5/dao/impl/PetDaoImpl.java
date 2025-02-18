package yb.ajaxtest5.dao.impl;

import yb.ajaxtest5.dao.IBaseDao;
import yb.ajaxtest5.dao.IPetDao;
import yb.ajaxtest5.pojo.Pet;
import yb.ajaxtest5.utils.DateFormatUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class PetDaoImpl extends BaseDaoImpl implements IPetDao {
    @Override
    public ArrayList<Pet> queryAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<Pet> pets = new ArrayList<>();
        try {
            connection = getConnection();
            statement = connection.prepareStatement("select * from pet");
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                Pet pet = new Pet();
                pet.setPetId(resultSet.getInt("petId"));
                pet.setPetName(resultSet.getString("petName"));
                pet.setPetBreed(resultSet.getString("petBreed"));
                pet.setPetSex(resultSet.getString("petSex"));
                pet.setBirthday((Date) resultSet.getObject("birthday"));
                pet.setDesc(resultSet.getString("desc"));
                pets.add(pet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(resultSet,statement,connection);
        }
        return pets;
    }

    @Override
    public ArrayList<Pet> queryByName(String name) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<Pet> pets = new ArrayList<>();
        try {
            connection = getConnection();
            statement = connection.prepareStatement("select * from pet where petName=?");
            statement.setString(1,name);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                Pet pet = new Pet();
                pet.setPetId(resultSet.getInt("petId"));
                pet.setPetName(resultSet.getString("petName"));
                pet.setPetBreed(resultSet.getString("petBreed"));
                pet.setPetSex(resultSet.getString("petSex"));
                pet.setBirthday((Date) resultSet.getObject("birthday"));
                pet.setDesc(resultSet.getString("desc"));
                pets.add(pet);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(resultSet,statement,connection);
        }
        return pets;
    }

    @Override
    public ArrayList<Pet> queryByBreed(String breed) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        ArrayList<Pet> pets = new ArrayList<>();


        try {
            connection = getConnection();
            statement = connection.prepareStatement("select * from pet where petBreed=?");
            statement.setString(1,breed);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                Pet pet = new Pet();
                pet.setPetId(resultSet.getInt("petId"));
                pet.setPetName(resultSet.getString("petName"));
                pet.setPetBreed(resultSet.getString("petBreed"));
                pet.setPetSex(resultSet.getString("petSex"));
                pet.setBirthday((Date) resultSet.getObject("birthday"));
                pet.setDesc(resultSet.getString("desc"));
                pets.add(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet,statement,connection);
        }

        return pets;
    }

    @Override
    public Integer addOne(Pet pet) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer i = new Integer(0);


        try {
            connection= getConnection();
            statement = connection.prepareStatement("insert into pet values (default,?,?,?,?,?)");
            statement.setString(1, pet.getPetName());
            statement.setString(2, pet.getPetBreed());
            statement.setString(3, pet.getPetSex());
            statement.setString(4, DateFormatUtil.dateToString(pet.getBirthday()));
            statement.setString(5, pet.getDesc());
            i = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}
