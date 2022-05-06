package ru.mvgrebenyuk.hiberOne.homeWork;

public class ProductDaoMain {

    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
            try {
                //UserDao userDao = new UserDaoImpl(sessionFactoryUtils);
                ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);
                //userDao.testCache();
                //productDao.testCache();
                System.out.println(productDao.findByName("Bread")); ////
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                sessionFactoryUtils.shotdown();
            }
    }
}
