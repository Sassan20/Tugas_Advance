package com.test.tugasadvancetim

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.tugasadvancetim.data.model
import com.test.tugasadvancetim.domain.model.Team
import com.test.tugasadvancetim.ui.theme.TugasAdvanceTimTheme

@Composable
fun Item (
    Team: Team,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onItemClicked(Team.id)
            }
    ) {
//        Image(
//            painter = painterResource(id = berita2.photo),
//            contentDescription = berita2.judul,
//            contentScale = ContentScale.Crop,
//        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = Team.name, style = MaterialTheme.typography.titleMedium)
            Row {
                Text(text = "Role :")
                Text(text = Team.role, color = MaterialTheme.colorScheme.primary)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Prev() {
    TugasAdvanceTimTheme {
        Item(
            Team = Team(
                1,
                "Muhammad Fadil",
                "Hecker",
                "3.535317089063918",
                "98.6628990959129",
            ),
            onItemClicked = { timId ->
                println("Berita : $timId")
            }
        )
    }
}