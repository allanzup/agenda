package br.com.zup.agenda.ui.contact.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.com.zup.agenda.data.model.UserResult
import br.com.zup.agenda.databinding.FragmentContactBinding
import br.com.zup.agenda.ui.contact.view.adapter.ContactAdapter
import br.com.zup.agenda.ui.registration.viewmodel.RegisterUserViewModel

class ContactFragment : Fragment() {

    private lateinit var binding: FragmentContactBinding

    private val viewModel: RegisterUserViewModel by lazy {
        ViewModelProvider(this)[RegisterUserViewModel::class.java]
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
private fun goToDetailContact(userResult: UserResult){

}
    private fun onClickRegister(){
        binding.floatingActionButton.setOnClickListener {
            val action=
        }
    }

}