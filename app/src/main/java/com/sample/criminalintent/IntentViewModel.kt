package com.sample.criminalintent

import androidx.lifecycle.ViewModel

class IntentViewModel (
    getIntentsFromDbUseCase: GetIntentsFromDbUseCase,
    saveIntentsToDbUseCase: SaveIntentsToDbUseCase,
    removeIntentsFromDbUseCase: RemoveIntentsFromDbUseCase,
): ViewModel() {

}