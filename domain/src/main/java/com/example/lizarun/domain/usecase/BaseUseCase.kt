package com.example.lizarun.domain.usecase

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class BaseUseCase<T : Any> {
    private val disposables = CompositeDisposable()

    fun dispose() {
        disposables.clear()
    }

    fun getRxJavaResult(
        singleResult: Single<T>,
        onSuccess: (T) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        disposables.addAll(singleResult.subscribe(onSuccess, onError))
    }

    fun getRxJavaResult(
        completableResult: Completable,
        onComplete: () -> Unit,
        onError: (Throwable) -> Unit
    ) {
        disposables.addAll(completableResult.subscribe(onComplete, onError))
    }
}