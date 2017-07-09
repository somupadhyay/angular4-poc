/**
 * 
 */
package org.som.sboot.domain;

import lombok.Data;

/**
 * @author upadhs5
 *
 */
@Data
public class Address {

    private String id;
    private String address;
    private String suite;
    private String state;
    private String zipcode;
    private String country;

    public Address(){};

    public Address(String address, String suite, String state, String zipcode, String country) {
        this.address = address;
        this.suite = suite;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;
    }


}
