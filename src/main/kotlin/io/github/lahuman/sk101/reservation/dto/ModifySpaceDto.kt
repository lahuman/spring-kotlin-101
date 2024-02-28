package io.github.lahuman.sk101.reservation.dto

import jakarta.validation.constraints.NotBlank

data class ModifySpaceDto(
    @field:NotBlank
    val seq: Long,
    @field:NotBlank
    val spaceNm: String,
    val spaceImagePath: String?,
    @field:NotBlank
    var spaceDesc: String
)