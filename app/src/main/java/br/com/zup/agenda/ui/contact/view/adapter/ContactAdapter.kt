package br.com.zup.agenda.ui.contact.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.agenda.data.model.CepResult
import br.com.zup.agenda.databinding.ContactItemBinding

class ContactAdapter(private var contactList: MutableList<CepResult>,
                     private val clickList: (movieResult: CepResult) -> Unit,)
    :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ContactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = contactList[position]
        holder.showMovieInfo(character)
        holder.binding.CvItem.setOnClickListener {
            clickList(character)
        }

    }

    override fun getItemCount() = contactList.size

    fun updateList(newList: MutableList<CepResult>) {
        contactList = newList
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ContactItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun showMovieInfo(contactResult:  CepResult) {
            binding.tvName.text = contactResult.name

        }
    }


}
