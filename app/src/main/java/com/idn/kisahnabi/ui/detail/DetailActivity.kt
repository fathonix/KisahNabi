package com.idn.kisahnabi.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.idn.kisahnabi.data.network.KisahResponse
import com.idn.kisahnabi.databinding.ActivityDetailBinding
import com.idn.kisahnabi.utils.fromHttpToHttpsString

class DetailActivity : AppCompatActivity() {

    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding as ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data = intent.getParcelableExtra<KisahResponse>(EXTRA_DATA)
        val nama = "Kisah" + data?.name
        supportActionBar?.title = nama

        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        data?.let {
            binding.apply {
                detailDesk.text = data.description
                detailNama.text = data.name
                detailTempat.text = data.tmp
                val usia = "Usia: " + data.usia + " tahun"
                detailUsia.text = usia

                Glide.with(this@DetailActivity)
                    .load(fromHttpToHttpsString(data.imageUrl))
                    .into(detailImage)
            }
        }
    }

    companion object {
        const val EXTRA_DATA = "data"
    }
}