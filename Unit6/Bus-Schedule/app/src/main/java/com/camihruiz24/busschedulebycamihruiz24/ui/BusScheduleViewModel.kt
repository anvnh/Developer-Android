package com.camihruiz24.busschedulebycamihruiz24.ui

import androidx.lifecycle.ViewModel
import com.camihruiz24.busschedulebycamihruiz24.data.BusSchedule
import com.camihruiz24.busschedulebycamihruiz24.data.BusScheduleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@HiltViewModel
class BusScheduleViewModel @Inject internal constructor(
    private val busScheduleRepository: BusScheduleRepository
): ViewModel() {

    // Get bus schedule
    fun getFullSchedule(): Flow<List<BusSchedule>> =
        busScheduleRepository.getAllBusSchedulesStream()

    // Get bus schedule by stop
    fun getScheduleFor(stopName: String): Flow<List<BusSchedule>> =
        busScheduleRepository.getBusScheduleStream(stopName)

}