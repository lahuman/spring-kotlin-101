package io.github.lahuman.sk101.entity

import io.github.lahuman.sk101.entity.common.DateAudit
import jakarta.persistence.*

@Entity
class Room(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var seq: Long,
    val roomNm: String,
    val roomLocation: String,
    val maxCapacity: Int,
    val hasDeviceInfo: String,
    @ManyToOne var space: Space,
) : DateAudit()