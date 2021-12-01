package com.backbase.android.cms.client.ui.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.backbase.android.cms.client.databinding.FragmentPostDetailsBinding
import com.backbase.android.cms.client.ui.post.model.Post
import com.backbase.android.cms.client.utils.fromHtml
import com.backbase.android.cms.client.utils.loadFromUrl

class PostFragmentDetails : Fragment() {

    private val args: PostFragmentDetailsArgs by navArgs()
    private var _binding: FragmentPostDetailsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPostDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val post = args.post as Post
        binding.title.text = post.title.fromHtml()
        binding.content.text = post.desc.fromHtml()
        binding.image.loadFromUrl(post.imageUrl)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}