package tdmu.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @NotNull
    @Min(0)
    private Long price;

    @OneToMany(mappedBy = "phone", cascade = CascadeType.ALL)
    private Set<PhoneRating> phoneRating;

    public Phone(Long id, @NotEmpty String name, @NotNull @Min(0) Long price, Set<PhoneRating> phoneRating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.phoneRating = phoneRating;
    }

    public Phone() {
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Set<PhoneRating> getPhoneRating() {
        return phoneRating;
    }

    public void setPhoneRating(Set<PhoneRating> phoneRating) {
        this.phoneRating = phoneRating;
    }

}
