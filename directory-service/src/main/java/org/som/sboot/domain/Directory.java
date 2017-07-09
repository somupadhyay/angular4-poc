/**
 * 
 */
package org.som.sboot.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * @author upadhs5
 *
 */
@Entity
@Data
public class Directory {
    
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Person> people;

    public Directory() {}

    public Directory(String name) {
        this.name = name;
    }

    public Directory(String name, List<Person> people) {
        this.name = name;
        this.people = people;
    }

}
