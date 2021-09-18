package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CEO extends User{

    private static final String CEO_CODE = "ceo_code";

    @JoinColumn(name = CEO_CODE)
    private int cEOCode;
}
