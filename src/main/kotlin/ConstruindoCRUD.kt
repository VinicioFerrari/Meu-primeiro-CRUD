fun main() {
    var opcao: String

    listaDeUsuario.addAll(
        listOf(
            Usuario(id = (1), nome = "Vinicio Portezan", idade = "27", cpf = "123456"),
            Usuario(id = (2), nome = "Carlinhos Brown", idade = "60", cpf = "789456")
        )
    )
    while (true) {
        opcao = menuPrincipal()
        when (opcao) {
            "1" -> cadastrarUsuario()
            "2" -> consultarUsuario()
            "3" -> atualizarUsuario()
            "4" -> excluirUsuario()
            "5" -> break


        }
    }


}
//variáveis Globais

val listaDeUsuario = mutableListOf<Usuario>()

fun menuPrincipal(): String {
    println("[1] Cadastrar Usuário")
    println("[2] Consultar Usuário")
    println("[3] Atualizar Usuário")
    println("[4] Excluir Usuário")
    println("[5] Sair")
    return readln()
}

fun cadastrarUsuario() {
    println("Digite seu nome completo: ")
    val nome = readln()
    println("Digite sua idade: ")
    val idade = readln()
    println("Digite seu CPF: ")
    val cpf = readln()
    val id = listaDeUsuario.size + 1
    val usuario = Usuario(id, nome, idade, cpf) //Coleta das informações necessárias para a classe Usuario
    listaDeUsuario.add(usuario) // coma as informações da variavel acima (usuario), será add na listaDeUsuario
}

fun consultarUsuario() {
    listaDeUsuario.forEach {
        println(it.nome)
        println(it.idade)
        println(it.cpf)

    }

}

fun atualizarUsuario() {
    println("Qual usuário deseja atualizar?")
    println("Digite ID: ")
    val id = readln().toInt()
    val usuarioEncontrado = buscarIdUsuario(id)
    usuarioEncontrado?.let {
        println(it)
        println("Qual informação deseja atualizar?")
        println("[1] Nome")
        println("[2] Idade")

        when (readln()) {
            "1" -> {
                println("Digite o nome: ")
                it.nome = readln()
            }

            "2" -> {
                println("Digite a idade: ")
                it.idade = readln()
            }
        }

        println("Usuário atualizado com sucesso!")


    } ?: println("Usuário não encontrado")

}

fun buscarIdUsuario(id: Int): Usuario? {
    return listaDeUsuario.find { it.id == id }
}

fun excluirUsuario() {
    println("Digite o ID do usuário a ser excluido: ")
    val id = readln().toInt()
    listaDeUsuario.removeIf {it.id == id}
    println("Usuário excluído com sucesso!")

}