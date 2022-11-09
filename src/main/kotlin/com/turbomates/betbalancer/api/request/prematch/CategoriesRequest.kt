package com.turbomates.betbalancer.api.request.prematch

data class CategoriesRequest(val languages: List<String>? = null, val sportId: Int? = null, val categoryId: Int? = null)
