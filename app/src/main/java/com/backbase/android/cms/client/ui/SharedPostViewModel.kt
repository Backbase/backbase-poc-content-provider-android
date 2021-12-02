package com.backbase.android.cms.client.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.backbase.android.cms.client.R
import com.backbase.android.cms.client.data.dto.Data
import com.backbase.android.cms.client.data.dto.Included
import com.backbase.android.cms.client.data.repo.PostService
import com.backbase.android.cms.client.domain.model.Post
import kotlinx.coroutines.launch

/**
 * This a SharedViewModel that acts as mediator between the ui and repository
 */
class SharedPostViewModel constructor(private val service: PostService) : ViewModel() {


    val listOfPosts = MutableLiveData<Result<List<Post>>>()

    init {
        fetchContent()
    }

    fun fetchContent() {
        viewModelScope.launch {
            try {
                publishLoading()
                val postResponse = service.fetchListOfPosts()
                if (postResponse.isSuccessful) {
                    val body = postResponse.body()!!
                    val listOfPost = convertToListOfPost(body.data, body.included)
                    publishResult(listOfPost)
                } else {
                    publishError()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                publishError()
            }

        }


    }

    private fun convertToListOfPost(data: List<Data>, included: List<Included>): List<Post> {
        val listOfPost = mutableListOf<Post>()
        for (index: Int in data.indices) {
            listOfPost.add(
                Post(
                    data[index].attributes.title,
                    data[index].attributes.field_description,
                    included[index].attributes.uri.url
                )
            )
        }
        return listOfPost
    }


    private fun publishResult(listOfPost: List<Post>) {
        listOfPosts.postValue(Result.success(listOfPost))
    }

    private fun publishLoading() {
        listOfPosts.postValue(Result.loading())
    }

    private fun publishError() {
        listOfPosts.postValue(Result.error(R.string.connection_error))
    }


}