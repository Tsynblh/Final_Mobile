package com.D121211081.Disney.ui.activities.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.D121211081.Disney.ui.activities.detail.DetailActivity
import com.D121211081.Disney.data.models.Disney
import com.D121211081.Disney.ui.theme.DisneyTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisneyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFFFF7D4)
                ) {
                    Column {
                        CenterAlignedTopAppBar(
                            modifier = Modifier.background(Color.Blue),  // Change background color here
                            title = {
                                Text(
                                    text = "Disney Character",
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 30.sp
                                )
                            }
                        )
                        val mainViewModel: MainViewModel = viewModel(factory = MainViewModel.Factory)
                        ListDisneyScreen(mainViewModel.mainUiState)
                    }

                }
            }
        }
    }

    @Composable
    private fun ListDisneyScreen(mainUiState: MainUiState, modifier: Modifier = Modifier) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            when (mainUiState) {
                is MainUiState.Loading -> Text(text = "Sedang Loading", fontSize = 30.sp)
                is MainUiState.Error -> Text(text = "Terjadi Error", fontSize = 30.sp)
                is MainUiState.Success -> DisneyList(mainUiState.disney)
            }
        }
    }

    @Composable
    fun DisneyList(disney: List<Disney>, modifier: Modifier = Modifier) {
        LazyColumn(modifier = modifier) {
            items(disney) { disney ->
                DisneyCard(disney = disney)
            }
        }
    }

    @Composable
    fun DisneyCard(disney: Disney) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .border(3.dp, Color.White, RoundedCornerShape(8.dp),)
                .clickable {
                    val intent = Intent(this, DetailActivity::class.java)
                    intent.putExtra("DISNEY", disney)
                    startActivity(intent)
                }
                .background(color = Color(0xFF9BB8CD))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                //
//                AsyncImage(
//                    model = ImageRequest.Builder(context = LocalContext.current)
//                        .data("https://image.tmdb.org/t/p/original" + Disney.imageUrl)
//                        .crossfade(true)
//                        .build(), contentDescription = Disney.name,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(200.dp)
//                        .clip(MaterialTheme.shapes.medium),
//                    contentScale = ContentScale.Crop
//                )

                // Pokemon Details
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = disney.name.toString(),
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = disney.createdAt.toString(),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

