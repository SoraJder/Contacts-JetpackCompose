package com.example.contacts.presentation.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.contacts.ui.theme.PostColor

@Composable
fun PostItem(
    titleText:String,
    bodyText:String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(PostColor)
            .clickable { }
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = titleText,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = bodyText,
            color = Color.Gray,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Divider(thickness = 1.dp, color = Color.White)
    }
}