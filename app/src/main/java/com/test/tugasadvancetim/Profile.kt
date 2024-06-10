package com.test.tugasadvancetim

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.test.tugasadvancetim.data.DummyData
import com.test.tugasadvancetim.data.model
import com.test.tugasadvancetim.navigation.Screen

@Composable
fun Profile(
    navController: NavController,
    modifier: Modifier = Modifier,
    modell: List<model> = DummyData.tim,
){
    Scaffold(
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier.padding(it)
        ) {
            items(modell, key = { it.id }) {
                Item(model = it, modifier = Modifier.padding(horizontal = 16.dp)) { id ->
                    navController.navigate(Screen.Detail.route + "/$id")
                }
            }
        }
    }
}
