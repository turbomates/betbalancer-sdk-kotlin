package com.turbomates.betbalancer.model

import com.turbomates.betbalancer.model.bookmakerstatus.Login
import io.kotest.matchers.shouldBe
import kotlinx.serialization.encodeToString
import nl.adaptivity.xmlutil.serialization.XML
import org.junit.jupiter.api.Test

class BookmakerStatusSerializationTest {
    @Test
    fun `login serialization`() {
        val login = Login(1, "testKey")
        val plain = XML().encodeToString(login)
        plain shouldBe """<BookmakerStatus bookmakerid="1" key="testKey" type="login"/>"""
    }
}
