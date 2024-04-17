package com.example.berlin_bucket_list.data

import com.example.berlin_bucket_list.R
import com.example.berlin_bucket_list.model.BerlinBucketListItem
import com.example.berlin_bucket_list.model.CategoryType


object DataSource {

    val categories = listOf(
        BerlinBucketListItem(
            name = R.string.category_1,
            imageId = R.drawable.barcomis_1,
            categoryType = CategoryType.Cafes,
        ),
        BerlinBucketListItem(
            name = R.string.category_2,
            imageId = R.drawable.britzer_garten,
            categoryType = CategoryType.Parks
        ),
        BerlinBucketListItem(
            name = R.string.category_3,
            imageId = R.drawable.alexa_2,
            categoryType = CategoryType.Shopping
        ),
        BerlinBucketListItem(
            name = R.string.category_4,
            imageId = R.drawable.legoland_3,
            categoryType = CategoryType.KidsFriendly
        ),
    )

    val emptyItem = BerlinBucketListItem(
    imageId = R.drawable.appbar_white,
    name = R.string.app_name,
    placeDescription = "Empty",
    address = null,
    credits = null,
    categoryType = CategoryType.Cafes
    )

    val cafes = listOf(
        BerlinBucketListItem(
            imageId = R.drawable.bonanza_1,
            name = R.string.cafe_1,
            placeDescription = "“Bonanza coffee doesn’t have to taste that way. But it does. It’s not your typical. It's unnecessarily good. Maybe that's because we're unnecessarily driven. Unnecessarily curious. Unnecessarily obsessed.”",
            extraInfo = "- BONANZA COFFEE TEAM",
            address = R.string.cafe_address_1,
            credits = R.string.credits_cafes_general,
            categoryType = CategoryType.Cafes
        ),
        BerlinBucketListItem(
            imageId = R.drawable.suesskramdealer_1,
            name = R.string.cafe_2,
            placeDescription = "“It lives up to its name: in this shop, which is still mostly furnished with wood from the Wilhelminian period, you feel like you've gone back in time. You can get fine chocolate, coffee, and gifts here. Since 2011, a modern coffee house right next door has been part of it, where you can sit comfortably and sip coffee.“",
            address = R.string.cafe_address_2,
            credits = R.string.credits_cafes_general,
            categoryType = CategoryType.Cafes

        ),
        BerlinBucketListItem(
            imageId = R.drawable.altstadtcafe_coepenick_1,
            name = R.string.cafe_3,
            placeDescription = "“This traditional café has been around for 20 years and has retained much of its nostalgic charm. Here you can sit in the cosy café or on the small terrace with a view of the Dahme. The coffee is accompanied by a homemade cake creation or a hearty snack. The perfect place to enjoy a break while exploring the historic city of Köpenick.“",
            address = R.string.cafe_address_3,
            credits = R.string.credits_cafes_general,
            categoryType = CategoryType.Cafes

        ),
        BerlinBucketListItem(
            imageId = R.drawable.kaffeehaus_frau_lueske_1,
            name = R.string.cafe_4,
            placeDescription = "“A real feel-good place: whether you're sitting outside in the garden on the terrace or making yourself comfortable in the café. You'll feel right at home at Frau Lüske's. In addition to coffee and delicious cakes, which are freshly delivered by small, local bakeries, you can also enjoy a delicious breakfast here.“",
            address = R.string.cafe_address_4,
            credits = R.string.credits_cafes_general,
            categoryType = CategoryType.Cafes

        ),
        BerlinBucketListItem(
            imageId = R.drawable.betty_n_caty_1,
            name = R.string.cafe_5,
            placeDescription = "“Already a real neighbourhood favourite Betty'n'Caty in Prenzlauer Berg serves you delicious breakfast and good coffee. The Avocado toast and the pancakes are particularly popular. In the afternoon there are delicious cakes. Many dishes are vegetarian, vegan or gluten-free.“",
            address = R.string.cafe_address_5,
            credits = R.string.credits_cafes_general,
            categoryType = CategoryType.Cafes

        ),
        BerlinBucketListItem(
            imageId = R.drawable.sets_1,
            name = R.string.cafe_6,
            placeDescription = "“In the elegant ambience of this Charlottenburg coffeehouse, you'll get the perfect start to the day - and into the evening. For breakfast, you can choose between freshly baked Belgian waffles, healthy sourdough sandwiches or the typical \"Sets\" breakfast arrangements.“",
            address = R.string.cafe_address_6,
            credits = R.string.credits_cafes_general,
            categoryType = CategoryType.Cafes

        ),
        BerlinBucketListItem(
            imageId = R.drawable.cafe_winterfeldt_schokoladen_1,
            name = R.string.cafe_7,
            placeDescription = "“You'll find a huge selection of sweet temptations at Winterfeldt-Ladencafé in Schöneberg. The winding rooms of the listed Wilhelminian pharmacy with its many cupboards and drawers offer plenty of space for chocolates and pralines. In addition to coffee and cake, you can enjoy a large selection of really chocolaty drinking chocolates here.“",
            address = R.string.cafe_address_7,
            credits = R.string.credits_cafes_general,
            categoryType = CategoryType.Cafes

        ),
        BerlinBucketListItem(
            imageId = R.drawable.patisserie_jubel_1,
            name = R.string.cafe_8,
            placeDescription = "“You will find the small but fine Patisserie Jubel on Hufelandstraße in Bötzowkiez. The staff serves you sensational little tartlets in different sizes that are artfully arranged. The varieties vary regularly - in summer there is melon, goat cheese, and lemon, and in winter there is mint parsnip, poppy, physicalis, and passion fruit.“",
            address = R.string.cafe_address_8,
            credits = R.string.credits_cafes_general,
            categoryType = CategoryType.Cafes

        ),
        BerlinBucketListItem(
            imageId = R.drawable.cafe_anna_blume_1,
            name = R.string.cafe_9,
            placeDescription = "“Lovingly crafted cakes and tarts, gorgeous breakfast creations, selective coffee and tea specialties, homemade ice-cream, as well as refreshing and authentic cuisine make the cafe house one of the most beloved addresses in Prenzlauer Berg.“",
            address = R.string.cafe_address_9,
            credits = R.string.credits_cafe_9,
            categoryType = CategoryType.Cafes

        ),
        BerlinBucketListItem(
            imageId = R.drawable.barcomis_1,
            name = R.string.cafe_10,
            placeDescription = "“Coffee is our passion - and has been since 1994. Founder Cynthia Barcomi started roasting coffee in order to serve authentic, good coffee to her guests. Since then, many new kinds have been added, but the traditional roasting process by hand and the excellent taste has remained.“",
            address = R.string.cafe_address_10,
            credits = R.string.credits_cafe_10,
            categoryType = CategoryType.Cafes
        )
    )

    val parks = listOf(
        BerlinBucketListItem(
            imageId = R.drawable.botanischer_garten,
            name = R.string.park_1,
            placeDescription = "“With an area of 43 hectares and around 20,000 plant species, it is one of the largest and most species-rich botanical gardens in the world. In an exemplary form it represents the garden art of the late 19th century oriented on Peter Lenné and Gustav Meyer.“",
            address = R.string.park_address_1,
            credits = R.string.credits_park_1,
            categoryType = CategoryType.Parks

        ),
        BerlinBucketListItem(
            imageId = R.drawable.britzer_garten,
            name = R.string.park_2,
            placeDescription = "“The Britzer Garten in the south of Berlin is not only a delight for flowers and garden lovers. This excellent green area inspires a wide public with its variety. Hardly any other park changes its face so much with the changing seasons.“",
            address = R.string.park_address_2,
            credits = R.string.credits_park_2,
            categoryType = CategoryType.Parks

        ),
        BerlinBucketListItem(
            imageId = R.drawable.buergerpark_pankow,
            name = R.string.park_3,
            placeDescription = "“It is home to oak trees, birch and maple, a rare swamp cypress and exotic trees, such as mulberry, trumpet tree and yellow poplar. In the early 1990s, a rose garden was designed featuring shrub roses, hybrid tea roses, mini roses and even climbing roses on the pergola made of sandstone columns. In the summer months, concerts are sometimes held in the music pavilion in the centre of the rose garden.“",
            address = R.string.park_address_3,
            credits = R.string.credits_park_3,
            categoryType = CategoryType.Parks
        ),
        BerlinBucketListItem(
            imageId = R.drawable.mauerpark,
            name = R.string.park_4,
            placeDescription = "”Today’s Mauerpark is on land that ran between the two parallel walls separating East and West Berlin. With its observation towers, attack dogs, trip wires and armed guards primed to shoot anyone trying to escape to the West, it was known as the “death strip. The park dates back to the early 1990s when local residents, noticing the rapid spread of self-seeded vegetation on the sandy strip of land, began planting trees and calling for the creation of a park. As a result, the city’s politicians included Mauerpark in the city’s bid to host the 2000 Olympics.”",
            address = R.string.park_address_4,
            credits = R.string.credits_park_4,
            categoryType = CategoryType.Parks
        ),
        BerlinBucketListItem(
            imageId = R.drawable.monbijoupark,
            name = R.string.park_5,
            placeDescription = "”Monbijoupark was given a nine-meter wide promenade and green spaces, wonderful for sunbathing or for ball games. Grilling is also generally allowed, except when it is temporarily banned due to an increased fire risk. From the \"Spreebalkon\" or the summer beach bar you can gaze at the water and let your thoughts drift.”",
            address = R.string.park_address_5,
            credits = R.string.credits_park_5,
            categoryType = CategoryType.Parks
        ),
        BerlinBucketListItem(
            imageId = R.drawable.rudolph_wilde_park,
            name = R.string.park_6,
            placeDescription = "”The Rudolph-Wilde-Park, together with the Volkspark Wilmersdorf, creates an inner-city green corridor, which is an important and diverse recreation centre for the surrounding residential area with high population density. One attraction is the Golden Deer, the emblem of Schöneberg, which is perched on a 8.5 m high pillar in the middle of a fountain.”",
            address = R.string.park_address_6,
            credits = R.string.credits_park_6,
            categoryType = CategoryType.Parks
        ),
        BerlinBucketListItem(
            imageId = R.drawable.tempelhofer_feld,
            name = R.string.park_7,
            placeDescription = "”Once airplanes took off from the grounds that used to be part of Tempelhof Airport. Now, the \"Tempelhofer Feld\" is a large public park where locals enjoy picnics, sunbathing and doing sports.”",
            address = R.string.park_address_7,
            credits = R.string.credits_park_7,
            categoryType = CategoryType.Parks
        ),
        BerlinBucketListItem(
            imageId = R.drawable.tiergarten,
            name = R.string.park_8,
            placeDescription = "”Popular among locals and visitors alike, the Tiergarten is Berlin's largest and most frequented inner-city park. It is ideal for a stroll, outdoor activities or a picnic.”",
            address = R.string.park_address_8,
            credits = R.string.credits_park_8,
            categoryType = CategoryType.Parks
        ),
        BerlinBucketListItem(
            imageId = R.drawable.viktoriapark,
            name = R.string.park_9,
            placeDescription = "”The Viktoriapark with the Kreuzberg hill is Berlin's highest inner-city elevation and has a real waterfall to offer.”",
            address = R.string.park_address_9,
            credits = R.string.credits_park_9,
            categoryType = CategoryType.Parks
        ),
        BerlinBucketListItem(
            imageId = R.drawable.volkspark_hasenheide,
            name = R.string.park_10,
            placeDescription = "”The Volkspark Hasenheide offers a lot of green, an animal park, an open-air cinema and a rose garden. The Neukölln Zoo and the large playground \"Fairytales from 1001 Nights\" are worthy of special mention.”",
            address = R.string.park_address_10,
            credits = R.string.credits_park_10,
            categoryType = CategoryType.Parks
        ),
    )

    val shoppingCenters = listOf(
        BerlinBucketListItem(
            imageId = R.drawable.mall_of_berlin_1,
            name = R.string.shopping_1,
            placeDescription = "”This elegant and new shopping paradise extraordinaire , the Mall of Berlin, is centrally located on Leipziger Platz, very close to Potsdamer Platz. In an overall sophisticated ambience you will find a well-rounded mix of shopping, gastronomy, housing, hotel and offices.”",
            address = R.string.shopping_address_1,
            credits = R.string.credits_shopping_general,
            categoryType = CategoryType.Shopping
        ),
        BerlinBucketListItem(
            imageId = R.drawable.bikini_berlin_1,
            name = R.string.shopping_2,
            placeDescription = "”Where architecture meets oooh, history meets aaaah, culinary delights meet mmmh – and visitors don’t just come to shop, but to practice the lost art of strolling, while soaking in the concept shopping mall’s historic past and modern design.”",
            address = R.string.shopping_address_2,
            credits = R.string.credits_shopping_2,
            categoryType = CategoryType.Shopping

        ),
        BerlinBucketListItem(
            imageId = R.drawable.alexa_1,
            name = R.string.shopping_3,
            placeDescription = "”With 180 individual stores the ALEXA offers the greatest shopping variety in Berlin! Next to special fashion-brands like Bench, Billabong, VILA or 1982 (only 3 times in Berlin) there are also exclusive shops for cosmetic products by Grüne Erde or Rituals Cosmetics.”",
            address = R.string.shopping_address_3,
            credits = R.string.credits_shopping_general,
            categoryType = CategoryType.Shopping

        ),
        BerlinBucketListItem(
            imageId = R.drawable.potsdamer_platz_arkaden_1,
            name = R.string.shopping_4,
            placeDescription = "”Discover everything the city has to offer: history, culture, entertainment, gastronomy and shopping! A vibrant place for locals, visitors and everyone looking to explore and re-discover Berlin.”",
            address = R.string.shopping_address_4,
            credits = R.string.credits_shopping_general,
            categoryType = CategoryType.Shopping
        ),
        BerlinBucketListItem(
            imageId = R.drawable.wilma_1,
            name = R.string.shopping_5,
            placeDescription = "”Wilmersdorfer Arcaden have been designed as a barrier-free shopping centre and therefore very accessible for physically challenged peole and mothers with prams alike. In addition the shopping centre offers child care on Fridays, Saturdays and open Sundays.”",
            address = R.string.shopping_address_5,
            credits = R.string.credits_shopping_general,
            categoryType = CategoryType.Shopping
        ),
        BerlinBucketListItem(
            imageId = R.drawable.boulevard_berlin_1,
            name = R.string.shopping_6,
            placeDescription = "”In Berlin the shops of Hollister and Zara Home can only be found here at Boulevard Berlin. Together with the only Berlin shop of Primark in the neighbouring SCC it turns the disitrict of Steglitz into a popular destination for shopping friends.”",
            address = R.string.shopping_address_6,
            credits = R.string.credits_shopping_general,
            categoryType = CategoryType.Shopping
        ),
        BerlinBucketListItem(
            imageId = R.drawable.spandau_arcaden_1,
            name = R.string.shopping_7,
            placeDescription = "”Where fashion is concerned they score with brands like Betty Barclay, Colloseum, Esprit and Jack Wolfskin. Their clothing can be combined perfectly with trendy sandals, rugged boots or sportive sneakers from one of the many shoe stores. Electronics get catered for by shops like Saturn, Mobilcom and Vodafone. For books and stationery McPaper, Thalia and Weltbild are the places to go and also in the food sector the Spandau Arcaden holds itself well with several bakeries, ecologic food and delikatessen.”",
            address = R.string.shopping_address_7,
            credits = R.string.credits_shopping_general,
            categoryType = CategoryType.Shopping
        ),
        BerlinBucketListItem(
            imageId = R.drawable.das_schloss_1,
            name = R.string.shopping_8,
            placeDescription = "”Shopping under stars, in space or under water - all possible at Das Schloss where the ceiling is used as a projection surface to provide for an unusual shopping ambiance. Be prepared for a nice finish with many special events during the holiday season or also fireworks for New Year’s Eve.”",
            address = R.string.shopping_address_8,
            credits = R.string.credits_shopping_general,
            categoryType = CategoryType.Shopping
        ),
        BerlinBucketListItem(
            imageId = R.drawable.eastgate_1,
            name = R.string.shopping_9,
            placeDescription = "”150 Shops, 80 of which alone for fashion such as Tom Tailor, Promod or Street One invite you for a stroll. But also jewellery by Pandora and Christ and home decoration by Leonardo, Nanu Nana and Das Depot fly their flags with a store here.”",
            address = R.string.shopping_address_9,
            credits = R.string.credits_shopping_general,
            categoryType = CategoryType.Shopping
        ),
        BerlinBucketListItem(
            imageId = R.drawable.gropius_passagen_1,
            name = R.string.shopping_10,
            placeDescription = "”Among the 160 stores you find above all well-known brands such as H&M, Esprit, Bijou Brigitte, Intersport Olympia, Douglas or The Body Shop. This is very useful especially when it rains or snows since shoppers there can find everything under one roof.”",
            address = R.string.shopping_address_10,
            credits = R.string.credits_shopping_general,
            categoryType = CategoryType.Shopping
        ),
    )

    val kidsFriendly = listOf(
        BerlinBucketListItem(
            imageId = R.drawable.zoo_berlin_1,
            name = R.string.kid_friendly_1,
            placeDescription = "”Zoo Berlin is in a class of its own! Not only is it the oldest and most frequently visited zoo in the country, it is also home to the largest variety of species of any zoo in the world – including the only giant pandas in Germany!”",
            address = R.string.kid_friendly_address_1,
            credits = R.string.credits_kids_friendly_general,
            categoryType = CategoryType.KidsFriendly
        ),
        BerlinBucketListItem(
            imageId = R.drawable.museumfuernaturkunde_1,
            name = R.string.kid_friendly_2,
            placeDescription = "”The permanent exhibitions together with regular special exhibitions give the public insights into current research at the museum and highlight original research objects. Visitors are encouraged and inspired to find their own route into science and experience ‘Evolution in Action’ rather than following a given pathway.”",
            address = R.string.kid_friendly_address_2,
            credits = R.string.credits_kids_friendly_general,
            categoryType = CategoryType.KidsFriendly
        ),
        BerlinBucketListItem(
            imageId = R.drawable.berlin_wall_for_kids_1,
            name = R.string.kid_friendly_3,
            placeDescription = "”Your engaging tour guide will share insights into life during those days, offer knowledge on legendary sights, and provide engaging activities during your time together.”",
            address = R.string.kid_friendly_address_3,
            credits = R.string.credits_kids_friendly_general,
            categoryType = CategoryType.KidsFriendly
        ),
        BerlinBucketListItem(
            imageId = R.drawable.legoland_3,
            name = R.string.kid_friendly_4,
            placeDescription = "”Let your kids unleash their creativity, energy, and imagination at this LEGO-themed indoor playground featuring rides, play areas, and interactive LEGO workshops. You’ll find rides and attractions suitable for kids of all ages, a factory tour, and building workshops.”",
            address = R.string.kid_friendly_address_4,
            credits = R.string.credits_kids_friendly_general,
            categoryType = CategoryType.KidsFriendly
        ),
        BerlinBucketListItem(
            imageId = R.drawable.sealife_1,
            name = R.string.kid_friendly_5,
            placeDescription = "”An underwater adventure in the heart of the city? It’s possible at SEA LIFE Berlin, where you can see a range of marine creatures, including sharks, sea turtles, and colorful fish. Don't miss the stunning AquaDom, a cylindrical aquarium in the middle of a hotel lobby.”",
            address = R.string.kid_friendly_address_5,
            credits = R.string.credits_kids_friendly_general,
            categoryType = CategoryType.KidsFriendly
        ),
        BerlinBucketListItem(
            imageId = R.drawable.tierpark_berlin_1,
            name = R.string.kid_friendly_6,
            placeDescription = "”Tierpark Berlin covers approximately 395 acres, providing ample space for animals to roam and visitors to explore. The park's layout aims to create habitats that closely resemble the animals' natural environments, with lush greenery, water features, and open spaces.”",
            address = R.string.kid_friendly_address_6,
            credits = R.string.credits_kids_friendly_general,
            categoryType = CategoryType.KidsFriendly
        ),
        BerlinBucketListItem(
            imageId = R.drawable.technikmuseum_1,
            name = R.string.kid_friendly_7,
            placeDescription = "”What kid doesn’t love technology? The Berlin Museum of Technology, also known as the Deutsches Technikmuseum Berlin, is a fascinating institution showcasing technology's history and its impact on society. Ignite your child's curiosity with hands-on exhibits showcasing technological advancements, vintage vehicles, aircraft, and interactive experiments.”",
            address = R.string.kid_friendly_address_7,
            credits = R.string.credits_kids_friendly_general,
            categoryType = CategoryType.KidsFriendly
        ),
        BerlinBucketListItem(
            imageId = R.drawable.labyrinth_kindermuseum_1,
            name = R.string.kid_friendly_8,
            placeDescription = "”The Labyrinth Kindermuseum, designed for kids aged 3-11, focuses on learning through play. It provides a safe and supportive environment where children can freely express themselves, experiment, and learn through their exploration and discovery.”",
            address = R.string.kid_friendly_address_8,
            credits = R.string.credits_kids_friendly_general,
            categoryType = CategoryType.KidsFriendly
        ),
    )
}