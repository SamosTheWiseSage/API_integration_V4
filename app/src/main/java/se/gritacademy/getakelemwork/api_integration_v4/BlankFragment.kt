package se.gritacademy.getakelemwork.api_integration_v4


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class BlankFragment : Fragment() {override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
    // Inflate the layout for this fragment
    var v = inflater.inflate(R.layout.fragment_blank, container, false)
    v.findViewById<Button>(R.id.button4).setOnClickListener({
        val intent = Intent (getActivity(), MainActivity2::class.java)
        getActivity()?.startActivity(intent)
    })
    return v
}}