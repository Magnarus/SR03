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
        String id_1id=  request.getParameter("id20");
        int id_1idTemp  = Integer.parseInt(id_1id);
        String newName_2id=  request.getParameter("newName22");
            java.lang.String newName_2idTemp = null;
        if(!newName_2id.equals("")){
         newName_2idTemp  = newName_2id;
        }
        sampleAnnuaireProxyid.updateCategorieName(id_1idTemp,newName_2idTemp);
break;
case 24:
        gotMethod = true;
        String nom_4id=  request.getParameter("nom29");
            java.lang.String nom_4idTemp = null;
        if(!nom_4id.equals("")){
         nom_4idTemp  = nom_4id;
        }
        String tel_5id=  request.getParameter("tel31");
            java.lang.String tel_5idTemp = null;
        if(!tel_5id.equals("")){
         tel_5idTemp  = tel_5id;
        }
        String details_6id=  request.getParameter("details33");
            java.lang.String details_6idTemp = null;
        if(!details_6id.equals("")){
         details_6idTemp  = details_6id;
        }
        String rue_8id=  request.getParameter("rue37");
            java.lang.String rue_8idTemp = null;
        if(!rue_8id.equals("")){
         rue_8idTemp  = rue_8id;
        }
        String codePostal_9id=  request.getParameter("codePostal39");
        int codePostal_9idTemp  = Integer.parseInt(codePostal_9id);
        String ville_10id=  request.getParameter("ville41");
            java.lang.String ville_10idTemp = null;
        if(!ville_10id.equals("")){
         ville_10idTemp  = ville_10id;
        }
        String id_11id=  request.getParameter("id43");
        int id_11idTemp  = Integer.parseInt(id_11id);
        %>
        <jsp:useBean id="beans1AdresseBean_7id" scope="session" class="beans.AdresseBean" />
        <%
        beans1AdresseBean_7id.setRue(rue_8idTemp);
        beans1AdresseBean_7id.setCodePostal(codePostal_9idTemp);
        beans1AdresseBean_7id.setVille(ville_10idTemp);
        beans1AdresseBean_7id.setId(id_11idTemp);
        String annonceur_12id=  request.getParameter("annonceur45");
            java.lang.String annonceur_12idTemp = null;
        if(!annonceur_12id.equals("")){
         annonceur_12idTemp  = annonceur_12id;
        }
        String id_13id=  request.getParameter("id47");
        int id_13idTemp  = Integer.parseInt(id_13id);
        %>
        <jsp:useBean id="beans1AnnonceBean_3id" scope="session" class="beans.AnnonceBean" />
        <%
        beans1AnnonceBean_3id.setNom(nom_4idTemp);
        beans1AnnonceBean_3id.setTel(tel_5idTemp);
        beans1AnnonceBean_3id.setDetails(details_6idTemp);
        beans1AnnonceBean_3id.setAdresse(beans1AdresseBean_7id);
        beans1AnnonceBean_3id.setAnnonceur(annonceur_12idTemp);
        beans1AnnonceBean_3id.setId(id_13idTemp);
        sampleAnnuaireProxyid.updateAnnonceName(beans1AnnonceBean_3id);
break;
case 49:
        gotMethod = true;
        String req_14id=  request.getParameter("req52");
            java.lang.String req_14idTemp = null;
        if(!req_14id.equals("")){
         req_14idTemp  = req_14id;
        }
        int mySQLwritingQuery49mtemp = sampleAnnuaireProxyid.mySQLwritingQuery(req_14idTemp);
        String tempResultreturnp50 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(mySQLwritingQuery49mtemp));
        %>
        <%= tempResultreturnp50 %>
        <%
break;
case 54:
        gotMethod = true;
        String id_15id=  request.getParameter("id57");
        int id_15idTemp  = Integer.parseInt(id_15id);
        beans.AnnonceBean[] getAnnoncesWithId54mtemp = sampleAnnuaireProxyid.getAnnoncesWithId(id_15idTemp);
if(getAnnoncesWithId54mtemp == null){
%>
<%=getAnnoncesWithId54mtemp %>
<%
}else{
        String tempreturnp55 = null;
        if(getAnnoncesWithId54mtemp != null){
        java.util.List listreturnp55= java.util.Arrays.asList(getAnnoncesWithId54mtemp);
        tempreturnp55 = listreturnp55.toString();
        }
        %>
        <%=tempreturnp55%>
        <%
}
break;
case 59:
        gotMethod = true;
        beans.CategorieBean[] getCategories59mtemp = sampleAnnuaireProxyid.getCategories();
if(getCategories59mtemp == null){
%>
<%=getCategories59mtemp %>
<%
}else{
        String tempreturnp60 = null;
        if(getCategories59mtemp != null){
        java.util.List listreturnp60= java.util.Arrays.asList(getCategories59mtemp);
        tempreturnp60 = listreturnp60.toString();
        }
        %>
        <%=tempreturnp60%>
        <%
}
break;
case 62:
        gotMethod = true;
        String nom_17id=  request.getParameter("nom67");
            java.lang.String nom_17idTemp = null;
        if(!nom_17id.equals("")){
         nom_17idTemp  = nom_17id;
        }
        String tel_18id=  request.getParameter("tel69");
            java.lang.String tel_18idTemp = null;
        if(!tel_18id.equals("")){
         tel_18idTemp  = tel_18id;
        }
        String details_19id=  request.getParameter("details71");
            java.lang.String details_19idTemp = null;
        if(!details_19id.equals("")){
         details_19idTemp  = details_19id;
        }
        String rue_21id=  request.getParameter("rue75");
            java.lang.String rue_21idTemp = null;
        if(!rue_21id.equals("")){
         rue_21idTemp  = rue_21id;
        }
        String codePostal_22id=  request.getParameter("codePostal77");
        int codePostal_22idTemp  = Integer.parseInt(codePostal_22id);
        String ville_23id=  request.getParameter("ville79");
            java.lang.String ville_23idTemp = null;
        if(!ville_23id.equals("")){
         ville_23idTemp  = ville_23id;
        }
        String id_24id=  request.getParameter("id81");
        int id_24idTemp  = Integer.parseInt(id_24id);
        %>
        <jsp:useBean id="beans1AdresseBean_20id" scope="session" class="beans.AdresseBean" />
        <%
        beans1AdresseBean_20id.setRue(rue_21idTemp);
        beans1AdresseBean_20id.setCodePostal(codePostal_22idTemp);
        beans1AdresseBean_20id.setVille(ville_23idTemp);
        beans1AdresseBean_20id.setId(id_24idTemp);
        String annonceur_25id=  request.getParameter("annonceur83");
            java.lang.String annonceur_25idTemp = null;
        if(!annonceur_25id.equals("")){
         annonceur_25idTemp  = annonceur_25id;
        }
        String id_26id=  request.getParameter("id85");
        int id_26idTemp  = Integer.parseInt(id_26id);
        %>
        <jsp:useBean id="beans1AnnonceBean_16id" scope="session" class="beans.AnnonceBean" />
        <%
        beans1AnnonceBean_16id.setNom(nom_17idTemp);
        beans1AnnonceBean_16id.setTel(tel_18idTemp);
        beans1AnnonceBean_16id.setDetails(details_19idTemp);
        beans1AnnonceBean_16id.setAdresse(beans1AdresseBean_20id);
        beans1AnnonceBean_16id.setAnnonceur(annonceur_25idTemp);
        beans1AnnonceBean_16id.setId(id_26idTemp);
        String nom_28id=  request.getParameter("nom89");
            java.lang.String nom_28idTemp = null;
        if(!nom_28id.equals("")){
         nom_28idTemp  = nom_28id;
        }
        String id_29id=  request.getParameter("id91");
        int id_29idTemp  = Integer.parseInt(id_29id);
        %>
        <jsp:useBean id="beans1CategorieBean_27id" scope="session" class="beans.CategorieBean" />
        <%
        beans1CategorieBean_27id.setNom(nom_28idTemp);
        beans1CategorieBean_27id.setId(id_29idTemp);
        sampleAnnuaireProxyid.addAnnonce(beans1AnnonceBean_16id,beans1CategorieBean_27id);
break;
case 93:
        gotMethod = true;
        String id_30id=  request.getParameter("id96");
        int id_30idTemp  = Integer.parseInt(id_30id);
        sampleAnnuaireProxyid.deleteAnnonce(id_30idTemp);
break;
case 98:
        gotMethod = true;
        beans.AnnonceBean[] getAnnonces98mtemp = sampleAnnuaireProxyid.getAnnonces();
if(getAnnonces98mtemp == null){
%>
<%=getAnnonces98mtemp %>
<%
}else{
        String tempreturnp99 = null;
        if(getAnnonces98mtemp != null){
        java.util.List listreturnp99= java.util.Arrays.asList(getAnnonces98mtemp);
        tempreturnp99 = listreturnp99.toString();
        }
        %>
        <%=tempreturnp99%>
        <%
}
break;
case 101:
        gotMethod = true;
        String rue_32id=  request.getParameter("rue106");
            java.lang.String rue_32idTemp = null;
        if(!rue_32id.equals("")){
         rue_32idTemp  = rue_32id;
        }
        String codePostal_33id=  request.getParameter("codePostal108");
        int codePostal_33idTemp  = Integer.parseInt(codePostal_33id);
        String ville_34id=  request.getParameter("ville110");
            java.lang.String ville_34idTemp = null;
        if(!ville_34id.equals("")){
         ville_34idTemp  = ville_34id;
        }
        String id_35id=  request.getParameter("id112");
        int id_35idTemp  = Integer.parseInt(id_35id);
        %>
        <jsp:useBean id="beans1AdresseBean_31id" scope="session" class="beans.AdresseBean" />
        <%
        beans1AdresseBean_31id.setRue(rue_32idTemp);
        beans1AdresseBean_31id.setCodePostal(codePostal_33idTemp);
        beans1AdresseBean_31id.setVille(ville_34idTemp);
        beans1AdresseBean_31id.setId(id_35idTemp);
        sampleAnnuaireProxyid.addAdresse(beans1AdresseBean_31id);
break;
case 114:
        gotMethod = true;
        String idAdresse_36id=  request.getParameter("idAdresse125");
        int idAdresse_36idTemp  = Integer.parseInt(idAdresse_36id);
        beans.AdresseBean getAdresse114mtemp = sampleAnnuaireProxyid.getAdresse(idAdresse_36idTemp);
if(getAdresse114mtemp == null){
%>
<%=getAdresse114mtemp %>
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
if(getAdresse114mtemp != null){
java.lang.String typerue117 = getAdresse114mtemp.getRue();
        String tempResultrue117 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typerue117));
        %>
        <%= tempResultrue117 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">codePostal:</TD>
<TD>
<%
if(getAdresse114mtemp != null){
%>
<%=getAdresse114mtemp.getCodePostal()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">ville:</TD>
<TD>
<%
if(getAdresse114mtemp != null){
java.lang.String typeville121 = getAdresse114mtemp.getVille();
        String tempResultville121 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeville121));
        %>
        <%= tempResultville121 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">id:</TD>
<TD>
<%
if(getAdresse114mtemp != null){
%>
<%=getAdresse114mtemp.getId()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 127:
        gotMethod = true;
        String id_37id=  request.getParameter("id130");
        int id_37idTemp  = Integer.parseInt(id_37id);
        sampleAnnuaireProxyid.deleteCategorie(id_37idTemp);
break;
case 132:
        gotMethod = true;
        String nom_38id=  request.getParameter("nom135");
            java.lang.String nom_38idTemp = null;
        if(!nom_38id.equals("")){
         nom_38idTemp  = nom_38id;
        }
        sampleAnnuaireProxyid.addCategorie(nom_38idTemp);
break;
case 137:
        gotMethod = true;
        String id_39id=  request.getParameter("id140");
        int id_39idTemp  = Integer.parseInt(id_39id);
        beans.AnnonceBean[] getAnnoncesWithIdCateg137mtemp = sampleAnnuaireProxyid.getAnnoncesWithIdCateg(id_39idTemp);
if(getAnnoncesWithIdCateg137mtemp == null){
%>
<%=getAnnoncesWithIdCateg137mtemp %>
<%
}else{
        String tempreturnp138 = null;
        if(getAnnoncesWithIdCateg137mtemp != null){
        java.util.List listreturnp138= java.util.Arrays.asList(getAnnoncesWithIdCateg137mtemp);
        tempreturnp138 = listreturnp138.toString();
        }
        %>
        <%=tempreturnp138%>
        <%
}
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