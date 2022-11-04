package com.turbomates.betbalancer

import com.turbomates.betbalancer.model.bookmakerstatus.Login
import io.ktor.network.selector.SelectorManager
import io.ktor.network.sockets.ServerSocket
import io.ktor.network.sockets.Socket
import io.ktor.network.sockets.aSocket
import io.ktor.network.sockets.openReadChannel
import io.ktor.network.sockets.openWriteChannel
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel
import io.ktor.utils.io.writeStringUtf8
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.encodeToString
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.serializer
import nl.adaptivity.xmlutil.serialization.XML
import org.slf4j.LoggerFactory

class LiveOddsClient(
    private val config: Config,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : CoroutineScope by CoroutineScope(dispatcher) {
    private val logger = LoggerFactory.getLogger(javaClass)
    private var inputChannel: ByteReadChannel
    private var outputChannel: ByteWriteChannel

    init {
        runBlocking {
            val socket = aSocket(SelectorManager()).tcp().connect(config.hostname, config.port)
            inputChannel = socket.openReadChannel()
            outputChannel = socket.openWriteChannel(autoFlush = true)
            logger.debug("Live odds socket client connected to ${config.hostname}:${config.port}")
            login()
        }
    }

    private suspend fun login() {
        val login = XML.encodeToString(Login(config.bookmakerId, config.key))
        outputChannel.writeStringUtf8(login)
    }

    private suspend fun startHandlingMessage() {
    //    TODO("implement")
    }

    data class Config(
        val hostname: String,
        val port: Int,
        val key: String,
        val bookmakerId: Int
    )
}
