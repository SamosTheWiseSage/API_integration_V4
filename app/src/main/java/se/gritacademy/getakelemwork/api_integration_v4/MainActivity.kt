package se.gritacademy.getakelemwork.api_integration_v4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.fragment.NavHostFragment
import coil.load
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var fr:FragmentContainerView
    lateinit var tv:TextView
    lateinit var btn:Button
    lateinit var btn2:Button
    lateinit var btn3:Button
    lateinit var insertstring: String
   lateinit var imageView:ImageView
    var intetst:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()
        fr = findViewById<FragmentContainerView>(R.id.fragmentContainerView)
        imageView  = findViewById(R.id.imageView)
        tv = findViewById(R.id.textView)

        btn = findViewById<Button>(R.id.button)
        btn2 = findViewById<Button>(R.id.button2)
        btn3 = findViewById<Button>(R.id.button3)
        var requestquery: RequestQueue = Volley.newRequestQueue(this)
        val queue = Volley.newRequestQueue(this)
       // var url = "https://dogapi.dog/api/v2/${insertstring}"
        var url = "https://dog.ceo/api/breed/hound/images"


            var request = StringRequest(Request.Method.GET, url, Response.Listener<String> { res ->
                Log.i("alrik", "WORKS " + res)
                var length:Int = JSONObject(res).getJSONArray("message").length()
                insertstring = JSONObject(res).getJSONArray("message").getString(intetst)
                imageView.load(insertstring)
                tv.setText("Page " + intetst)
                btn3.setOnClickListener({
                    if (intetst > 0) {
                        intetst--
                        insertstring = JSONObject(res).getJSONArray("message").getString(intetst)
                        imageView.load(insertstring)
                        Log.i("alrik", "onCreate: " + intetst)
                        tv.setText("Page " + intetst)
                    } else if (intetst == 0){
                        tv.text = intetst.toString()
                        tv.setText("Page " + intetst)
                    }
                })
                btn2.setOnClickListener({
                    intetst = 0
                    insertstring = JSONObject(res).getJSONArray("message").getString(intetst)
                    imageView.load(insertstring)
                    Log.i("alrik", "onCreate: " +intetst)
                    tv.setText("Page " + intetst)
                })

                    btn.setOnClickListener {
                        if (intetst < length){
                        intetst++
                            tv.setText("Page " + intetst)
                    insertstring = JSONObject(res).getJSONArray("message").getString(intetst)
                    } else if (intetst > length){
                        intetst = 0
                            tv.setText("Page " + intetst)
                    insertstring = JSONObject(res).getJSONArray("message").getString(intetst)
                            imageView.load(insertstring)
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