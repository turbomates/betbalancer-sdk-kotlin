package com.turbomates.betbalancer.model.bookmakerstatus

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement

@Serializable
@SerialName("BookmakerStatus")
data class Login(
    @SerialName("bookmakerid")
    override val bookmakerId: Int,
    val key: String
) : BookmakerStatus {
    @XmlElement(false)
    override val type = BookmakerStatus.Type.LOGIN
}
