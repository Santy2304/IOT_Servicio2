package com.example.ef_buscar.Dao;

import com.example.ef_buscar.Entity.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="servicio-producto")
public interface EmployeeDao {
    @GetMapping("/rh/empleado/orderby/{order}")
    List<Employee> buscar(@PathVariable String order);

}
