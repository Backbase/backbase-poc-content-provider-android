package com.backbase.android.cms.client.ui.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.backbase.android.cms.client.R
import com.backbase.android.cms.client.databinding.FragmentPostBinding
import com.backbase.android.cms.client.ui.Result
import com.backbase.android.cms.client.ui.SharedPostViewModel
import com.backbase.android.cms.client.domain.model.Post
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
/**
 * Initial Fragment that list of Data into a RecycleView
 */
class PostFragment : Fragment() {

    private val viewModel by sharedViewModel<SharedPostViewModel>()
    private var _binding: FragmentPostBinding? = null
    private val adapter = PostAdapter(
        object : PostAdapter.OnComponentClickListener {
            override fun onComponentClicked(post: Post) {
                val direction = PostFragmentDirections.fromPostToDetails(post)
                findNavController().navigate(direction)
            }
        }
    )
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPostBinding.inflate(inflater, container, false)
        println("onCreateView-->")
        viewModel.listOfPosts.observe(viewLifecycleOwner, { result ->
            println("result-->${result}")
            when (result.status) {
                Result.Status.SUCCESS -> onSuccess(result)
                Result.Status.ERROR -> onError(result)
                Result.Status.LOADING -> onLoading()
            }

        })
        return binding.root
    }

    private fun onSuccess(result: Result<List<Post>>) {
        binding.progressBar.hide()
        adapter.dataSet.clear()
        adapter.dataSet.addAll(result.data!!)
        if (adapter.itemCount == 0) {
            binding.emptyResult.isVisible = true
        } else {
            adapter.notifyDataSetChanged()
        }
    }

    private fun onError(
        result: Result<List<Post>>
    ) {
        binding.progressBar.hide()
        Snackbar.make(binding.root, result.message!!, Snackbar.LENGTH_INDEFINITE)
            .setAction(R.string.retry) {
                viewModel.fetchContent()
            }
            .show()
    }

    private fun onLoading() {
        binding.progressBar.show()
        binding.emptyResult.isVisible = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycleView.layoutManager = LinearLayoutManager(context)
        binding.recycleView.adapter = adapter
        binding.retry.setOnClickListener {
            viewModel.fetchContent()
        }
    }
}