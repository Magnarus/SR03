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
        String id_14id=  request.getParameter("id52");
        int id_14idTemp  = Integer.parseInt(id_14id);
        beans.AnnonceBean[] getAnnoncesWithId49mtemp = sampleAnnuaireProxyid.getAnnoncesWithId(id_14idTemp);
if(getAnnoncesWithId49mtemp == null){
%>
<%=getAnnoncesWithId49mtemp %>
<%
}else{
        String tempreturnp50 = null;
        if(getAnnoncesWithId49mtemp != null){
        java.util.List listreturnp50= java.util.Arrays.asList(getAnnoncesWithId49mtemp);
        tempreturnp50 = listreturnp50.toString();
        }
        %>
        <%=tempreturnp50%>
        <%
}
break;
case 54:
        gotMethod = true;
        beans.CategorieBean[] getCategories54mtemp = sampleAnnuaireProxyid.getCategories();
if(getCategories54mtemp == null){
%>
<%=getCategories54mtemp %>
<%
}else{
        String tempreturnp55 = null;
        if(getCategories54mtemp != null){
        java.util.List listreturnp55= java.util.Arrays.asList(getCategories54mtemp);
        tempreturnp55 = listreturnp55.toString();
        }
        %>
        <%=tempreturnp55%>
        <%
}
break;
case 57:
        gotMethod = true;
        String nom_16id=  request.getParameter("nom62");
            java.lang.String nom_16idTemp = null;
        if(!nom_16id.equals("")){
         nom_16idTemp  = nom_16id;
        }
        String tel_17id=  request.getParameter("tel64");
            java.lang.String tel_17idTemp = null;
        if(!tel_17id.equals("")){
         tel_17idTemp  = tel_17id;
        }
        String details_18id=  request.getParameter("details66");
            java.lang.String details_18idTemp = null;
        if(!details_18id.equals("")){
         details_18idTemp  = details_18id;
        }
        String rue_20id=  request.getParameter("rue70");
            java.lang.String rue_20idTemp = null;
        if(!rue_20id.equals("")){
         rue_20idTemp  = rue_20id;
        }
        String codePostal_21id=  request.getParameter("codePostal72");
        int codePostal_21idTemp  = Integer.parseInt(codePostal_21id);
        String ville_22id=  request.getParameter("ville74");
            java.lang.String ville_22idTemp = null;
        if(!ville_22id.equals("")){
         ville_22idTemp  = ville_22id;
        }
        String id_23id=  request.getParameter("id76");
        int id_23idTemp  = Integer.parseInt(id_23id);
        %>
        <jsp:useBean id="beans1AdresseBean_19id" scope="session" class="beans.AdresseBean" />
        <%
        beans1AdresseBean_19id.setRue(rue_20idTemp);
        beans1AdresseBean_19id.setCodePostal(codePostal_21idTemp);
        beans1AdresseBean_19id.setVille(ville_22idTemp);
        beans1AdresseBean_19id.setId(id_23idTemp);
        String annonceur_24id=  request.getParameter("annonceur78");
            java.lang.String annonceur_24idTemp = null;
        if(!annonceur_24id.equals("")){
         annonceur_24idTemp  = annonceur_24id;
        }
        String id_25id=  request.getParameter("id80");
        int id_25idTemp  = Integer.parseInt(id_25id);
        %>
        <jsp:useBean id="beans1AnnonceBean_15id" scope="session" class="beans.AnnonceBean" />
        <%
        beans1AnnonceBean_15id.setNom(nom_16idTemp);
        beans1AnnonceBean_15id.setTel(tel_17idTemp);
        beans1AnnonceBean_15id.setDetails(details_18idTemp);
        beans1AnnonceBean_15id.setAdresse(beans1AdresseBean_19id);
        beans1AnnonceBean_15id.setAnnonceur(annonceur_24idTemp);
        beans1AnnonceBean_15id.setId(id_25idTemp);
        String nom_27id=  request.getParameter("nom84");
            java.lang.String nom_27idTemp = null;
        if(!nom_27id.equals("")){
         nom_27idTemp  = nom_27id;
        }
        String id_28id=  request.getParameter("id86");
        int id_28idTemp  = Integer.parseInt(id_28id);
        %>
        <jsp:useBean id="beans1CategorieBean_26id" scope="session" class="beans.CategorieBean" />
        <%
        beans1CategorieBean_26id.setNom(nom_27idTemp);
        beans1CategorieBean_26id.setId(id_28idTemp);
        sampleAnnuaireProxyid.addAnnonce(beans1AnnonceBean_15id,beans1CategorieBean_26id);
break;
case 88:
        gotMethod = true;
        String id_29id=  request.getParameter("id91");
        int id_29idTemp  = Integer.parseInt(id_29id);
        sampleAnnuaireProxyid.deleteAnnonce(id_29idTemp);
break;
case 93:
        gotMethod = true;
        beans.AnnonceBean[] getAnnonces93mtemp = sampleAnnuaireProxyid.getAnnonces();
if(getAnnonces93mtemp == null){
%>
<%=getAnnonces93mtemp %>
<%
}else{
        String tempreturnp94 = null;
        if(getAnnonces93mtemp != null){
        java.util.List listreturnp94= java.util.Arrays.asList(getAnnonces93mtemp);
        tempreturnp94 = listreturnp94.toString();
        }
        %>
        <%=tempreturnp94%>
        <%
}
break;
case 96:
        gotMethod = true;
        String rue_31id=  request.getParameter("rue101");
            java.lang.String rue_31idTemp = null;
        if(!rue_31id.equals("")){
         rue_31idTemp  = rue_31id;
        }
        String codePostal_32id=  request.getParameter("codePostal103");
        int codePostal_32idTemp  = Integer.parseInt(codePostal_32id);
        String ville_33id=  request.getParameter("ville105");
            java.lang.String ville_33idTemp = null;
        if(!ville_33id.equals("")){
         ville_33idTemp  = ville_33id;
        }
        String id_34id=  request.getParameter("id107");
        int id_34idTemp  = Integer.parseInt(id_34id);
        %>
        <jsp:useBean id="beans1AdresseBean_30id" scope="session" class="beans.AdresseBean" />
        <%
        beans1AdresseBean_30id.setRue(rue_31idTemp);
        beans1AdresseBean_30id.setCodePostal(codePostal_32idTemp);
        beans1AdresseBean_30id.setVille(ville_33idTemp);
        beans1AdresseBean_30id.setId(id_34idTemp);
        sampleAnnuaireProxyid.addAdresse(beans1AdresseBean_30id);
break;
case 109:
        gotMethod = true;
        String idAdresse_35id=  request.getParameter("idAdresse120");
        int idAdresse_35idTemp  = Integer.parseInt(idAdresse_35id);
        beans.AdresseBean getAdresse109mtemp = sampleAnnuaireProxyid.getAdresse(idAdresse_35idTemp);
if(getAdresse109mtemp == null){
%>
<%=getAdresse109mtemp %>
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
if(getAdresse109mtemp != null){
java.lang.String typerue112 = getAdresse109mtemp.getRue();
        String tempResultrue112 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typerue112));
        %>
        <%= tempResultrue112 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">codePostal:</TD>
<TD>
<%
if(getAdresse109mtemp != null){
%>
<%=getAdresse109mtemp.getCodePostal()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">ville:</TD>
<TD>
<%
if(getAdresse109mtemp != null){
java.lang.String typeville116 = getAdresse109mtemp.getVille();
        String tempResultville116 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeville116));
        %>
        <%= tempResultville116 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">id:</TD>
<TD>
<%
if(getAdresse109mtemp != null){
%>
<%=getAdresse109mtemp.getId()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 122:
        gotMethod = true;
        String id_36id=  request.getParameter("id125");
        int id_36idTemp  = Integer.parseInt(id_36id);
        sampleAnnuaireProxyid.deleteCategorie(id_36idTemp);
break;
case 127:
        gotMethod = true;
        String nom_37id=  request.getParameter("nom130");
            java.lang.String nom_37idTemp = null;
        if(!nom_37id.equals("")){
         nom_37idTemp  = nom_37id;
        }
        sampleAnnuaireProxyid.addCategorie(nom_37idTemp);
break;
case 132:
        gotMethod = true;
        String id_38id=  request.getParameter("id135");
        int id_38idTemp  = Integer.parseInt(id_38id);
        beans.AnnonceBean[] getAnnoncesWithIdCateg132mtemp = sampleAnnuaireProxyid.getAnnoncesWithIdCateg(id_38idTemp);
if(getAnnoncesWithIdCateg132mtemp == null){
%>
<%=getAnnoncesWithIdCateg132mtemp %>
<%
}else{
        String tempreturnp133 = null;
        if(getAnnoncesWithIdCateg132mtemp != null){
        java.util.List listreturnp133= java.util.Arrays.asList(getAnnoncesWithIdCateg132mtemp);
        tempreturnp133 = listreturnp133.toString();
        }
        %>
        <%=tempreturnp133%>
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