package com.udemy.kad.lesson3.mapper

import com.github.dozermapper.core.DozerBeanMapperBuilder
import com.github.dozermapper.core.Mapper

object DozerMapper {
    private var mapper: Mapper = DozerBeanMapperBuilder.buildDefault()

    fun <O, D> parseObject(origin: O, destination: Class<D>?): D {
        return mapper.map(origin, destination)
    }

    fun <O, D> parseListObjects(origin: List<O>, destination: Class<D>?): List<D> {
        val destinationList: ArrayList<D> = ArrayList()
        for (o in origin)
            destinationList.add(mapper.map(o, destination))
        return destinationList
    }
}