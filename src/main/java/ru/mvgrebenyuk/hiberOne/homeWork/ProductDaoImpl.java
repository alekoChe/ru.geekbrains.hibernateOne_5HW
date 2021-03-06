package ru.mvgrebenyuk.hiberOne.homeWork;

import org.hibernate.Session;

import java.util.List;

public class ProductDaoImpl implements ProductDao{

    private SessionFactoryUtils sessionFactoryUtils;

    public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils){
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Product findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> findAll() {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            List<Product> products = session.createQuery("select p from Product p").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public Product findByName(String tittle) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Product products = session.createQuery("select p from Product p where p.tittle = :tittle", Product.class)
                    .setParameter("tittle", tittle)
                    .getSingleResult();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public void save(Product product) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Long id, String tittle) {
        //            session.createQuery("update Product p set p.tittle :tittle where p.id = :id")
        //                    .setParameter("tittle", tittle)
        //                    .setParameter("id", id)
        //                    .executeUpdate();
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            product.setTitle(tittle);
            session.getTransaction().commit();
        }
    }

    @Override
    public void testCache() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.get(Product.class, 1L);
            session.get(Product.class, 1L);
            session.get(Product.class, 1L);
            session.getTransaction().commit();
        }
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.get(Product.class, 1L);
            session.get(Product.class, 1L);
            session.get(Product.class, 1L);
            session.getTransaction().commit();
        }
    }


}
