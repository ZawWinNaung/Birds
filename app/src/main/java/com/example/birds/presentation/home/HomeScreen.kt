package com.example.birds.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.birds.presentation.components.CategoryDropDown
import com.example.birds.presentation.components.ErrorScreen
import com.example.birds.ui.theme.Dark
import com.example.birds.ui.theme.oswaldFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(level: String, viewModel: HomeViewModel = hiltViewModel()) {

    val lazyListState = rememberLazyListState()

    val categories = viewModel.categories.collectAsState()

    val onError = viewModel.onError.collectAsState()

    val onLoading = viewModel.onLoading.collectAsState()

    var dropDownState by remember { mutableStateOf(false) }

    var selectedCategory by remember { mutableStateOf("") }

    LaunchedEffect(key1 = true) {
        viewModel.getRecentObservations("TH")
    }

    LaunchedEffect(categories.value) {
        if (categories.value.isNotEmpty()) {
            selectedCategory = categories.value[0]
        }
    }

//    LaunchedEffect(selectedCategory) {
//        viewModel.getExercisesByCategory(selectedCategory)
//    }

    Scaffold(containerColor = Dark.Background) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            if (onLoading.value) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .width(64.dp)
                            .align(alignment = Alignment.CenterHorizontally),
                        color = MaterialTheme.colorScheme.secondary,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant,
                    )
                }
            }
            if (categories.value.isNotEmpty()) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Level : ${level.capitalize(Locale.current)}",
                        fontFamily = oswaldFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        fontStyle = FontStyle.Italic,
                        color = Dark.TextColor,
                        modifier = Modifier.padding(top = 32.dp)
                    )
                    CategoryDropDown(
                        items = categories.value,
                        expanded = dropDownState,
                        onExpandedChange = { dropDownState = !dropDownState },
                        onDismissRequest = { dropDownState = false },
                        selectedValue = selectedCategory,
                        onSelectItem = { selectedItem ->
                            dropDownState = false
                            selectedCategory = selectedItem
                        }
                    )
                }

            }
            onError.value?.let {
                ErrorScreen(error = it)
            }
        }
    }


}