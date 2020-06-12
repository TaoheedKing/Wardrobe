package com.example.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Outfit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "outfit", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Item> items;

    public boolean isCurrentoutfit() {
        return currentoutfit;
    }

    public void setCurrentoutfit(boolean currentoutfit) {
        this.currentoutfit = currentoutfit;
    }

    private boolean currentoutfit;
    public Outfit() {
        this.currentoutfit=false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
