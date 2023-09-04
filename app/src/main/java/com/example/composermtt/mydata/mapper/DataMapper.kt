package com.example.composermtt.mydata.mapper

interface DataMapper<T> {
    fun toDomain(): T
}