<!-- Ne pas oublier cette ligne sinon tous les tags de la JSTL seront ignorés ! -->  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<c:if test="${!empty requestScope['message']}">         
    <div class="alert alert-info">${requestScope['message']}</div>
</c:if>  


    
<!-- Zone qui affiche les utilisateurs si le paramètre action vaut listerComptes -->  
<h2>Liste des utilisateurs</h2>  
<br>
<table  class="table table-hover">  
    <!-- La ligne de titre du tableau des comptes -->  
    <tr>  
        <td><b>Login</b></td>  
        <td><b>Nom</b></td>  
        <td><b>Prénom</b></td>  
    </tr>  

    <!-- Ici on affiche les lignes, une par utilisateur -->  
    <!-- cette variable montre comment on peut utiliser JSTL et EL pour calculer -->  
    <c:set var="total" value="0"/>  

    <c:forEach var="u" items="${requestScope['listeDesUsers']}">  
        <tr>  
            <td>${u.login}</td>  
            <td>${u.lastname}</td>  
            <td>${u.firstname}</td>  
            <!-- On compte le nombre de users -->  
            <c:set var="total" value="${total+1}"/>  
        </tr>  
    </c:forEach>  

    <!-- Affichage du solde total dans la dernière ligne du tableau -->  
    <tr><td><b>TOTAL</b></td><td></td><td><b>${total}</b></td><td></td></tr>  
</table>

Total : ${totalUtilisateur}

<ul class="pagination">
    
    <c:forEach var="i" begin="1" end="${totalUtilisateur}" step="10">
        <!--<option value="<c:out value="${i+100}"/>"><c:out value="${i+100}"/></option>-->
        
        <c:choose>
            <c:when test="i+10>${totalUtilisateur}"> <li><a href="#">${i} - ${totalUtilisateur}</a></li></c:when>
            <c:otherwise><li><a href="#">${i} - ${i+9}</a></li></c:otherwise>
        </c:choose>
    </c:forEach> 
</ul>
