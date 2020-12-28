import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Product_Discount_Calculator", urlPatterns = "/display-discount")
public class Product_Discount_Calculator extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("productDescription");
        float price = Float.parseFloat(request.getParameter("price"));
        float discount = Float.parseFloat(request.getParameter("discountPercent"));

        float discountAmount = price * discount;
        float discountPrice = price - discountAmount;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>description: " + description+ "</h1>");
        writer.println("<h1>price: " + price+ "</h1>");
        writer.println("<h1>discount: " + discount+ "</h1>");
        writer.println("<h1>discountAmount: " + discountAmount+ "</h1>");
        writer.println("<h1>discountPrice: " + discountPrice+ "</h1>");
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
