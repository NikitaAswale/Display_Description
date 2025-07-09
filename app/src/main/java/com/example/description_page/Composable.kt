package com.example.description_page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Display(){

    val viewModel: DescriptionViewModel = viewModel()
    val description1  by viewModel.description.collectAsState()

    var content by remember{ mutableStateOf("") }
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        OutlinedTextField(value = content, onValueChange = {content = it},
            label = { Text("Enter task description") })

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Button(onClick = {
            viewModel.addDescription(content)
        }) {
            Text("Enter The Task")
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text("Your Tasks",
            modifier = Modifier,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold)

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Text(
                "1. Do Yoga at 7 am" +"\n"+
                "2. Go to School at 9 am," +"\n"+
                "3.Remember to cook good meal" +"\n"+
                "4. Make a good time with friends")
    }
}
