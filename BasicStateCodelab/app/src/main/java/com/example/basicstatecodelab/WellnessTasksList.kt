package com.example.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.basicstatecodelab.ui.theme.BasicStateCodelabTheme

@Composable
fun WellnessTaskList(
    list: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
) {
    LazyColumn(
        modifier = modifier,
//        state = rememberLazyListState()
    ) {
        items(
            list,
            key = { task -> task.id }
        ) { task ->
            WellnessTaskItem(
                taskName = task.label,
                onClose = { onCloseTask(task) },
                checked = task.checked,
                onCheckChange = { checked -> onCheckedTask(task, checked) }
            )
        }
    }
}

@Composable
@Preview(showBackground = false)
fun WellnessTaskListPreview() {
    BasicStateCodelabTheme {
        WellnessTaskList(
            mutableListOf(),
            {},
            onCheckedTask = { _, _ -> {} })
    }
}