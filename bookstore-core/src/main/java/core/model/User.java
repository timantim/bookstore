package core.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity<Long> {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Boolean isAdmin = Boolean.FALSE;

    @Override
    public String toString(){
        return "" +
                "";
    }
}
