$(function() {
  $(".ui.form").form({
    nome: {
      identifier: "nome",
      rules: [{ type: "empty", prompt: "Por favor preencha o campo Produto " }]
    },
    categoria: {
      identifier: "categoria",
      rules: [{ type: "empty", prompt: "Selecione uma categoria" }]
    },

    dataCadastro: {
      identifier: "dataCadastro",
      rules: [{ type: "empty", prompt: "Por favor preencha o campo Data" }]
    }
  });

  $(".activating.element").popup({
    popup: $(".flowing.popup"),
    hoverable: true,
    hide: 800
  });

  $(".ui.dropdown").dropdown();
});

const modal = () => {
  let produto = document.getElementById("nome").value;
  let categoria = document.getElementById("categoria").value;
  let dataCadastro = document.getElementById("dataCadastro").value;

  if (!categoria == "" && !produto == "" && !dataCadastro == "") {
    $(".ui.modal").modal("show");
  }
  console.log(categoria);
};

const modalAddCategoria = () => {
  $(".ui.modal").modal("show");
};
