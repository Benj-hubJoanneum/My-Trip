package at.fhj.iit.ims.mytrip.list

import at.fhj.iit.ims.mytrip.model.Landmark

object LandmarkRepository {
    private val items = listOf(
        Landmark(1, "Uhrturm", "Treffpunkt Tinderdates", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Uhrturm_graz_2003.JPG/120px-Uhrturm_graz_2003.JPG"),
        Landmark(2, "Hauptbahnhof", "Meet and greet with Sandler", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ad/Graz_Hauptbahnhof_bei_Nacht.jpg/500px-Graz_Hauptbahnhof_bei_Nacht.jpg"),
        Landmark(3, "Stadpark", "Marktplatz für Fragliche Produkte", "https://www.graz.at/cms/bilder/120833/80/0/0/36ad3c6c/920%20Stadtpark%20Graz%20%28c%29%20Graz%20Tourismus%20-%20Harry%20Schiffer.jpg"),
        Landmark(4, "Bermuda Dreieck", "U-Boot Simulator", "https://media-cdn.tripadvisor.com/media/photo-s/06/4f/ea/81/kottulinsky.jpg"),
        Landmark(5, "Flan o'brien", "Irish Pub", "https://www.flannobrien.eu/wp-content/themes/yootheme/cache/Flann-O%C2%B4Brien-Irish-Pub-streetview-2b1a6443.jpeg"),
        Landmark(6, "Friendly Alien", "Kaffee für unsportliche Tinderdates", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9b/Graz_Kunsthaus_vom_Schlossberg_20061126.jpg/330px-Graz_Kunsthaus_vom_Schlossberg_20061126.jpg"),
        Landmark(7, "Stadthalle", "Live Events von Konzerten bis Häuslbauer Messe", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Stadthalle_Graz_%28AUT%29.jpg/250px-Stadthalle_Graz_%28AUT%29.jpg"),
        Landmark(8, "Rathaus", "Kommunistische Mitte", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Graz%2C_Rathaus%2C_Bild_3.jpg/250px-Graz%2C_Rathaus%2C_Bild_3.jpg"),
        Landmark(9, "Kasematten", "Schlossberg Bühne", "https://www.i-m-l-s.com/wp-content/uploads/2022/01/Schlossbergbuehne-Kasematten-Graz.webp"),
        Landmark(10, "Billa Eck", "Meet and Greet with Giftler", "https://preview.redd.it/der-giftm%C3%BCllexpress-h%C3%A4lt-am-billa-eck-v0-z3njjd17zawb1.jpg?width=640&crop=smart&auto=webp&s=ac9efb74b9d30577b67a186b11377b8262522273"),
        Landmark(11, "Dom im Berg", "Maulwurfdisco", "https://www.graz.net/wp-content/uploads/2023/06/Dom-im-Berg-Graz_04-768x432.jpg"),
        Landmark(12, "Hauptplatz", "kA da gibt's nen Brunnen", "https://www.graz101.at/images/hauptplatz010.jpg#joomlaImage://local-images/hauptplatz010.jpg?width=1000&height=603"),
        Landmark(14, "Murinsel", "Island in the mur", "https://media.gettyimages.com/id/496835171/de/foto/murinsel-in-graz-%C3%B6sterreich.jpg?s=612x612&w=0&k=20&c=7NZMt8G7Scrq5NCuVyoUzhXVvXkn7oBgXfVrUp1Quoc="),
        Landmark(15, "Mur stage", "Studenten Bühne", "https://imgs.search.brave.com/ZpKo9VrqLF-TqaXUxyD2tKi503R8zMWWoF5mfEucVZI/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly93d3cu/c3RlaWVybWFyay5j/b20vc3R0LWltcG9y/dHMvZ3Jhei9pbmZy/YXN0cnVrdHVyL2Np/dHlwZWFjaC1ncmF6/XzI0NDY4MTY2LzI5/NTAxNzUvaW1hZ2Ut/dGh1bWJfXzI5NTAx/NzVfX2RlbWktaW5m/cmFzdHJ1Y3R1cmUt/ZXZlbnQtZGV0YWls/LWdhbGxlcnkvY2l0/eWJlYWNoLS1jLS1n/cmF6LXRvdXJpc211/cy0tLWhhcnJ5LXNj/aGlmZmVyLS0yLTJ4/XzE4NzQzXzI0NDY4/MTY2LmpwZw"),
    )

    fun getAll(): List<Landmark> = items

    fun getById(id: Int): Landmark? = items.firstOrNull { it.id == id }
}
