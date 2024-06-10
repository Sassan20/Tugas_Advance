package com.test.tugasadvancetim

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.test.tugasadvancetim.data.DummyData
import com.test.tugasadvancetim.data.model

@Composable
fun DetailtimScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    timId: Int?
) {
    val newtimList = DummyData.tim.filter { Tim ->
        Tim.id == timId
    }
    Column(
        modifier = modifier
    ) {
        DetailberitaContent(
            onBackClick = {navController.navigateUp()},
            newTimList = newtimList)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DetailberitaContent(
    newTimList: List<model>,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Berita"
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Arrow Back"
                        )
                    }
                }
            )
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(it)
                .padding(16.dp)
        ) {
//            AsyncImage(
//                model = ImageRequest.Builder(LocalContext.current)
//                    .data(data = newBeritasList[0].photo)
//                    .build(),
//                contentScale = ContentScale.Crop,
//                modifier = Modifier
//                    .size(height = 250.dp, width = 500.dp)
//                    .clip(RoundedCornerShape(16.dp)),
//                contentDescription = "Poster Movie"
//            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.padding(4.dp)) {
                Text(
                    text = newTimList[0].name,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${newTimList[0].role}",
                    style = MaterialTheme.typography.titleSmall,
                )
            }
        }
    }
}