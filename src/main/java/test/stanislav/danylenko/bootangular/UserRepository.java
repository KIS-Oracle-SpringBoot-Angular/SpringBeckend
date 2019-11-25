package test.stanislav.danylenko.bootangular;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {

    @Procedure(procedureName = "insert_user_t")
    void insertUser(@Param("new_name") String newName);

    @Procedure(procedureName = "validate_email")
    void validateEmail(@Param("email") String newName) throws Exception;

    @Query(nativeQuery = true, value = "SELECT count_name_length_more(:length) FROM dual")
    Integer countNameLengthMore(@Param("length") Integer length);

}
