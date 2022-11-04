package com.turbomates.betbalancer.model.liveodds

import kotlinx.serialization.modules.SerializersModule

sealed class LiveOdds {
    companion object {
        val module = SerializersModule { }
    }
}
