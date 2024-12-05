package com.example.clinicupdatesapp.data.interests.impl

import com.example.clinicupdatesapp.data.Result
import com.example.clinicupdatesapp.data.interests.InterestSection
import com.example.clinicupdatesapp.data.interests.InterestsRepository
import com.example.clinicupdatesapp.data.interests.TopicSelection
import com.example.clinicupdatesapp.utils.addOrRemove

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

/**
 * Implementation of InterestRepository that returns a hardcoded list of
 * topics, people and publications synchronously.
 */
@OptIn(ExperimentalCoroutinesApi::class)
class FakeInterestsRepository : InterestsRepository {

    private val topics by lazy {
        listOf(
            InterestSection("Android", listOf("Jetpack Compose", "Kotlin", "Jetpack")),
            InterestSection(
                "Programming",
                listOf("Kotlin", "Declarative UIs", "Java", "Unidirectional Data Flow", "C++")
            ),
            InterestSection("Technology", listOf("Pixel", "Google"))
        )
    }

    private val people by lazy {
        listOf(
            "Kobalt Toral",
            "K'Kola Uvarek",
            "Kris Vriloc",
            "Grala Valdyr",
            "Kruel Valaxar",
            "L'Elij Venonn",
            "Kraag Solazarn",
            "Tava Targesh",
            "Kemarrin Muuda"
        )
    }

    private val clinics by lazy {
        listOf(
            "마트의원",
            "풍림연세의원",
            "안철수 소아과",
            "키큰아이 의원",
            "뼈마디 정형외과",
            "밝은 피부과",
            "속편한 내과",
            "소리이비인후과",
            "한마음 가정의학과"
        )
    }

    // for now, keep the selections in memory
    private val selectedTopics = MutableStateFlow(setOf<TopicSelection>())
    private val selectedPeople = MutableStateFlow(setOf<String>())
    private val selectedClinics = MutableStateFlow(setOf<String>())


    override suspend fun getTopics(): Result<List<InterestSection>> {
        return Result.Success(topics)
    }

    override suspend fun getPeople(): Result<List<String>> {
        return Result.Success(people)
    }

    override suspend fun getClinics(): Result<List<String>> {
        return Result.Success(clinics)
    }

    override suspend fun toggleTopicSelection(topic: TopicSelection) {
        selectedTopics.update {
            it.addOrRemove(topic)
        }
    }

    override suspend fun togglePersonSelected(person: String) {
        selectedPeople.update {
            it.addOrRemove(person)
        }
    }

    override suspend fun toggleClinicSelected(publication: String) {
        selectedClinics.update {
            it.addOrRemove(publication)
        }
    }

    override fun observeTopicsSelected(): Flow<Set<TopicSelection>> = selectedTopics

    override fun observePeopleSelected(): Flow<Set<String>> = selectedPeople

    override fun observeClinicSelected(): Flow<Set<String>> = selectedClinics
}
