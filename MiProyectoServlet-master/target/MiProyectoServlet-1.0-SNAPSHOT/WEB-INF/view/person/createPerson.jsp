<%--
  Created by IntelliJ IDEA.
  User: Cesar
  Date: 20/07/2022
  Time: 03:05 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrar Persona</title>
    <%@include file="../../template/head.jsp"%>
</head>
<body>
<jsp:include page="../../template/navbar.jsp"/>
<h1>REGISTRAR PERSONA</h1>
<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="card mt-5">
                <div class="card-header">REGISTRAR PERSONA</div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-12">
                            <form name="registerPerson" class="needs-validation" novalidate action="savePerson" method="post">
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label for="name" class="fw-bold">Nombre</label>
                                            <input type="text" class="form-control" name="name" id="name" required>
                                            <div class="invalid-feedback">
                                                Campo Obligatorio
                                            </div>
                                        </div>
                                        <div class="col">
                                            <label for="lastname" class="fw-bold">Apellido</label>
                                            <input type="text" class="form-control" name="lastname" id="lastname" required>
                                            <div class="invalid-feedback">
                                                Campo Obligatorio
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label for="age" class="fw-bold">Edad</label>
                                            <input type="number" class="form-control" name="age" id="age" required>
                                            <div class="invalid-feedback">
                                                Campo Obligatorio
                                            </div>
                                        </div>
                                        <div class="col">
                                            <label for="phone" class="fw-bold">Telefono</label>
                                            <input type="text" class="form-control" name="phone" id="phone" required>
                                            <div class="invalid-feedback">
                                                Campo Obligatorio
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label for="email" class="fw-bold">Correo Electronico</label>
                                            <input type="text" class="form-control" name="email" id="email" required>
                                            <div class="invalid-feedback">
                                                Campo Obligatorio
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col-12 text-end">
                                            <button type="submit" class="btn btn-success btn-sm">Registrar</button>
                                            <button type="button" class="btn btn-danger btn-sm">Cancelar</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<script>
    (function () {
        'use strict'
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.querySelectorAll('.needs-validation')
        // Loop over them and prevent submission
        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }
                    form.classList.add('was-validated')
                }, false)
            })
    })()
</script>
<jsp:include page="../../template/footer.jsp"/>
</body>
</html>
