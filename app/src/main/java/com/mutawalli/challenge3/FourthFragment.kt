package com.mutawalli.challenge3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_fourth.*

class FourthFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fourth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnBackto3.setOnClickListener {
            if (etUsia.text?.isNotEmpty() ?: true && etAlamat.text?.isNotEmpty() ?: true &&
                etPekerjaan.text?.isNotEmpty() ?: true
            ) {
                val nama = arguments?.getString("NAMA")
                val usia = etUsia.text.toString().toInt()
                val alamat = etAlamat.text.toString()
                val pekerjaan = etPekerjaan.text.toString()
                val dataOrang = Data(nama, usia, alamat, pekerjaan)
                val orangBundle = bundleOf("ORANG" to dataOrang)

                Navigation.findNavController(view).navigate(R.id.fourThree, orangBundle)

            } else {
                Toast.makeText(btnBackto3.context, "Semua field harus diisi", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}