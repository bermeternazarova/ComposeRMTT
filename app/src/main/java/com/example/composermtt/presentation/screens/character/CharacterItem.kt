package com.example.composermtt.presentation.screens.character

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.composermtt.domain.model.CharactersDmn

@Composable
fun CharacterItem (
    modifier: Modifier=Modifier,
    item :CharactersDmn,
    onItemClick :(Int)->Unit
){
  Row(
      modifier= modifier
          .clickable {
              onItemClick(item.id)
          }
          .padding(start = 6.dp, top = 12.dp, bottom = 12.dp)
  ) {
      CharacterImageContainer(
          modifier=Modifier
              .size(64.dp)
      ){
          CharacterImage(item = item)
      }
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
              text = item.species,
              style = MaterialTheme.typography.titleMedium
          )

      }
  }
  Divider(
      modifier=Modifier
          .padding(top = 10.dp)
  )
}

@Composable
private fun CharacterImageContainer(
    modifier: Modifier,
    click:@Composable () -> Unit
) {
    Surface (
        modifier.aspectRatio(1f),
        RoundedCornerShape(4.dp)
    ){
        click()
    }
}

@Composable
private fun CharacterImage(
    item:CharactersDmn
){
  Box{
      val image = rememberAsyncImagePainter(
       model = ImageRequest.Builder(LocalContext.current)
           .data(item.image)
           .size(Size.ORIGINAL)
           .build()
      )
      Image(
          painter =image ,
          contentDescription ="image",
          contentScale = ContentScale.Crop,
          modifier = Modifier
              .fillMaxSize()
              .padding(vertical = 4.dp, horizontal = 4.dp)
      )
  }
}

@Composable
fun GridCharacter(
    modifier: Modifier=Modifier,
    item :CharactersDmn,
    onItemClick :(Int)->Unit
){
   Column (
       modifier=modifier
           .clickable {
               onItemClick(item.id)
           },
       verticalArrangement = Arrangement.SpaceBetween
   ){
     CharacterImage(item = item)
       Text(
           text = item.name,
           style = MaterialTheme.typography.titleMedium
       )
       Text(
           text = item.species,
           style = MaterialTheme.typography.titleMedium
       )
   }
}