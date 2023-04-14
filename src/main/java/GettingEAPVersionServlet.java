import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/GettingEAPVersion")
public class GettingEAPVersionServlet extends HttpServlet {

    @Inject
    JBossServerVersionBean a;

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><body>");
        writer.println(a.getJBossServerVersion());
        writer.println(a.getJBossServerName());
        writer.println("</body></html>");
        writer.close();
    }

}
