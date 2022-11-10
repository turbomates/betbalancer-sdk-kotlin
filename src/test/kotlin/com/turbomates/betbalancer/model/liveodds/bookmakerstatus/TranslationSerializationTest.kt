@file:Suppress("SpellCheckingInspection")

package com.turbomates.betbalancer.model.liveodds.bookmakerstatus

import com.turbomates.betbalancer.infrastructure.xml
import io.kotest.matchers.shouldBe
import kotlinx.serialization.encodeToString
import org.junit.jupiter.api.Test
import java.util.Locale

class TranslationSerializationTest {
    @Test
    fun `serialization`() {
        val translation = Translation(1, listOf(Locale.ENGLISH, Locale.JAPAN))
        val plain = xml.encodeToString(translation)
        plain shouldBe """<BookmakerStatus bookmakerid="1" type="gettranslation" languages="en,ja"/>"""
    }
}
