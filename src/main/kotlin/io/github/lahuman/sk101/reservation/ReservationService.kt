package io.github.lahuman.sk101.reservation

import io.github.lahuman.sk101.entity.Space
import io.github.lahuman.sk101.reservation.dto.CreateSpaceDto
import io.github.lahuman.sk101.reservation.dto.ModifySpaceDto
import io.github.lahuman.sk101.reservation.dto.ResponseSpaceDto
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException.NotFound

@Service
class ReservationService(
    private val spaceRepository: SpaceRepository,
    private val roomRepository: RoomRepository
) {


    fun selectSpace() = spaceRepository.findAll()
        .map { ResponseSpaceDto(it.seq!!, it.spaceNm, it.spaceImagePath, it.spaceDesc, it.regDtm!!, it.modDtm!!) }


    fun insertSpace(spaceDto: CreateSpaceDto): ResponseSpaceDto {
        val space = spaceRepository.save(
            Space(null, spaceDto.spaceNm, spaceDto.spaceImagePath, spaceDto.spaceDesc)
        );

        return ResponseSpaceDto(
            space.seq!!,
            space.spaceNm,
            space.spaceImagePath,
            space.spaceDesc,
            space.regDtm!!,
            space.modDtm!!
        )
    }

    fun updateSpace(spaceDto: ModifySpaceDto): ResponseSpaceDto {
        val space = spaceRepository.findByIdOrNull(spaceDto.seq) ?: throw RuntimeException("Not Found")

        space.spaceNm = spaceDto.spaceNm;
        space.spaceDesc = spaceDto.spaceDesc;
        space.spaceImagePath = spaceDto.spaceImagePath;

        spaceRepository.save(space);

        return ResponseSpaceDto(
            space.seq!!,
            space.spaceNm,
            space.spaceImagePath,
            space.spaceDesc,
            space.regDtm!!,
            space.modDtm!!
        )
    }

    fun deleteSpace(seq: Long) {
        val space = spaceRepository.findByIdOrNull(seq) ?: throw RuntimeException("Not Found")

        spaceRepository.delete(space)

    }
}