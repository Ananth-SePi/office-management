package com.sepi.officemanagement.services

import com.sepi.officemanagement.models.Employee

interface EmployeeService {

    fun getAllEmployees(): List<Employee>

    fun getEmployeeByID(employeeID: String): Employee

    fun saveEmployeeDetail(employeeDetail: Employee)

    fun updateEmployeeDetail(employeeID: String, employeeDetail: Employee): Employee

    fun deleteEmployeeDetail(employeeID: String)

}