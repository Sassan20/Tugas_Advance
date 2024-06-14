package com.test.tugasadvancetim.view.main

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.test.tugasadvancetim.data.local.entity.TeamEntity
import com.test.tugasadvancetim.utils.ViewModelFactory
import com.test.tugasadvancetim.view.main.component.TopAppBarTeam
import java.time.Instant

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamScreen(
    id: Int,
    navController: NavController,
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current
) {
    val teamViewModel: TeamViewModel =
        viewModel(factory = ViewModelFactory.getInstance(context = context))
    val state by teamViewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(id) {
        teamViewModel.onEvent(TeamEvent.OnGetTeamById(id))
    }

    TeamContent(
        isTaskExist = state.TeamId != null,
        onBackClick = { navController.navigateUp() },
        onDeleteClick = {
            state.TeamId?.let { teamViewModel.deleteTeam(it) }
            navController.navigateUp()
        },
        name = state.name,
        onNameChange = { teamViewModel.onEvent(TeamEvent.OnNameChange(it)) },
        role = state.role,
        onRoleChange = { teamViewModel.onEvent(TeamEvent.OnRoleChange(it)) },
        onSaveClick = {
            val team = TeamEntity(
                id = state.TeamId,
                name = state.name,
                role = state.role,
                latitude = state.latitude,
                longitude = state.longitude
            )

            if (state.name.isNotEmpty() && state.role.isNotEmpty()  && state.latitude.isNotEmpty() && state.longitude.isNotEmpty()) {
                teamViewModel.saveTeam(team)
                navController.navigateUp()
            } else
                Toast.makeText(context, "All fields are required", Toast.LENGTH_SHORT).show()
        },
        latitude = state.latitude,
        onLatitudeChange = { teamViewModel.onEvent(TeamEvent.OnLatitudeChange(it)) },
        longitude = state.longitude,
        onLongitudeChange = { teamViewModel.onEvent(TeamEvent.OnLongitudeChange(it)) },
        modifier = modifier
    )
}

@Composable
fun TeamContent(
    isTaskExist: Boolean,
    onBackClick: () -> Unit,
    onDeleteClick: () -> Unit,
    name: String,
    onNameChange: (String) -> Unit,
    role: String,
    onRoleChange: (String) -> Unit,
    onSaveClick: () -> Unit,
    latitude: String,
    onLatitudeChange: (String) -> Unit,
    longitude: String,
    onLongitudeChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBarTeam(
                isTaskExist = isTaskExist,
                onBackButtonClick = onBackClick,
                onDeleteButtonClick = onDeleteClick
            )
        },
        modifier = modifier
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(state = rememberScrollState())
                .fillMaxSize()
                .padding(contentPadding)
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = onNameChange,
                label = { Text(text = "name") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = role,
                onValueChange = onRoleChange,
                label = { Text(text = "Role") },
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = latitude,
                onValueChange = onLatitudeChange,
                label = { Text(text = "Latitude") },
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = longitude,
                onValueChange = onLongitudeChange,
                label = { Text(text = "Longitude") },
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = onSaveClick,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(text = "Save", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}