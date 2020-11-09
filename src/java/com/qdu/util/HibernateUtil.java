package com.qdu.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 * <br>Hibernate工具类，负责帮你构建会话工厂
 *
 * @author NIIT
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    //留了一个方法，帮你返回这个会话工厂对象，用于获取会话操作数据库
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    //使用会话工厂是为了获取会话，和某个数据库进行交互，也就是操作那个数据库
    //所以不妨自己定义一个方法直接用于获取会话,类似于获取一个连接
    //通过会话操作数据库底层也就是开连接操作数据库
    public static Session getSession() {
        //调用SessionFactory的openSession()方法可用于打开一个新会话
        //该方法返回一个新的会话对象
        return sessionFactory.openSession();
    }

    //会话使用完需要关闭，释放资源，可以自己添加一个方法用于关闭会话
    //这里定义的方法需要接受一个Session对象，表示你要关闭的会话
    public static void closeSession(Session session) {
        if (null != session && session.isOpen()) //如果会话不为null，并且是开的状态，则关闭会话
        {
            session.close();
        }
    }
}
