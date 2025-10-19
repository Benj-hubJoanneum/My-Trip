package at.fhj.iit.ims.mytrip.core.data.local


import at.fhj.iit.ims.mytrip.core.model.LandmarkComment


/**
 * Pure data holder with seeded content for local/demo usage.
 * No Compose/Android dependencies here.
 */
class MockLandmarkDataSource {


    data class BaseLandmark(
        val id: Int,
        val name: String,
        val description: String,
        val imageUrl: String
    )


    val baseLandmarks = listOf(
        BaseLandmark(1, "Uhrturm", "Treffpunkt Tinderdates", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Uhrturm_graz_2003.JPG/120px-Uhrturm_graz_2003.JPG"),
        BaseLandmark(2, "Hauptbahnhof", "Meet and greet with Sandler", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ad/Graz_Hauptbahnhof_bei_Nacht.jpg/500px-Graz_Hauptbahnhof_bei_Nacht.jpg"),
        BaseLandmark(3, "Stadtpark", "Marktplatz für Fragliche Produkte", "https://www.graz.at/cms/bilder/120833/80/0/0/36ad3c6c/920%20Stadtpark%20Graz%20%28c%29%20Graz%20Tourismus%20-%20Harry%20Schiffer.jpg"),
        BaseLandmark(4, "Bermuda Dreieck", "U-Boot Simulator", "https://media-cdn.tripadvisor.com/media/photo-s/06/4f/ea/81/kottulinsky.jpg"),
        BaseLandmark(5, "Flan o'brien", "Irish Pub", "https://www.flannobrien.eu/wp-content/themes/yootheme/cache/Flann-O%C2%B4Brien-Irish-Pub-streetview-2b1a6443.jpeg"),
        BaseLandmark(6, "Friendly Alien", "Kaffee für unsportliche Tinderdates", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9b/Graz_Kunsthaus_vom_Schlossberg_20061126.jpg/330px-Graz_Kunsthaus_vom_Schlossberg_20061126.jpg"),
        BaseLandmark(7, "Stadthalle", "Live Events von Konzerten bis Häuslbauer Messe", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Stadthalle_Graz_%28AUT%29.jpg/250px-Stadthalle_Graz_%28AUT%29.jpg"),
        BaseLandmark(8, "Rathaus", "Kommunistische Mitte", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Graz%2C_Rathaus%2C_Bild_3.jpg/250px-Graz%2C_Rathaus%2C_Bild_3.jpg"),
        BaseLandmark(9, "Kasematten", "Schlossberg Bühne", "https://www.i-m-l-s.com/wp-content/uploads/2022/01/Schlossbergbuehne-Kasematten-Graz.webp"),
        BaseLandmark(10, "Billa Eck", "Meet and Greet with Giftler", "https://preview.redd.it/der-giftm%C3%BCllexpress-h%C3%A4lt-am-billa-eck-v0-z3njjd17zawb1.jpg?width=640&crop=smart&auto=webp&s=ac9efb74b9d30577b67a186b11377b8262522273"),
        BaseLandmark(11, "Dom im Berg", "Maulwurfdisco", "https://www.graz.net/wp-content/uploads/2023/06/Dom-im-Berg-Graz_04-768x432.jpg"),
        BaseLandmark(12, "Hauptplatz", "kA da gibt's nen Brunnen", "https://www.graz101.at/images/hauptplatz010.jpg#joomlaImage://local-images/hauptplatz010.jpg?width=1000&height=603"),
        BaseLandmark(14, "Murinsel", "Island in the mur", "https://media.gettyimages.com/id/496835171/de/foto/murinsel-in-graz-%C3%B6sterreich.jpg?s=612x612&w=0&k=20&c=7NZMt8G7Scrq5NCuVyoUzhXVvXkn7oBgXfVrUp1Quoc="),
        BaseLandmark(15, "Mur stage", "Studenten Bühne", "https://imgs.search.brave.com/ZpKo9VrqLF-TqaXUxyD2tKi503R8zMWWoF5mfEucVZI/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly93d3cuc3RlaWVybWFyay5jb20vc3R0LWltcG9ydHMvZ3Jhei9pbmZyYXN0cnVrdHVyL2NpdHlwZWFjaC1ncmF6XzI0NDY4MTY2LzI5NTAxNzUvaW1hZ2UtdGh1bWJfXzI5NTAxNzVfX2RlbWktaW5mcmFzdHJ1Y3R1cmUtZXZlbnQtZGV0YWlsLWdhbGxlcnkvY2l0eWJlYWNoLS1jLS1ncmF6LXRvdXJpc211cy0tLWhhcnJ5LXNjaGlmZmVyLS0yLTJ4XzE4NzQzXzI0NDY4MTY2LmpwZw")
    )


    private val comments = listOf(
// Uhrturm (1)
        LandmarkComment(1, 1, "Great view", "Perfect meetup spot, nice skyline.", 5),
        LandmarkComment(2, 1, "Romantic", "Sunset was lovely.", 4),
// Hauptbahnhof (2)
        LandmarkComment(3, 2, "Functional", "Busy but efficient.", 3),
        LandmarkComment(4, 2, "Crowded", "Too many people in rush hour.", 2),
// Stadtpark (3)
        LandmarkComment(5, 3, "Chill", "Green and quiet.", 4),
// Bermuda Dreieck (4)
        LandmarkComment(6, 4, "Party area", "Fun pubs all around.", 5),
        LandmarkComment(7, 4, "Loud", "Great at night, loud though.", 4),
// Flan o'brien (5)
        LandmarkComment(8, 5, "Cozy pub", "Guinness on point.", 5),
// Friendly Alien / Kunsthaus (6)
        LandmarkComment(9, 6, "Iconic", "Architecture is wild.", 5),
        LandmarkComment(10, 6, "Coffee stop", "Nice café inside.", 4),
// Stadthalle (7)
        LandmarkComment(11, 7, "Great venue", "Acoustics decent.", 4),
// Rathaus (8)
        LandmarkComment(12, 8, "Beautiful", "Lovely facade.", 5),
// Kasematten (9)
        LandmarkComment(13, 9, "Atmospheric", "Open-air stage rocks.", 5),
// Billa Eck (10)
        LandmarkComment(14, 10, "Convenient", "Good for quick snacks.", 3),
// Dom im Berg (11)
        LandmarkComment(15, 11, "Unique", "Club inside a mountain!", 5),
        LandmarkComment(16, 11, "Cool vibes", "Lighting is amazing.", 4),
// Hauptplatz (12)
        LandmarkComment(17, 12, "Centerpiece", "Fountain & markets.", 5),
// Murinsel (14)
        LandmarkComment(18, 14, "Quirky", "Bridge-island café.", 4),
// Mur Stage (15)
        LandmarkComment(19, 15, "Student spot", "Live shows are fun.", 4)
    )


    fun commentsFor(landmarkId: Int) = comments.filter { it.landmarkId == landmarkId }
}