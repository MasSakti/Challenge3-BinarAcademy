package com.mutawalli.challenge3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnGoto3.setOnClickListener {
            if (etNama.text?.isNotEmpty() == true) {
                val nama = etNama.text.toString()
                val namaBundle = bundleOf("NAMA" to nama)

                Navigation.findNavController(view).navigate(R.id.twoThree, namaBundle)

            } else {
                Toast.makeText(btnGoto3.context, "Field Nama harus diisi", Toast.LENGTH_SHORT)
                    .show()
            }

        }
    }

}