package br.com.zup.agenda.ui.registration.view

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.zup.agenda.R
import br.com.zup.agenda.databinding.FragmentRegistrationBinding
import br.com.zup.agenda.ui.registration.viewmodel.RegisterUserViewModel


class RegistrationFragment : Fragment() {
   private lateinit var binding: FragmentRegistrationBinding

    private val viewModel: RegisterUserViewModel by lazy {
        ViewModelProvider(this)[RegisterUserViewModel::class.java]
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding= FragmentRegistrationBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSearch.setOnClickListener {
            val cep = binding.etCepUm.text.toString()
            viewModel.getCep(cep)
            receptCep()
        }
    }
    fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)

    private fun receptCep() {
        viewModel.cepResponse.observe(viewLifecycleOwner, Observer {
            it.let {
                binding.etCepUm.text = it.cep.toEditable()
                binding.etCity.text = it.cidade.toEditable()
                binding.etDistrict.text = it.bairro.toEditable()
                binding.etRoad.text = it.logradouro.toEditable()
                binding.etState.text = it.estado.toEditable()
            }
}