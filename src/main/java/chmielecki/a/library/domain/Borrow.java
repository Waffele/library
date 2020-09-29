package chmielecki.a.library.domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;


public class Borrow {


    private Long id;

    private int d;
    private int u;
    private int b;




    public Borrow() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getU() {
        return u;
    }

    public void setU(int u) {
        this.u = u;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
