package dao;

import entiy.DUser;

public interface UserDao {
  public DUser Validate(DUser dUser);
  public void reg(DUser dUser);
  public int regValidate(String valicode,int id);
  public void uservalidateOk(int userid);
  public DUser seachduser();
}
