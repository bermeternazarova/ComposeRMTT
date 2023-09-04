package com.example.composermtt.presentation.screens.episode

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composermtt.domain.model.EpisodeDmn

@Composable
fun EpisodeItem(
    item: EpisodeDmn,
    modifier: Modifier=Modifier,
    onItemClick :(Int)->Unit
) {
    Row(
        modifier= modifier
            .clickable {
                onItemClick(item.id)
            }
            .padding(start = 6.dp, top = 12.dp, bottom = 12.dp)
    ) {
        Spacer(Modifier.width(20.dp))
        Column(
            modifier= Modifier
                .fillMaxWidth()
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = item.episode,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = item.air_date,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = item.created,
                style = MaterialTheme.typography.titleMedium
            )

        }
    }
}

