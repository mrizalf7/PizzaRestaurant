package com.example.pizzarestaurant.utils

import com.example.pizzarestaurant.domain.model.Pizza


object PizzaData {
    private var Data  = arrayOf(

        arrayOf("Pepperoni Pizza",
            "https://i.ibb.co/gFThkys/pepperoni-pizzaa.jpg",
            "Cocok bagi anda yang ingin merasakan pizza original dengan taburan keju dan daging asap yang lezat",
            "Pepperoni pizza adalah pizza yang memiliki  topping daging pepperoni sapi asli. Di Italia, pepperoni disebut salame piccante (salami panas). Biasa menjadi bahan baku pizza di Amerika Serikat, yang sering mewakili 30% pelengkap. Pizza ini cocok untuk santap siang ataupun malam anda",
            "Rp.66.000,00"
        ),
        arrayOf("Spaghetti",
            "https://i.ibb.co/q1jW0yG/spagheti.jpg",
            "Cocok bagi anda yang ingin merasakan spaghetti original dengan bumbu yang oriental",
            "Spaghetti (bahasa Italia [spaˈɡetti]) adalah pasta berbentuk silinder yang panjang, tipis, padat. Ini adalah makanan pokok masakan Italia tradisional. Seperti pasta lainnya, spageti terbuat dari gandum giling dan air dan terkadang diperkaya dengan vitamin dan mineral. Spaghetti Italia biasanya dibuat dari semolina gandum durum." +
                    "Biasanya pasta berwarna putih karena menggunakan tepung olahan, tetapi tepung gandum utuh dapat ditambahkan. Spaghettoni adalah spageti yang lebih tebal, sedangkan capellini adalah spageti yang sangat tipis",
            "Rp.62.000,00"),
        arrayOf("Burger",
        "https://i.ibb.co/zRf86bT/burger.jpg",
        "Cocok bagi anda yang ingin merasakan kelembutan burger berlapiskan keju, sayuran dan daging yang tebal"
            ,"Hamburger atau burger adalah sejenis roti berbentuk bundar yang diiris dua, dan di tengahnya diisi dengan patty yang biasanya diambil dari daging, kemudian sayur-sayuran berupa selada, tomat dan bawang bombai. Sebagai sausnya, hamburger diberi berbagai jenis saus seperti mayones, saus tomat dan sambal, serta moster. Beberapa varian hamburger juga dilengkapi dengan keju dan asinan. Hamburger merupakan makanan siap saji yang populer di Amerika Serikat",
            "Rp.52.000,00"),
        arrayOf("Steak",
        "https://i.ibb.co/R9zjHwM/steak.jpg",
        "Cocok bagi anda yang ingin merasakan lezatnya daging steak dipadukan dengan kentang yang lezat",
        "Steik adalah sepotong besar daging, biasanya daging sapi. Daging merah, dada ayam, dan ikan sering kali dipotong menjadi steik. Kebanyakan steik dipotong tegak lurus dengan serat otot, menambah kelegitan daging. Steik biasanya dimasak dengan dipanggang, meskipun dapat digoreng atau dibroil Sebuah restoran yang mengkhususkan dalam steik biasanya dikenal sebagai rumah steik",
        "Rp.70.000,00")
    )

    val listData: ArrayList<Pizza>
        get() {
            val list = ArrayList<Pizza>()
            for (aData in Data) {
                val pizza = Pizza()
                pizza.pizzaName = aData[0]
                pizza.pizzaPhoto = aData[1]
                pizza.pizzaDesc1 = aData[2]
                pizza.pizzaDesc2 = aData[3]
                pizza.pizzaPrice= aData[4]
                list.add(pizza)
            }
            return list
        }

}