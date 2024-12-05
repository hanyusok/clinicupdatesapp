package com.example.clinicupdatesapp.data.interests

import com.example.clinicupdatesapp.data.Result
import kotlinx.coroutines.flow.Flow

data class InterestSection(val title: String, val interests: List<String>)

// Interface to the Interests data layer.
interface InterestsRepository {

    // Get relevant topics to the user.
    suspend fun getTopics(): Result<List<InterestSection>>

    // Get list of people
    suspend fun getPeople(): Result<List<String>>

    // Get list of publications
    suspend fun getClinics(): Result<List<String>>

    // Toggle between selected and unselected
    suspend fun toggleTopicSelection(topic: TopicSelection)

    // Toggle between selected and unselected
    suspend fun togglePersonSelected(person: String)

    // Toggle between selected and unselected
    suspend fun toggleClinicSelected(publication: String)

    // Currently selected topics
    fun observeTopicsSelected(): Flow<Set<TopicSelection>>

    // Currently selected people
    fun observePeopleSelected(): Flow<Set<String>>

    // Currently selected publications
    fun observeClinicSelected(): Flow<Set<String>>
}

data class TopicSelection(val section: String, val topic: String)
