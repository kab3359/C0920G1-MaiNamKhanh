import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

@javax.servlet.annotation.WebServlet(name = "Demo",urlPatterns = "/index")
public class Demo extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<html>");

        Scanner input = new Scanner(System.in);
        int str = 3*2;

        writer.println("<h1>" + str + "</h1>");
        writer.println("</html>");
    }
}
