package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_002dcollaborator_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Add collaborator</title>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"/css/style.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/header.jsp", out, false);
      out.write("\r\n");
      out.write("<form name=\"add-collaborator-form\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/controller\" method=\"GET\">\r\n");
      out.write("    <input type=\"hidden\" name=\"command\" value=\"save-collaborator\"/>\r\n");
      out.write("    <table class=\"mysimpletable-table\">\r\n");
      out.write("        <thead>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <th>Property</th>\r\n");
      out.write("            <th>Value</th>\r\n");
      out.write("        </tr>\r\n");
      out.write("        </thead>\r\n");
      out.write("        <tbody>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>Id</td>\r\n");
      out.write("            <td><input type=\"text\" disabled=\"disabled\" name=\"id\"\r\n");
      out.write("                       value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.collaborator != null ? sessionScope.collaborator.id : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>Surname</td>\r\n");
      out.write("            <td><input type=\"text\" name=\"surname\" id=\"surname\"\r\n");
      out.write("                       value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.collaborator != null ? sessionScope.collaborator.surname : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required\r\n");
      out.write("                       pattern=\"[a-zA-Zа-яА-Я]{3,}\" title=\"Please, enter at least 3 characters\">\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>Name</td>\r\n");
      out.write("            <td><input type=\"text\" name=\"name\"\r\n");
      out.write("                       value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.collaborator != null ? sessionScope.collaborator.name : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required\r\n");
      out.write("                       pattern=\"[a-zA-Zа-яА-Я]{3,}\" title=\"Please, enter at least 3 characters\"></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>Patronymic</td>\r\n");
      out.write("            <td><input type=\"text\" name=\"patronymic\"\r\n");
      out.write("                       value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.collaborator != null ? sessionScope.collaborator.patronymic : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required\r\n");
      out.write("                       pattern=\"[a-zA-Zа-яА-Я]{3,}\" title=\"Please, enter at least 3 characters\"></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>Position</td>\r\n");
      out.write("            <td><input type=\"text\" name=\"position\"\r\n");
      out.write("                       value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.collaborator != null ? sessionScope.collaborator.position : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required\r\n");
      out.write("                       pattern=\"[a-zA-Zа-яА-Я]{2,}\" title=\"Please, enter at least 2 characters\"></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        </tbody>\r\n");
      out.write("    </table>\r\n");
      out.write("    <br><br>\r\n");
      out.write("    <p class=\"center-p\">\r\n");
      out.write("        <a href=\"list-of-collaborators.jsp\" style=\"text-decoration: none\" class=\"mybutton\">Cancel</a>\r\n");
      out.write("        <input type=\"submit\" name=\"buttonAddCollaborator\" value=\"Save\" class=\"mybutton\"/>\r\n");
      out.write("    </p>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
