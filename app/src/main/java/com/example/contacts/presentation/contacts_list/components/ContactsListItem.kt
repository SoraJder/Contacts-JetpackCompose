package com.example.contacts.presentation.contacts_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.contacts.common.Utils
import com.example.contacts.model.Contact
import com.example.contacts.ui.theme.ImageLogoColor

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ContactListItem(
    contact: Contact
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 16.dp)
            .clickable { },
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (contact.id % 2 != 0) {
            GlideImage(
                model = "https://picsum.photos/200/200",
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .width(50.dp)
                    .height(50.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
            )
        } else {
            Spacer(modifier = Modifier.width(16.dp))
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(
                        color = ImageLogoColor,
                        shape = CircleShape
                    )
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = Utils.provideInitials(contact.name),
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = contact.name,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .weight(1f)
        )
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = null,
            tint = ImageLogoColor,
            modifier = Modifier
                .padding(end = 16.dp)
        )
    }
}