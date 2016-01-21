<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head></head>
<body>
 <table style="height: 10px; width: 775px;" border="1">

    <tr>
        <td>Código</td>
        <td>Descriçao</td>
        <td>Valor</td>
        <td>Tipo</td>
        <td>Pago?</td>
        <td>Data de Pagamento</td>
        <td>Ações</td>
    </tr>

    <c:forEach items="${contas}" var="conta">
        <tr>
                <td>${conta.id}</td>
                <td>${conta.descricao}</td>
                <td>${conta.valor}</td>
                <td>${conta.tipo}</td>
                <td>
                    <c:if test="${conta.paga eq false}">
                     Nao paga!
                    </c:if>
                    <c:if test="${conta.paga eq true}">
                    Paga!
                    </c:if>
                 </td>
                <td><fmt:formatDate value="${conta.dataPagamento.time}" pattern="dd/MM/yyyy" /> </td>
                <td>
                    <a href="removeConta?id=${conta.id}">Deletar</a>
                    <a href="editarConta?id=${conta.id}">Editar</a>
                </td>
            </tr>

    </c:forEach>
    </table>
</body>
</html>