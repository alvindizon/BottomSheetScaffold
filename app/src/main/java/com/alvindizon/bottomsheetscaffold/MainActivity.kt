package com.alvindizon.bottomsheetscaffold

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alvindizon.bottomsheetscaffold.ui.theme.BottomSheetScaffoldTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomSheetScaffoldTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = rememberStandardBottomSheetState(skipHiddenState = false))
                    val scope = rememberCoroutineScope()
                    BottomSheetScaffold(
                        sheetContainerColor = Color.Gray,
                        sheetContent = {
                        Box(modifier = Modifier.fillMaxSize()) {
                            Text("Sheet Content")
                        }
                    }) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(it),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Button(onClick = { scope.launch{ bottomSheetScaffoldState.bottomSheetState.expand() } }) {
                                Text("Expand")
                            }
                            Box(modifier = Modifier.fillMaxSize()) {
                                Text("Main Content")
                            }
                        }
                    }
                }
            }
        }
    }
}
