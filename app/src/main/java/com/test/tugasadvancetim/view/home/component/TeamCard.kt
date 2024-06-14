package com.test.tugasadvancetim.view.home.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamCard(
    name: String,
    role: String,
    onItemTaskClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onItemTaskClicked,
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.titleMedium,
                modifier = modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = role,
                style = MaterialTheme.typography.bodyMedium,
                modifier = modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Box(modifier = Modifier.fillMaxSize()
                .height(200.dp)) {
                MapsScreen()
            }
        }
    }
}

@Composable
fun MapsScreen() {
    val lokasi = LatLng(1.1187356561737642, 104.04845189126856)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(lokasi, 15f)
    }

    val properties = MapProperties(mapType = MapType.HYBRID)
    val uiSettings = remember { mutableStateOf(MapUiSettings(zoomControlsEnabled = true)) }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        properties = properties,
        uiSettings = uiSettings.value
    ) {
        Marker(
            state = MarkerState(position = lokasi),
            title = "Lokasi Saya"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TeamCardPrev() {
    TeamCard(
        name = "John Doe",
        role = "Software Engineer",
        onItemTaskClicked = { /* TODO: Add action here */ }
    )
}
