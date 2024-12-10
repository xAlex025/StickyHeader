package com.example.stickyheader

import androidx.annotation.DrawableRes

data class Model(
    var titulo: String,
    val telefono: Int,

    )

fun getContactos(): List<Model> {
    return listOf(
        Model("Juan Pérez", 612345678),
        Model("Ana Gómez", 687654321),
        Model("Carlos Rodríguez", 639123456),
        Model("María López", 644987654),
        Model("Luis García", 633234567),
        Model("Patricia Sánchez", 609789012),
        Model("Raúl Fernández", 612345678),
        Model("Elena Martínez", 688876543),
        Model("Marta Jiménez", 675123456),
        Model("Pedro García", 629876543),
        Model("Lucía Rodríguez", 686543210),
        Model("David Hernández", 645678901),
        Model("Isabel Martínez", 698765432),
        Model("Antonio López", 612987654),
        Model("Carmen Sánchez", 611234567),
        Model("Jorge Fernández", 635987654),
        Model("Sofía Pérez", 699876543),
        Model("Alberto García", 644123456),
        Model("Laura Fernández", 688765432),
        Model("Miguel Álvarez", 618234567),
        Model("Beatriz Castro", 690987654),
        Model("Raquel Gómez", 661234567),
        Model("Felipe López", 612345678),
        Model("Nuria Sánchez", 634567890),
        Model("Martín Gómez", 675234567),
        Model("Sandra López", 688234567),
        Model("Eduardo Rodríguez", 635678901),
        Model("Verónica García", 693456789)

    )
}
