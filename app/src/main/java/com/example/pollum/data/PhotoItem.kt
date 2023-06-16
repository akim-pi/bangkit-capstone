package com.example.pollum.data

object PhotoItem {
    val itemList = mutableListOf(
        PhotoData(
            "https://i.guim.co.uk/img/media/9988a21ff2c14703e6be54cf00b584b86764d672/945_1419_3421_2052/master/3421.jpg?width=1200&height=900&quality=85&auto=format&fit=crop&s=94a14e3ec4dcb5495693791e6df4a265",
            "Lebah Madu",
            "Healthy"
        ),
        PhotoData(
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShWpMWUYjdnQ4AgQA27fAMYeq1C05RPi8rpA&usqp=CAU",
            "Lebah Madu 2",
            "Healthy"
        )
    )

    fun addPhoto(photoData: PhotoData) {
        itemList.add(photoData)
    }
}
