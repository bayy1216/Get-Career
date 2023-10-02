package com.reditus.getcareer.presentation.view.career

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.reditus.getcareer.presentation.component.career.CareerItem
import com.reditus.getcareer.presentation.viewmodel.career.CareerViewModel

@Composable
fun CareerScreen(viewModel: CareerViewModel, modifier: Modifier) {
    val state = viewModel.careerList
    Column(modifier = modifier.then(Modifier.fillMaxHeight())) {
        state.forEach{
            CareerItem(content = it.title, date = it.date)
        }
    }
}