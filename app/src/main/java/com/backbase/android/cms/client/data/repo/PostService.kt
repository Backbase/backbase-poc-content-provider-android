package com.backbase.android.cms.client.data.repo

import com.backbase.android.cms.client.data.dto.PostResponse
import retrofit2.Response
import retrofit2.http.GET
interface PostService {
    @GET("/jsonapi/node/post/?include=field_image_url")
    suspend fun fetchListOfPosts(): Response<PostResponse>
}