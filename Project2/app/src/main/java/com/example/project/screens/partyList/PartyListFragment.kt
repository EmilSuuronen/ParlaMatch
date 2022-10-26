package com.example.project.screens.partyList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project.R
import com.example.project.adapters.OnClickListener
import com.example.project.adapters.PartyListAdapter
import com.example.project.databinding.FragmentPartyListBinding

/* Emil Suuronen - 1909931
25.9.2022
 */

// main fragment for the party list
class PartyListFragment : Fragment() {

    private lateinit var binding: FragmentPartyListBinding
    private lateinit var partyListViewModel: PartyListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val application = requireNotNull(this.activity).application

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_party_list, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        partyListViewModel = ViewModelProvider(this, PartyListViewModelFactory(application)).get(PartyListViewModel::class.java)

        val partyListAdapter = PartyListAdapter(OnClickListener { party
            ->  partyListViewModel.navigateToMepListFragment(party)})
        binding.partyListRecyclerView.adapter = partyListAdapter

        partyListViewModel.allParties.observe(viewLifecycleOwner)
            {parties -> parties?.let {partyListAdapter.submitList(parties)}}

        binding.partyListRecyclerView.layoutManager = LinearLayoutManager(activity)

        //
        partyListViewModel.partyNavigation.observe(viewLifecycleOwner) { party ->
            if (party != null) {
                this.findNavController()
                    .navigate(PartyListFragmentDirections.actionPartyListFragmentToRandomMepFragment(party))
                partyListViewModel.navigationDone()
            }
        }
        return binding.root
    }
}