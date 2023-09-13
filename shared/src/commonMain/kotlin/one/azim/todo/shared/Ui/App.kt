@file:OptIn(ExperimentalFoundationApi::class)

package one.azim.todo.shared.Ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.collectLatest
import one.azim.todo.shared.expected.getPlatformName
import one.azim.todo.shared.http.Posts
import one.azim.todo.shared.http.getPostOnIOThread
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    MaterialTheme {
        var greetingText by remember { mutableStateOf("Hello, World!") }
        var showImage by remember { mutableStateOf(false) }
        var bodyText by remember { mutableStateOf("") }
        var posts by remember { mutableStateOf<List<Posts>>(listOf()) }

        LaunchedEffect(Unit) {
            getPostOnIOThread().collectLatest {
                    posts = it
                    bodyText = "Received"
                }
        }

        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                greetingText = "Hello, ${getPlatformName()}"
                showImage = !showImage

            }) {
                Text(greetingText)
            }
            TextField(greetingText, onValueChange = { greetingText = it })
            AnimatedVisibility(showImage) {
                Image(
                    painterResource("compose-multiplatform.xml"), null
                )
            }
            AnimatedVisibility(!showImage) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    stickyHeader {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text("Items from server")
                        }
                    }
                    items(posts.size) {
                        postUi(posts[it], Modifier.animateItemPlacement())
                    }
                }
            }
        }
    }
}


/**
 * TODO: Implement simple MVVM Architecture
 * TODO: Implement DI
 * TODO: Implement Clean Code
 * TODO: Implement caching layer
 * TODO: Add Test cases for Code
 * TODO: Add Test case for UI
 * TODO: Add simple Navigation
 * TODO: Add simple Deep Link
 * */