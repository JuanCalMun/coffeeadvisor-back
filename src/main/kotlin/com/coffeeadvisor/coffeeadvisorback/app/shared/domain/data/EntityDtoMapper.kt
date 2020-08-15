package com.coffeeadvisor.coffeeadvisorback.app.shared.domain.data

interface EntityDtoMapper<E : BaseEntity, D : BaseDto> {
    fun dtoToEntity(dto: D): E
    fun entityToDto(entity: E): D
    fun dtoToEntityList(dtoList: Iterable<D>): List<E> = dtoList.map { dtoToEntity(it) }
    fun entityToDtoList(entityList: Iterable<E>): List<D> = entityList.map { entityToDto(it) }
}