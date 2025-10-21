package at.fhj.iit.ims.mytrip.core.data.local

import at.fhj.iit.ims.mytrip.core.model.LandmarkComment

/**
 * Pure data holder with seeded content for local/demo usage.
 * No Compose/Android dependencies here.
 */
class FakeLandmarkDataSource {

    data class BaseLandmark(
        val id: Int,
        val name: String,
        val description: String,
        val imageUrl: String,
        val latitude: Double,
        val longitude: Double,
        val cashless: Boolean = true,
        val ticketURL: String = "",
        val reservationURL: String = ""
    )

    // Seed landmarks (URLs for ticket/reservation can be empty -> buttons won't show)
    val baseLandmarks = listOf(
        BaseLandmark(1, "Uhrturm", "Treffpunkt Tinderdates",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Uhrturm_graz_2003.JPG/120px-Uhrturm_graz_2003.JPG",
            47.0735697, 15.4377041,
            cashless = false,
            "https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Uhrturm_graz_2003.JPG/120px-Uhrturm_graz_2003.JPG",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Uhrturm_graz_2003.JPG/120px-Uhrturm_graz_2003.JPG"
        ),
        BaseLandmark(2, "Hauptbahnhof", "Meet and greet with Sandler",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ad/Graz_Hauptbahnhof_bei_Nacht.jpg/500px-Graz_Hauptbahnhof_bei_Nacht.jpg",
            47.0722373, 15.4183974
        ),
        BaseLandmark(3, "Stadtpark", "Marktplatz für Fragliche Produkte",
            "https://www.graz.at/cms/bilder/120833/80/0/0/36ad3c6c/920%20Stadtpark%20Graz%20%28c%29%20Graz%20Tourismus%20-%20Harry%20Schiffer.jpg",
            47.074885, 15.4426608
        ),
        BaseLandmark(4, "Bermuda Dreieck", "U-Boot Simulator",
            "https://media-cdn.tripadvisor.com/media/photo-s/06/4f/ea/81/kottulinsky.jpg",
            47.0750485, 15.4511869,
            cashless = true, reservationURL = "" /* add if known */
        ),
        BaseLandmark(5, "Flan o'brien", "Irish Pub",
            "https://www.flannobrien.eu/wp-content/themes/yootheme/cache/Flann-O%C2%B4Brien-Irish-Pub-streetview-2b1a6443.jpeg",
            47.0713889, 15.4361111,
            cashless = true, reservationURL = ""
        ),
        BaseLandmark(6, "Friendly Alien", "Kaffee für unsportliche Tinderdates",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9b/Graz_Kunsthaus_vom_Schlossberg_20061126.jpg/330px-Graz_Kunsthaus_vom_Schlossberg_20061126.jpg",
            47.0713866, 15.4340738
        ),
        BaseLandmark(7, "Stadthalle", "Live Events von Konzerten bis Häuslbauer Messe",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Stadthalle_Graz_%28AUT%29.jpg/250px-Stadthalle_Graz_%28AUT%29.jpg",
            47.0577932, 15.446928,
            cashless = true, ticketURL = "" /* add ticket shop if known */
        ),
        BaseLandmark(8, "Rathaus", "Kommunistische Mitte",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Graz%2C_Rathaus%2C_Bild_3.jpg/250px-Graz%2C_Rathaus%2C_Bild_3.jpg",
            47.070541, 15.4385571
        ),
        BaseLandmark(9, "Kasematten", "Schlossberg Bühne",
            "https://www.i-m-l-s.com/wp-content/uploads/2022/01/Schlossbergbuehne-Kasematten-Graz.webp",
            47.0764157, 15.4376012,
            cashless = true, ticketURL = ""
        ),
        BaseLandmark(10, "Billa Eck", "Meet and Greet with Giftler",
            "https://preview.redd.it/der-giftm%C3%BCllexpress-h%C3%A4lt-am-billa-eck-v0-z3njjd17zawb1.jpg?width=640&crop=smart&auto=webp&s=ac9efb74b9d30577b67a186b11377b8262522273",
            47.0764157, 15.4376012,
            cashless = true
        ),
        BaseLandmark(11, "Dom im Berg", "Maulwurfdisco",
            "https://www.graz.net/wp-content/uploads/2023/06/Dom-im-Berg-Graz_04-768x432.jpg",
            47.0731999, 15.4369123,
            cashless = true, ticketURL = ""
        ),
        BaseLandmark(12, "Hauptplatz", "kA da gibt's nen Brunnen",
            "https://www.graz101.at/images/hauptplatz010.jpg#joomlaImage://local-images/hauptplatz010.jpg?width=1000&height=603",
            47.0708499, 15.4382908
        ),
        BaseLandmark(14, "Murinsel", "Island in the mur",
            "https://media.gettyimages.com/id/496835171/de/foto/murinsel-in-graz-%C3%B6sterreich.jpg?s=612x612&w=0&k=20&c=7NZMt8G7Scrq5NCuVyoUzhXVvXkn7oBgXfVrUp1Quoc=",
            47.0731386, 15.4345565
        ),
        BaseLandmark(15, "City Peach", "Studenten Bühne",
            "https://www.graz.net/wp-content/uploads/2024/05/citypeach_01.jpg",
            47.0731386, 15.4345565,
            cashless = true, reservationURL = ""
        )
    )

    private val comments = listOf(
        // (same comments as before) — keep your seed data
        LandmarkComment(1, 1, "Great view", "Perfect meetup spot, nice skyline.", 5),
        LandmarkComment(2, 1, "Romantic", "Sunset was lovely.", 4),
        LandmarkComment(3, 2, "Functional", "Busy but efficient.", 3),
        LandmarkComment(4, 2, "Crowded", "Too many people in rush hour.", 2),
        LandmarkComment(5, 3, "Chill", "Green and quiet.", 4),
        LandmarkComment(6, 4, "Party area", "Fun pubs all around.", 5),
        LandmarkComment(7, 4, "Loud", "Great at night, loud though.", 4),
        LandmarkComment(8, 5, "Cozy pub", "Guinness on point.", 5),
        LandmarkComment(9, 6, "Iconic", "Architecture is wild.", 5),
        LandmarkComment(10, 6, "Coffee stop", "Nice café inside.", 4),
        LandmarkComment(11, 7, "Great venue", "Acoustics decent.", 4),
        LandmarkComment(12, 8, "Beautiful", "Lovely facade.", 5),
        LandmarkComment(13, 9, "Atmospheric", "Open-air stage rocks.", 5),
        LandmarkComment(14, 10, "Convenient", "Good for quick snacks.", 3),
        LandmarkComment(15, 11, "Unique", "Club inside a mountain!", 5),
        LandmarkComment(16, 11, "Cool vibes", "Lighting is amazing.", 4),
        LandmarkComment(17, 12, "Centerpiece", "Fountain & markets.", 5),
        LandmarkComment(18, 14, "Quirky", "Bridge-island café.", 4),
        LandmarkComment(19, 15, "Student spot", "Live shows are fun.", 4),
    )

    fun commentsFor(landmarkId: Int) = comments.filter { it.landmarkId == landmarkId }
}
