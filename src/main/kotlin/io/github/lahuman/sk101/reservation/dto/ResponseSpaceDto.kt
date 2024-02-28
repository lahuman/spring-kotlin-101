package io.github.lahuman.sk101.reservation.dto

import java.time.LocalDate
import java.time.LocalDateTime

data class ResponseSpaceDto(
    val seq: Long,
    val spaceNm: String,
    var spaceImagePath: String?,
    var spaceDesc: String,
    val regDtm: LocalDateTime,
    val modDtm: LocalDateTime
)