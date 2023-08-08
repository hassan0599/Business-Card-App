package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard( )
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Avatar(
            profilePainter = painterResource(R.drawable.walter_white),
            specialtyPainter = painterResource(R.drawable.android)
        )
        TitleCard(
            name = stringResource(R.string.name),
            title = stringResource(R.string.title)
        )
        DescriptionCard(
            email = stringResource(R.string.email),
            phone = stringResource(R.string.phone),
            im = stringResource(R.string.im),
            location = stringResource(R.string.location),
        )
    }
}

@Composable
private fun Avatar(
    profilePainter: Painter,
    specialtyPainter: Painter,
    modifier: Modifier = Modifier
) {
    Box {
        Image(
            painter = profilePainter,
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .border(4.dp, Color(0xFF03017A), CircleShape)
        )
        Image(
            painter = specialtyPainter,
            contentDescription = null,
            modifier = Modifier.align(Alignment.BottomStart)
        )
    }
}

@Composable
private fun TitleCard(
    name: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(top=30.dp)
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
private fun DescriptionCard(
    email: String,
    phone: String,
    im: String,
    location: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(top=60.dp)
    ) {
        IconWithText(
            imageVector = Icons.Filled.Email,
            text = email
        )
        IconWithText(
            imageVector = Icons.Filled.Phone,
            text = phone
        )
        IconWithText(
            imageVector = Icons.Filled.Share,
            text = im
        )
        IconWithText(
            imageVector = Icons.Default.Place,
            text = location
        )
    }
}

@Composable
private fun IconWithText(
    imageVector: ImageVector,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(top=4.dp, bottom=4.dp)
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            tint=Color(0xFF00810D),
            modifier = Modifier.
            padding(end=5.dp)
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}