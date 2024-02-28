package io.github.lahuman.sk101.reservation

import io.github.lahuman.sk101.entity.Room
import io.github.lahuman.sk101.entity.Space
import org.springframework.data.repository.CrudRepository


interface RoomRepository : CrudRepository<Room, Long> {
}

interface SpaceRepository : CrudRepository<Space, Long> {

}

