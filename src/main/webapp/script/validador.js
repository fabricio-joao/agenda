/**
 * Valiadação de formulario
 * @author Fabricio Neto
 */

function validar(){
	let nome = frmContato.nome.value
	let fone = frmContato.fone.value
	if(nome === ""){
		alert("Preenche campo Nome")
		frmContatos.nome.focus()
		return false
	} else if(fone === ""){
		alert("Preenche campo Fone")
		frmContatos.fone.focus()
		return false
	} else {
		document.forms["frmContato"].submit()
	}
 }