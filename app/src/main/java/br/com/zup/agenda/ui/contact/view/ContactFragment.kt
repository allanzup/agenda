package br.com.zup.agenda.ui.contact.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.com.zup.agenda.data.model.CepResult
import br.com.zup.agenda.databinding.FragmentContactBinding
import br.com.zup.agenda.ui.contact.view.adapter.ContactAdapter
import br.com.zup.agenda.ui.registration.viewmodel.RegisterCepViewModel

class ContactFragment : Fragment() {

    private lateinit var binding: FragmentContactBinding

    private val viewModel: RegisterCepViewModel by lazy {
        ViewModelProvider(this)[RegisterCepViewModel::class.java]
    }
private val contactAdapter:ContactAdapter by lazy {
    ContactAdapter(arrayListOf(),this::goToDetailContact )
}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentContactBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
private fun goToDetailContact(cepResult: CepResult){

}

}