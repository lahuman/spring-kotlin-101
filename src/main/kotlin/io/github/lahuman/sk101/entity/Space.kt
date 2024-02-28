package io.github.lahuman.sk101.entity

import io.github.lahuman.sk101.entity.common.DateAudit
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Space(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var seq: Long?,
    @Column(columnDefinition = "varchar(100) not null")
    var spaceNm: String,
    @Column(columnDefinition = "varchar(500) null")
    var spaceImagePath: String?,
    @Column(columnDefinition = "varchar(1000) null")
    var spaceDesc: String
): DateAudit()