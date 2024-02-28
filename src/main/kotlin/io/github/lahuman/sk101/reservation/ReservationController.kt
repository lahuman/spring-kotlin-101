package io.github.lahuman.sk101.reservation

import io.github.lahuman.sk101.entity.Space
import io.github.lahuman.sk101.reservation.dto.CreateSpaceDto
import io.github.lahuman.sk101.reservation.dto.ModifySpaceDto
import io.github.lahuman.sk101.reservation.dto.ResponseSpaceDto
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/reservation")
class ReservationController(
    private val reservationService: ReservationService
) {

    @GetMapping("/space")
    fun getSpace() = reservationService.selectSpace()

    @GetMapping("/space/{seq}")
    fun getSpaceOne() = reservationService.selectSpace()

    @PostMapping("/space")
    fun addSpace(@Valid @RequestBody spaceDto: CreateSpaceDto): ResponseSpaceDto {
        return reservationService.insertSpace(spaceDto);
    }

    @PutMapping("/space/{seq}")
    fun modifySpace(@PathVariable seq: Long, @Valid @RequestBody spaceDto: ModifySpaceDto): ResponseSpaceDto {
        if (seq != spaceDto.seq) throw RuntimeException("SEQ를 확인하세요.")
        return reservationService.updateSpace(spaceDto);
    }

    @DeleteMapping("/space/{seq}")
    fun removeSpace(@PathVariable seq: Long) {
        reservationService.deleteSpace(seq)
    }


}