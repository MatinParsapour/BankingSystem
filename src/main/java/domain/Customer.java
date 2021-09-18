package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.NamedEntityGraph;

@Entity
@Setter
@Getter
@NamedEntityGraph
@AllArgsConstructor
public class Customer extends User{
}
