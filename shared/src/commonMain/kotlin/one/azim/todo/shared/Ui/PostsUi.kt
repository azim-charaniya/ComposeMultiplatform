package one.azim.todo.shared.Ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import one.azim.todo.shared.http.Posts

@Composable
fun postUi(posts: Posts, modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(8.dp).fillMaxWidth()) {
        Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Text(
                posts.title,
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                posts.body,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(vertical = 4.dp).fillMaxWidth()
            )
        }
    }
}