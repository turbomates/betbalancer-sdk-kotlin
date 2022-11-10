package com.turbomates.betbalancer.infrastructure

import com.turbomates.betbalancer.liveodds.response.LiveOdds
import nl.adaptivity.xmlutil.ExperimentalXmlUtilApi
import nl.adaptivity.xmlutil.XmlDeclMode
import nl.adaptivity.xmlutil.serialization.UnknownChildHandler
import nl.adaptivity.xmlutil.serialization.XML

@OptIn(ExperimentalXmlUtilApi::class)
val xml = XML {
    xmlDeclMode = XmlDeclMode.None
    // autoPolymorphic = true
    unknownChildHandler = UnknownChildHandler { _, _, _, _, _ ->
        emptyList()
    }
}
