package br.edu.ifpb.assync.entity;

/**
 * Created by Thomas on 06/10/2016.
 */
public class Person {

    private String name;
    private String email;
    private String address;
    private String cpf;

    public Person(){}
    public Person(String nome, String email, String address, String cpf){
        setName(name);
        setEmail(email);
        setAddress(address);
        setCpf(cpf);
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getNome() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Nome : "+this.getNome() + "\n Endereço: "+this.getAddress() + "\n Cpf: "+
                this.getCpf() + "\n Email: " +this.getEmail();
    }

}
