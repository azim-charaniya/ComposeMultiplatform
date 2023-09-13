package one.azim.todo.shared.expected

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import one.azim.todo.shared.Ui.postUi
import one.azim.todo.shared.http.Posts

@Preview
@Composable
fun postUIPreview() {
    MaterialTheme {
        postUi(Posts(
            1,1,"Title","Body"
        ))
    }
}
