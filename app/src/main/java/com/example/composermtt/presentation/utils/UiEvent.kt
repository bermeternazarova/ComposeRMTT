package com.example.composermtt.presentation.utils

sealed class UiEvent {
    data class ShowSnackBar(
        val message:String
    ): UiEvent()
}