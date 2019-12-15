package com.mpierucci.android.architecture.usecase

import com.mpierucci.android.architecture.usecase.failure.Failure
import com.mpierucci.android.architecture.usecase.functional.Either


//TODO add interfaces for Flowable UseCase

interface UseCase<in PARAMS, out RESULT> {

    suspend fun execute(params: PARAMS): Either<Failure, RESULT>
}