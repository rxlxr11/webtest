package yb.ajaxtest5.dao;

import yb.ajaxtest5.pojo.Pet;

import java.util.ArrayList;

public interface IPetDao extends IBaseDao{
    ArrayList<Pet> queryAll();
    ArrayList<Pet> queryByName(String name);
    ArrayList<Pet> queryByBreed(String breed);
    Integer addOne(Pet pet);
}
