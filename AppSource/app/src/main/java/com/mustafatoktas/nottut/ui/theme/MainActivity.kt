package com.mustafatoktas.nottut.ui.theme

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.mustafatoktas.nottut.common.Dil
import com.mustafatoktas.nottut.common.OnOFF
import com.mustafatoktas.nottut.common.Tema
import com.mustafatoktas.nottut.data.local.MyDataStore
import com.mustafatoktas.nottut.ui.navigation.MainNavHost
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Locale
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var myDataStore: MyDataStore

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setContent {
            val tema by myDataStore.temaFlow.collectAsState(initial = Tema.Sistem)
            val dil by myDataStore.dilFlow.collectAsState(initial = Dil.English)
            val dinamikRenk by myDataStore.dinamikRenkFlow.collectAsState(initial = OnOFF.Acik)
            val context = LocalContext.current

            LaunchedEffect(dil) {
                updateLocale(context, dil)
            }

            NotTutTheme(
                tema = tema,
                dinamikRenk = dinamikRenk,
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val scope = rememberCoroutineScope()
                    val mainNavController = rememberNavController()
                    val subNavController = rememberNavController()

                    MainNavHost(
                        mainNavController = mainNavController,
                        subNavController = subNavController,
                        context = context
                    )

                    scope.launch(Dispatchers.IO) {
                        val kosedenKoseye = myDataStore.getKoseDenKoseYe()
                        if (kosedenKoseye == OnOFF.Acik) {
                            withContext(Dispatchers.Main) {
                                enableEdgeToEdge()
                            }
                        }
                    }
                }
            }
        }
    }

    private fun updateLocale(context: Context, dil: Dil) {
        val locale = when (dil) {
            Dil.English -> Locale("en")
            Dil.Turkce -> Locale("tr")
        }

        Locale.setDefault(locale)
        val resources = context.resources
        val config = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }
}
