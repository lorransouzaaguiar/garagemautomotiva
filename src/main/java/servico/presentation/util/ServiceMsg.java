package servico.presentation.util;

public enum ServiceMsg {
	NEW_SUCCESS("Serviço salvo com sucesso!"),
	NEW_ERROR("Falha ao salvar serviço!"),
	EDIT_SUCCESS("Serviço atualizado com sucesso!!"),
	EDIT_ERROR("Falha ao atualizar serviço!"),
	DELETE_SUCCESS("Serviço deletado com sucesso!"),
	DELETE_ERROR("Falha ao deletar serviço!"),
	SEARCH_SUCCESS("Serviço obtido com sucesso!"),
	SEARCH_ERROR("Falha ao obter serviço!"),
	SEARCHFIELD_EMPTY("Insira a descrição do serviço a ser pesquisado!"),
	TABLE_WARNING("Selecione um serviço na tabela");
	
	private String message;
	
	ServiceMsg(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
