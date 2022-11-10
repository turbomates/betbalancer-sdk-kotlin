import com.turbomates.betbalancer.liveodds.response.LiveOdds
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.decodeStructure

@Serializer(forClass = LiveOdds.Status::class)
object LiveOddsStatusDeserializationStrategy : DeserializationStrategy<LiveOdds.Status> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("LiveOddsStatusDeserializationStrategyDescriptor") {
        element<LiveOdds.Status>("status")
    }

    override fun deserialize(decoder: Decoder): LiveOdds.Status {
        return decoder.decodeStructure(descriptor) {
            var status = LiveOdds.Status.ERROR
            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> status = decodeSerializableElement(descriptor, 0, LiveOdds.Status.serializer())
                    CompositeDecoder.DECODE_DONE -> break
                    else -> error("Unexpected index: $index")
                }
            }

            return@decodeStructure status
        }
    }
}

