package startup;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import utils.HibernateUtil;

@WebListener
public class StartupListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Inicializando Hibernate...");
        HibernateUtil.getEntityManager().close();
        System.out.println("Hibernate inicializado!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Encerrando Hibernate...");
    }
}
