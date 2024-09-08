package com.example.fitnessworkoutexercisesfree.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowRightAlt
import androidx.compose.material.icons.rounded.ExpandMore
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitnessworkoutexercisesfree.ui.theme.Dark
import com.example.fitnessworkoutexercisesfree.ui.theme.oswaldFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryDropDown(
    items: List<String>,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    onDismissRequest: () -> Unit,
    selectedValue: String,
    onSelectItem: (String) -> Unit
) {
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = onExpandedChange,
        modifier = Modifier
            .padding(top = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .menuAnchor(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = selectedValue.capitalize(Locale.current),
                style = MaterialTheme.typography.headlineLarge,
                fontFamily = oswaldFontFamily,
                fontSize = 42.sp,
                maxLines = 2,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .padding(end = 16.dp)
                    .widthIn(180.dp, 220.dp),
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Rounded.ArrowRightAlt,
                    contentDescription = "right arrow",
                    modifier = Modifier.size(24.dp),
                    tint = MaterialTheme.colorScheme.onSurface,
                )
            }
        }


        MaterialTheme(
            shapes = MaterialTheme.shapes.copy(
                extraSmall = RoundedCornerShape(16.dp),
                medium = RoundedCornerShape(16.dp),
                large = RoundedCornerShape(16.dp),
                extraLarge = RoundedCornerShape(16.dp)
            )
        ) {
            ExposedDropdownMenu(
                modifier = Modifier
                    .background(Dark.Background),
                expanded = expanded,
                onDismissRequest = onDismissRequest
            ) {
                items.forEach { item: String ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = item.capitalize(Locale.current),
                                modifier = Modifier.fillMaxWidth(),
                                fontFamily = oswaldFontFamily,
                                fontWeight = FontWeight.Normal,
                                fontStyle = FontStyle.Italic,
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center
                            )
                        },
                        onClick = { onSelectItem.invoke(item) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Dark.Background)
                    )
                }
            }
        }
    }
}