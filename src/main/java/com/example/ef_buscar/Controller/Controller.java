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
    final EmployeeDao employeeDao;

    public Controller(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;

    }

    @GetMapping("/rh/buscarempleado/{letra}/{order}")
    public List<Employee> obtenerPorId(@PathVariable("letra") String letra,@PathVariable("order") String order ){

            List<Employee> listaEmployee = employeeDao.buscar(order);
            for(int i=0;i<listaEmployee.size();i++){



            }

            return null;
    }


}
