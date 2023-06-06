package com.example.pollum.camera

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.bumptech.glide.Glide
import com.example.pollum.NavigationActivity
import com.example.pollum.data.PhotoData
import com.example.pollum.data.PhotoItem
import com.example.pollum.databinding.ActivityResultBinding


class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    private lateinit var titleEditText: EditText
    private lateinit var descriptionEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        titleEditText = binding.edTitle
        descriptionEditText = binding.edtDesc

        val photoUrl = intent.getStringExtra(EXTRA_PHOTO_URL)
        Glide.with(this)
            .load(photoUrl)
            .into(binding.resultImageView)

        binding.back.setOnClickListener { onBackPressed() }

        binding.save.setOnClickListener { onSaveButtonClicked() }
    }

    private fun onSaveButtonClicked() {
        val photoUrl = intent.getStringExtra(EXTRA_PHOTO_URL)
        val title = titleEditText.text.toString()
        val description = descriptionEditText.text.toString()

        val photoData = PhotoData(photoUrl, title, description)
        PhotoItem.addPhoto(photoData)

        val resultIntent = Intent().apply {
            putExtra(EXTRA_PHOTO_DATA, photoData)
        }
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }

    companion object {
        const val EXTRA_PHOTO_URL = "extra_photo_url"
        const val EXTRA_PHOTO_DATA = "extra_photo_data"
    }
}
