package com.example.ef_buscar.Controller;

import com.example.ef_buscar.Dao.EmployeeDao;
import com.example.ef_buscar.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@org.springframework.stereotype.Controller
@RestController
public class Controller {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/rh/buscarempleado/{letra}/{order}")
    public List<Employee> obtenerPorId(@PathVariable("letra") String letra,@PathVariable("order") String order ){

            List<Employee> listaEmployee = employeeDao.buscar(order);

        List<Employee> empleadosFiltrados = listaEmployee.stream()
                .filter(employee -> employee.getFirstName().startsWith(letra))
                .sorted((e1, e2) -> {
                    // Ordenar en forma descendente según el campo especificado
                    switch (order.toLowerCase()) {
                        case "firstname":
                            return e2.getFirstName().compareTo(e1.getFirstName());
                        case "lastname":
                            return e2.getLastName().compareTo(e1.getLastName());
                        case "email":
                            return e2.getEmail().compareTo(e1.getEmail());
                        default:
                            throw new IllegalArgumentException("Campo de orden no válido: " + order);
                    }
                })
                .toList();

        return empleadosFiltrados;
    }


}
