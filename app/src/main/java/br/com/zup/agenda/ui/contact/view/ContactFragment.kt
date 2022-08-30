package br.com.zup.agenda.ui.contact.view

import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.agenda.R
import br.com.zup.agenda.data.model.UserResult
import br.com.zup.agenda.databinding.FragmentContactBinding
import br.com.zup.agenda.ui.contact.view.adapter.ContactAdapter
import br.com.zup.agenda.ui.home.view.MainActivity
import br.com.zup.agenda.ui.registration.viewmodel.RegisterUserViewModel
import br.com.zup.agenda.viewstate.ViewState

class ContactFragment : Fragment() {

    private lateinit var binding: FragmentContactBinding

    private val viewModel: RegisterUserViewModel by lazy {
        ViewModelProvider(this)[RegisterUserViewModel::class.java]
    }
    private val contactAdapter: ContactAdapter by lazy {
        ContactAdapter(arrayListOf(), this::clickList)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentContactBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.floatingActionButton.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_contactFragment_to_registrationFragment)
        }
    }

    private fun listContact() {
        binding.RvListContact.adapter = contactAdapter
        binding.RvListContact.layoutManager = LinearLayoutManager(context)
    }
    private fun clickList(contact: UserResult) {
        val bundle = bundleOf("CONTACT" to contact)
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_contactFragment_to_detailFragment, bundle)
    }
    private fun receptData() {
        val contact = arguments?.getParcelableArrayList<UserResult>("CONTACT")
        if (contact != null) {
            contactAdapter.updateList(contact)
        }
    }
//    private fun observe() {
//        viewModel.useListState.observe(this.viewLifecycleOwner) {
//
//            }
        }
//    }
//}
