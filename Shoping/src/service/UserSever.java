package service;

import entiy.DUser;

public interface UserSever {
public DUser Validate(DUser dUser);
public void reg(DUser dUser);
public int regValidate(String valicode);
}
