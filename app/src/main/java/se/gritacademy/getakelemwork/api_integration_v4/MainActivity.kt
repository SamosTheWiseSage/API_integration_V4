package se.gritacademy.getakelemwork.api_integration_v4

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        findViewById<Button>(R.id.button).setOnClickListener {
            Log.i("TESTABRA", "onCreate: "+navController.currentDestination!!.toString())

            Log.i("TESTADÖ", "onCreate: "+navController.currentDestination!!.toString()+navController.currentDestination!!.id)
            if(navController.currentDestination!!.id == R.id.blankFragment2)
                navController.navigate(R.id.action_blankFragment2_to_blankFragment)
            else
                navController.navigate(R.id.action_blankFragment_to_blankFragment2)
        }

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}