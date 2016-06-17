<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleAnnuaireProxyid" scope="session" class="DAO.AnnuaireProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleAnnuaireProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleAnnuaireProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleAnnuaireProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        DAO.Annuaire getAnnuaire10mtemp = sampleAnnuaireProxyid.getAnnuaire();
if(getAnnuaire10mtemp == null){
%>
<%=getAnnuaire10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 17:
        gotMethod = true;
        beans.CategorieBean[] getCategories17mtemp = sampleAnnuaireProxyid.getCategories();
if(getCategories17mtemp == null){
%>
<%=getCategories17mtemp %>
<%
}else{
        String tempreturnp18 = null;
        if(getCategories17mtemp != null){
        java.util.List listreturnp18= java.util.Arrays.asList(getCategories17mtemp);
        tempreturnp18 = listreturnp18.toString();
        }
        %>
        <%=tempreturnp18%>
        <%
}
break;
case 20:
        gotMethod = true;
        String rue_2id=  request.getParameter("rue25");
            java.lang.String rue_2idTemp = null;
        if(!rue_2id.equals("")){
         rue_2idTemp  = rue_2id;
        }
        String codePostal_3id=  request.getParameter("codePostal27");
        int codePostal_3idTemp  = Integer.parseInt(codePostal_3id);
        String ville_4id=  request.getParameter("ville29");
            java.lang.String ville_4idTemp = null;
        if(!ville_4id.equals("")){
         ville_4idTemp  = ville_4id;
        }
        String id_5id=  request.getParameter("id31");
        int id_5idTemp  = Integer.parseInt(id_5id);
        %>
        <jsp:useBean id="beans1AdresseBean_1id" scope="session" class="beans.AdresseBean" />
        <%
        beans1AdresseBean_1id.setRue(rue_2idTemp);
        beans1AdresseBean_1id.setCodePostal(codePostal_3idTemp);
        beans1AdresseBean_1id.setVille(ville_4idTemp);
        beans1AdresseBean_1id.setId(id_5idTemp);
        sampleAnnuaireProxyid.addAdresse(beans1AdresseBean_1id);
break;
case 33:
        gotMethod = true;
        String idAdresse_6id=  request.getParameter("idAdresse44");
        int idAdresse_6idTemp  = Integer.parseInt(idAdresse_6id);
        beans.AdresseBean getAdresse33mtemp = sampleAnnuaireProxyid.getAdresse(idAdresse_6idTemp);
if(getAdresse33mtemp == null){
%>
<%=getAdresse33mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">rue:</TD>
<TD>
<%
if(getAdresse33mtemp != null){
java.lang.String typerue36 = getAdresse33mtemp.getRue();
        String tempResultrue36 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typerue36));
        %>
        <%= tempResultrue36 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">codePostal:</TD>
<TD>
<%
if(getAdresse33mtemp != null){
%>
<%=getAdresse33mtemp.getCodePostal()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">ville:</TD>
<TD>
<%
if(getAdresse33mtemp != null){
java.lang.String typeville40 = getAdresse33mtemp.getVille();
        String tempResultville40 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeville40));
        %>
        <%= tempResultville40 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">id:</TD>
<TD>
<%
if(getAdresse33mtemp != null){
%>
<%=getAdresse33mtemp.getId()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 46:
        gotMethod = true;
        beans.AnnonceBean[] getAnnonces46mtemp = sampleAnnuaireProxyid.getAnnonces();
if(getAnnonces46mtemp == null){
%>
<%=getAnnonces46mtemp %>
<%
}else{
        String tempreturnp47 = null;
        if(getAnnonces46mtemp != null){
        java.util.List listreturnp47= java.util.Arrays.asList(getAnnonces46mtemp);
        tempreturnp47 = listreturnp47.toString();
        }
        %>
        <%=tempreturnp47%>
        <%
}
break;
case 49:
        gotMethod = true;
        String id_7id=  request.getParameter("id52");
        int id_7idTemp  = Integer.parseInt(id_7id);
        sampleAnnuaireProxyid.deleteAnnonce(id_7idTemp);
break;
case 54:
        gotMethod = true;
        String nom_9id=  request.getParameter("nom59");
            java.lang.String nom_9idTemp = null;
        if(!nom_9id.equals("")){
         nom_9idTemp  = nom_9id;
        }
        String tel_10id=  request.getParameter("tel61");
            java.lang.String tel_10idTemp = null;
        if(!tel_10id.equals("")){
         tel_10idTemp  = tel_10id;
        }
        String details_11id=  request.getParameter("details63");
            java.lang.String details_11idTemp = null;
        if(!details_11id.equals("")){
         details_11idTemp  = details_11id;
        }
        String rue_13id=  request.getParameter("rue67");
            java.lang.String rue_13idTemp = null;
        if(!rue_13id.equals("")){
         rue_13idTemp  = rue_13id;
        }
        String codePostal_14id=  request.getParameter("codePostal69");
        int codePostal_14idTemp  = Integer.parseInt(codePostal_14id);
        String ville_15id=  request.getParameter("ville71");
            java.lang.String ville_15idTemp = null;
        if(!ville_15id.equals("")){
         ville_15idTemp  = ville_15id;
        }
        String id_16id=  request.getParameter("id73");
        int id_16idTemp  = Integer.parseInt(id_16id);
        %>
        <jsp:useBean id="beans1AdresseBean_12id" scope="session" class="beans.AdresseBean" />
        <%
        beans1AdresseBean_12id.setRue(rue_13idTemp);
        beans1AdresseBean_12id.setCodePostal(codePostal_14idTemp);
        beans1AdresseBean_12id.setVille(ville_15idTemp);
        beans1AdresseBean_12id.setId(id_16idTemp);
        String annonceur_17id=  request.getParameter("annonceur75");
            java.lang.String annonceur_17idTemp = null;
        if(!annonceur_17id.equals("")){
         annonceur_17idTemp  = annonceur_17id;
        }
        String id_18id=  request.getParameter("id77");
        int id_18idTemp  = Integer.parseInt(id_18id);
        %>
        <jsp:useBean id="beans1AnnonceBean_8id" scope="session" class="beans.AnnonceBean" />
        <%
        beans1AnnonceBean_8id.setNom(nom_9idTemp);
        beans1AnnonceBean_8id.setTel(tel_10idTemp);
        beans1AnnonceBean_8id.setDetails(details_11idTemp);
        beans1AnnonceBean_8id.setAdresse(beans1AdresseBean_12id);
        beans1AnnonceBean_8id.setAnnonceur(annonceur_17idTemp);
        beans1AnnonceBean_8id.setId(id_18idTemp);
        String nom_20id=  request.getParameter("nom81");
            java.lang.String nom_20idTemp = null;
        if(!nom_20id.equals("")){
         nom_20idTemp  = nom_20id;
        }
        String id_21id=  request.getParameter("id83");
        int id_21idTemp  = Integer.parseInt(id_21id);
        %>
        <jsp:useBean id="beans1CategorieBean_19id" scope="session" class="beans.CategorieBean" />
        <%
        beans1CategorieBean_19id.setNom(nom_20idTemp);
        beans1CategorieBean_19id.setId(id_21idTemp);
        sampleAnnuaireProxyid.addAnnonce(beans1AnnonceBean_8id,beans1CategorieBean_19id);
break;
case 85:
        gotMethod = true;
        String id_22id=  request.getParameter("id88");
        int id_22idTemp  = Integer.parseInt(id_22id);
        sampleAnnuaireProxyid.deleteCategorie(id_22idTemp);
break;
case 90:
        gotMethod = true;
        String nom_23id=  request.getParameter("nom93");
            java.lang.String nom_23idTemp = null;
        if(!nom_23id.equals("")){
         nom_23idTemp  = nom_23id;
        }
        sampleAnnuaireProxyid.addCategorie(nom_23idTemp);
break;
case 95:
        gotMethod = true;
        String id_24id=  request.getParameter("id98");
        int id_24idTemp  = Integer.parseInt(id_24id);
        beans.AnnonceBean[] getAnnoncesWithId95mtemp = sampleAnnuaireProxyid.getAnnoncesWithId(id_24idTemp);
if(getAnnoncesWithId95mtemp == null){
%>
<%=getAnnoncesWithId95mtemp %>
<%
}else{
        String tempreturnp96 = null;
        if(getAnnoncesWithId95mtemp != null){
        java.util.List listreturnp96= java.util.Arrays.asList(getAnnoncesWithId95mtemp);
        tempreturnp96 = listreturnp96.toString();
        }
        %>
        <%=tempreturnp96%>
        <%
}
break;
case 100:
        gotMethod = true;
        String nom_26id=  request.getParameter("nom105");
            java.lang.String nom_26idTemp = null;
        if(!nom_26id.equals("")){
         nom_26idTemp  = nom_26id;
        }
        String tel_27id=  request.getParameter("tel107");
            java.lang.String tel_27idTemp = null;
        if(!tel_27id.equals("")){
         tel_27idTemp  = tel_27id;
        }
        String details_28id=  request.getParameter("details109");
            java.lang.String details_28idTemp = null;
        if(!details_28id.equals("")){
         details_28idTemp  = details_28id;
        }
        String rue_30id=  request.getParameter("rue113");
            java.lang.String rue_30idTemp = null;
        if(!rue_30id.equals("")){
         rue_30idTemp  = rue_30id;
        }
        String codePostal_31id=  request.getParameter("codePostal115");
        int codePostal_31idTemp  = Integer.parseInt(codePostal_31id);
        String ville_32id=  request.getParameter("ville117");
            java.lang.String ville_32idTemp = null;
        if(!ville_32id.equals("")){
         ville_32idTemp  = ville_32id;
        }
        String id_33id=  request.getParameter("id119");
        int id_33idTemp  = Integer.parseInt(id_33id);
        %>
        <jsp:useBean id="beans1AdresseBean_29id" scope="session" class="beans.AdresseBean" />
        <%
        beans1AdresseBean_29id.setRue(rue_30idTemp);
        beans1AdresseBean_29id.setCodePostal(codePostal_31idTemp);
        beans1AdresseBean_29id.setVille(ville_32idTemp);
        beans1AdresseBean_29id.setId(id_33idTemp);
        String annonceur_34id=  request.getParameter("annonceur121");
            java.lang.String annonceur_34idTemp = null;
        if(!annonceur_34id.equals("")){
         annonceur_34idTemp  = annonceur_34id;
        }
        String id_35id=  request.getParameter("id123");
        int id_35idTemp  = Integer.parseInt(id_35id);
        %>
        <jsp:useBean id="beans1AnnonceBean_25id" scope="session" class="beans.AnnonceBean" />
        <%
        beans1AnnonceBean_25id.setNom(nom_26idTemp);
        beans1AnnonceBean_25id.setTel(tel_27idTemp);
        beans1AnnonceBean_25id.setDetails(details_28idTemp);
        beans1AnnonceBean_25id.setAdresse(beans1AdresseBean_29id);
        beans1AnnonceBean_25id.setAnnonceur(annonceur_34idTemp);
        beans1AnnonceBean_25id.setId(id_35idTemp);
        sampleAnnuaireProxyid.updateAnnonceName(beans1AnnonceBean_25id);
break;
case 125:
        gotMethod = true;
        String id_36id=  request.getParameter("id128");
        int id_36idTemp  = Integer.parseInt(id_36id);
        beans.AnnonceBean[] getAnnoncesWithIdCateg125mtemp = sampleAnnuaireProxyid.getAnnoncesWithIdCateg(id_36idTemp);
if(getAnnoncesWithIdCateg125mtemp == null){
%>
<%=getAnnoncesWithIdCateg125mtemp %>
<%
}else{
        String tempreturnp126 = null;
        if(getAnnoncesWithIdCateg125mtemp != null){
        java.util.List listreturnp126= java.util.Arrays.asList(getAnnoncesWithIdCateg125mtemp);
        tempreturnp126 = listreturnp126.toString();
        }
        %>
        <%=tempreturnp126%>
        <%
}
break;
case 130:
        gotMethod = true;
        String id_37id=  request.getParameter("id133");
        int id_37idTemp  = Integer.parseInt(id_37id);
        String newName_38id=  request.getParameter("newName135");
            java.lang.String newName_38idTemp = null;
        if(!newName_38id.equals("")){
         newName_38idTemp  = newName_38id;
        }
        sampleAnnuaireProxyid.updateCategorieName(id_37idTemp,newName_38idTemp);
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>