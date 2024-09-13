package se.gritacademy.getakelemwork.api_integration_v4

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import coil.load
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

lateinit var btngoback: Button
lateinit var edtitext:EditText
lateinit var insertstring:String
lateinit var imageView2:ImageView
var intetst2:Int = 0
class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        btngoback = findViewById(R.id.buttongoback)
        edtitext = findViewById(R.id.editTextText)
        imageView2  = findViewById(R.id.imageView2)

            var requestquery: RequestQueue = Volley.newRequestQueue(this)
            val queue = Volley.newRequestQueue(this)
            // var url = "https://dogapi.dog/api/v2/${insertstring}"
            insertstring = "hound"
           btngoback.setOnClickListener({
                insertstring = edtitext.text.toString()
               var url = "https://dog.ceo/api/breed/${insertstring}/images"
                Log.i("alrik", "BAZINGA: "+ insertstring)
            var request = StringRequest(Request.Method.GET, url, Response.Listener<String> { res ->
                Log.i("alrik", "MAIN222222 " + res)
              //  var length:Int = JSONObject(res).getJSONArray("message").length()
                var fullfull = JSONObject(res).getJSONArray("message").getString(intetst2)
                    imageView2.load(fullfull).toString()
            }, {
                Log.i("alrik", "Fail ")
            })
            requestquery.getCache().clear()
            requestquery.add(request)
        })
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
        }
    }
