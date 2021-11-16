package cliente.presentation.util;

public enum CustomerMsg {
	NEW_SUCCESS("Cliente salvo com sucesso!"),
	NEW_ERROR("Falha ao salvar cliente!"),
	EDIT_SUCCESS("Cliente atualizado com sucesso!"),
	EDIT_ERROR("Falha ao atualizar cliente!"),
	DELETE_SUCCESS("Cliente deletado com sucesso!"),
	DELETE_ERROR("Falha ao deletar cliente!"),
	SEARCH_SUCCESS("Cliente obtido com sucesso!"),
	SEARCH_ERROR("Falha ao obter cliente!"),
	SEARCHFIELD_EMPTY("Insira o nome do cliente a ser pesquisado!"),
	TABLE_WARNING("Selecione um cliente na tabela");
	
	private String message;
	
	CustomerMsg(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
