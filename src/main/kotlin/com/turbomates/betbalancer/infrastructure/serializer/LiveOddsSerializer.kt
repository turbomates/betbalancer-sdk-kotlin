// import com.turbomates.betbalancer.liveodds.response.LiveOdds
// import com.turbomates.betbalancer.liveodds.response.LoginFailed
// import com.turbomates.betbalancer.liveodds.response.LoginOk
// import kotlinx.serialization.KSerializer
// import kotlinx.serialization.Serializable
// import kotlinx.serialization.Serializer
// import kotlinx.serialization.descriptors.PolymorphicKind
// import kotlinx.serialization.descriptors.SerialDescriptor
// import kotlinx.serialization.descriptors.buildClassSerialDescriptor
// import kotlinx.serialization.descriptors.buildSerialDescriptor
// import kotlinx.serialization.descriptors.element
// import kotlinx.serialization.encoding.Decoder
// import kotlinx.serialization.encoding.Encoder
// import kotlinx.serialization.encoding.decodeStructure
// import kotlinx.serialization.serializerOrNull
// import nl.adaptivity.xmlutil.serialization.XmlElement
// import nl.adaptivity.xmlutil.serialization.XmlSerialName
//
// @Serializer(forClass = LiveOdds::class)
// object LiveOddsSerializer : KSerializer<LiveOdds> {
//     override val descriptor: SerialDescriptor = buildClassSerialDescriptor("BetbalancerLiveOdds") {
//         element<LiveOdds.Status>("status")
//     }
//
//     override fun serialize(encoder: Encoder, value: LiveOdds) {
//         val actualSerializer =
//             encoder.serializersModule.getPolymorphic(LiveOdds::class, value)
//                 ?: value::class.serializerOrNull()
//                 ?: throw LiveOddsSerializerException("Subtype ${value::class} is not registered")
//         @Suppress("UNCHECKED_CAST")
//         (actualSerializer as KSerializer<LiveOdds>).serialize(encoder, value)
//     }
//
//     override fun deserialize(decoder: Decoder): LiveOdds {
//         decoder.decodeStructure(descriptor) {
//             while (true) {
//                 if (decodeElementIndex(descriptor) == 0) {
//                     // val status = decodeStringElement(descriptor, 0)
//                     val status = decodeSerializableElement(descriptor,0, LiveOdds.Status.serializer())
//                     println(status)
//                 } else break
//             }
//         }
//
//         val v = LiveOddsXml.serializer().deserialize(decoder)
//         val status = v.status
//         return when (status) {
//             LiveOdds.Status.LOGIN_OK -> LoginOk.serializer().deserialize(decoder)
//             LiveOdds.Status.LOGIN_FAILED -> LoginFailed.serializer().deserialize(decoder)
//             else -> throw LiveOddsSerializerException("Cannot deserialize status $status")
//         }
//     }
//
//     @Serializable
//     @XmlSerialName("BetbalancerLiveOdds", "http://www.betbalancer.com/BetbalancerLiveOdds", "")
//     private data class LiveOddsXml(
//         @XmlElement(false)
//         val status: LiveOdds.Status
//     )
// }
//
// class LiveOddsSerializerException(message: String) : Exception(message)
