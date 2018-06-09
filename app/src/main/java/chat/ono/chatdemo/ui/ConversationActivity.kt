package chat.ono.chatdemo.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import chat.ono.chatdemo.R
import chat.ono.chatdemo.adapter.ConversationAdapter
import chat.ono.chatsdk.IMClient
import kotlinx.android.synthetic.main.activity_conversation.*

class ConversationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversation)

        var conversations = IMClient.getConversationList()
        var adapter = ConversationAdapter(this)
        adapter.add(conversations)

        rv_conversation.layoutManager = LinearLayoutManager(this)
        rv_conversation.adapter = adapter

        tb_tv_add.setOnClickListener {
            startActivity(Intent(this@ConversationActivity, ContactsActivity::class.java))
        }

    }
}