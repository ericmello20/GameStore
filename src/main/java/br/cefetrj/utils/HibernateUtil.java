package br.cefetrj.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {

    private static EntityManagerFactory emf;

    static {
        try {
            System.out.println("Inicializando Hibernate...");
            emf = Persistence.createEntityManagerFactory("meuPU");
            System.out.println("Hibernate inicializado com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao inicializar o Hibernate:");
            e.printStackTrace();
        }
    }

    public static EntityManager getEntityManager() {
        if (emf == null) {
            throw new IllegalStateException("EntityManagerFactory não foi inicializado corretamente.");
        }
        return emf.createEntityManager();
    }

    public static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
