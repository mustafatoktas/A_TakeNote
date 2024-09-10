package com.mustafatoktas.nottut.ui.generalComponents.siralama_siniflari

sealed class NotSiralamasi(val siralamaTipi: SiralamaTipi) {

    class Baslik(siralamaTipi: SiralamaTipi) : NotSiralamasi(siralamaTipi)
    class Tarih(siralamaTipi: SiralamaTipi) : NotSiralamasi(siralamaTipi)
    class Renk(siralamaTipi: SiralamaTipi) : NotSiralamasi(siralamaTipi)

    fun copy(siralamaTipi: SiralamaTipi): NotSiralamasi {
        return when (this) {
            is Baslik -> Baslik(siralamaTipi)
            is Tarih -> Tarih(siralamaTipi)
            is Renk -> Renk(siralamaTipi)
        }
    }
}
