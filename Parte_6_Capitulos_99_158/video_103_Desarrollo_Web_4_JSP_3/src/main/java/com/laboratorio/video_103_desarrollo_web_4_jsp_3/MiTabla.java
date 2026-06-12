
package com.laboratorio.video_103_desarrollo_web_4_jsp_3;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class MiTabla extends SimpleTagSupport {
    //private final int[] valores1 = {5,7,8,6,14};
    //private final int[] valores2 = {2,4,1,5,3};
    
    private Columna columna1;
    private Columna columna2;
    
    public void setColumna1(Columna columna1){
        this.columna1=columna1;
    }
    
    public void setColumna2(Columna columna2){
        this.columna2=columna2;
    }
    @Override
    public void doTag() throws JspException, IOException{
        Operaciones operaciones = new Operaciones();
        JspWriter out= getJspContext().getOut();
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>Valor 1</th>");
        out.println("<th>Valor 2</th>");
        out.println("<th>Suma</th>");
        out.println("<th>Resta</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        for(int i=0;i<columna1.getValores().length;i++)
        {
            out.println("<tr>");
            out.println("<td>"+columna1.getValores()[i]+"</td>");
            out.println("<td>"+columna2.getValores()[i]+"</td>");
            out.println("<td>"+operaciones.suma(
                                columna1.getValores()[i], 
                                columna2.getValores()[i])+
                        "</td>");
            out.println("<td>"+operaciones.resta(
                                columna1.getValores()[i], 
                                columna2.getValores()[i])+
                        "</td>");
            out.println("</tr>");
        }
        out.println("</body>");
        out.println("</table>");
    }
    
}
