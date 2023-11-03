package com.reditus.getcareer.presentation.component.career

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.reditus.getcareer.R
import com.reditus.getcareer.data.dto.CareerModel
import com.reditus.getcareer.presentation.theme.GetCareerTheme

object CareerItem

@Composable
fun CareerItem.fromModel(model: CareerModel) {
    BaseCareerItem(
        content = model.title,
        date = model.date,
        contentUrl = model.url
    )
}


@Composable
fun BaseCareerItem(painter: Painter? = null,content: String, date: String, contentUrl: String) {
    val context = LocalContext.current
    val url by remember { mutableStateOf(contentUrl) }

    val launcher: ManagedActivityResultLauncher<Intent, ActivityResult> =
        rememberLauncherForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->

        }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth().padding(10.dp),
    ) {
        painter?.let { 
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .padding(10.dp)
            )
        }

        Text(
            text = content,
            modifier = Modifier.weight(7f).clickable {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                launcher.launch(intent)
            }
        )
        Text(text = date,modifier = Modifier.weight(2f))
    }
}

@Preview
@Composable
fun PreviewCareerItem() {
    GetCareerTheme {
        BaseCareerItem(
            painter = painterResource(id = R.drawable.naver),
            content = "네카라쿠배가즈아",
            date = "2021-09-01",
            contentUrl = "https://www.naver.com"
        )
    }
}