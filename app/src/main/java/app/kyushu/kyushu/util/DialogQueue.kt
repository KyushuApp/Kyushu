package app.kyushu.kyushu.util

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import app.kyushu.kyushu.presentation.components.GenericDialogInfo
import app.kyushu.kyushu.presentation.components.PositiveAction
import java.util.ArrayDeque
import java.util.LinkedList
import java.util.Queue

class DialogQueue {
    val queue: MutableState<Queue<GenericDialogInfo>> = mutableStateOf(
        LinkedList()
    )

    fun removeHeadMessage() {
        if (queue.value.isNotEmpty()) {
            val update = queue.value
            update.remove() // remove first (oldest message)
            queue.value = ArrayDeque() // force recompose (bug?)
            queue.value = update
        }
    }

    fun appendErrorMessage(title: String, description: String) {
        queue.value.offer(
            GenericDialogInfo.Builder()
                .title(title)
                .onDismiss(this::removeHeadMessage)
                .description(description)
                .positive(
                    PositiveAction(
                        positiveBtnTxt = "Ok",
                        onPositiveAction = this::removeHeadMessage,
                    )
                )
                .build()
        )
    }
}