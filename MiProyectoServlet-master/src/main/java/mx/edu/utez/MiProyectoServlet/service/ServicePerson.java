package mx.edu.utez.MiProyectoServlet.service;

import mx.edu.utez.MiProyectoServlet.model.person.BeanPerson;
import mx.edu.utez.MiProyectoServlet.model.person.DaoPerson;
import mx.edu.utez.MiProyectoServlet.utils.ResultAction;

import java.util.List;

public class ServicePerson {
    DaoPerson daoPerson = new DaoPerson();

    public List<BeanPerson> showPersons(){
        return daoPerson.showPersons();
    }

    public ResultAction savePerson(BeanPerson person){
        ResultAction result = new ResultAction();
        if (daoPerson.savePerson(person)) {
            result.setResult(true);
            result.setMessage("Persona Registrada Correctamente");
            result.setStatus(200);
        }else {
            result.setResult(false);
            result.setMessage("Error al Registrar Persona");
            result.setStatus(400);
        }
        return result;
    }

    public BeanPerson findPerson(Long id){
        return daoPerson.findPerson(id);
    }

    public ResultAction updatePerson(BeanPerson person){
        ResultAction result = new ResultAction();
        if (daoPerson.updatePerson(person)) {
            result.setResult(true);
            result.setMessage("Persona Modificada Correctamente");
            result.setStatus(200);
        }else {
            result.setResult(false);
            result.setMessage("Error al Modificar Persona");
            result.setStatus(400);
        }
        return result;
    }
}
