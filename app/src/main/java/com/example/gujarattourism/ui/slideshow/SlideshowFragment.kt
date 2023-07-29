package com.example.gujarattourism.ui.slideshow

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.gujarattourism.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textViews = listOf<ImageView>(
            binding.imageView4,
            binding.imageView5,
            binding.imageView6,
            binding.imageView7,
        )

        val links = listOf<String>(
            "https://www.facebook.com/gujtourism",
            "https://twitter.com/gujarattourism",
            "https://www.instagram.com/gujarattourism/",
            "https://www.youtube.com/user/tcglvideos"
        )

        for (i in 0..3) {
            textViews[i].setOnClickListener {
                val url = links[i]
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            }
        }

        val inpFields = listOf<EditText>(
            binding.editTextName,
            binding.editTextTextEmailAddress,
            binding.editTextPhone,
            binding.editTextTextMessage,
        )

        val btn = binding.btnSubmit
        btn.setOnClickListener {
            for (inpField in inpFields) {
                inpField.setText("")
            }
            Toast.makeText(context, "Thank you for your feedback!", Toast.LENGTH_SHORT).show()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}