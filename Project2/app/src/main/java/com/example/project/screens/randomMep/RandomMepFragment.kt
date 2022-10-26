package com.example.project.screens.randomMep

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.project.R
import com.example.project.databinding.FragmentRandomMepBinding

/* Emil Suuronen - 1909931
4.10.2022
 */

// Main fragment for the Random member of parliament screen
class RandomMepFragment : Fragment(){

    lateinit var binding : FragmentRandomMepBinding
    private lateinit var viewModel: RandomMepViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val application = requireNotNull(activity).application
        val args = RandomMepFragmentArgs.fromBundle(requireArguments())

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_random_mep, container, false)

        binding.lifecycleOwner = viewLifecycleOwner

        viewModel = ViewModelProvider(this, RandomMepViewModelFactory(application, args.party))
            .get(RandomMepViewModel::class.java)

        binding.viewModel = viewModel

        //on click listener for like button
        //observing changes in randomMep and navigating to the next view passing the meps id
        binding.likeButton.setOnClickListener{
            viewModel.randomMep.observe(viewLifecycleOwner) {personNumber -> personNumber?.let {
                this.findNavController().navigate(RandomMepFragmentDirections.actionRandomMepFragmentToMepMessageFragment(it.personNumber))
                viewModel.navigationDone()
            }}
        }

        //onClick for the dislike button
        //on click the random mep is observed and viewmodel is updated with new random mep
        binding.dislikeButton.setOnClickListener{
            viewModel.dislikeClick()
            viewModel.randomMep.observe(viewLifecycleOwner) {
                binding.viewModel = viewModel
            }
        }

        return binding.root
    }
}

