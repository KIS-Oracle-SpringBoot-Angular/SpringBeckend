package test.stanislav.danylenko.bootangular;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "UserTest")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UT_SEQ")
    @SequenceGenerator(sequenceName = "user_test_seq", allocationSize = 1, name = "UT_SEQ")
    private long id;
    @NonNull
    private String name;
    @NonNull
    private String email;

}