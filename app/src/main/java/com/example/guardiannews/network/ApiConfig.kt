package com.example.guardiannews.network

class ApiConfig {

    companion object {
        const val baseUrl: String = "https://content.guardianapis.com"
    }

    fun getBaseUrl(): String {
        return baseUrl
    }

}