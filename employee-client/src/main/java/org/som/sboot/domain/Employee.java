/**
 * 
 */
package org.som.sboot.domain;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author upadhs5
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Employee {

    @JsonProperty("firstName")
    private String first;
    @JsonProperty("lastName")
    private String last;
    private String email;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private List<Address> addresses;


    public Employee(){}

    public Employee(String first, String last, String email, String password, List<Address> addresses) {
        super();
        this.first = first;
        this.last = last;
        this.email = email;
        this.password = password;
        this.addresses = addresses;
    }

}
