package com.example.gujarattourism.ui.gallery

import android.graphics.text.LineBreaker
import android.os.Build
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.gujarattourism.R
import com.example.gujarattourism.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // "@+id/textView_sou_2"
        // "@+id/textView_pava_2"
        // "@+id/textView_sun_2"
        // "@+id/textView_gir_2"
        // "@+id/textView_vav_2"

        // list of all the textViews
        val textViews = listOf<TextView>(
            binding.textView2,
            binding.textViewSou2,
            binding.textViewPava2,
            binding.textViewSun2,
            binding.textViewGir2,
            binding.textViewVav2
        )
        for (textView in textViews) {
            textView.justificationMode = LineBreaker.JUSTIFICATION_MODE_INTER_WORD
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}