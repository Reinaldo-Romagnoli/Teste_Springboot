package com.api.cliniconect.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.crypto.Data;

public class PacientsDto {
    @NotBlank
    private String name;
    @NotBlank
    private String sex;
    @NotBlank
    private String adress;
    @Size(max = 11)
    private String cpf;
    @NotBlank
    private String tellphone;
    @NotBlank
    private Data birth_date;
    @NotBlank
    private String email;
    @NotBlank
    private String service_information;

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
