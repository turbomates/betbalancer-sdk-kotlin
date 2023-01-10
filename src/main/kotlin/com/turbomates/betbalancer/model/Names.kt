package com.turbomates.betbalancer.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlValue

@Serializable
@SerialName("Texts")
data class Names(val list: List<Name>) {
    @Serializable
    @SerialName("Text")
    data class Name(
        @SerialName("Language")
        val language: String,
        private val name: Value
    ) {
        override fun toString(): String {
            return name.value
        }

        @Serializable
        data class Value(@XmlValue(true) val value: String)
    }
}
