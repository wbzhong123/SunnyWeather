package com.example.sunnyweather.ui.place



import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.sunnyweather.logic.modedl.Place
import com.example.sunnyweather.logic.network.Repository

class PlaceViewModel: ViewModel() {
    private val searchLiveData = MutableLiveData<String>()
   val placeList = ArrayList<Place>()
    val placeLiveData = searchLiveData.switchMap { query ->
        Repository.searchPlaces(query)
    }
    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }
}