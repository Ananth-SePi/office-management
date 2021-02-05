package com.sepi.officemanagement.controllers

import com.sepi.officemanagement.MediaType
import com.sepi.officemanagement.models.Employee
import com.sepi.officemanagement.services.EmployeeService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.Exception
import java.util.*
import javax.ws.rs.Consumes
import javax.ws.rs.Produces
import javax.ws.rs.core.Response

@RestController
@RequestMapping("/employees")
class EmployeeResource {

    @Autowired
    lateinit var employeeService: EmployeeService
    
    val logger: Logger = LoggerFactory.getLogger(EmployeeResource::class.java)

    /**
     * To fetch all the employee details
     * TODO add filter option like query string against the employee name, pagination
     */
    @GetMapping("")
    @Produces(MediaType.EMPLOYEES_V1)
    fun getAllEmployees(): Response {
        logger.info("Getting all employees")
        return Response.status(Response.Status.OK)
            .entity(employeeService.getAllEmployees())
            .build()
    }

    /**
     * Fetches the employee detail of an employee ID given.
     * @param employeeID, ID of an employee
     * @return employee detail of given employee ID
     */
    @GetMapping("/{employeeID}")
    @Consumes(MediaType.EMPLOYEE_V1)
    @Produces(MediaType.EMPLOYEE_V1)
    fun getAllEmployeeID(@PathVariable employeeID: String): Response {
        return try {
            logger.info("Getting employee $employeeID")
            Response.status(Response.Status.OK)
                .entity(employeeService.getEmployeeByID(employeeID))
                .build()
        } catch (exception: Exception) {
            logger.error("Error while getting employee detail by ID $employeeID. Cause: ${exception.message}")
            exception.printStackTrace()
            Response.status(Response.Status.NOT_FOUND).build()
        }
    }

    /**
     * Creates new employee.
     * @param employeeDetail, an employee object with all the necessary information.
     * @return 201 (created) if created; else 400 (bad request)
     */
    @PostMapping("")
    @Consumes(MediaType.EMPLOYEE_V1)
    fun saveEmployeeDetail(@RequestBody employeeDetail: Employee): Response {
        return try {
            logger.info("Saving employee detail")
            employeeDetail.employeeID = "2021CS" + UUID.randomUUID()
            logger.info("New employee ID ${employeeDetail.employeeID} has been created")
            employeeDetail.version = MediaType.EMPLOYEE_V1
            employeeDetail.address.version = MediaType.ADDRESS_V1
            employeeService.saveEmployeeDetail(employeeDetail)
            Response.status(Response.Status.CREATED)
                .build()
        } catch (exception: Exception) {
            logger.error("Error while saving employee detail. Cause: ${exception.message}")
            exception.printStackTrace()
            Response.status(Response.Status.BAD_REQUEST)
                .build()
        }    
    }

    /**
     * Updates the employee detail of an employee ID given.
     * @param employeeID, ID of an employee
     * @param employeeDetail, employee detail object
     * @return updated employee object.
     */
    @PutMapping("/{employeeID}")
    @Consumes(MediaType.EMPLOYEE_V1)
    @Produces(MediaType.EMPLOYEE_V1)
    fun updateEmployeeDetail(@PathVariable employeeID: String,
                             @RequestBody employeeDetail: Employee): Response {
        return try {
            logger.info("Updating employee detail $employeeID")
            employeeDetail.version = MediaType.EMPLOYEE_V1
            employeeDetail.address.version = MediaType.ADDRESS_V1
            employeeService.saveEmployeeDetail(employeeDetail)
            Response.status(Response.Status.CREATED)
                .build()
        } catch (exception: Exception) {
            logger.error("Error while saving employee detail by id $employeeID. Cause: ${exception.message}")
            exception.printStackTrace()
            Response.status(Response.Status.BAD_REQUEST)
                .build()
        }
    }

    /**
     * Deletes the employee detail of an employee ID given.
     * @param employeeID, ID of an employee
     * @return 204 (no content) if delete success; else 404 (not found)
     */
    @DeleteMapping("/{employeeID}")
    fun updateEmployeeDetail(@PathVariable employeeID: String): Response {
        return try {
            logger.info("Deleting employee detail by ID $employeeID")
            employeeService.deleteEmployeeDetail(employeeID)
            Response.status(Response.Status.NO_CONTENT).build()
        } catch (exception: Exception) {
            logger.error("Error while deleting employee detail by id $employeeID")
            Response.status(Response.Status.NOT_FOUND).build()
        }
    }

}