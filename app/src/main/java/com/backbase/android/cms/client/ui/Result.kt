package com.backbase.android.cms.client.ui

/**
 * The Result class help to show the status of the screen
 * for example
 * when the status is LOADING it means there's ongoing request and a loading indicator should be displayed
 * when the status is ERROR it mean the screen should display an error
 * when the status is SUCCESS it means the screen should display the result fetched
 */
data class Result<out T>(val status: Status, val data: T?, val message: Int?) {
    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T): Result<T> {
            return Result(Status.SUCCESS, data, null)
        }

        fun <T> error(message: Int, data: T? = null): Result<T> {
            return Result(Status.ERROR, data, message)
        }

        fun <T> loading(data: T? = null): Result<T> {
            return Result(Status.LOADING, data, null)
        }
    }
}