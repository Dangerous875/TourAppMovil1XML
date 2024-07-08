package com.example.tourapp.repositories

import com.example.tourapp.data.TourPackage
import com.example.tourapp.data.TransportType

object PackageRepository {

    private val packages = mutableListOf<TourPackage>()

    init {
        packages.add(
            TourPackage(
                1L,
                "Bariloche Premium",
                TransportType.AIRPLANE,
                10,
                4.7,
                150000.00,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Llao_llao.jpg/800px-Llao_llao.jpg",
                DestinationRepository.getBariloche()
            )
        )

        packages.add(
            TourPackage(
                2L,
                "Mendoza Extremo",
                TransportType.BUS,
                7,
                4.1,
                75000.50,
                "https://tangol.com/blog/Fotos/Notas/lanzate-tirolesa-en-mendoza_398_202102231623570.JPG",
                DestinationRepository.getMendoza()
            )
        )

        packages.add(
            TourPackage(
                3L,
                "Descanso en Merlo",
                TransportType.BUS,
                5,
                3.6,
                55000.50,
                "https://cloudfront-us-east-1.images.arcpublishing.com/artear/C5DNOQH6TJBMJGIPWB2HU4QCNQ.jpeg",
                DestinationRepository.getMerlo()
            )
        )

        packages.add(
            TourPackage(
                4L,
                "Full termas",
                TransportType.BUS,
                4,
                4.0,
                35500.75,
                "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/17/e9/14/69/termas-colon-sector-norte.jpg?w=1200&h=-1&s=1",
                DestinationRepository.getTermas()
            )
        )

        packages.add(
            TourPackage(
                5L,
                "Cuartetazo",
                TransportType.TRAIN,
                6,
                4.9,
                84000.00,
                "https://www.cordobaturismo.gov.ar/wp-content/uploads/2020/10/R%C3%ADo-en-La-Cumbrecita.jpg",
                DestinationRepository.getCordoba()
            )
        )

        packages.add(
            TourPackage(
                6L,
                "Vibra la naturaleza",
                TransportType.BUS,
                7,
                5.0,
                150000.00,
                "https://www.corrientes.com.ar/util/img/esteros-del-ibera-3.jpg",
                DestinationRepository.getEsterosDelIbera()
            )
        )

        packages.add(
            TourPackage(
                7L,
                "Fin del mundo",
                TransportType.AIRPLANE,
                5,
                4.8,
                415000.00,
                "https://upload.wikimedia.org/wikipedia/commons/7/71/Les_Eclaireurs_Lighthouse.jpg",
                DestinationRepository.getUshuaia()
            )
        )

        packages.add(
            TourPackage(
                8L,
                "Nos vamos para el norte!",
                TransportType.AIRPLANE,
                5,
                3.9,
                120000.00,
                "https://universes.art/fileadmin/_processed_/f/7/csm_00-P1030492-2000-750_6587371537.jpg",
                DestinationRepository.getSalta()
            )
        )

        packages.add(
            TourPackage(
                9L,
                "Cruzando el charco",
                TransportType.FERRY,
                3,
                1.7,
                45000.75,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9e/Colonia_del_Sacramento_calle_t%C3%ADpica.JPG/640px-Colonia_del_Sacramento_calle_t%C3%ADpica.JPG",
                DestinationRepository.getColonia()
            )
        )

        packages.add(
            TourPackage(
                10L,
                "Full Cataratas",
                TransportType.AIRPLANE,
                6,
                4.9,
                85000.00,
                "https://c0.wallpaperflare.com/preview/675/649/241/iguazu-falls-iguazu-waterfall-brasil.jpg",
                DestinationRepository.getCataratas()
            )
        )
    }
    fun getPackagesList() : List<TourPackage> {
        return packages //TODO Implementar solucion para obtener todos los paquetes turisticos
    }

    fun getById(id: Long) : TourPackage {
        val position = packages.indices.find { packages[it].id== id }
        return packages[position!!.toInt()] //TODO Implementar solucion para obtener el paquete turistico solicitado}
    }

}
