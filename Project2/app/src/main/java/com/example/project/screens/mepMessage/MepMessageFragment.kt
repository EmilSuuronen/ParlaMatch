package com.example.project.screens.mepMessage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.project.R
import com.example.project.adapters.MepMessageAdapter
import com.example.project.databinding.FragmentMepMessageBinding


/* Emil Suuronen - 1909931
9.10.2022
 */


// main fragment for the message screen
class MepMessageFragment: Fragment() {

    private lateinit var binding: FragmentMepMessageBinding
    private lateinit var mepMessageViewModel: MepMessageViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val application = requireNotNull(this.activity).application
        val args = MepMessageFragmentArgs.fromBundle(requireArguments())

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mep_message, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        mepMessageViewModel = ViewModelProvider(this, MepMessageViewModelFactory(application, args.personNumber)).get(
            MepMessageViewModel::class.java)
        binding.viewModel = mepMessageViewModel

        val adapter = MepMessageAdapter()

        binding.mepMessageRecylcerView.adapter = adapter

        // binding onClickListener for message sending button
        // on click the contents of editView "messageEditText" are submitted to pass to database
        binding.sendButton.setOnClickListener{
            if (binding.messageEditText.text.isNotEmpty()) {
                mepMessageViewModel.sendMessage(binding.messageEditText.text.toString())
                binding.messageEditText.text = null
            }
        }

        // observing changes in the messages database
        // when change is observed the adapter submits the message to recyclerView
        mepMessageViewModel.messages.observe(viewLifecycleOwner) {message ->
            message?.let {adapter.submitList(message)}
        }

        return binding.root
    }
}
