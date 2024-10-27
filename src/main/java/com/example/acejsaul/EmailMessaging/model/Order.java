package com.example.acejsaul.EmailMessaging.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ordId;
    @ManyToOne
    @JoinColumn(name = "ordered_by")
    @JsonIgnore
    private Client client;
    private Instant instant;
    @OneToMany
    @Fetch(FetchMode.JOIN)
    private List<Product> productList;

    public Order() {
    }

    public Order(UUID ordId, Client client, List<Product> productList) {
        this.ordId = ordId;
        this.client = client;
        this.instant = Instant.now();
        this.productList = productList;
    }

    public UUID getOrdId() {
        return ordId;
    }

    public void setOrdId(UUID ordId) {
        this.ordId = ordId;
    }

    public Long getClient() {
        return client.getId();
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void addToProductList(Product product){
        productList.add(product);
    }

    public void removeFromProductList(Product product){
        productList.remove(product);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(ordId, order.ordId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ordId);
    }
}
