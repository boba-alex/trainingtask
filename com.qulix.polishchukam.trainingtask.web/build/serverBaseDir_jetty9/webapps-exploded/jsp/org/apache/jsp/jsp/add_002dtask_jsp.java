package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_002dtask_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Add task</title>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"/css/style.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/header.jsp", out, false);
      out.write('\r');
      out.write('\n');
      service.ProjectService projectService = null;
      synchronized (_jspx_page_context) {
        projectService = (service.ProjectService) _jspx_page_context.getAttribute("projectService", PageContext.PAGE_SCOPE);
        if (projectService == null){
          projectService = new service.ProjectService();
          _jspx_page_context.setAttribute("projectService", projectService, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      service.CollaboratorService collaboratorService = null;
      synchronized (_jspx_page_context) {
        collaboratorService = (service.CollaboratorService) _jspx_page_context.getAttribute("collaboratorService", PageContext.PAGE_SCOPE);
        if (collaboratorService == null){
          collaboratorService = new service.CollaboratorService();
          _jspx_page_context.setAttribute("collaboratorService", collaboratorService, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("<form name=\"add-task-form\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/controller\" method=\"GET\">\r\n");
      out.write("    <input type=\"hidden\" name=\"command\" value=\"save-task\"/>\r\n");
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
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.task != null ? sessionScope.task.id : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>Project</td>\r\n");
      out.write("            <td>\r\n");
      out.write("                <select name=\"project-id\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${!empty sessionScope.project ? ' disabled=\"true\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" id=\"select-id\">\r\n");
      out.write("                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                </select>\r\n");
      out.write("                <input type=\"hidden\" name=\"project-id\" id=\"proj-id\"/>;\r\n");
      out.write("                <script>\r\n");
      out.write("                     document.getElementById(\"proj-id\").value = document.getElementById(\"select-id\").value;\r\n");
      out.write("                </script>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>Name</td>\r\n");
      out.write("            <td><input type=\"text\" name=\"name\"\r\n");
      out.write("                       value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.task != null ? sessionScope.task.name : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required\r\n");
      out.write("                       pattern=\"[a-zA-Zа-яА-Я]{2,}(\\s{1}[a-zA-Zа-яА-Я]{1,})*\"\r\n");
      out.write("                       title=\"Please, enter at least 2 characters, then 1 space and words(at least 1 character)\"></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>Work in hours</td>\r\n");
      out.write("            <td><input type=\"text\" name=\"work-in-hours\"\r\n");
      out.write("                       value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.task != null ? sessionScope.task.workInHours : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required\r\n");
      out.write("                       pattern=\"[0-9]*\" title=\"Please, enter integer numbers\"></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>Start date</td>\r\n");
      out.write("            <td><input type=\"date\" name=\"begin-time\"\r\n");
      out.write("                       value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.task != null ? sessionScope.task.beginTime : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required min=\"1970-01-01\"\r\n");
      out.write("                       max=\"3000-01-01\"></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>Finish date</td>\r\n");
      out.write("            <td><input type=\"date\" name=\"end-time\"\r\n");
      out.write("                       value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.task != null ? sessionScope.task.endTime : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required min=\"1970-01-01\"\r\n");
      out.write("                       max=\"3000-01-01\"></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>Task status</td>\r\n");
      out.write("            <td>\r\n");
      out.write("                <select name=\"task-status\">\r\n");
      out.write("                    <option value=\"NOT_STARTED\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.task.taskStatus == 'NOT_STARTED' ? 'selected=\"selected\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">\r\n");
      out.write("                        NOT_STARTED\r\n");
      out.write("                    </option>\r\n");
      out.write("                    <option value=\"IN_PROGRESS\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.task.taskStatus == 'IN_PROGRESS' ? 'selected=\"selected\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">\r\n");
      out.write("                        IN_PROGRESS\r\n");
      out.write("                    </option>\r\n");
      out.write("                    <option value=\"COMPLETED\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.task.taskStatus == 'COMPLETED' ? 'selected=\"selected\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">\r\n");
      out.write("                        COMPLETED\r\n");
      out.write("                    </option>\r\n");
      out.write("                    <option value=\"POSTPONED\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.task.taskStatus == 'POSTPONED' ? 'selected=\"selected\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">\r\n");
      out.write("                        POSTPONED\r\n");
      out.write("                    </option>\r\n");
      out.write("                </select>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>Collaborator</td>\r\n");
      out.write("            <td>\r\n");
      out.write("                <select name=\"collaborator-id\">\r\n");
      out.write("                    ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                </select>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        </tbody>\r\n");
      out.write("    </table>\r\n");
      out.write("    <br><br>\r\n");
      out.write("    <p class=\"center-p\">\r\n");
      out.write("        <a href=\"list-of-tasks.jsp\" style=\"text-decoration: none\" class=\"mybutton\">Cancel</a>\r\n");
      out.write("        <input type=\"submit\" name=\"buttonAddTask\" value=\"Save\" class=\"mybutton\"/>\r\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("eachProject");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectService.projects}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                        <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eachProject.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eachProject.id == sessionScope.project.id ? 'selected=\"selected\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(">\r\n");
          out.write("                                ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eachProject.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(',');
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eachProject.shortName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\r\n");
          out.write("                        </option>\r\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setVar("eachCollaborator");
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${collaboratorService.collaborators}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                        <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eachCollaborator.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eachCollaborator.id == sessionScope.task.collaborator.id ? 'selected=\"selected\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(">\r\n");
          out.write("                                ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eachCollaborator.surname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(',');
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eachCollaborator.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(',');
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eachCollaborator.patronymic}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(',');
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eachCollaborator.position}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\r\n");
          out.write("                        </option>\r\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }
}
