package com.camihruiz24.busschedulebycamihruiz24.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OfflineBusScheduleRepository @Inject constructor(
    private val busScheduleDao: BusScheduleDao
) : BusScheduleRepository {
    override fun getAllBusSchedulesStream(): Flow<List<BusSchedule>> =
        busScheduleDao.getAllBusSchedulesStream()

    override fun getBusScheduleStream(id: Int): Flow<BusSchedule?> =
        busScheduleDao.getBusScheduleStream(id)

    override fun getBusScheduleStream(busStop: String): Flow<List<BusSchedule>> =
        busScheduleDao.getBusScheduleStream(busStop)

}
