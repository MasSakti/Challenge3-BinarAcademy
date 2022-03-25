package com.mutawalli.challenge3

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_third.*

class ThirdFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments?.containsKey("ORANG") == true) {
            val dataOrang = arguments?.getParcelable<Data>("ORANG")
            val nama = dataOrang?.nama
            val usia = dataOrang?.usia
            val alamat = dataOrang?.alamat
            val pekerjaan = dataOrang?.pekerjaan
            val ganjilGenap = if (usia?.rem(2) == 0) {
                "Genap"
            } else {
                "Ganjil"
            }
            tvOutput.text = "$nama\n" +
                    "$usia, $ganjilGenap\n" +
                    "$alamat\n" +
                    "$pekerjaan"
        } else {
            val nama = arguments?.getString("NAMA")
            tvOutput.text = nama
        }
        btnGoto4.setOnClickListener {
            val nama = if (arguments?.containsKey("ORANG") == true) {
                arguments?.getParcelable<Data>("ORANG")?.nama
            } else {
                arguments?.getString("NAMA")
            }
            val bundleNama = bundleOf("NAMA" to nama)
            Navigation.findNavController(view).navigate(R.id.threeFour, bundleNama)
        }
    }

}