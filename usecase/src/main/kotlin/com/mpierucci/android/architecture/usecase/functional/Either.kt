package com.mpierucci.android.architecture.usecase.functional

/**
 * Copyright (C) 2019 Marco Pierucci Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/**
 * Represents a value of one of two possible types (a disjoint union).
 * Instances of [Either] are either an instance of [Left] or [Right].
 * FP Convention dictates that [Left] is used for "failure"
 * and [Right] is used for "success".
 *
 * See <a href="https://fernandocejas.com/2018/05/07/architecting-android-reloaded">Credits to Fernando Cejas.</a>
 */

//TODO candidate to be replaced by arrow
sealed class Either<out L, out R> {
    data class Left<L>(val left: L) : Either<L, Nothing>()
    data class Right<R>(val right: R) : Either<Nothing, R>()


    /**
     * Applies `ifLeft` if this is a [Left] or `ifRight` if this is a [Right].
     *
     * @param ifLeft the function to apply if this is a [Left]
     * @param ifRight the function to apply if this is a [Right]
     * @return the results of applying the function
     */

    inline fun fold(ifLeft: (L) -> Any, ifRight: (R) -> Any): Any {
        return when (this) {
            is Left -> ifLeft(left)
            is Right -> ifRight(right)
        }
    }
}

/**
 * Right-biased flatMap() FP convention which means that Right is assumed to be the default case
 * to operate on. If it is Left, operations like map, flatMap, ... return the Left value unchanged.
 */
fun <T, L, R> Either<L, R>.flatMap(fn: (R) -> Either<L, T>): Either<L, T> {
    return when (this) {
        is Either.Left -> Either.Left(left)
        is Either.Right -> fn(right)
    }
}

/**
 * Right-biased map() FP convention which means that Right is assumed to be the default case
 * to operate on. If it is Left, operations like map, flatMap, ... return the Left value unchanged.
 */
fun <T, L, R> Either<L, R>.map(fn: (R) -> (T)): Either<L, T> = flatMap { Either.Right(fn(it)) }

