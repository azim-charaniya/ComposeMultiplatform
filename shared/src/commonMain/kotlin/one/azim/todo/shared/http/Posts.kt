package one.azim.todo.shared.http

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.serialization.Serializable

/*
* Some side effect function that allows to read some data from network
* */
suspend fun getPosts(): String {
    val response: HttpResponse = client.get(HttpConstants.POSTS_URL)
    return response.body<List<Posts>>().firstOrNull().toString()
}

@Serializable
data class Posts(val userId: Int, val id: Int, val title: String,val body: String)

fun getAllPosts(): Flow<List<Posts>> = flow {
    emit(client.get(HttpConstants.POSTS_URL).body())
}

fun getPostOnIOThread(): Flow<List<Posts>>  = getAllPosts().flowOn(Dispatchers.IO)