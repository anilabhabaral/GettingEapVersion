import java.lang.management.ManagementFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.management.MBeanServer;
import javax.management.ObjectName;

@Singleton
public class JBossServerVersionBean {

    private MBeanServer server;
    private String serverName;
    private String serverVersion;

    @PostConstruct
    private void init() {
        server = ManagementFactory.getPlatformMBeanServer();

        try {
            ObjectName objectName = new ObjectName("jboss.as:management-root=server");

            serverName = (String) server.getAttribute(objectName, "productName");
            serverVersion = (String) server.getAttribute(objectName, "productVersion");
        } catch (Exception e) {
            throw new RuntimeException("Unable to obtain server name and version!", e);
        }
    }

    public String getJBossServerName() {
        System.out.println("\n\n\n Server-Name             = \t"+serverName);
        System.out.println("\n Server-Version          = \t"+serverVersion+ "\n\n\n");
        return "Server name: "+serverName;
    }

    public String getJBossServerVersion() {
        return "Server version: "+serverVersion;
    }
}
