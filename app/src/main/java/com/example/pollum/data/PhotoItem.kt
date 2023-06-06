package com.example.pollum.data

object PhotoItem {
    val itemList = mutableListOf(
        PhotoData(
            "https://cdn.shopify.com/s/files/1/0529/2641/5045/t/23/assets/tokinorora_birth_thumbnail_en_fix_1685001870_800x.png?v=1684739851",
            "Tokino Sora",
            "Hololive Merch"
        ),
        PhotoData(
            "https://thumbor.prod.vidiocdn.com/3f4mwBLHjkmEOVVzsyWMC62olRU=/filters:quality(70)/vidio-web-prod-film/uploads/film/image_portrait/6258/transformers-the-last-knight-651701.jpg",
            "Transformers: The Last Knight",
            "Movie"
        )
    )

    fun addPhoto(photoData: PhotoData) {
        itemList.add(photoData)
    }
}
