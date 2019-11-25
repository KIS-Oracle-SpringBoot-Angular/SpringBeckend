package test.stanislav.danylenko.bootangular;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

  /*  @Procedure(procedureName = "insert_user_t")
    void insertDepartment(@Param("new_name") String newName);

    @Query(nativeQuery = true, value = "SELECT length_string(:text) FROM dual")
    Integer countGoods(@Param("text") String text);*/

}
