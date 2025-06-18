package com.mustafatoktas.nottut.data.local

import android.content.Context
import android.os.Build
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.mustafatoktas.nottut.common.BaslangicSayfasi
import com.mustafatoktas.nottut.common.Constants
import com.mustafatoktas.nottut.common.Dil
import com.mustafatoktas.nottut.common.OnOFF
import com.mustafatoktas.nottut.common.Tema
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

val Context.myDataStore: DataStore<Preferences> by preferencesDataStore(Constants.DATASTORE_VERITABANI_ADI)

@Singleton
class MyDataStore @Inject constructor(
    context: Context
) {
    private val myDataStore = context.myDataStore

    private object DataStoreConstants {
        val TEMA = stringPreferencesKey("secili_tema")
        val BASLANGIC_SAYFASI = stringPreferencesKey("basangic_sayfasi")
        val KOSEDEN_KOSEYE = stringPreferencesKey("kose_den_kose_ye")
        val DIL = stringPreferencesKey("dil")
        val DINAMIK_RENK = stringPreferencesKey("dinamik_renk")
    }

    // Tema
    val temaFlow: Flow<Tema> = myDataStore.data
        .map { preferences ->
            val temaString = preferences[DataStoreConstants.TEMA] ?: Tema.Sistem.name // varsayılan tema sistem
            Tema.valueOf(temaString) // String'i Enum'a dönüştürüyoruz
        }

    suspend fun getTema(): Tema {
        return temaFlow.first()
    }

    suspend fun setTema(tema: Tema) {
        myDataStore.edit { preferences ->
            preferences[DataStoreConstants.TEMA] = tema.name // Enum'u String olarak kaydediyoruz
        }
    }

    // Baslangıç Sayfası
    suspend fun getBaslangicSayfasi(): BaslangicSayfasi {
        val preferences = myDataStore.data.first()
        val baslangicSayfasiString = preferences[DataStoreConstants.BASLANGIC_SAYFASI] ?: BaslangicSayfasi.Tum_Notlar.name // varsayılan sayfa tüm notlar
        return BaslangicSayfasi.valueOf(baslangicSayfasiString)
    }

    suspend fun setBaslangicSayfasi(yeniBaslangicSayfasi: BaslangicSayfasi) {
        myDataStore.edit { preferences ->
            preferences[DataStoreConstants.BASLANGIC_SAYFASI] = yeniBaslangicSayfasi.name
        }
    }

    // Koseden Koseye
    suspend fun getKoseDenKoseYe(): OnOFF {
        val preferences = myDataStore.data.first()
        val kosedenKoseyeString = preferences[DataStoreConstants.KOSEDEN_KOSEYE] ?: OnOFF.Acik.name // varsayılan seçenek açık
        return OnOFF.valueOf(kosedenKoseyeString)
    }

    suspend fun setKoseDenKoseYe(yeniKoseDenKoseYe: OnOFF) {
        myDataStore.edit { preferences ->
            preferences[DataStoreConstants.KOSEDEN_KOSEYE] = yeniKoseDenKoseYe.name
        }
    }

    // Dil
    val dilFlow: Flow<Dil> = myDataStore.data
        .map { preferences ->
            val dilString = preferences[DataStoreConstants.DIL] ?: Dil.English.name // varsayılan dil ing
            Dil.valueOf(dilString)
        }

    suspend fun getDil(): Dil {
        return dilFlow.first()
    }

    suspend fun setDil(dil: Dil) {
        myDataStore.edit { preferences ->
            preferences[DataStoreConstants.DIL] = dil.name
        }
    }

    // dinamik renk
    val dinamikRenkFlow: Flow<OnOFF> = myDataStore.data
        .map { preferences ->
            val dinamikRenkString = preferences[DataStoreConstants.DINAMIK_RENK] ?: if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) OnOFF.Acik.name else OnOFF.Kapali.name
            OnOFF.valueOf(dinamikRenkString)
        }

    suspend fun getDinamikRenk(): OnOFF {
        return dinamikRenkFlow.first()
    }

    suspend fun setDinamikRenk(onOff: OnOFF) {
        myDataStore.edit { preferences ->
            preferences[DataStoreConstants.DINAMIK_RENK] = onOff.name
        }
    }
}
