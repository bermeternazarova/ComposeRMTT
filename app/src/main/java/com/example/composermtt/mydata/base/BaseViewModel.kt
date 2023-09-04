package com.example.composermtt.mydata.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    //Надо докончить, не рабочая версия

//    private var _currentPage: Int = 0
//    protected open val currentPage = _currentPage
//    private var _showPrevious = _currentPage > 1
//    var showPrevious = _showPrevious
//    private var _showNext = _currentPage < 40
//    var showNext = _showNext

//    private fun getAll(
//        increase: Boolean
//    ) {
//        viewModelScope.launch {
//            if (increase) {
//                _currentPage++
//            } else if (_currentPage > 1) {
//                _currentPage--
//            }
//            useCase()
//        }
//
//
//    }

  //  protected open suspend fun useCase() {}
}