package com.D121211081.Disney.ui.activities.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.D121211081.Disney.data.models.Disney
import com.D121211081.Disney.ui.theme.DisneyTheme

class DetailActivity : ComponentActivity() {
    private var selectedDisney: Disney? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selectedDisney = intent.getParcelableExtra("DISNEY")
        setContent {
            DisneyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DetailScreen()
                }
            }
        }
    }


    @Composable
    fun DetailScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Disney Image (Portrait)
//            AsyncImage(
//                model = ImageRequest.Builder(context = LocalContext.current)
//                    .data("https://static.wikia.nocookie.net/disney/images" + selectedDisney?.imageUrl)
//                    .crossfade(true)
//                    .build(), contentDescription = selectedDisney?.films?.toString(),
//                modifier = Modifier
//                    .width(400.dp)
//                    .height(600.dp)
//                    .clip(MaterialTheme.shapes.medium),
//                contentScale = ContentScale.Crop
//            )

//      Pokemon Details
//      Name
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = selectedDisney?.name.toString(),
                style = MaterialTheme.typography.displayMedium,
                fontWeight = FontWeight.Bold
            )
////      Abilities
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = selectedDisney?.createdAt.toString(),
                style = MaterialTheme.typography.bodyMedium
            )
//
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = selectedDisney?.allies.toString(),
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = selectedDisney?.url.toString(),
                style = MaterialTheme.typography.bodyMedium
            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(
//                text = selectedDisney?.name.toString(),
//                style = MaterialTheme.typography.headlineSmall,
//                fontWeight = FontWeight.Bold
//            )
//            Spacer(modifier = Modifier.height(4.dp))
//            Text(
//                text = selectedDisney?.createdAt.toString(),
//                style = MaterialTheme.typography.bodySmall
//            )
        }
    }
}