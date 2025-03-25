package com.camihruiz24.busschedulebycamihruiz24.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BusScheduleDao {
    /**
     * Retrieve all the [BusSchedule]s from the the given data source.
     */
    @Query("SELECT * FROM Schedule ORDER BY arrival_time ASC")
    fun getAllBusSchedulesStream(): Flow<List<BusSchedule>>

    /**
     * Retrieve a [BusSchedule] from the given data source that matches with the [itemId].
     */
    @Query("SELECT * FROM Schedule WHERE id = :itemId")
    fun getBusScheduleStream(itemId: Int): Flow<BusSchedule>

    /**
     * Retrieve a single [BusSchedule] from the given data source that matches with the [busStop].
     */
    @Query("SELECT * FROM Schedule WHERE stop_name = :busStop ORDER BY arrival_time ASC")
    fun getBusScheduleStream(busStop: String): Flow<List<BusSchedule>>
}
