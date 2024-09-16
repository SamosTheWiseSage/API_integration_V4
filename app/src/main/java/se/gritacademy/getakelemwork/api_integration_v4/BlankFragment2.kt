package se.gritacademy.getakelemwork.api_integration_v4

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class BlankFragment2 : Fragment() {   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        btn = findViewById<Button>(R.id.buttongoback)
    var v = inflater.inflate(R.layout.fragment_blank2, container, false)
    v.findViewById<Button>(R.id.button4frag2).setOnClickListener({
        val intent = Intent (getActivity(), MainActivity::class.java)
        getActivity()?.startActivity(intent)
    })
        return v
    }
}