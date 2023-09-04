package com.example.composermtt.presentation.screens.character

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.composermtt.domain.usecase.character.CharactersUseCase
import com.example.composermtt.mydata.utils.Result
import com.example.composermtt.mydata.base.BaseViewModel
import com.example.composermtt.presentation.state.CharactersState
import com.example.composermtt.presentation.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val charactersUseCase: CharactersUseCase
) : BaseViewModel() {

    var state by mutableStateOf(CharactersState(isLoading = true))
        private set

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var currentPage = 1

    init {
        getCharacters(increase = false)
    }

    fun getCharacters(increase: Boolean) {
        viewModelScope.launch {
            if (increase){
                currentPage ++
            }
            else if (currentPage>1){
                currentPage --
            }

            val showPrevious = currentPage>1
            val showNext = currentPage<40

            charactersUseCase(currentPage).onEach { result ->
                when(result){
                    is Result.Success ->{
                        state=state.copy(
                            characters = result.data ?: emptyList(),
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