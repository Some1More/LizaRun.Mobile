package com.example.lizarun.domain.usecase

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class BaseUseCase<T : Any> {
    private val disposables = CompositeDisposable()

    fun dispose() {
        disposables.clear()
    }

    fun execute(singleCall: Single<T>) {
        disposables.addAll(singleCall.subscribe())
    }

    fun execute(completableCall: Completable) {
        disposables.addAll(completableCall.subscribe())
    }
}