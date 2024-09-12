package se.gritacademy.getakelemwork.api_integration_v4

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var tv:TextView
    lateinit var btn:Button
    lateinit var insertstring: String
   lateinit var imageView:ImageView
    var intetst:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()
        tv = findViewById(R.id.FragmentContainer)
        imageView  = findViewById(R.id.imageView)

        btn = findViewById<Button>(R.id.button)
        var requestquery: RequestQueue = Volley.newRequestQueue(this)
        val queue = Volley.newRequestQueue(this)
       // var url = "https://dogapi.dog/api/v2/${insertstring}"
        var url = "https://dog.ceo/api/breed/hound/images"


            var request = StringRequest(Request.Method.GET, url, Response.Listener<String> { res ->
                Log.i("alrik", "WORKS " + res)
                var length:Int = JSONObject(res).getJSONArray("message").length()
                insertstring = JSONObject(res).getJSONArray("message").getString(intetst)
                imageView.load(insertstring)

                    btn.setOnClickListener {
                        if (intetst < length){
                        intetst++
                    } else if (intetst > length){
                        intetst = 0
                    }
                insertstring = JSONObject(res).getJSONArray("message").getString(intetst)
                imageView.load(insertstring)
//                tv.text = JSONObject(res).getJSONArray("data").getJSONObject(0)
//                    .getJSONObject("attributes").getString("name")
//                           //array 0 -> obj -> attributes  obj -> name
                    }
            }, {
                Log.i("alrik", "Fail ")
            })
            requestquery.getCache().clear()
            requestquery.add(request)

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}