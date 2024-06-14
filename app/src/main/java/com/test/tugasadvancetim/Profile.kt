package com.test.tugasadvancetim

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.test.tugasadvancetim.data.sqlite.DatabaseHelper
import com.test.tugasadvancetim.domain.model.Team

@Composable
fun profileScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
){
    val databaseHelper = DatabaseHelper(context)
    val team = databaseHelper.readData()

    var isDialogShown by remember { mutableStateOf(false) }
    var isDetailShown by remember { mutableStateOf(false) }
    var id by remember { mutableIntStateOf(0) }
    var name by remember { mutableStateOf("") }
    var role by remember { mutableStateOf("") }
    var latitude by remember { mutableStateOf("") }
    var longitude by remember { mutableStateOf("") }

    if (isDialogShown) {
        DialogAddTeam(
            onDismiss = { isDialogShown = false },
            name = name,
            onNameChange = { name = it },
            role = role,
            onRoleChange = { role = it },
            latitude = latitude,
            onLatitudeChange = { latitude = it },
            longitude = longitude,
            onLongitudeChange = { longitude = it },
            onUploadClick = {
                if (name.isNotBlank() || role.isNotBlank() || latitude.isNotBlank() || longitude.isNotBlank()) {
                    databaseHelper.insertData(name, role, latitude, longitude)
                    isDialogShown = false
                    name = ""
                    role = ""
                    latitude = ""
                    longitude = ""
                    Toast.makeText(context, "Berhasil Menambah Mentee", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Semua Field wajib diisi", Toast.LENGTH_SHORT).show()
                }
            }
        )
    }

    if (isDetailShown) {
        DialogUpdateMentee(
            id = id,
            onDismiss = { isDetailShown = false },
            team = databaseHelper.readData().filter { team ->
                team.id == id
            },
            databaseHelper = databaseHelper
        )
    }

    Profile(
        navController = navController,
        name = name,
        Tims = team,
        onInsertClick = {
            isDialogShown = true
        },
        modifier = modifier,
        showDetail = { Id, isShown ->
            id = Id
            isDetailShown = isShown
        }
    )

}
@Composable
fun Profile(
    name: String,
    navController: NavController,
    Tims: List<Team>,
    onInsertClick: () -> Unit,
    showDetail: (Int, Boolean) -> Unit,
    modifier: Modifier = Modifier,
){

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onInsertClick) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Icon")
            }
        }
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier.padding(it)
        ) {
            items(Tims, key = { it.id }) {
                Item(
                    Team = it,
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) { Id ->
                    showDetail(Id, true)
                }
            }
        }
    }
}
