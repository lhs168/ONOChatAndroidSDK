package chat.ono.chatdemo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import chat.ono.chatdemo.R
import chat.ono.chatsdk.model.Conversation
import com.bumptech.glide.Glide

import kotlinx.android.synthetic.main.item_conversation.view.*

class ConversationAdapter(context: Context, data:ArrayList<Conversation>? = null) : BaseAdapter<ConversationAdapter.ItemViewHolder, Conversation>(context, data) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_conversation, parent)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(conversation: Conversation) {
            Glide.with(itemView).load(conversation.user.avatar).into(itemView.iv_avatar)
            itemView.tv_name.text = conversation.user.nickname
        }
    }
}
