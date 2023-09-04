package com.example.composermtt.mydata.model.character

import com.example.composermtt.domain.model.CharacterDmn
import com.example.composermtt.mydata.model.InfoModel
import com.example.composermtt.mydata.model.LocationModel
import com.example.composermtt.mydata.model.OriginModel
import com.example.composermtt.mydata.model.toInfo
import com.example.composermtt.mydata.model.toLocation
import com.example.composermtt.mydata.model.toOrigin

data class CharacterModel(
    val created:String,
    val episode:List<String>,
    val gender:String,
    val id :Int,
    val image :String,
    val name :String,
    val species:String,
    val status:String,
    val type:String,
    val url:String,
    val location: LocationModel,
    val origin: OriginModel,
    val info: InfoModel
)
fun CharacterModel.toCharacter():CharacterDmn{
    return CharacterDmn(
        id=id,gender=gender,image=image,location=location.toLocation(),name=name,origin=origin.toOrigin(),species=species,status=status,
        info = info.toInfo()
    )
}
