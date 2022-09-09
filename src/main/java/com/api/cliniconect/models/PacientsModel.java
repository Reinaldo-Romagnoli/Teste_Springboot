package com.api.cliniconect.models;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "PACIENTS")
public class PacientsModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 50)
    private String name;
    @Column(nullable = false, length = 70)
    private String sex;
    @Column(nullable = false, length = 70)
    private String adress;
    @Column(nullable = false, unique = true, length = 70)
    private String cpf;
    @Column(nullable = false, unique = true, length = 70)
    private String tellphone;
    @Column(nullable = false, length = 70)
    private Data birth_date;
    @Column(nullable = false, unique = true, length = 70)
    private String email;
    @Column(nullable = false, unique = true, length = 70)
    private String service_information;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTellphone() {
        return tellphone;
    }

    public void setTellphone(String tellphone) {
        this.tellphone = tellphone;
    }

    public Data getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Data birth_date) {
        this.birth_date = birth_date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getService_information() {
        return service_information;
    }

    public void setService_information(String service_information) {
        this.service_information = service_information;
    }

}
