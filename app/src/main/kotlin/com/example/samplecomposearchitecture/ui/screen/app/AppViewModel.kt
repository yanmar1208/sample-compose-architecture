package com.example.samplecomposearchitecture.ui.screen.app

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppViewModel
    @Inject
    constructor() : ViewModel()
