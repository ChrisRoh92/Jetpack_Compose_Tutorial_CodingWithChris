package com.example.compose_components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_components.ui.theme.Compose_ComponentsTheme




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

val exampleList = listOf<String>(
    "Christoph",
    "Leonie",
    "Thomas",
    "Rainer",
    "Christian",
    "Christoph",
    "Leonie",
    "Thomas",
    "Rainer",
    "Christian",
    "Christoph",
    "Leonie",
    "Thomas",
    "Rainer",
    "Christian",
    "Christoph",
    "Leonie",
    "Thomas",
    "Rainer",
    "Christian",
    "Christoph",
    "Leonie",
    "Thomas",
    "Rainer",
    "Christian",
)

@Composable
fun App()
{
    Scaffold(
        topBar = {
            TopAppBar { /* Top app bar content */ }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* ... */ }) {
               Icon(Icons.Filled.Add, contentDescription = "Add")
            }
        }

    ) { contentPadding ->
        // Screen content
        Box {
            Column(modifier = Modifier.padding(contentPadding).verticalScroll(rememberScrollState())){
                StatusCard()
                ListCard(exampleList)
            }
        }

    }

}

@Composable
fun StatusCard()
{
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp),
        elevation = 8.dp
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)) {
            repeat(3){
                Column(modifier =
                Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
                    .weight(1.0f),
                    horizontalAlignment = Alignment.CenterHorizontally


                ) {
                    Text(text = "Hallo")
                    Text(text = "Hallo")
                    Text(text = "Hallo")
                    Text(text = "Hallo")
                    Text(text = "Hallo")
                }
            }


        }

    }
}

@Composable
fun ListCard(messages: List<String>)
{
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp)
        .height(400.dp),
        elevation = 8.dp
    ) {
        LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
            items(messages){ message ->
                ListItem(name = message)

            }
        }
    }
}

@Composable
fun ListItem(name:String)
{
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 4.dp)
        .height(60.dp)
    ) {
        Icon(Icons.Rounded.Favorite,
            contentDescription = "Example",
            modifier = Modifier
                .padding(4.dp)
                .size(32.dp))
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp)
        ) {
            Text(name)
            Text(name)
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Compose_ComponentsTheme {
        App()
    }
}