package com.example.ciclodevida

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ciclodevida.ui.theme.CicloDeVidaTheme

class MainActivity : ComponentActivity() {

    val TAG:String = "Estado"
    var timeStart:Long=0
    var timeFinish:Long=0
    var timePassed:Long=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CicloDeVidaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }

    override fun onStart(){
        super.onStart()
        timeStart=System.currentTimeMillis()
        Log.d(TAG,"He llegado al Start")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"He llegado al Resume")
        updateUI()
    }

    override fun onPause() {
        super.onPause()
        timeFinish = System.currentTimeMillis()
        timePassed += ((timeFinish - timeStart) *0.001).toLong()
        Log.d(TAG,"Tiempo que ha estado en ejecucion: "+timePassed+" segundos")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"He llegado al Stop o se ha pausado")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"He llegado al estado de mi destrucción")
    }

    fun updateUI(){
        Toast.makeText(this,"Tiempo que has estado activo: $timePassed segundos",Toast.LENGTH_SHORT).show()
    }


}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
