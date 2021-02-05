package com.sepi.officemanagement.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.lang.NonNull
import java.util.*

@Document(collection = "employees")
data class Employee(@Id var employeeID: String,
                    @NonNull var firstName: String,
                    var lastName: String,
                    var dob: String,
                    @NonNull var gender: String,
                    @NonNull var doj: String,
                    @NonNull var address: Address,
                    @NonNull var version: String) {

}
