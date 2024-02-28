package io.github.lahuman.sk101.reservation.dto

import com.fasterxml.jackson.annotation.JsonInclude
import jakarta.validation.constraints.NotBlank

@JsonInclude(JsonInclude.Include.NON_NULL)
data class CreateSpaceDto(
    @field:NotBlank
    val spaceNm: String,
    val spaceImagePath: String?,
    @field:NotBlank
    var spaceDesc: String
)