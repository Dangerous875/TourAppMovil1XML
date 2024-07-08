package com.example.tourapp.repositories

import com.example.tourapp.data.Destination

object DestinationRepository {

     fun getBariloche(): Destination {
        return Destination(
            1L,
            "Bariloche",
            "San Carlos de Bariloche (comúnmente llamada Bariloche) es una ciudad en la región de la Patagonia argentina. Limita con Nahuel Huapi, un gran lago glacial rodeado de montañas de los Andes. Bariloche es conocida por su arquitectura al estilo alpino de Suiza y su chocolate, que se vende en tiendas de la calle Mitre, la avenida principal.",
            listOf(
                "https://media.ambito.com/p/09dc04d56f9a00e9d087163f0cd76465/adjuntos/239/imagenes/040/404/0040404265/foto-bariloche-1-1png.png",
                "https://i0.wp.com/barilocheparabrasileiros.com.br/wp-content/uploads/2020/08/Guia-de-Inverno.jpeg",
                "https://media.istockphoto.com/id/820824654/es/foto/bariloche-lago-nahuel-huapi.jpg?s=612x612&w=0&k=20&c=UIe5LkCmk1zAZRFEFnVdAbEncUSPAtpPdRf0KtQHpjo=",
                "https://osomviajes.com/wp-content/uploads/2021/12/Bariloche-con-nieve.jpg",
                "https://muysibarita.com/wp-content/uploads/2023/03/bariloche-invierno.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2LhFLejd0MTzZaBBf60quOX5Fkm5g0X-SJNlDJwn6_Eqby-6NjeZMubUVH2xlwvJ4b2Q&usqp=CAU")
        )
    }

     fun getMendoza(): Destination {
        return Destination(
            2L,
            "Mendoza",
            "Mendoza es una ciudad de la región de Cuyo en Argentina y es el corazón de la zona vitivinícola argentina, famosa por sus Malbecs y otros vinos tintos. Sus distintas bodegas ofrecen degustaciones y visitas guiadas. La ciudad tiene calles amplias y frondosas rodeadas de edificios modernos y art déco, y con plazas más pequeñas que rodean la Plaza Independencia, sitio del Museo Municipal de Arte Moderno subterráneo, que exhibe arte moderno y contemporáneo.",
            listOf("https://media.tacdn.com/media/attractions-splice-spp-674x446/07/20/a5/f9.jpg", "https://images.unsplash.com/photo-1546863340-7e4e97e46f42?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", "https://i0.wp.com/diariosanrafael.com.ar/wp-content/uploads/2022/07/turismo-mendoza.jpg")
        )
    }

     fun getMerlo(): Destination {
        return Destination(
            3L,
            "San Luis, Merlo",
            "Villa de Merlo es una ciudad de la provincia de San Luis, en la zona central de Argentina. Se ubica a los pies de las montañas Comechingones. En el centro de la ciudad se encuentra la Iglesia de Nuestra Señora del Rosario, construida en el siglo XVIII con adobe. El Museo del Poeta Antonio Esteban Agüero está ubicado en la antigua casa del poeta y documenta su vida y su obra. Un camino al este de la ciudad sube al Mirador del Sol, con vistas panorámicas de las montañas",
            listOf("https://www.welcomeargentina.com/sanluis/imagenes/san-luis-plaza.jpg",
                "https://media.lacapital.com.ar/p/af28ad4d7357095fca9bf724af718ade/adjuntos/203/imagenes/100/034/0100034949/642x0/smart/0_27_20181022125605jpg.jpg",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/4/45/Ruta_en_Merlo.jpg/294px-Ruta_en_Merlo.jpg")
        )
    }

     fun getTermas(): Destination {
        return Destination(
            4L,
            "Termas de Colon",
            "Termas Colón, ofrece un entorno singular de riquezas naturales, donde agua, flora, fauna y paisaje se conjugan para formar un microclima especial que despierta en el visitante una sensación de bienestar y relax.",
            listOf("https://www.turismoentrerios.com/colon/img/termas-01.jpg", "https://images.squarespace-cdn.com/content/v1/53eab704e4b0dfc0547d4034/1633806050800-8IJ0VJN8Z6S5SGCI2N5P/Termas1.png", "https://media.lacapital.com.ar/p/ef0450cb5f0d625e6ff53cb69f491a3a/adjuntos/203/imagenes/100/113/0100113846/1200x675/smart/parque-destacadajpg.jpg")
        )
    }

     fun getCordoba(): Destination {
        return Destination(
            5L,
            "Cordoba",
            "Córdoba, la capital de la provincia argentina del mismo nombre, es conocida por su arquitectura colonial española. Alberga la Manzana Jesuítica, un complejo del siglo XVII con claustros activos, iglesias y el campus original de la Universidad Nacional de Córdoba, una de las universidades más antiguas de Sudamérica. El punto central de la ciudad es la Plaza San Martín y la Catedral de Córdoba de estilo neobarroco",
            listOf("https://media.istockphoto.com/id/1004624644/es/foto/plaza-san-martin-y-catedral-de-c%C3%B3rdoba-c%C3%B3rdoba-argentina.jpg?s=2048x2048&w=is&k=20&c=EXYI_CSYPxFq0p4fjsGV9azuQQuRtubUNeSwCU7emGo=", "https://www.cordobaturismo.gov.ar/wp-content/uploads/2018/09/Villa-Carlos-Paz.jpg", "https://hotelvesubio.com/wp-content/uploads/2022/02/reloj-cucu.jpeg")
        )
    }

    fun getEsterosDelIbera(): Destination {
        return Destination(
            6L,
            "Esteros del Ibera, Corrientes",
            "La Reserva Provincial del Iberá es un área protegida dentro de los extensos Esteros del Iberá, en el noreste de Argentina. Abarca pantanos, ciénagas y lagunas que se extienden al suroeste desde la ciudad de Ituzaingó hasta Chavarría. Junto a la laguna Iberá está la villa Colonia Carlos Pellegrini, que sirve de base en el área. La reserva tiene una fauna abundante que incluye caimanes, ciervos de los pantanos y cientos de especies de aves.",
            listOf("https://www.boomerangviajes.tur.ar/wp-content/uploads/2022/01/Travesia-en-Kayak-por-Esteros-1067x800.jpg", "https://www.labrujula24.com/wp-content/uploads/2022/05/ibera.jpg", "https://media-cdn.tripadvisor.com/media/photo-s/07/a9/7c/62/esteros-del-ibera.jpg")
        )
    }

    fun getUshuaia(): Destination {
        return Destination(
            7L,
            "Tierra del Fuego",
            "Ushuaia es una ciudad turística de Argentina. Se ubica en el archipiélago de Tierra del Fuego, el extremo austral de Sudamérica, apodado el Fin del Mundo. Esta ciudad con mucho viento, ubicada en una escarpada colina, está rodeada de los montes Martial y el canal Beagle. Es una vía de acceso a los cruceros hacia la Antártida y a los recorridos cerca de la Isla Yécapasela, conocida como la Isla Pingüino por sus colonias de esta especie",
            listOf("https://denomades.s3.us-west-2.amazonaws.com/blog/wp-content/uploads/2018/08/30192236/26824519578_6a65e00419_o.jpg", "https://assets.isu.pub/document-structure/230227205753-1d4950002a497fe2707e7f13d447b5cd/v1/5710027cd9b32bd9d95924309e92b887.jpeg", "https://i0.wp.com/elplanetaurbano.com/wp-content/uploads/2023/02/la_ciudad_fueguina_de_ushuaia.jpg")
        )
    }

    fun getSalta(): Destination {
        return Destination(
            8L,
            "Salta",
            "Salta es una capital provincial del noroeste montañoso de Argentina. Se fundó en 1582 y es conocida por su arquitectura colonial española y su herencia andina. La ciudad se centra en la Plaza 9 de Julio, elegante y rodeada de cafés, en torno a la cual se ubican la Catedral de Salta y El Cabildo, un ayuntamiento del siglo XVIII transformado en museo. En las cercanías, está el Museo de Arqueología de Alta Montaña (MAAM), que alberga artefactos incas y momias.",
            listOf("https://eqfsewpc7rt.exactdn.com/wp-content/uploads/2022/01/que-ahcer-en-salta-dia-por-dia.jpeg", "https://elacopleinformativo.com.ar/wp-content/uploads/2023/03/Salta.jpg","https://upload.wikimedia.org/wikipedia/commons/thumb/5/54/Panor%C3%A1mica_Ciudad_de_Salta.jpg/1920px-Panor%C3%A1mica_Ciudad_de_Salta.jpg")
        )
    }

    fun getColonia(): Destination {
        return Destination(
            9L,
            "Colonia",
            "Colonia es un departamento del suroeste de Uruguay, frente a Buenos Aires al otro lado del estuario del Río de la Plata. La capital departamental, Colonia del Sacramento, es conocida por su barrio histórico con adoquines y los edificios coloniales portugueses y españoles. Muchos albergan museos, incluido el Museo del Azulejo. El faro de Colonia del Sacramento está rodeado de las ruinas de un convento y tiene vista panorámica.",
            listOf("https://elsouvenir.com/wp-content/uploads/2020/12/colonia-uruguay-header.jpg",
                "https://upload.wikimedia.org/wikipedia/commons/1/10/Calle_de_los_Suspiros%2C_Colonia_del_Sacramento%2C_Uruguay_-_panoramio.jpg",
                "https://imgar.zonapropcdn.com/avisos/1/00/51/01/85/96/720x532/1851485389.jpg",
                "https://viajeacoloniauruguay.com/wp-content/uploads/2019/04/Colonia_del_Sacramento.jpg",
                "https://mislugares.com/wp-content/uploads/2018/11/colonia-6-1-1024x683.jpg",
                "https://www.colonia.gub.uy/uploads/noticia_d81cb63df061d77655fd5269ca6c28784c7763eb.jpg",
                "https://www.entornoturistico.com/wp-content/uploads/2022/06/Playa-Ferrando-en-Colonia-del-Sacramento.jpg")
        )
    }

    fun getCataratas(): Destination {
        return Destination(
            10L,
            "Iguazu",
            "Al norte de la provincia de Misiones, en el límite con Brasil, se encuentran las majestuosas Cataratas del Iguazú: una de las Siete Maravillas Naturales del Mundo y, sin dudas, uno de los lugares más espectaculares de Latinoamérica.  El Parque Nacional fue creado en 1934 y declarado Sitio de Patrimonio Mundial por la UNESCO en 1984. También recibió la mención de Área de Importancia para la Protección de las Aves (AICA).",
            listOf("https://www.fundacionaquae.org/wp-content/uploads/2016/01/800px_iguacu-002.jpg",
                "https://media-cdn.tripadvisor.com/media/photo-s/26/ce/02/d4/caption.jpg",
                "https://lavidasondosviajes.com/wp-content/uploads/2022/09/donde-alojarse-cataratas-del-iguazu.jpg",
                "https://w0.peakpx.com/wallpaper/1010/1017/HD-wallpaper-cataratas-del-iguazu-raibow-iguazu-cataratas-cascadas.jpg",
                "https://c.wallhere.com/photos/ce/d0/nature_landscape_waterfall_Iguazu_Falls_Argentina_trees_forest_jungle-1523673.jpg!d",
                "https://c.wallhere.com/photos/f5/48/2048x1184_px_Argentina_Iguazu_Iguazu_Falls_landscape_nature_water_waterfall-701498.jpg!d")
        )
    }
}