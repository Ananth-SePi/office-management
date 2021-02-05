package com.sepi.officemanagement.models

import org.springframework.lang.NonNull

data class Address(@NonNull val line1: String,
                   val line2: String,
                   val line3: String,
                   @NonNull val city: String,
                   val landmark: String,
                   @NonNull val pincode: Int,
                   @NonNull var currentAddress: Boolean,
                   @NonNull var version: String) {
}