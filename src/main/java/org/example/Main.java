package org.example;

import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Main {
    public static void main(String[] args) {
        // create EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // access transaction object
        EntityTransaction transaction = entityManager.getTransaction();

        Owner owner1 = new Owner();
        Owner owner2 = new Owner();
        Owner owner3 = new Owner();

        Cat cat1 = new Cat();
        Cat cat2 = new Cat();

        owner1.setName("Oscar");
        owner2.setName("Mo");
        owner3.setName("Paxton");

        cat1.setName("Boris");
        cat1.setAge(5);
        cat1.setBreed("Breed1");

        cat2.setName("Garfield");
        cat2.setAge(7);
        cat2.setBreed("Breed2");

        owner1.addCat(cat1);
        owner2.addCat(cat1);
        owner3.addCat(cat2);
        cat1.addOwner(owner1);
        cat1.addOwner(owner2);
        cat2.addOwner(owner3);

        transaction.begin();
        entityManager.persist(cat1);
        entityManager.persist(cat2);
        entityManager.persist(owner1);
        entityManager.persist(owner2);
        entityManager.persist(owner3);
        transaction.commit();

        // close entity manager
        entityManager.close();
        entityManagerFactory.close();
    }
}