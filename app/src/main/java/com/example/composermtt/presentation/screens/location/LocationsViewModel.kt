package com.example.composermtt.presentation.screens.location

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.composermtt.domain.usecase.location.LocationsUseCase
import com.example.composermtt.mydata.base.BaseViewModel
import com.example.composermtt.mydata.utils.Result
import com.example.composermtt.presentation.state.LocationsState
import com.example.composermtt.presentation.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationsViewModel @Inject constructor(
    private val locationsUseCase: LocationsUseCase
):BaseViewModel() {
    var state by mutableStateOf(LocationsState(isLoading = true))
        private set

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var currentPage = 1

    init {

        getLocations(increase = false)
    }

    fun getLocations(increase: Boolean) {
        viewModelScope.launch {
            if (increase){
                currentPage ++
            }
            else if (currentPage>1){
                currentPage --
            }

            val showPrevious = currentPage>1
            val showNext = currentPage<40

            locationsUseCase(currentPage).onEach { result ->
                when(result){
                    is Result.Success ->{
                        state=state.copy(
                            locations = result.data ?: emptyList(),
                            isLoading = false,
                            showPreview = showPrevious,
                            showNext = showNext
                        )
                    }
                    is Result.Error ->{
                        state=state.copy(
                            isLoading = false
                        )
                        _eventFlow.emit(
                            UiEvent.ShowSnackBar(
                            result.message ?:"Unknown error"
                        ))
                    }
                    is Result.Loading ->{
                        state=state.copy(
                            isLoading = true
                        )
                    }
                }
            }.launchIn(this)
        }
    }

}