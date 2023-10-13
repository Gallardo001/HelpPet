package ex.gallardo.helppet.utils

import ex.gallardo.helppet.R

object Const {
    val carouselItems = listOf(
        CarouselItem(
            image = R.drawable.illustrations_pets_shower,
            text = "Con Helpets, ya no olvidarás las citas de tu mascota."
        )   ,
        CarouselItem(
            image = R.drawable.illustrations_pets_doctor,
            text = "Helpets, te ayudará administrar   los datos médico de tu mascota."
        )  ,
        CarouselItem(
            image = R.drawable.illustrations_food_pets,
            text = "Ya no olvidarás más en darles los medicamentos a tus mascotas con Helpets."
        )
    )

    val months = listOf(
        "Enero",
        "Febrero",
        "Marzo",
        "Abril",
        "Mayo",
        "Junio",
        "Julio",
        "Agosto",
        "Septiembre",
        "Octubre",
        "Noviembre",
        "Diciembre"
    )

    val gender = listOf(
        "Macho",
        "Hembra",
    )

    val steps = listOf(
        "Step 1",
        "Step 2",
        "Step 3",
        "Step 4",
        "Step 5",
    )
}