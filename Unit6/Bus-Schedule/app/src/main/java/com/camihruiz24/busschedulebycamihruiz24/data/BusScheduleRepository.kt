package com.camihruiz24.busschedulebycamihruiz24.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

/**
 * Repository that provides insert, update, delete, and retrieve of [BusSchedule] from a given data source.
 */
interface BusScheduleRepository {
    /**
     * Retrieve all the [BusSchedule]s from the the given data source.
     */
    fun getAllBusSchedulesStream(): Flow<List<BusSchedule>>

    /**
     * Retrieve a [BusSchedule] from the given data source that matches with the [id].
     */
    fun getBusScheduleStream(id: Int): Flow<BusSchedule?>

    /**
     * Retrieve a sigle [BusSchedule] from the given data source that matches with the [busStop].
     */
    fun getBusScheduleStream(busStop: String): Flow<List<BusSchedule>>

}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindBusScheduleRepository(
        repositoryImpl: OfflineBusScheduleRepository
    ): BusScheduleRepository

}

