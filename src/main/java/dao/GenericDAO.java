package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import model.Entidade;
import model.Usuario;
import utils.HibernateUtil;

public abstract class GenericDAO<T extends Entidade> {
    private final Class<T> classe;

    public GenericDAO(Class<T> classe) {
        this.classe = classe;

    }

public void salvar(T entidade, Usuario conta) {
    EntityManager entityManager = HibernateUtil.getEntityManager();
    try {
        entityManager.getTransaction().begin();
        entidade.setCriadoPor(conta);
        entidade.setDataCriacao(java.time.LocalDate.now());
        entityManager.persist(entidade);
        entityManager.getTransaction().commit();
    } catch (Exception e) {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
        e.printStackTrace();
        throw e; // opcional: relança para o container/servlet ver o erro
    } finally {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }
}


    public void atualizar(T entidade, Usuario conta) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entidade.setAlteradoPor(conta);
        entidade.setDataUltimaAlteracao(java.time.LocalDate.now());
        entityManager.merge(entidade);
        entityManager.getTransaction().commit();

    }

    public void deletar(int id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        T usuario = entityManager.find(classe, id);
        if (usuario != null)
            entityManager.remove(usuario);
        entityManager.getTransaction().commit();

    }

    public List<T> listarTodos() {
        try (EntityManager entityManager = HibernateUtil.getEntityManager()) {
            return entityManager.createQuery("FROM " + classe.getSimpleName(), classe).getResultList();

        }

    }

    public T buscarPorId(int id) {
        try (EntityManager entityManager = HibernateUtil.getEntityManager()) {
            return entityManager.find(classe, id);

        }

    }

    public List<T> listarPorTipo(String tipo) {
        try (EntityManager entityManager = HibernateUtil.getEntityManager()) {
            return entityManager.createQuery("FROM " + classe.getSimpleName() + "WHERE tipo = " + tipo, classe)
                    .getResultList();

        }

    }

}