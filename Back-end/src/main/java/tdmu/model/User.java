package tdmu.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    @Column(unique=true)
    private String username;

    @NotEmpty
    private String password;

    @NotNull
    private Boolean isFemale;

    @NotNull
    @Min(0)
    private Long dateOfBirth;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<PhoneRating> phoneRating;

    public User(Long id, @NotEmpty String name, @NotEmpty String username, @NotEmpty String password, @NotNull Boolean isFemale, @NotNull @Min(0) Long dateOfBirth, Set<PhoneRating> phoneRating) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.isFemale = isFemale;
        this.dateOfBirth = dateOfBirth;
        this.phoneRating = phoneRating;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getFemale() {
        return isFemale;
    }

    public void setFemale(Boolean female) {
        isFemale = female;
    }

    public Long getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<PhoneRating> getPhoneRating() {
        return phoneRating;
    }

    public void setPhoneRating(Set<PhoneRating> phoneRating) {
        this.phoneRating = phoneRating;
    }
}
