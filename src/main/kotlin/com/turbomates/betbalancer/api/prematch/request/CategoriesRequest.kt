package com.turbomates.betbalancer.api.prematch.request

data class CategoriesRequest(val languages: List<String>? = null, val sportId: Int? = null, val categoryId: Int? = null)
