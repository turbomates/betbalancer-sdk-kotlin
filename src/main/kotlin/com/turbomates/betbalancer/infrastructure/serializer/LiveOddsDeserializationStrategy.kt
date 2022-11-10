import com.turbomates.betbalancer.liveodds.response.LiveOdds
// import com.turbomates.betbalancer.liveodds.response.LoginFailed
import com.turbomates.betbalancer.liveodds.response.LoginOk
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PolymorphicKind
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.buildSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.serializerOrNull
import nl.adaptivity.xmlutil.serialization.CompactFragmentSerializer
import nl.adaptivity.xmlutil.serialization.XmlElement
import nl.adaptivity.xmlutil.serialization.XmlSerialName
import nl.adaptivity.xmlutil.serialization.structure.XmlDescriptor

@Serializer(forClass = LiveOdds::class)
object LiveOddsDeserializationStrategy : DeserializationStrategy<LiveOdds> {
    override fun deserialize(decoder: Decoder): LiveOdds {
        return LoginOk.serializer().deserialize(decoder)
        // val status = LiveOddsXml.serializer().deserialize(decoder).status
        // return when (status) {
        //     LiveOdds.Status.LOGIN_OK -> LoginOk.serializer().deserialize(decoder)
        //     // LiveOdds.Status.LOGIN_FAILED -> LoginFailed.serializer().deserialize(decoder)
        //     else -> throw LiveOddsSerializerException("Cannot deserialize status $status")
        // }
    }

    @Serializable
    @XmlSerialName("BetbalancerLiveOdds", "http://www.betbalancer.com/BetbalancerLiveOdds", "")
    data class LiveOddsXml(
        @XmlElement(false)
        val status: LiveOdds.Status
    )
}

class LiveOddsSerializerException(message: String) : Exception(message)
