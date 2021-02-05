package com.sepi.officemanagement.services

import com.sepi.officemanagement.models.Employee
import com.sepi.officemanagement.repositories.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EmployeeServiceImpl: EmployeeService {

    @Autowired
    lateinit var employeeRepository: EmployeeRepository

    override fun getAllEmployees(): List<Employee> {
        return employeeRepository.findAll()
    }

    override fun getEmployeeByID(employeeID: String): Employee {
        if (employeeRepository.existsById(employeeID)) {
            return employeeRepository.findById(employeeID).get()
        } else {
            throw Exception("Given employee ID $employeeID not matched with records")
        }
    }

    override fun saveEmployeeDetail(employeeDetail: Employee) {
        employeeRepository.save(employeeDetail)
    }

    override fun updateEmployeeDetail(employeeID: String, employeeDetail: Employee): Employee {
        if (employeeRepository.existsById(employeeID)) {
            return employeeRepository.save(employeeDetail)
        } else {
            throw Exception("Given employee ID $employeeID not matched with records")
        }
    }

    override fun deleteEmployeeDetail(employeeID: String) {
        if (employeeRepository.existsById(employeeID)) {
            employeeRepository.deleteById(employeeID)
        } else {
            throw Exception("Given employee ID $employeeID not matched with records")
        }
    }

}