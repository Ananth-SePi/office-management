package com.sepi.officemanagement.repositories

import com.sepi.officemanagement.models.Employee
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository: MongoRepository<Employee, String> {
}