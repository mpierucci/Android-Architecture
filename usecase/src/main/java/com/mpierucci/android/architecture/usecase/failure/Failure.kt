package com.mpierucci.android.architecture.usecase.failure

sealed class Failure {

    data class Api(val message: String) : Failure()
    object NetworkConnection : Failure()
    object ServerError : Failure()
    object Unknown : Failure()

    abstract class FeatureFailure(val message: String) : Failure()
}