package br.senac.lojaretrofit.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import br.senac.lojaretrofit.R
import br.senac.lojaretrofit.databinding.ActivityListaProdutosBinding
import br.senac.lojaretrofit.databinding.ActivityTesteBinding
import br.senac.lojaretrofit.model.Pessoa
import br.senac.lojaretrofit.model.Produto
import br.senac.lojaretrofit.services.API
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TesteActivity : AppCompatActivity() {
    lateinit var binding: ActivityTesteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTesteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRequest.setOnClickListener {
            atualizarProdutos()
        }
    }

    override fun onResume() {
        super.onResume()

        //Atualiza a lista de produtos quando a tela é reaberta
        atualizarProdutos()
    }



    //Função que, quando chamada, vai até o endpoint da API e atualiza os produtos
    fun atualizarProdutos() {

        //Callback acionado quando a execução da API concluir
        val callback = object : Callback<List<Pessoa>> {

            //Chamada quando o endpoint responder
            override fun onResponse(call: Call<List<Pessoa>>, response: Response<List<Pessoa>>) {

                if (response.isSuccessful) {
                    val listaPessoas= response.body()

                } else {
                    //msg de erro
                }
            }

            override fun onFailure(call: Call<List<Pessoa>>, t: Throwable) {
                //AlertDialog.Builder()


            }

        }

        //Faz a chamada a API
        API().pessoa.listar().enqueue(callback)
    }
}