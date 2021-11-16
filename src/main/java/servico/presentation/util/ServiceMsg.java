package servico.presentation.util;

public enum ServiceMsg {
	NEW_SUCCESS("Servi�o salvo com sucesso!"),
	NEW_ERROR("Falha ao salvar servi�o!"),
	EDIT_SUCCESS("Servi�o atualizado com sucesso!!"),
	EDIT_ERROR("Falha ao atualizar servi�o!"),
	DELETE_SUCCESS("Servi�o deletado com sucesso!"),
	DELETE_ERROR("Falha ao deletar servi�o!"),
	SEARCH_SUCCESS("Servi�o obtido com sucesso!"),
	SEARCH_ERROR("Falha ao obter servi�o!"),
	SEARCHFIELD_EMPTY("Insira a descri��o do servi�o a ser pesquisado!"),
	TABLE_WARNING("Selecione um servi�o na tabela");
	
	private String message;
	
	ServiceMsg(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
