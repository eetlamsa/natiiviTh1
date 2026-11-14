package com.example.viikkotehtv1

import android.R.attr.textStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.viikkotehtv1.R.string.your_heart_rate_limits_are
import com.example.viikkotehtv1.ui.theme.Viikkotehtävä1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Viikkotehtävä1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HeartRateLimits(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun HeartRateLimits(modifier: Modifier = Modifier) {

    var ageInput by remember { mutableStateOf("") }

    val age = ageInput.toIntOrNull() ?: 0

    val upper = (220 - age) * 0.85f
    val lower = (220 - age) * 0.65f

    Column(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        TextField(
            value = ageInput,
            onValueChange = { ageInput = it },
            label = { Text(text = "Age") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = stringResource(
                R.string.your_heart_rate_limits_are,
                upper,
                lower
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun HeartRateLimitsPreview() {
    Viikkotehtävä1Theme {
        HeartRateLimits ()
    }
}