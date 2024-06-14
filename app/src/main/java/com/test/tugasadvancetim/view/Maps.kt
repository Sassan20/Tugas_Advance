package com.test.tugasadvancetim.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@Composable
fun MapsScreen() {
    val lokasi = LatLng(-7.607555275157032, 110.203708658232)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(lokasi, 17f)
    }

    val properties = MapProperties(mapType = MapType.HYBRID)
    val uiSettings = remember { mutableStateOf(MapUiSettings(zoomControlsEnabled = true)) }

    Box(modifier = Modifier.fillMaxSize()) {
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
}

@Preview(showBackground = true)
@Composable
private fun MapsPrev() {
    MapsScreen()
}