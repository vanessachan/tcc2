<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
<form:form modelAttribute="conta" action="/adicionarContas" method="post">
        <form:hidden path="id"/>
<div class="row">
    <div class="large-8 columns large-offset-2">
        <div class="row">

          <div class="small-6 small-centered columns">

            <div data-alert class="alert-box alert">
              <strong>Error</strong> - You are the error.
                <form:errors  class="error" path="descricao"/>
              <a href="#" class="close">&times;</a>
            </div>
        </div>
        </div>

        <div class="row">
            <div class="large-12 columns">

                <label>
                    Descriçao
                    <form:textarea path="descricao" rows="5" cols="100"/>
                </label>
            </div>
        </div>
        <div class="row">
            <div class="large-6 columns">
                <label>
                    Valor
                    <form:input  path="valor"/>
                </label>
            </div>
            <div class="large-6 columns">
                <label>
                    Tipo
                        <form:select path="tipo">
                            <form:option value="ENTRADA" label="Entrada" />
                            <form:option value="SAIDA" label="Saida" />
                        </form:select>
                </label>
            </div>
        </div>
        <input class="button" type="submit" value="confirmar"/>

    </div>
</div>

    </form:form>


</t:layout>