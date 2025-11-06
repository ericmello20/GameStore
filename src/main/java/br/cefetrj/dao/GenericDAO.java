package br.cefetrj.dao;

import java.util.List;

import br.cefetrj.model.Entidade;
import br.cefetrj.model.Usuario;
import br.cefetrj.utils.HibernateUtil;
import jakarta.persistence.EntityManager;

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

    public void deletar(Integer id) {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            T entidade = em.find(classe, id);
            if (entidade != null) {
                em.remove(entidade);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            throw e;
        } finally {
            if (em.isOpen())
                em.close();
        }
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
        try (EntityManager em = HibernateUtil.getEntityManager()) {
            return em.createQuery("FROM " + classe.getSimpleName() + " e WHERE e.tipo = :tipo", classe)
                    .setParameter("tipo", tipo)
                    .getResultList();
        }
    }

}