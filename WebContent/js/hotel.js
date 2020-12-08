/**
 * 
 */


 var idhotelAtual = 0;
 
 
 listarHotel();
 
 
 function listarHotel() {
 	document.getElementById("listahoteis").innerHTML = "<tr><td>aguarde, carregando...</td></tr>";
	
	fetch("Controller?service=HotelListar").then(function(response) {
	    response.json().then(function(dados) {

			
	  		var tab = "<th>Nome</th>"
	  		          + "<th>Endereco</th>"
                      + "<th>Diaria</th>"
                      + "<th>Cidade</th>"
                      + "<th>Estado</th>"
                      + "<th>Telefone</th>"
	  		          + "<th width='10px'></th>"
	  		          + "<th width='10px'></th>"
                      + "<th width='10px'></th>"
                      + "<th width='10px'></th>"
                      + "<th width='10px'></th>"
                      + "<th width='10px'></th>";

	  		for (var i in dados) {
	  			tab += "<tr>"
	  			    + "<td>" + dados[i].nome + "</td>"
	  			    + "<td>" + dados[i].endereco + "</td>"
                    + "<td>" + dados[i].diaria + "</td>"
                    + "<td>" + dados[i].cidade + "</td>"
                    + "<td>" + dados[i].estado + "</td>"
                    + "<td>" + dados[i].telefone + "</td>"
	  			    + "<td><button type='button' class='btn btn-primary' onclick='alteraHotel("+dados[i].idhotel+")'>Alterar</button></td>"
	  			    + "<td><button type='button' class='btn btn-danger' onclick='excluirHotel("+dados[i].idhotel+")'>Excluir</button></td>"
	  			    + "</tr>"
	  		}
	  		document.getElementById("listahoteis").innerHTML = tab;

	    });
	});
	
	}
 	
 
 
 function salvarHotel() {
	

	const params = new URLSearchParams({
	  	idhotel:idhotelAtual, 
    	nome:document.getElementById("nome").value,
    	endereco: document.getElementById("endereco").value,
        diaria: document.getElementById("diaria").value,
        cidade: document.getElementById("cidade").value,
        estado: document.getElementById("estado").value,
        telefone: document.getElementById("telefone").value,
	});

	var url ="Controller?service=HotelSalvar&"+params.toString();
	
	fetch(url).then(function(response) {
	    response.json().then(function(dados) {
			if (dados=="ok") {
				listarHotel();
				$('#formhotel').modal('hide');
			} else {
				alert("Falha ao salvar os dados");
			} 
		});
	});

 }
 
 function novoHotel() {
     idhotelAtual = 0;
 	 document.getElementById("nome").value = "";
 	 document.getElementById("endereco").value = "";
     document.getElementById("diaria").value = "";
     document.getElementById("cidade").value = "";
     document.getElementById("estado").value = "";
     document.getElementById("telefone").value = "";
 	 
 	 $('#formhotel').modal('show');
 }
 
 function excluirHotel(idhotel) {
 	
	fetch("Controller?service=HotelExcluir&idhotel="+idhotel)
	.then(function(response) {
	    response.json().then(function(dados) {
			if (dados=="ok") {
				listarHotel();
			} else {
				alert("Falha ao salvar os dados");
			}
		}); 
	});
 }
 
 function alteraHotel(idhotel) {
 	
 	fetch("Controller?service=HotelConsultar&idhotel="+idhotel)
 	.then(function(response) {
	    response.json().then(function(dados) {

		 idhotelAtual = dados.idhotel;
	 	 document.getElementById("nome").value = dados.nome;
	 	 document.getElementById("endereco").value = dados.endereco;
         document.getElementById("diaria").value = dados.diaria;
         document.getElementById("cidade").value = dados.cidade;
         document.getElementById("estado").value = dados.estado;
         document.getElementById("telefone").value = dados.telefone;
	 	 
	 	 $('#formhotel').modal('show');

	    });
	});
 }
 