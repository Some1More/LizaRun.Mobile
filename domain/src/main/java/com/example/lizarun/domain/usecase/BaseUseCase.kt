package com.example.lizarun.domain.usecase

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable

interface BaseUseCase<T : Any> {
    private val disposables: CompositeDisposable
        get() = CompositeDisposable()

    fun dispose() {
        disposables.clear()
    }

    fun Single<T>.executeUseCase(
        onSuccess: (T) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        disposables.addAll(subscribe(onSuccess, onError))
    }

    fun Completable.executeUseCase(
        onComplete: () -> Unit,
        onError: (Throwable) -> Unit
    ) {
        disposables.addAll(subscribe(onComplete, onError))
    }
}